package com.wissen.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Interface responsible for bulk upload.
 *
 * @author Vishal Tomar
 */
public interface BulkUploadService {

    /**
     * Method for bulk upload
     *
     * @param dataFile
     */
    public void bulkUploadToDb(MultipartFile dataFile);

    /**
     * Method to validate bulk upload excel file.
     *
     * @param dataFile
     */
    public void validateExcel(MultipartFile dataFile);
}
