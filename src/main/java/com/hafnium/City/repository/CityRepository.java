package com.hafnium.City.repository;

import com.hafnium.City.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {

    List<City> findAllByCityName(String cityName);
}
