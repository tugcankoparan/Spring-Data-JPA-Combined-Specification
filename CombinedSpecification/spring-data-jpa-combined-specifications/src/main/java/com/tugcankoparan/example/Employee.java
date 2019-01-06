package com.tugcankoparan.example;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Phone> phones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public static Employee create(String name, Phone... phones) {
        Employee e = new Employee();
        e.name = name;
        if (phones != null) {
            e.phones = Arrays.asList(phones);
        }
        return e;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phones=" + phones +
                '}';
    }
}