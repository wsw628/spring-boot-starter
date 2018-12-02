package com.example;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... strings) {
        // 데이터 추가
        Customer created1 = customerRepository.save(new Customer(null, "Hidetoshi", "Dekisugi"));
        Customer created2 = customerRepository.save(new Customer(null, "Kim", "Ji"));
        Customer created3 = customerRepository.save(new Customer(null, "Park", "Jisong"));
        Customer created4 = customerRepository.save(new Customer(null, "Wee", "RG"));
        Customer created5 = customerRepository.save(new Customer(null, "Choi", "Il"));
        System.out.println(created1 + " is created");

        // 페이징 처리
        Pageable pageable = new PageRequest(0, 3);
        Page<Customer> page = customerRepository.findAllOrderByNameWithPaging(pageable);

        System.out.println("한 페이지당 데이터수=" + page.getSize());
        System.out.println("현재 페이지=" + page.getNumber());
        System.out.println("전체 페이지 수=" + page.getTotalPages());
        System.out.println("전체 데이터 수=" + page.getTotalElements());
        page.getContent().forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
