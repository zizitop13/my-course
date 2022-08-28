package framework;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.stream.Collectors;

public class TestHandler {

    private String rootPackage;

    public void handle(){
        InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream(rootPackage.replace("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        Set<Class<?>> packageClasses = reader.lines()
                .filter(file -> file.endsWith(".class"))
                .map(className -> getClass(className, rootPackage))
                .collect(Collectors.toSet());

        for (Class<?> testClass: packageClasses){
            for (Method method : testClass.getMethods()) {
                //method - get all annotations
                //if annotations contains @Test then execute method
                for (Annotation annotation : method.getAnnotations()) {
                    if(annotation instanceof Test){
                        //execute method
                    }
                }

            }

        }
    }

    private Class<?> getClass(String className, String rootPackage) {
        try {
            return Class.forName(rootPackage + "." + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
