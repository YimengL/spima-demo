package com.springmicroservice.microservices.licensingservice.repository;

import com.springmicroservice.microservices.licensingservice.model.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License, String> {
  public List<License> findByOrOrganizationId(String organizationId);

  public License findByOrOrganizationIdAndLicenseId(String organizationId, String licenseId);
}
