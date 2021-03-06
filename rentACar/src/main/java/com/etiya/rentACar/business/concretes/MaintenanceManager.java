package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.abstracts.MaintenanceService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarStatusRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.DeleteMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.UpdateMaintenanceRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.MaintenanceDao;
import com.etiya.rentACar.entities.CarStates;
import com.etiya.rentACar.entities.Maintenance;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MaintenanceManager implements MaintenanceService {

    private MaintenanceDao maintenanceDao;
    private ModelMapperService modelMapperService;
    private CarService carService;

    public MaintenanceManager(MaintenanceDao maintenanceDao, ModelMapperService modelMapperService, CarService carService) {
        this.maintenanceDao = maintenanceDao;
        this.modelMapperService = modelMapperService;
        this.carService = carService;
    }

    @Override
    public Result add(CreateMaintenanceRequest createMaintenanceRequest) {
        checkCarStatus(createMaintenanceRequest.getReturnDate(), createMaintenanceRequest.getAddDate(), createMaintenanceRequest.getCarId());
        Maintenance maintenance = this.modelMapperService.forRequest().map(createMaintenanceRequest, Maintenance.class);
        this.maintenanceDao.save(maintenance);
        UpdateCarStatusRequest updateCarStatusRequest = new UpdateCarStatusRequest(createMaintenanceRequest.getCarId(), CarStates.UnderMaintenance);
        carService.updateCarStatus(updateCarStatusRequest);
        return new SuccessResult(BusinessMessages.MaintenanceMessages.MAINTENANCE_ADDED);
    }

    @Override
    public Result delete(DeleteMaintenanceRequest deleteMaintenanceRequest) {
        this.maintenanceDao.deleteById(deleteMaintenanceRequest.getCarId());
        return new SuccessResult(BusinessMessages.MaintenanceMessages.MAINTENANCE_DELETED);
    }

    @Override
    public Result update(UpdateMaintenanceRequest updateMaintenanceRequest) {
        checkCarStatus(updateMaintenanceRequest.getReturnDate(), updateMaintenanceRequest.getAddDate(), updateMaintenanceRequest.getCarId());
        Maintenance maintenance = this.modelMapperService.forRequest().map(updateMaintenanceRequest, Maintenance.class);
        this.maintenanceDao.save(maintenance);
        return new SuccessResult(BusinessMessages.MaintenanceMessages.MAINTENANCE_UPDATED);
    }

    @Override
    public DataResult<List<ListMaintenanceDto>> getAll() {
        List<Maintenance> maintenances = this.maintenanceDao.findAll();
        List<ListMaintenanceDto> response = maintenances.stream()
                .map(maintenance -> this.modelMapperService.forDto().map(maintenance, ListMaintenanceDto.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListMaintenanceDto>>(response);    }

    @Override
    public DataResult<List<ListMaintenanceDto>> getByCarId(int carId) {
        List<Maintenance> maintenances = this.maintenanceDao.getByCarId(carId);
        List<ListMaintenanceDto> response = maintenances.stream()
                .map(maintenance -> this.modelMapperService.forDto().map(maintenance, ListMaintenanceDto.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListMaintenanceDto>>(response);
    }


    private void checkMaintenanceDate(LocalDate returnDate, LocalDate addDate){
        if (returnDate.isBefore(addDate)) {
            throw new BusinessException(BusinessMessages.MaintenanceMessages.MAINTENANCE_DATE_NOT_AVAILABLE);
        }
    }

    private void checkCarStatus(LocalDate returnDate,LocalDate addDate, int carId){
        if (!carService.checkIfCarAvailable(carId)) {
            checkMaintenanceDate(returnDate,addDate);
        }
    }
}