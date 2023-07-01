package com.zizitop.course.se.controller;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class DispatcherHandler implements HttpHandler {

    //  создаем приватную переменную типа Map с HttpMapping в качестве ключа
    //  и ControllerHandler в качестве значения.
    private final Map<HttpMapping, ControllerHandler> controllerMap;

    // создаем конструктор класса, который принимает Map с HttpMapping и
    // ControllerHandler, соответствующую этому классу.
    public DispatcherHandler(Map<HttpMapping, ControllerHandler> controllerMap) {
        this.controllerMap = controllerMap;
    }

    // переопределяем метод handle, который принимает HttpExchange и выбрасывает IOException.
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        // создаем блок try, где получаем объект OutputStream, связанный с текущим обменом.
        try (OutputStream os = exchange.getResponseBody()) {
            // создаем строковую переменную serializedResponse и присваиваем ей пустую строку.
            String serializedResponse = "";
            // создаем вложенный блок try с логикой приложения.
            try {
                // получаем из HttpExchange HttpMapping.
                HttpMapping httpMapping = HttpMapping.fromExchange(exchange);
                // получаем из Map нужный ControllerHandler для данного маршрута.
                ControllerHandler controllerHandler = controllerMap.get(httpMapping);

                // блок условий, где проверяется найден ли нужный ControllerHandler
                // по данному маршруту. Если нет, выбрасывается IOException с соответствующим предупреждением.
                if (controllerHandler == null) {
                    throw new IOException("Controller for mapping " + httpMapping + " not found");
                }

                //TODO: extract body, params, headers - в данном блоке планируется описать методы, извлекающие тело,
                // параметры, заголовки запросов.

                // создаем переменную 'body', содержащую тело запроса и получаем её вызовом метода extractBody.
                Object body = extractBody(exchange);
                // создаем переменную 'params', содержащую параметры запроса и получаем
                // её вызовом метода extractParams.
                Map<String, String> params = extractParams(exchange);
                // создаем переменную 'headers', содержащую заголовки запроса и получаем
                // её вызовом метода extractHeaders.
                Map<String, String> headers = extractHeaders(exchange);

                // создаем переменную 'response', в которую записываем результат
                // выполнения метода execute для данного маршрута и данных.
                Object response = controllerHandler.execute(body, params, headers);

                // сериализуем ответ, полученный в предыдущей строке вызовом функции serialize.
                serializedResponse = serialize(response);

                // отправляем ответ с кодом 200 и длиной serializedResponse.
                exchange.sendResponseHeaders(200, serializedResponse.length());

            // блок 'catch' вложенного блока try, в котором обрабатываются исключения.
            } catch (Exception e) {
                // если выбрасывается исключение определенного типа, записываем
                // соответствующее сообщение в serializedResponse.
                serializedResponse = e.getMessage();
                // отправляем ответ с кодом 500 и длиной serializedResponse.
                exchange.sendResponseHeaders(500, serializedResponse.length());

            // блок 'finally', который всегда выполняется независимо от того успешно ли
            // вышли из блока try или выброшено исключение.
            } finally {
                // записываем ответ в выходной поток в формате байтов.
                os.write(serializedResponse.getBytes());
            }
        }
    }

    // создаем приватный метод, который извлекает параметры из HttpExchange.
    private Map<String, String> extractHeaders(HttpExchange exchange) {
        // временно возвращаем 'null', так как метод в стадии разработки,
        // в дальнейшем на его месте будет логика приложения.
        return null;
    }

    // создаем приватный метод, который извлекает тело запроса, переданного в HttpExchange.
    private Object extractBody(HttpExchange exchange) {

        // создаем обертку над InputStream, чтобы читать данные более эффективно.
        try (InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
             BufferedReader br = new BufferedReader(isr)
        ) {
            // создаем StringBuilder, в который записываем полученные данные.
            StringBuilder sb = new StringBuilder();
            // читаем поток данных и когда достигнем конца, прекращаем читать.
            String line;
            while ((line = br.readLine()) != null) {
                // добавляем в StringBuilder каждую прочитанную строку.
                sb.append(line);
            }
            // преобразуем StringBuilder в строковой формат.
            return sb.toString();

        // обрабатываем исключение 'UnsupportedEncodingException'
        // и выбрасываем его в рантайме, если оно произошло.
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        // обрабатываем исключение 'IOException' и выбрасываем его в рантайме, если оно произошло.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // создаем приватный метод, который извлекает параметры из HttpExchange.
    private Map<String, String> extractParams(HttpExchange exchange) {
        // получаем строку из запроса из HttpExchange.
        String query = exchange.getRequestURI().getQuery();

        //  создаем экземпляр HashMap.
        Map<String, String> params = new HashMap<>();

        // если Query-строка пустая, возвращаем пустой экземпляр HashMap.
        if (query == null) {
            return params;
        }

        // Разделение строки запроса на подстроки, используя знак "амперсанд".
        // Создание массива строк
        String[] split = query.split("&");

        // Циклическое перебирание строк запроса, вывод каждой подстроки на консоль.
        for (String keyValue : split) {
            // разделение каждого элемента строки на две части, используя знак равенства.
            // добавление ключа-значения в экземпляр HashMap.
            String[] pair = keyValue.split("=");
            params.put(pair[0], pair[1]);
        }

        // возвращаем заполненный экземпляр HashMap.
        return params;
    }

    // создаем приватную метод serialize, который сериализует данные в строку.
    private String serialize(Object response) {
        // сериализуем данные, переданные этому методу и преобразуем их в строковый формат.
        return response.toString();
    }


}

/** Этот класс является обработчиком HTTP-запросов, который вызывается при каждом запросе
 * к веб-приложению. Он получает от клиента запрос и выполняет соответствующий контроллер
 * в зависимости от маршрута запроса и метода HTTP. Класс также извлекает параметры, тело
 * и заголовки запросов и сериализует ответ в строковый формат для отправки обратно клиенту.
 * Класс содержит методы для извлечения параметров, тела и заголовков запросов, а также методы
 * для сериализации и десериализации данных. **/