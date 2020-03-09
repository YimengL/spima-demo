package com.springmicroservice.microservices.licensingservice.controllers;

import com.springmicroservice.microservices.licensingservice.model.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

  @Value("${spring.datasource.username}")
  private String var;

  @RequestMapping(value = "/hello")
  public String hello() {
    return String.format("hello. %s", var);
  }

  @RequestMapping(value = "/{licenseId}", method = RequestMethod.GET)
  public License getLincenses(@PathVariable("organizationId") String organizationId,
                              @PathVariable("licenseId") String licenseId) {
    return new License()
        .withId(licenseId)
        .withProductName("Teleco")
        .withLicenseType("Seat")
        .withOrganizationId("TestOrg");
  }

}
