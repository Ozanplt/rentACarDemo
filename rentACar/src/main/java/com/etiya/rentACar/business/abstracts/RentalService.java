package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.UpdateReturnDateRequest;
import com.etiya.rentACar.business.responses.rentalResponses.ListRentalDto;
import com.etiya.rentACar.business.responses.rentalResponses.RentalDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.entities.Rental;

import java.util.List;

public interface RentalService {
    DataResult<List<ListRentalDto>> getAll();
    DataResult<Rental> add(CreateRentalRequest createRentalRequest);

    Result updateRentalReturnDate(UpdateReturnDateRequest updateReturnDateRequest);
    Result update(UpdateRentalRequest updateRentalRequest);
    Result delete(DeleteRentalRequest deleteRentalRequest);
    DataResult<RentalDto> getById(int id);
    DataResult<RentalDto> getByLastRental(int id);

    double setDiscountedPrice(int carId, double discountRate);///
}