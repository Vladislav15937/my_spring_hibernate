package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);


      UserService userService = context.getBean(UserService.class);
      User user = new User("user1","user1","email1");
      User user1 = new User("user2","user2","email2");
      User user2 = new User("user3","user3","email3");
      Car car = new Car("M1",99);
      Car car1 = new Car("M2",100);
      Car car2 = new Car("M3",111);

      userService.add(user.setCar(car).setUser(user));
      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));


      List<User> users = userService.listUsers();
      for (User user100 : users) {
         System.out.println("Id = "+user100.getId());
         System.out.println("First Name = "+user100.getFirstName());
         System.out.println("Last Name = "+user100.getLastName());
         System.out.println("Email = "+user100.getEmail());
         System.out.println();
      }
      System.out.println(userService.getUser("M1", 99).toString());
      System.out.println(userService.getUser("M2", 100).toString());
      System.out.println(userService.getUser("M3", 111).toString());


      context.close();
   }
}
