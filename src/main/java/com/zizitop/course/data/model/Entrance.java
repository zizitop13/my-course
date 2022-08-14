package com.zizitop.course.data.model;


import java.util.Objects;

/**
 * Номер подъезда
 * Количество квартир
 * <p>
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrance entrance = (Entrance) o;
        return entranceNumber == entrance.entranceNumber && flatsNumber == entrance.flatsNumber && intercom == entrance.intercom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(entranceNumber, flatsNumber, intercom);
    }
}
