package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user, Car car) {
      userDao.add(car);
      userDao.add(user);
   }

   @Transactional
   @Override
   public void add(Car car) {
      userDao.add(car);
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public User getUser(String model, int series) {
      return userDao.getUser(model, series);
   }
   @Transactional(readOnly = true)
   @Override
   public void tata(String model, int series){
   }

   @Override
   public String toString() {
      return "UserServiceImp{" +
              "userDao=" + userDao +
              '}';
   }
}
