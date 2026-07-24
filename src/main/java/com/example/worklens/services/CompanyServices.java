package com.example.worklens.services;

import com.example.worklens.entity.Company;
import com.example.worklens.exception.custom.ResourceNotFoundException;
import com.example.worklens.repository.CompanyRepository;
import com.example.worklens.services.interfaces.CompanyImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServices implements CompanyImpl {
    private final CompanyRepository companyrepo;

    public CompanyServices(CompanyRepository company) {
        this.companyrepo = company;
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> company = companyrepo.findAll();
        return company;
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company with ID: "+ id + " not found"));
    }

    @Override
    public Company saveCompany(Company company) {
        return companyrepo.save(company);
    }

    @Override
    public void deleteCompanyById(Long id) {
        companyrepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Company with ID: "+id+" cannot be found"));
        companyrepo.deleteById(id);
    }
}
