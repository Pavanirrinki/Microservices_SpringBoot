package java.com.example.demo.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.com.example.demo.Entity.Users;
import java.com.example.demo.UserDto.UserDto;
import java.com.example.demo.UserRepository.UserRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDto save(UserDto userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Users users = userDtoToEntity(userDto);
		Users savedUsers = userRepository.save(users);
		return entityToUserDto(savedUsers);
	}



	private Users userDtoToEntity(UserDto userDto) {
		Users users = new Users();
		users.setName(userDto.getName());
		users.setEmail(userDto.getEmail());
		users.setPassword(userDto.getPassword());
		return users;
	}

	private UserDto entityToUserDto(Users users) {
		UserDto userDto = new UserDto();
		userDto.setName(users.getName());
		userDto.setEmail(users.getEmail());
		userDto.setPassword(users.getPassword());
		userDto.setId(users.getId());
		return userDto;
	}

	@Override
	public UserDto checkUserByEmailAndPassword(String email, String password) {
		Optional<Users> userOptional = userRepository.findByEmailAndPassword(email, password);
		return userOptional.map(this::entityToUserDto).orElse(null);
	}

	@Override
	@Transactional
	public String deleteUser(String email) {
		Optional<Users> deletedCount = userRepository.deleteByEmail(email);
		if (deletedCount.isPresent()) {
			return "User successfully deleted";
		}
		return "User not found";
	}

	@Override
	public UserDto updateuserData(Long id, UserDto userDto) {
	    Optional<Users> userOptional = userRepository.findById(id);
	    if (!userOptional.isPresent()) {
	        throw new RuntimeException("User not found with id: " + id);
	    }
	    Users user = userOptional.get();
	    user.setName(userDto.getName());
	    user.setEmail(userDto.getEmail());
	    user.setPassword(userDto.getPassword());

	    Users savedUsers = userRepository.save(user);
	    return entityToUserDto(savedUsers);
	}
}
