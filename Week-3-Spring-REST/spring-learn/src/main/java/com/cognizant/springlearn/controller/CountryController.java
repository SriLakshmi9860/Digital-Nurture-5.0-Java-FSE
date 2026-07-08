package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public Country getCountryIndia() {

        Country country = new Country();
        country.setCode("IN");
        country.setName("India");

        return country;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {

        System.out.println("Start");
        System.out.println("Country code requested: " + code);

        Country country = countryService.getCountry(code);

        System.out.println("Country found: " + country.getName());
        System.out.println("End");

        return country;
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) {

        System.out.println("Start");

        System.out.println("Country Code : " + country.getCode());
        System.out.println("Country Name : " + country.getName());

        System.out.println("End");

        return country;
    }
}