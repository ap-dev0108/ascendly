package com.example.worklens.controller;

import com.example.worklens.dto.ApiResponse;
import com.example.worklens.entity.Company;
import com.example.worklens.services.CompanyServices;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    private final CompanyServices companyServices;

    public CompanyController(CompanyServices company) {
        this.companyServices = company;
    }

    @GetMapping("/getAllCompanies")
    public ApiResponse<List<Company>> GetAllCompanies() {
        List<Company> company_list= companyServices.getAllCompanies();
        return new ApiResponse<>(
                true,
                "Company List is fetched",
                company_list
        );
    }

    @GetMapping("/getCompanyById")
    public ApiResponse<Company> GetCompanyById(@RequestBody Long id) {
        Company company_by_id = companyServices.getCompanyById(id);
        return new ApiResponse<>(
                true,
                "Company with ID: "+id+" has been found",
                new Company()
        );
    }

    @PostMapping("/addCompanies")
    public ApiResponse<Company> AddCompanies(@RequestBody Company company) {
        Company newCompany = companyServices.saveCompany(company);
        return new ApiResponse<>(
                true,
                "Company Registered",
                newCompany
        );
    }

    @DeleteMapping("/deleteCompany")
    public ApiResponse<String> DeleteCompany(@RequestBody Long id) {
        return new ApiResponse<>(
                true,
                "Company Deleted",
                "Company ID: "+id.toString()
        );
    }
}
