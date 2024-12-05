package hiber.dao;

import hiber.model.Car;

import java.util.Optional;

public interface CarDao {
    Optional<Car> getBy(String model, int series);
}
