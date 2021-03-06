package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.customerRequests.CreateCustomerRequest;
import com.etiya.rentACar.business.requests.customerRequests.DeleteCustomerRequest;
import com.etiya.rentACar.business.requests.customerRequests.UpdateCustomerRequest;
import com.etiya.rentACar.business.responses.customerResponses.CustomerDto;
import com.etiya.rentACar.business.responses.customerResponses.ListCustomerDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.entities.Customer;

import java.util.List;

public interface CustomerService {

    DataResult<List<ListCustomerDto>> getAll();

    Result delete(DeleteCustomerRequest deleteCustomerRequest);
    Result update(UpdateCustomerRequest updateCustomerRequest);
    DataResult<Customer> add(CreateCustomerRequest createCustomerRequest);
    DataResult<CustomerDto> getByLastCustomer(int id);
}