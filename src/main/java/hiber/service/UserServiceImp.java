package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;
   private final CarDao carDao;

   public UserServiceImp(UserDao userDao, CarDao carDao) {
      this.userDao = userDao;
      this.carDao = carDao;
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   public void add(User user, Car car) {
      userDao.add(user, car);
   }

   // Optional<User> для того, чтобы дальше в функциональном стиле с ним работать
   @Override
   public Optional<User> userByCar(String model, int series) {
      Optional<Car> car = carDao.getBy(model, series);
      if (car.isPresent()) {
         return Optional.of(car.get().getUser());
      }

      return Optional.empty();
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }
}