package com.zizitop.course.data.model;
import com.zizitop.course.data.model.numbers.EntranceNumber;

import java.util.List;

public class Entrance {
    private EntranceNumber number;
    private List<Flat> flats;

    public Entrance(EntranceNumber number){
        this.number = number;
    }
}
