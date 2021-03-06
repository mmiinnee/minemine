package com.example.demo.controller;

import com.example.demo.entity.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.CompanyTypeEntity;
import com.example.demo.entity.ProvinceEntity;
import com.example.demo.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController @CrossOrigin(origins = "http://localhost:4200")

public class CompanyController {
    @Autowired
    private CompanyTypeRepository companyTypeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ProvinceRepository provincRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository, CompanyTypeRepository companyTypeRepository,
                             ProvinceRepository provincRepository){
        this.companyRepository = companyRepository;
        this.companyTypeRepository = companyTypeRepository;
        this.provincRepository = provincRepository;

    }
    @GetMapping(path = "/companys", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CompanyEntity> Company(){
        return companyRepository.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping(path = "/companyType", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CompanyTypeEntity> CompanyType(){
        return companyTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/province", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ProvinceEntity> Provinc(){
        return provincRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/company/{companyName}/{companyType}/{companyAddress}/{provincName}")
    public CompanyEntity company(@RequestBody CompanyEntity comp, @PathVariable String companyName, @PathVariable String companyType,
                                  @PathVariable String companyAddress, @PathVariable String provincName) {
        CompanyEntity companyEntity = new CompanyEntity();
        CompanyTypeEntity companytype = companyTypeRepository.findBycompanyType(companyType);
        ProvinceEntity provinc = provincRepository.findByprovinceName(provincName);

        System.out.println(companyName);
        System.out.println(companyType);
        System.out.println(companyAddress);
        System.out.println(provincName);

        companyEntity.setCompanyName(companyName);
        companyEntity.setCompanyTypeEntity(companytype);
        companyEntity.setCompanyAddress(companyAddress);
        companyEntity.setProvineceEntity(provinc);




        return companyRepository.save(companyEntity);
    }


}
