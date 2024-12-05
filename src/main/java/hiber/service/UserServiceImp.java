package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;
   @Autowired
   private CarDao carDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   public void add(User user, Car car) {
      userDao.add(user, car);
   }

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
