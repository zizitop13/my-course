package com.zizitop.course.model;


import java.util.Arrays;

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
    public int entranceNumber;
    public int flatNumber;

    private Entrance[] entrances;

         // 0             1         2
    //    [Entrance1, Entrance2, Entrance3] (3)e
    //    [Entrance1, null, Entrance2, null, Entrance2] (5)e
//    [Entrance1, Entrance2] (2)
//    [Entrance1, null] (2)
    public void setEntrances(Entrance[] entrances) {
        this.entrances = entrances;
        for (int i = 0; i < entrances.length; i++) {
            if (entrances[i] != null){
                this.entranceNumber++;
            }
        }
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
                ", entranceNumber=" + entranceNumber +
                ", flatNumber=" + flatNumber +
                ", entrance=" + Arrays.toString(entrances) +
                '}';
    }
}
