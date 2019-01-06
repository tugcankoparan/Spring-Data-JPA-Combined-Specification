package com.tugcankoparan.example;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Employee.class)
public abstract class Employee_ {
public static volatile SingularAttribute<Employee,Long> id;
public static volatile SingularAttribute<Employee,String> name;
public static volatile ListAttribute<Employee, Phone> phones;
}
