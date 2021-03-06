package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.entities.Car;
import org.springframework.stereotype.Service;
import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.BrandDao;
import com.etiya.rentACar.entities.Brand;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandManager implements BrandService {
    private BrandDao brandDao;
    private ModelMapperService modelMapperService;

    public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
        super();
        this.brandDao = brandDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(CreateBrandRequest createBrandRequest) {
        checkIfBrandExists(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandDao.save(brand);
        return new SuccessResult(BusinessMessages.BrandMessage.BRAND_ADDED);

    }
    @Override
    public Result update(UpdateBrandRequest updateBrandRequest) {

        Brand brand= this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandDao.save(brand);
        return new SuccessResult(BusinessMessages.BrandMessage.BRAND_UPDATED);
    }

    @Override
    public Result delete(DeleteBrandRequest deleteBrandRequest) {
        this.brandDao.deleteById(deleteBrandRequest.getId());
        return new SuccessResult(BusinessMessages.BrandMessage.BRAND_DELETED);
    }

    @Override
    public DataResult<List<ListBrandDto>> getAll() {
        List<Brand> brands = this.brandDao.findAll();
        List<ListBrandDto> response = brands.stream()
                .map(brand -> this.modelMapperService.forDto()
                        .map(brand, ListBrandDto.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListBrandDto>>(response);
    }

    private void checkIfBrandExists(String brandName){
        if (brandDao.existsBrandByNameIgnoreCase(brandName)) {
            throw new BusinessException(BusinessMessages.BrandMessage.BRAND_NAME_EXISTS);
        }
    }
}

