package com.etiya.rentACar.business.responses.paymentResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListPaymentDto {

    private int id;

    private LocalDate rentDate;

    private LocalDate returnDate;

    private double totalPrice;

    private String cardNumber;

    private String cardFirstName;

    private String cardLastName;

    private String expirationDate;

    private String cvc;

    private String customerFirstName;

    private String customerLastName;

    private String carBrandName;

    private String returnCityName;

    private String rentCityName;

    private int invoiceId;

    private int rentalId;

    private String billNo;

    private double carDailyPrice;

    private double rentalDailyDiscountedTotalPrice;

}
