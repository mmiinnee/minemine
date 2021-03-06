package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "COMPANY")
public class CompanyEntity {
    @Id
    @SequenceGenerator(name="company_seq",sequenceName="company_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="company_seq")
    @Column(name="companyId",unique = true, nullable = false)
    private @NonNull Long companyId;
    @NotNull
    @Size(min=6,max=50)
    @Pattern(regexp = "^บริษัท([ก-ู]|[เ-์])+")
    private  String companyName;
    @NotNull
    @Column(unique = true)
    private  String companyAddress;

    @ManyToOne(fetch=FetchType.EAGER, targetEntity = CompanyTypeEntity.class)
    private CompanyTypeEntity companyTypeEntity;

    @ManyToOne(fetch=FetchType.EAGER, targetEntity = ProvinceEntity.class)
    private ProvinceEntity provinceEntity;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public CompanyTypeEntity getCompanyTypeEntity() {
        return companyTypeEntity;
    }

    public void setCompanyTypeEntity(CompanyTypeEntity companyTypeEntity) {
        this.companyTypeEntity = companyTypeEntity;
    }

    public ProvinceEntity getProvincEntity() {
        return provinceEntity;
    }

    public void setProvineceEntity(ProvinceEntity provinceEntity) {
        this.provinceEntity= provinceEntity;
    }
}
