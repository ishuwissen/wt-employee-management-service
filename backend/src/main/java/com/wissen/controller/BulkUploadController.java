package com.wissen.controller;

import com.wissen.service.BulkUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/bulkUpload")
@Slf4j
@Validated
public class BulkUploadController {

    @Autowired()
    @Qualifier("EmployeeBulkUpload")
    private BulkUploadService bulkUploadService;

    /**
     * API to load employee Data from the Excel file and also it validates the records
     * @param dataFile
     * @return String with Save Status
     */
    @PostMapping(path = "/employee")
    public ResponseEntity<String> employeeInfoBulkUpload(@RequestPart(required = true) MultipartFile dataFile) {
        log.debug("Load the Excel data to the data base by validating the data");
        this.bulkUploadService.bulkUploadToDb(dataFile);
        return ResponseEntity.status(HttpStatus.OK).body("Saved successfully.");
    }

    /**
     * API to validate the Excel file and data
     * @param dataFile
     * @return response
     */
    @PostMapping(path = "/validate")
    public ResponseEntity<String> validateBulkUpload(@RequestPart(required = true) MultipartFile dataFile) {
        log.debug("Validate the excel payload");
        this.bulkUploadService.validateExcel(dataFile);
        return ResponseEntity.status(HttpStatus.OK).body("validated successfully.");
    }
}
