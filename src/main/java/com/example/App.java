package com.example;

import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
import com.example.app.Frontend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.Scanner;

@EnableAutoConfiguration
//@Import(AppConfig.class)
@ComponentScan
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        try (ConfigurableApplicationContext context =
                     SpringApplication.run(App.class, args)) {

            /**
             * ArgumentResolver 를 통해 아래 부분도 추상화가 되었다
             *
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter 2 numbers like 'a b' : ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            */

            /**
             * Frontend 를 통해 다시 한번 추상화 된다
             *
            System.out.print("Enter 2 numbers like 'a b' : ");
            ArgumentResolver argumentResolver = context.getBean(ArgumentResolver.class);
            Argument argument = argumentResolver.resolve(System.in);
            Calculator calculator = context.getBean(Calculator.class);
            int result = calculator.calc(argument.getA(), argument.getB());
            System.out.println("result : " + result);
            */

            Frontend frontend = context.getBean(Frontend.class);
            frontend.run();
        }
    }
}
