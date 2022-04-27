package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.OrderedAdditionalProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedAdditionalPropertyDao extends JpaRepository<OrderedAdditionalProperty,Integer> {
    List<OrderedAdditionalProperty> getAllIdById(int id);
}
