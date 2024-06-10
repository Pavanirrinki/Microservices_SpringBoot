package java.com.example.demo.Security;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.com.example.demo.Entity.Users;
import java.com.example.demo.UserRepository.UserRepository;

@Service
public class customUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
Users users = userRepository.findByEmail(username).get();

		return new User(users.getEmail(), users.getPassword(),Collections.emptyList());
	}

}
