package com.example.worklens.entity;

import jakarta.persistence.*;

@Entity
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long company_id;

    @Column(name = "company_name")
    public String company_name;

    @Column(name = "company_mail")
    public String company_mail;

    @Column(name = "website_url")
    public String website_url;

    @Column(name = "is_active")
    public boolean is_active;

    @Column(name = "logo_url")
    public String logo_url;

    public Company() {

    }

    //GETTER
    public Long getCompany_id() {
        return company_id;
    }
    public String getCompany_name() {
        return company_name;
    }
    public String getCompany_mail() {
        return company_mail;
    }
    public String getWebsite_url() {
        return website_url;
    }
    public String getLogo_url() {
        return logo_url;
    }
    public boolean getIsActive() {
        return is_active;
    }

    //SETTER
    public void setCompany_id(Long id) {
        this.company_id = id;
    }
    public void setCompany_name(String name) {
        this.company_name = name;
    }
    public void setCompany_mail(String mail) {
        this.company_mail = mail;
    }
    public void setWebsite_url(String url) {
        this.website_url = url;
    }
    public void setIs_active(boolean active) {
        this.is_active = active;
    }
    public void setLogo_url(String logo) {
        this.logo_url = logo;
    }
}
