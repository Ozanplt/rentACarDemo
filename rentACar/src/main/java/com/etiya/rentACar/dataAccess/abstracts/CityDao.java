package com.etiya.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.rentACar.entities.City;
import com.etiya.rentACar.entities.Rental;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityDao extends JpaRepository<City, Integer> {
    City getById(int id);

    boolean existsCityByNameIgnoreCase(String cityName);

}