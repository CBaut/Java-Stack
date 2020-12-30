package com.codingdojo.relationships.services;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.repositories.LicenseRepository;

import org.springframework.stereotype.Service;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public License createLicense(License license) {
        // Create license number by converting id to string and padding zeros in front
        Long number = license.getPerson().getId();
        System.out.println(number);
        int numLength = String.valueOf(number).length();
        System.out.println("Length:" + numLength);
        int numZeros = 6 - numLength;
        String licenseNumber = "";
        for (int i = 0; i < numZeros; i++) {
            licenseNumber = licenseNumber + "0";
        }
        System.out.println(licenseNumber);
        licenseNumber = licenseNumber + String.valueOf(number);
        license.setNumber(licenseNumber);
        return licenseRepository.save(license);
    }
}
