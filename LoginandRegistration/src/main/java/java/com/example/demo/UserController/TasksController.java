package java.com.example.demo.UserController;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.com.example.demo.UserDto.TasksDto;
import java.com.example.demo.UserDto.TasksOfAllUsers;
import java.com.example.demo.UserDto.UserDto;
import java.com.example.demo.UserRepository.TasksRepository;
import java.com.example.demo.UserService.TaskService;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TasksController {

	@Autowired
	private TasksRepository tasksRepository;
	
	@Autowired
	private TaskService taskservice;
	
	@PostMapping("/{user_id}")
	public ResponseEntity<?> createUser(@PathVariable(name = "user_id") Long user_id, @RequestBody TasksDto taskDto) throws Exception{
	    try {
            TasksDto savedTask = taskservice.save(user_id, taskDto);
	        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	}
	 @GetMapping("/user/{user_id}")
	    public ResponseEntity<List<TasksDto>> getAllTasksOfUser(@PathVariable("user_id") long userId) {
	     
	            List<TasksDto> tasks = taskservice.GetAllTasksofUser(userId);
	            
	            if (tasks.isEmpty()) {
	                return new ResponseEntity<>(HttpStatus.BAD_GATEWAY); // Or HttpStatus.NOT_FOUND based on your requirements
	            }
	            return new ResponseEntity<>(tasks, HttpStatus.OK);
	 }

	 @PutMapping("/user/{task_id}/{user_id}")
	 public ResponseEntity<?> updateTask(@PathVariable("task_id") long task_id, @RequestBody TasksDto taskDto,@PathVariable("user_id") long user_id) {
	     try {
	         TasksDto updatedTask = taskservice.UpdateTask(task_id, taskDto,user_id);
	         return new ResponseEntity<>(updatedTask, HttpStatus.OK);
	     } catch (Exception e) {
	         e.printStackTrace();
	         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	     }
	 }
@DeleteMapping("/{task_id}")
public ResponseEntity<String> DeleteTask(@PathVariable("task_id") long task_id) {
    try {
        String updatedTask = taskservice.DeleteTask(task_id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

@GetMapping("/All_tasks_of_users")
public ResponseEntity<List<TasksOfAllUsers>> GetAllTasks(){
	List<TasksOfAllUsers> alltasks = taskservice.getAllTasks();
	return new ResponseEntity<>(alltasks, HttpStatus.OK);
	
}
}
