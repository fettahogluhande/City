package com.hafnium.City.service;

import com.hafnium.City.model.City;
import com.hafnium.City.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public City createCity(City city) {
        city.setCreatedDate(new Date());
        return cityRepository.save(city);
    }

    public List<City> getAllCities(String cityName) {
        if (Objects.isNull(cityName)) {
            return cityRepository.findAll();
        }else{
            return cityRepository.findAllByCityName(cityName);
        }
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new RuntimeException("City not found"));
    }
    public String deleteCity(Long id) {
         City city = cityRepository.findById(id).orElseThrow(() -> new RuntimeException("City not found"));
         cityRepository.deleteById(id);
         return "City deleted successfully";
    }

    public City updateCity(Long id, City city) {
        City existingCity = cityRepository.findById(id).orElseThrow(() -> new RuntimeException("City not found"));
        existingCity.setCityName(city.getCityName());
        return cityRepository.save(existingCity);
    }
}
