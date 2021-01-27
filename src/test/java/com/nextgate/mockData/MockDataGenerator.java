package com.nextgate.mockData;

import com.github.javafaker.Faker;

import java.util.logging.Logger;

public class MockDataGenerator {



       private static Faker faker = new Faker();
       public static String getMockData(String data){
        String username = faker.name().firstName().toLowerCase();
        String password = faker.bothify(username.substring(0, 1)
                .toUpperCase().concat(username.substring(1)
                        .concat(faker.regexify("[!, @, #, $, %, ^, &, *]"))));
        if(data.equals("username")) return username;
        else return password;
    }




}
