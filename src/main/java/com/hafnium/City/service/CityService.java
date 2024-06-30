package com.hafnium.City.service;

import com.hafnium.City.dto.request.CityRequestDto;
import com.hafnium.City.dto.response.CityResponseDto;
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

    public CityResponseDto createCity(CityRequestDto city) {
        City newCity = new City();
        newCity.setCityName(city.getCityName());
        newCity.setCreatedDate(new Date());

        City saveCity = new City();
        saveCity = cityRepository.save(newCity);

        CityResponseDto cityResponseDto = new CityResponseDto();
        cityResponseDto.setCityName(saveCity.getCityName());
        cityResponseDto.setCreatedDate(saveCity.getCreatedDate());
        return cityResponseDto;
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
