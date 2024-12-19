package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    void add(User user, Car car);

    // Optional<User> для того, чтобы дальше в функциональном стиле с ним работать
    Optional<User> userByCar(String model, int series);
}
