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
	public CompanyDto updateCompanyDetails(String company_id, String name, 
			String email, String mobilenumber,List<String> companyDescription, List<String> workingTechnologies) {
		
		Company_Table company = companyRepository.findById(company_id).get();
		company.setCompanyDescription(companyDescription);
		company.setName(name);
		company.setWorkingTechnologies(workingTechnologies);
		company.setMobile(Long.parseLong(mobilenumber));
		company.setEmail(email);
		companyRepository.save(company);
		CompanyDto updatedCompany = modelMapper.map(company, CompanyDto.class);
		return updatedCompany;
	}

	@Override
	public CompanyDto saveCompanyDetails(String name, List<String> companyDescription, String email, long mobilenumber,
			String password, List<String> workingTechnologies,String profile_pic) {
	    Company_Table company = new Company_Table();
	    company.setCompanyDescription(companyDescription);
	    company.setEmail(email);
	    company.setName(name);
	    company.setMobile(mobilenumber);
	    company.setPassword(password);
	    company.setWorkingTechnologies(workingTechnologies);
	    company.setComapany_profile_pic(profile_pic);
	    return modelMapper.map(companyRepository.save(company), CompanyDto.class);
		
	}

	@Override
	public CompanyDto loginuser(Map<String, String> loginuser) throws Exception {
		Company_Table  companyDetails = companyRepository.findByEmail(loginuser.get("email"));
		   if(companyDetails == null) {
			   throw new Exception("User not found with email: " + loginuser.get("email")); 
		   } if(!companyDetails.getPassword().equals(loginuser.get("password"))) {
			   throw new Exception("Email and password not match:"); 
		   }
		return modelMapper.map(companyDetails, CompanyDto.class);

	}

	

}
