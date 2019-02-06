package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.demo.entity.CompanyTypeEntity;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface CompanyTypeRepository extends JpaRepository<CompanyTypeEntity, Long> {
    CompanyTypeEntity findBycompanyType(String companyType);
    CompanyTypeEntity findBycompanyTypeId(Long companyTypeId);
}
