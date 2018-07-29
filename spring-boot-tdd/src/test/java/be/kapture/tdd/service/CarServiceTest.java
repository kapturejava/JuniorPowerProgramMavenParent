package be.kapture.tdd.service;


import be.kapture.tdd.domain.Car;
import be.kapture.tdd.exception.CarNotFoundException;
import be.kapture.tdd.repository.CarRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;


    @Before
    public void setUp(){
        carService = new CarService(carRepository);
    }

    @Test
    public void getCar_shouldReturnCar() throws Exception {

        given(carRepository.findByName("prius")).willReturn(new Car("prius","hybrid"));

        Car car = carService.getCarDetails("prius");
        assertThat(car.getName()).isEqualTo("prius");
        assertThat(car.getType()).isEqualTo("hybrid");

    }

    @Test(expected = CarNotFoundException.class)
    public void getCar_notFound() throws Exception {
        given(carRepository.findByName(anyString())).willReturn(null);

        Car car = carService.getCarDetails("prius");
    }





}