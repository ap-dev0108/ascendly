package com.example.worklens.services;

import com.example.worklens.entity.Company;
import com.example.worklens.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServices {
    private final CompanyRepository _company;

    public CompanyServices(CompanyRepository company) {
        this._company = company;
    }

    public List<Company> GetAllCompanies() {
        var company = _company.findAll();
        if (company.isEmpty()) {
            return null;
        }
        return company;
    }
}
