package com.tugcankoparan.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ExampleClient {

    @Autowired
    private EmployeeRepository repo;

    public void run() {
        List<Employee> persons = createEmployees();
        repo.saveAll(persons);
        findAllEmployees();
        findEmployeesByNameOrPhoneType();
        findEmployeesByNameAndPhoneType();
        findEmployeesByNotName();
    }

    private void findEmployeesByNameOrPhoneType() {
        System.out.println("-- finding employees with name='Tim' OR PhoneType=Cell --");
        List<Employee> list = repo.findAll(EmployeeSpecs.getEmployeesByNameOrPhoneTypeSpec("Tim", PhoneType.Cell));
        list.forEach(System.out::println);
    }

    private void findEmployeesByNameAndPhoneType() {
        System.out.println("-- finding employees with name='Jack' AND PhoneType=Cell --");
        List<Employee> list = repo.findAll(EmployeeSpecs.getEmployeesByNameAndPhoneTypeSpec("Jack", PhoneType.Cell));
        list.forEach(System.out::println);
    }

    private void findEmployeesByNotName() {
        System.out.println("-- finding employees with name not 'Mike' --");
        List<Employee> list = repo.findAll(EmployeeSpecs.getEmployeeByNotNameSpec("Mike"));
        list.forEach(System.out::println);
    }

    private void findAllEmployees() {
        System.out.println(" -- getting all Employees --");
        Iterable<Employee> iterable = repo.findAll();
        List<Employee> allEmployees = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        allEmployees.forEach(System.out::println);
    }

    private static List<Employee> createEmployees() {
         return Arrays.asList(Employee.create("Diana",
                Phone.of(PhoneType.Home, "111-111-111"),Phone.of(PhoneType.Work, "222-222-222")),
                Employee.create("Mike", Phone.of(PhoneType.Work, "333-111-111"), Phone.of(PhoneType.Cell, "333-222-222")),
                Employee.create("Tim", Phone.of(PhoneType.Work, "444-111-111"), Phone.of(PhoneType.Home, "444-222-222")),
                Employee.create("Jack", Phone.of(PhoneType.Cell, "555-222-222")));
    }
}