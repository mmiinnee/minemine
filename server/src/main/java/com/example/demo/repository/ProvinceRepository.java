package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.demo.entity.ProvinceEntity;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long> {
    ProvinceEntity findByprovinceName(String provinceName);

    @Query("SELECT t FROM ProvinceEntity t WHERE t.provinceName = :Name")
    ProvinceEntity findByName(@Param("Name") String Name);

    @Query("SELECT t.provinceId FROM ProvinceEntity t WHERE t.provinceName = :Name")
    long findIdByName(@Param("Name") String Name);

    @Query("SELECT t FROM ProvinceEntity t WHERE t.provinceId = :provinceId")
    ProvinceEntity findProvinceById(@Param("provinceId") Long provinceId);

}
