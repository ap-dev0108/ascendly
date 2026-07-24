package com.example.worklens.services.interfaces;

import com.example.worklens.entity.Company;

import java.util.List;

public interface CompanyImpl {
    //Save Operation
    Company saveCompany(Company company);

    //Read Operation
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);

    //Delete Operation
    void deleteCompanyById(Long id);
}
