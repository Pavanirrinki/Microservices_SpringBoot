package java.com.example.demo.UserService;

import java.util.List;

import org.apache.catalina.User;

import java.com.example.demo.Entity.Users;
import java.com.example.demo.UserDto.UserDto;

public interface UserService {
    UserDto save(UserDto userDto);
  
   UserDto checkUserByEmailAndPassword(String email, String password);
   String deleteUser(String email);
  UserDto updateuserData(Long id,UserDto userDto);

}
