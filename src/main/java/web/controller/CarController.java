package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/car")
    public String printWelcome(@RequestParam(required = false) Integer count , Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Los", 343, "K089OP"));
        cars.add(new Car("erw", 1233, "X089OP"));
        cars.add(new Car("ooij", 854166, "M089XP"));
        cars.add(new Car("uoioz", 8665, "O089OP"));
        cars.add(new Car("oljue", 5547, "A082OA"));
        cars.add(new Car("erwyu", 1990, "X089OO"));
        carService.setCars(cars);
        model.addAttribute("car", carService.getCar(count));
        return "car";
    }
}
