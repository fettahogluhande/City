package com.hafnium.City.controller;

import com.hafnium.City.dto.request.CityRequestDto;
import com.hafnium.City.dto.response.CityResponseDto;
import com.hafnium.City.model.City;
import com.hafnium.City.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping
    public CityResponseDto createCity(@RequestBody CityRequestDto city) {
        return cityService.createCity(city);
    }

    @GetMapping
    public List<City> getAllCities(@RequestParam(required = false) String cityName) {
        return cityService.getAllCities(cityName);
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCity(@PathVariable Long id) {
        return cityService.deleteCity(id);
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable Long id, @RequestBody City city) {
        return cityService.updateCity(id, city);
    }
}
