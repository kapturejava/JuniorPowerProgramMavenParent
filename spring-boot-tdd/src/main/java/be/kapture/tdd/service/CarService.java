package be.kapture.tdd.service;

import be.kapture.tdd.domain.Car;
import be.kapture.tdd.exception.CarNotFoundException;
import be.kapture.tdd.repository.CarRepository;

public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {

        this.carRepository = carRepository;
    }

    public Car getCarDetails(String name) {
        Car car = carRepository.findByName(name);
        if(car == null) throw new CarNotFoundException();
        return car;
    }
}
