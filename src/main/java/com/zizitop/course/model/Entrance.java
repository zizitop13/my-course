package com.zizitop.course.model;


/**
 * Номер подъезда
 * Количество квартир
 *
 * Наличие домофона
 */
public class Entrance {
    public int entranceNumber;
    public int flatsNumber;
    protected boolean intercom;

    @Override
    public String toString() {
        return "Entrance{" +
                "entranceNumber=" + entranceNumber +
                ", flatsNumber=" + flatsNumber +
                ", intercom=" + intercom +
                '}';
    }
}
