package com.example;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;

@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... strings) {
        String sql = "SELECT id, first_name, last_name FROM customers WHERE id = :id";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", 2);
        /**
         * anonymous class
        Customer result = jdbcTemplate.queryForObject(sql, param,
                new RowMapper<Customer>() {
                    @Override
                    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Customer(rs.getInt("id"),
                                            rs.getString("first_name"),
                                            rs.getString("last_name"));
                    }
                });
        */

        /**
         * ramda expression
        Customer result = jdbcTemplate.queryForObject(sql, param,
                (rs, rowNum) -> new Customer(rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")));
         */

        // 데이터 추가
        Customer created = customerRepository.save(new Customer(null, "Hidetoshi", "Dekisugi"));
        System.out.println(created + " is created");

        // 데이터 표시
        customerRepository.findAll().forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
