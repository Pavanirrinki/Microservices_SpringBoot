package java.com.example.demo.UserRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.com.example.demo.Entity.Tasks;
import java.com.example.demo.UserDto.TasksOfAllUsers;

public interface TasksRepository extends JpaRepository<Tasks,Long>{


	List<Tasks> findAllByUsersId(long id);
	
	@Query("SELECT new com.example.demo.UserDto.TasksOfAllUsers(u.Name, u.id, t.task_name, t.status) FROM Tasks t JOIN t.users u")
	List<TasksOfAllUsers> getAllTasks();



}
