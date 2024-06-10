package Job_application.CompanyService.Service;

import java.util.List;
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
	public CompanyDto saveComapny(CompanyDto companyDto) {
	
		
		Company_Table company = companyRepository.save(modelMapper.map(companyDto, Company_Table.class));
		CompanyDto savedcompanies = modelMapper.map(company, CompanyDto.class);
         return savedcompanies;
		}

	@Override
	public List<Company_Table> fetchAllCompanies() {
		List<Company_Table> allcompanies = companyRepository.findAll();
		return allcompanies;
	}

	@Override
	public CompanyDto updateCompanyDetails(UUID company_id,CompanyDto companyDto) {
		Company_Table company = companyRepository.findById(company_id).get();
		company.setCompanyDescription(companyDto.getCompanyDescription());
		company.setCompanyName(companyDto.getCompanyName());
		company.setWorkingTechnologies(companyDto.getWorkingTechnologies());
		companyRepository.save(company);
		CompanyDto updatedCompany = modelMapper.map(company, CompanyDto.class);
		return updatedCompany;
	}

	

}
