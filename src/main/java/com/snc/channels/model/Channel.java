package com.snc.channels.model;

import java.net.URI;

//DTO - data transfer object (pattern)
//инкапсуляция - ООП (инкапсуляции, полиморфизма и наследование)
//класс, абстракция (уелостаная сущность), DTO pattern
public class Channel extends BaseChannel
// extends Object
//            |
//         BaseChannel
//            |
//         Channel...
{
    private int count; // property/field
    private String name;
    private URI link;

    public String toString(){
        return "id:" + id + " name: " + name + ", count: " + count
                + " link:" + link;
    }

    public Channel(){

    }

    public int getCount(){
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URI getLink() {
        return link;
    }

    public void setLink(URI link) {
        this.link = link;
    }
}
