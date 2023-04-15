package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImp implements CarService {
    private List<Car> cars;

    public CarServiceImp(List<Car> cars) {
        this.cars = new ArrayList<>();
    }

    public CarServiceImp() {

    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> getCar(Integer count) {
        if (count == null || count >= 5) {
            return cars;
        }
        return cars.subList(0, count);
    }

    @Override
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
