package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void  add (Car car);
    void add(User user);
    List<User> listUsers();
    void add(User user,Car car);
    User getUser(String model, int series);
    void tata (String model, int series);
}
