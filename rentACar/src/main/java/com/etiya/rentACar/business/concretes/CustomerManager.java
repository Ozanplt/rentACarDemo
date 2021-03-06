package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CustomerService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.customerRequests.CreateCustomerRequest;
import com.etiya.rentACar.business.requests.customerRequests.DeleteCustomerRequest;
import com.etiya.rentACar.business.requests.customerRequests.UpdateCustomerRequest;
import com.etiya.rentACar.business.responses.customerResponses.CustomerDto;
import com.etiya.rentACar.business.responses.customerResponses.ListCustomerDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.CustomerDao;
import com.etiya.rentACar.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {

    private CustomerDao customerDao;
    private ModelMapperService modelMapperService;

    public CustomerManager(CustomerDao customerDao, ModelMapperService modelMapperService) {
        this.customerDao = customerDao;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public DataResult<Customer> add(CreateCustomerRequest createCustomerRequest) {

        Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
        this.customerDao.save(customer);

        return new SuccessDataResult<>(customer, BusinessMessages.CustomerMessage.CUSTOMER_ADDED);
    }

    @Override
    public Result update(UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
        this.customerDao.save(customer);
        return new SuccessResult(BusinessMessages.CustomerMessage.CUSTOMER_UPDATED);
    }

    @Override
    public Result delete(DeleteCustomerRequest deleteCustomerRequest) {
        this.customerDao.deleteById(deleteCustomerRequest.getId());
        return new SuccessResult(BusinessMessages.CustomerMessage.CUSTOMER_DELETED);
    }

    @Override
    public DataResult<List<ListCustomerDto>> getAll() {
        List<Customer> customers = this.customerDao.findAll();
        List<ListCustomerDto> response = customers.stream()
                .map(car -> this.modelMapperService.forDto().map(car, ListCustomerDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<ListCustomerDto>>(response);

    }

    @Override
    public DataResult<CustomerDto> getByLastCustomer(int id) {
        Customer customer = this.customerDao.getById(id);
        CustomerDto customerDto = this.modelMapperService.forDto().map(customer, CustomerDto.class);
        return new SuccessDataResult<CustomerDto>(customerDto);
    }
}

