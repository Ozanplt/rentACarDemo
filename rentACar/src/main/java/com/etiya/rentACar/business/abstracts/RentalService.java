package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.rentalRequests.*;
import com.etiya.rentACar.business.responses.rentalResponses.ListRentalDto;
import com.etiya.rentACar.business.responses.rentalResponses.RentalDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.entities.Rental;
import lombok.Data;

public interface RentalService {
    DataResult<List<ListRentalDto>> getAll();
    DataResult<Rental> add(CreateRentalRequest createRentalRequest);

    Result updateRentalReturnDate(UpdateReturnDateRequest updateReturnDateRequest);
    Result update(UpdateRentalRequest updateRentalRequest);
    Result delete(DeleteRentalRequest deleteRentalRequest);
    DataResult<RentalDto> getById(int id);
    DataResult<RentalDto> getByLastRental(int id);

    double setDiscountedPrice(int carId);///
}