package com.tugcankoparan.example;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Phone.class)
public abstract class Phone_{
public static volatile SingularAttribute<Phone , Long> id;
public static volatile SingularAttribute<Phone , PhoneType> type;
public static volatile SingularAttribute<Phone, String> number;
}