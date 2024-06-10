package java.com.example.demo.UserService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.com.example.demo.Entity.FileUpload;
import java.com.example.demo.UserRepository.FileUploadRepository;

import jakarta.mail.Multipart;

@Service
public class FileUploadServiceImpl {
	
	@Autowired
	private FileUploadRepository fileuploadRepository;
	
	public String saveFile(MultipartFile file,String name,String description) throws IOException {
		FileUpload fileupload = new FileUpload();
		fileupload.setFile(file.getBytes());
		fileupload.setDescription(description);
		fileupload.setName(name);
		 fileuploadRepository.save(fileupload);
		
		 return "File Upload Successfully";
	}

	public FileUpload getFile(Long id) {
		
		return fileuploadRepository.findById(id).orElse(null);
	}
   
	

}
