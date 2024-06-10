package java.com.example.demo.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.com.example.demo.Entity.FileUpload;

@Repository
public interface FileUploadRepository extends JpaRepository<FileUpload, Long>{

}
