package com.tugcankoparan.example;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;

public class EmployeeSpecs {
    public static Specification<Employee> getEmployeesByNameSpec(String name) {
        return (root, query, criteriaBuilder) -> {
            Predicate equalPredicate = criteriaBuilder.equal(root.get(Employee_.name), name);
            return equalPredicate;
        };
    }

    public static Specification<Employee> getEmployeesByPhoneTypeSpec(PhoneType phoneType) {
        return (root, query, criteriaBuilder) -> {
            ListJoin<Employee, Phone> phoneJoin = root.join(Employee_.phones);
            Predicate equalPredicate = criteriaBuilder.equal(phoneJoin.get(Phone_.type), phoneType);
            query.distinct(true);
            return equalPredicate;
        };
    }

    public static Specification<Employee> getEmployeesByNameOrPhoneTypeSpec(String name, PhoneType phoneType) {
        return Specification.where(getEmployeesByNameSpec(name)).or(getEmployeesByPhoneTypeSpec(phoneType));
    }

    public static Specification<Employee> getEmployeesByNameAndPhoneTypeSpec(String name, PhoneType phoneType) {
        return Specification.where(getEmployeesByNameSpec(name)).and(getEmployeesByPhoneTypeSpec(phoneType));
    }

    public static Specification<Employee> getEmployeeByNotNameSpec(String name) {
        return Specification.not(getEmployeesByNameSpec(name));
    }
}