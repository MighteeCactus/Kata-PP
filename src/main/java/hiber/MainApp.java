package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      userService.add(new User("Boris", "Razor", "missed-me@still-alive.com"),
              new Car("Lada", 777));
      userService.add(new User("Daniel", "Morales", "taxi@garage.com"),
              new Car("Peugeot 406",  1997));

      Consumer<User> presentUser = user -> {
         System.out.println("Id = "+ user.getId());
         System.out.println("First Name = "+ user.getFirstName());
         System.out.println("Last Name = "+ user.getLastName());
         System.out.println("Email = "+ user.getEmail());
         System.out.println();
      };

      List<User> users = userService.listUsers();
      users.forEach(presentUser);

      Consumer<User> presentDriver = user -> {
         System.out.println("Driver of a "+ user.getCar().getModel() + " " + user.getCar().getSeries() + " is:");
         presentUser.accept(user);
      };

      userService.userByCar("Peugeot 406", 1997).ifPresent(presentDriver);
      userService.userByCar("Mazda", 666).ifPresent(presentDriver);

      context.close();
   }
}
