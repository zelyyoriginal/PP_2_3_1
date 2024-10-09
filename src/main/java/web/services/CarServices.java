package web.services;

import web.models.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServices {
    List<Car> cars;

    public CarServices() {
        cars = new ArrayList<Car>();
        cars.add(new Car("TOYOTA", 2001, "BLACK"));
        cars.add(new Car("TOYOTA", 2024, "ORANGE"));
        cars.add(new Car("BMW", 1997, "RED"));
        cars.add(new Car("LADA", 20017, "BLUE"));
        cars.add(new Car("HKJHKL", 1000, "BLACK"));
    }

    public List<Car> getCars(int count) {

        if (count == 0 || count >= 5) {
            return cars;
        }
        return cars.subList(0, count);
    }
}
