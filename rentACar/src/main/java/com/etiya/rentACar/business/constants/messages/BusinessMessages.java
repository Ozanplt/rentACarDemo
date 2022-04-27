package com.etiya.rentACar.business.constants.messages;

public class BusinessMessages {
    public class MaintenanceMessages{

        public static final String MAINTENANCE_DATE_NOT_AVAILABLE="MAINTENANCE_DATE_NOT_AVAILABLE";
        public static final String MAINTENANCE_ADDED="MAINTENANCE_ADDED";
        public static final String MAINTENANCE_UPDATED="MAINTENANCE_UPDATED";
        public static final String MAINTENANCE_DELETED="MAINTENANCE_DELETED";
    }
    public class CarStateMessage {
        public static final String CAR_STATE_UNDER_MAINTENANCE="CAR_STATE_UNDER_MAINTENANCE";
        public static final String CAR_STATE_AVAILABLE="CAR_STATE_AVAILABLE";
        public static final String CAR_STATE_RENTED="CAR_STATE_RENTED";
        public static final String CAR_NOT_AVAILABLE = "CAR_NOT_AVAILABLE";


    }
    public class BrandMessage {
        public static final String BRAND_NAME_EXISTS = "BRAND_NAME_EXISTS";
        public static final String BRAND_ADDED="BRAND_ADDED";
        public static final String BRAND_UPDATED="BRAND_UPDATED";
        public static final String BRAND_DELETED="BRAND_DELETED";

    }
    public class ColorMessage {
        public static final String COLOR_NAME_EXISTS = "COLOR_NAME_EXISTS";
        public static final String COLOR_ADDED="COLOR_ADDED";
        public static final String COLOR_UPDATED="COLOR_UPDATED";
        public static final String COLOR_DELETED="COLOR_DELETED";

    }
    public class CarMessage {

        public static final String CAR_ADDED="CAR_ADDED";
        public static final String CAR_UPDATED="CAR_UPDATED";
        public static final String CAR_DELETED="CAR_DELETED";
        public static final String CAR_NOT_EXISTS = "CAR_NOT_EXISTS";

    }

    public class RentalMessage {
        public static final String RENTAL = " !";
        public static final String RENTAL_ADDED="RENTAL_ADDED";
        public static final String RENTAL_UPDATED="RENTAL_UPDATED";
        public static final String RENTAL_DELETED="RENTAL_DELETED";

    }
    public class CarDamageMessage {

        public static final String DAMAGE_ADDED="DAMAGE_ADDED";
        public static final String DAMAGE_UPDATED="DAMAGE_UPDATED";
        public static final String DAMAGE_DELETED="DAMAGE_DELETED";

    }

    public class CustomerMessage {
        public static final String CUSTOMER = " !";
        public static final String CUSTOMER_ADDED="CUSTOMER_ADDED";
        public static final String CUSTOMER_UPDATED="CUSTOMER_UPDATED";
        public static final String CUSTOMER_DELETED="CUSTOMER_DELETED";

    }

    public class AdditionalPropertyMessage {
        public static final String ADDITIONAL_PROPERTY = " !";
        public static final String ADDITIONAL_PROPERTY_ADDED="ADDITIONAL_PROPERTY_ADDED";
        public static final String ADDITIONAL_PROPERTY_UPDATED="ADDITIONAL_PROPERTY_UPDATED";
        public static final String ADDITIONAL_PROPERTY_DELETED="ADDITIONAL_PROPERTY_DELETED";
        public static final String ADDITIONAL_PROPERTY_ALREADY_EXISTS="ADDITIONAL_PROPERTY_ALREADY_EXISTS";

    }
    public class CityMessage {
        public static final String CITY = " !";
        public static final String CITY_ADDED="CITY_ADDED";
        public static final String CITY_UPDATED="CITY_UPDATED";
        public static final String CITY_DELETED="CITY_DELETED";
        public static final String CITY_ALREADY_EXISTS="CITY_ALREADY_EXISTS";

    }

    public class OrderedAdditionalPropertyMessage {
        public static final String ORDERED_ADDITIONAL_PROPERTY = " !";
        public static final String ORDERED_ADDITIONAL_PROPERTY_ADDED="ORDERED_ADDITIONAL_PROPERTY_ADDED";
        public static final String ORDERED_ADDITIONAL_PROPERTY_UPDATED="ORDERED_ADDITIONAL_PROPERTY_UPDATED";
        public static final String ORDERED_ADDITIONAL_PROPERTY_DELETED="ORDERED_ADDITIONAL_PROPERTY_DELETED";
        public static final String ORDERED_ADDITIONAL_PROPERTY_ALREADY_EXISTS="ORDERED_ADDITIONAL_PROPERTY_ALREADY_EXISTS";

    }

    public class InvoiceMessage {
        public static final String INVOICE = " !";
        public static final String INVOICE_ADDED="INVOICE_ADDED";
        public static final String INVOICE_UPDATED="INVOICE_UPDATED";
        public static final String INVOICE_DELETED="INVOICE_DELETED";

    }

    public class PaymentMessage {
        public static final String PAYMENT = " !";
        public static final String PAYMENT_ADDED="PAYMENT_ADDED";
        public static final String PAYMENT_UPDATED="PAYMENT_UPDATED";
        public static final String PAYMENT_DELETED="PAYMENT_DELETED";
        public static final String PAYMENT_NOT_ACCEPTED ="PAYMENT_NOT_ACCEPTED";

    }
}
