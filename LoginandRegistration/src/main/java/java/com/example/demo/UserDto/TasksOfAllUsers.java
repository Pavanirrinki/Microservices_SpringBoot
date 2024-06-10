package java.com.example.demo.UserDto;

public class TasksOfAllUsers {
   private String name;
   private long id;
   private String task_name;
   private String status;
   
public TasksOfAllUsers(String name, long id, String task_name, String status) {
	super();
	this.name = name;
	this.id = id;
	this.task_name = task_name;
	this.status = status;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTask_name() {
	return task_name;
}
public void setTask_name(String task_name) {
	this.task_name = task_name;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
