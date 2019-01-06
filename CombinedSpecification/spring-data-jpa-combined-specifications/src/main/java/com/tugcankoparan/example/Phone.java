package com.tugcankoparan.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Phone {
    @Id
    @GeneratedValue
    private long id;
    private PhoneType type;
    private String number;

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public static Phone of(PhoneType type, String number) {
        Phone p = new Phone();
        p.type = type;
        p.number = number;
        return p;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", type=" + type +
                ", number='" + number + '\'' +
                '}';
    }
}