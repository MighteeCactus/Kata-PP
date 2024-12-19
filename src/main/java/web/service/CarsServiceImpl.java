package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.List;

@Component
public class CarsServiceImpl implements CarsService {

    @Autowired
    List<Car> cars;

    @Override
    public List<Car> getCars(int count) {
        long limit = count < 1 ? cars.size() : count;
        return cars.stream().limit(limit).toList();
    }
}
