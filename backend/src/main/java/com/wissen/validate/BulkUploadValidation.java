package com.wissen.validate;

import com.wissen.exception.EmployeeExcelValidationException;
import org.springframework.web.multipart.MultipartFile;

/**
 * Interface for bulk upload validation.
 *
 * @author Vishal Tomar
 */
public interface BulkUploadValidation {

    /**
     * Method to validate bulk upload.
     *
     * @param dataFile
     * @throws EmployeeExcelValidationException
     */
    public void validate(MultipartFile dataFile) throws EmployeeExcelValidationException;

}
