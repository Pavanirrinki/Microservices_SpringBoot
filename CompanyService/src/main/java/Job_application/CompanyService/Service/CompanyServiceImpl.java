package Job_application.CompanyService.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Job_application.CompanyService.CompanyDto.CompanyDto;
import Job_application.CompanyService.CompanyRepository.CompanyRepository;
import Job_application.CompanyService.Entity.Company_Table;


@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private ModelMapper modelMapper;

	

	@Override
	public List<Company_Table> fetchAllCompanies() {
		List<Company_Table> allcompanies = companyRepository.findAll();
		return allcompanies;
	}

	@Override
	public CompanyDto updateCompanyDetails(String company_id,CompanyDto companyDto) {
		Company_Table company = companyRepository.findById(company_id).get();
		company.setCompanyDescription(companyDto.getCompanyDescription());
		company.setName(companyDto.getName());
		company.setWorkingTechnologies(companyDto.getWorkingTechnologies());
		companyRepository.save(company);
		CompanyDto updatedCompany = modelMapper.map(company, CompanyDto.class);
		return updatedCompany;
	}

	@Override
	public CompanyDto saveCompanyDetails(String name, List<String> companyDescription, String email, long mobilenumber,
			String password, List<String> workingTechnologies) {
	    Company_Table company = new Company_Table();
	    company.setCompanyDescription(companyDescription);
	    company.setEmail(email);
	    company.setName(name);
	    company.setMobile(mobilenumber);
	    company.setPassword(password);
	    company.setWorkingTechnologies(workingTechnologies);
	    return modelMapper.map(companyRepository.save(company), CompanyDto.class);
		
	}

	@Override
	public String loginuser(Map<String, String> loginuser) throws Exception {
		Company_Table  companyDetails = companyRepository.findByEmail(loginuser.get("email"));
		   if(companyDetails == null) {
			   throw new Exception("User not found with email: " + loginuser.get("email")); 
		   } if(!companyDetails.getPassword().equals(loginuser.get("password"))) {
			   throw new Exception("Email and password not match:"); 
		   }
		return "User Successffully Login";

	}

	

}
