package com.etiya.rentACar.business.responses.carResponses;


import com.etiya.rentACar.entities.CarStates;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ListCarDto {
    private int id;
    private double dailyPrice;
    private String description;
    private double modelYear;
    private String colorName;
    private String brandName;
    private CarStates carState;
    private LocalDate maintenanceReturnDate;
    private String cityName;
    private double carKilometer;

}
