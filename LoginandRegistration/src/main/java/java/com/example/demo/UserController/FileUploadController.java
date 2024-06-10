package java.com.example.demo.UserController;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.net.http.HttpHeaders;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.com.example.demo.Entity.FileUpload;
import java.com.example.demo.UserService.FileUploadServiceImpl;

@RestController
@RequestMapping("/file_upload")
public class FileUploadController {
	
	@Autowired
	private FileUploadServiceImpl fileUploadService;
	
	
	@PostMapping("/save")
	
	public String fileUpload(
			@RequestParam("file") MultipartFile file,
			@RequestParam("name") String name,
			@RequestParam("description") String description) throws IOException {
		System.out.println("llllll");
		fileUploadService.saveFile(file,name,description);
		return null;
		
	}
}
