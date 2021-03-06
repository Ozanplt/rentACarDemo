package com.etiya.rentACar.business.requests.paymentRequests;

import com.etiya.rentACar.entities.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.modelmapper.internal.bytebuddy.build.ToStringPlugin;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {

    @JsonIgnore
    private int id;

    private LocalDate rentDate;

    private LocalDate returnDate;

    @JsonIgnore
    private double totalPrice;


    //Kart bilgileri

    private String cardNumber;

    private String cardFirstName;

    private String cardLastName;

    private String expirationDate;

    private String cvc;

    private String customerFirstName;

    private String customerLastName;

    private int carId;

    private int returnCityId;

    private int rentCityId;

    private double returnKilometer;

    @JsonIgnore
    private int invoiceId;

    @JsonIgnore
    private int rentalId;

    private List<Integer> orderedAdditionalPropertyIdentities;

    private double discountRate;
}
