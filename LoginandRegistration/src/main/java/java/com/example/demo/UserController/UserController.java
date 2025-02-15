package java.com.example.demo.UserController;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.naming.AuthenticationException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.com.example.demo.Entity.Users;
import java.com.example.demo.Security.JwtTokenProvider;
import java.com.example.demo.UserDto.JWTAuthResponse;
import java.com.example.demo.UserDto.LoginDto;
import java.com.example.demo.UserDto.UserDto;
import java.com.example.demo.UserRepository.UserRepository;
import java.com.example.demo.UserService.UserService;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwttokenprovider;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/home")
	public String home() {
		return "Welcome spring Project";
	}

//Register the user details using post request
	@PostMapping("/register")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		return new ResponseEntity<>(userService.save(userDto), HttpStatus.CREATED);
	}

//Login the user using registered data
	@PostMapping("/login")
	public ResponseEntity<JWTAuthResponse> loginUser(@RequestBody LoginDto loginDto) {
		System.out.println("kumar");
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
			System.out.println("paaaaaa");
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = jwttokenprovider.generateToken(authentication);
			return  ResponseEntity.ok(new JWTAuthResponse(token));
		} catch (Exception e) {
			// Log the exception and return an error response
			if (e instanceof AuthenticationException) {
				System.out.println("Authentication failed: " + e.getMessage());
				return  (ResponseEntity<JWTAuthResponse>) ResponseEntity.status(HttpStatus.UNAUTHORIZED);
			} else {
				// Log unexpected exceptions
				System.out.println("Unexpected error: " + e.getMessage());
				return (ResponseEntity<JWTAuthResponse>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

//Delete the user using email as parameter
	@DeleteMapping("/deleteuser")
	public ResponseEntity<?> deleteUser(@RequestParam(name = "email") String email) {
		return new ResponseEntity<>(userService.deleteUser(email), HttpStatus.OK);
	}

	// update the user
	@PutMapping("/update-user")
	public UserDto UpdateUser(@RequestBody UserDto userDto, @RequestParam(name = "id") Long id) {
		UserDto userdto = userService.updateuserData(id, userDto);
		return userdto;

	}
	


	
	
}


