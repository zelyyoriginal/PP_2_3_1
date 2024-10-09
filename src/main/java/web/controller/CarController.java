package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.services.CarServices;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    @GetMapping("/")
    public String showCars(@RequestParam(name = "count", defaultValue = "0") int count, ModelMap model) {
        List<Car> cars = new CarServices().getCars(count);
        model.addAttribute("cars", cars);
        return "car";
    }
}
