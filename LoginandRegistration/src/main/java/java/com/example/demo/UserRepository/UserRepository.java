package java.com.example.demo.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import java.com.example.demo.Entity.*;



public interface UserRepository extends JpaRepository<Users, Long>{
	Optional<Users>  findByEmail(String username);
   Optional<Users> findByEmailAndPassword(String email, String password);
  
   Optional<Users> deleteByEmail(String email);
	

}
