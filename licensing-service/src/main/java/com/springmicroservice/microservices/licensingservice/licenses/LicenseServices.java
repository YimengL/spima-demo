package com.springmicroservice.microservices.licensingservice.licenses;

import com.springmicroservice.microservices.licensingservice.config.ServiceConfig;
import com.springmicroservice.microservices.licensingservice.model.License;
import com.springmicroservice.microservices.licensingservice.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LicenseServices {

  @Autowired
  private LicenseRepository licenseRepository;

  @Autowired
  ServiceConfig config;

  public License getLicense(String organizationId, String licenseId) {
    License license = licenseRepository.findByOrOrganizationIdAndLicenseId(organizationId,
        licenseId);
    return license.withComment(config.getExampleProperty());
  }

  public List<License> getLicensesByOrg(String organizationId) {
    return licenseRepository.findByOrOrganizationId(organizationId);
  }

  public void saveLicense(License license) {
    license.withId(UUID.randomUUID().toString());
    licenseRepository.save(license);
  }

  public void updateLicense(License license) {
    licenseRepository.save(license);
  }


  public void deleteLicense(License license) {
    licenseRepository.delete(license);
  }
}
