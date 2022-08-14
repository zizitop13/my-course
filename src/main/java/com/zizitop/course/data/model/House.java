package com.zizitop.course.data.model;


import com.zizitop.course.data.MyList;

/**
 * Класс дом
 * Адрес
 * Управляющая компания
 * Год постройки дома
 * Общее количество жильцов
 * Количество этажей
 * Наличие лифта
 * Наличие мусоропровода
 * Наличие технического этажа
 * Количество подъездов
 * Количество квартир
 */
public class House {

    public String address;
    public String serviceCompany;
    public int yearOfBuilt;
    public int tenantNumber;
    public int floorsNumber;
    public boolean elevator;
    public boolean garbageChute;
    public boolean serviceFloor;
    public int entranceQuantity;
    public int flatNumber;

    private MyList<Entrance> entrances;


    public void setEntrances(MyList<Entrance> entrances) {
        this.entrances = entrances;
        this.entranceQuantity = entrances.size();
    }

    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                ", serviceCompany='" + serviceCompany + '\'' +
                ", yearOfBuilt=" + yearOfBuilt +
                ", tenantNumber=" + tenantNumber +
                ", floorsNumber=" + floorsNumber +
                ", elevator=" + elevator +
                ", garbageChute=" + garbageChute +
                ", serviceFloor=" + serviceFloor +
                ", entranceNumber=" + entranceQuantity +
                ", flatNumber=" + flatNumber +
                ", entrance=" + entrances +
                '}';
    }
}
