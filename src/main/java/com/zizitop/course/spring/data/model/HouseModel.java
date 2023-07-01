package com.zizitop.course.spring.data.model;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Getter
@Setter
public class HouseModel {

    @Id
    @Setter(AccessLevel.PACKAGE)
    @GeneratedValue(strategy=SEQUENCE, generator="CUST_SEQ")
    private long id;
    private String street;
    private String number;
}
