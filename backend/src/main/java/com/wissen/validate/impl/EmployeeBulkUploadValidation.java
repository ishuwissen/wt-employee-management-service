package com.wissen.validate.impl;

import com.wissen.enums.EmployeeExcelHeaders;
import com.wissen.exception.EmployeeExcelValidationException;
import com.wissen.service.DepartmentService;
import com.wissen.service.DesignationService;
import com.wissen.service.RoleService;
import com.wissen.validate.BulkUploadValidation;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.wissen.constants.ExcelConstant.EMPLOYEE_SHEET_COLUMN_COUNT;

/**
 * Implementation class for employeebulk upload validation.
 *
 * @author Vishal Tomar
 */
@Component
public class EmployeeBulkUploadValidation implements BulkUploadValidation {

    @Autowired
    private DesignationService designationService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private RoleService roleService;

    private List<String> departments;
    private List<String> designations;
    private List<String> roles;

    @PostConstruct
    public void setUp() {
        this.departments = this.departmentService.getAllDepartments().stream().map(department -> department.getDepName()).collect(Collectors.toList());
        this.designations = this.designationService.getAllDesignation().stream().map(designation -> designation.getDesgName()).collect(Collectors.toList());
        this.roles = this.roleService.getAllRoles().stream().map(role -> role.getRoleName()).collect(Collectors.toList());
    }

    /**
     * Method to validate excel data file.
     *
     * @param dataFile
     * @throws EmployeeExcelValidationException
     *
     * @author Vishal Tomar
     */
    @Override
    public void validate(MultipartFile dataFile) throws EmployeeExcelValidationException {
        List<EmployeeExcelHeaders> headers = Arrays.stream(EmployeeExcelHeaders.values()).toList();
        try {
            XSSFWorkbook workBook = new XSSFWorkbook(dataFile.getInputStream());
            XSSFSheet sheet = workBook.getSheetAt(0);
            // validate headers
            validateHeaders(sheet.getRow(0), headers);
            //validate values
            for(int rowIndex=1; rowIndex<sheet.getLastRowNum()+1; rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                for(int cellIndex=0; cellIndex<EMPLOYEE_SHEET_COLUMN_COUNT; cellIndex++) {
                    Cell cell = row.getCell(cellIndex);
                    if(Objects.isNull(cell) && !headers.get(cellIndex).isNullAllowed())
                        throw new RuntimeException("Empty value is not allowed for " + headers.get(cellIndex).getValue());
                    else if(Objects.nonNull(cell) && headers.get(cellIndex).isDateType() && (cell.getDateCellValue() instanceof Date))
                        continue; // will update this in next PR
                    else if(Objects.nonNull(cell) && !StringUtils.equals(cell.getCellType().toString(), headers.get(cellIndex).getCellType().toString()))
                        throw new RuntimeException("Please make value of " + headers.get(cellIndex).getValue() + " to " + headers.get(cellIndex).getCellType().toString());
                    else if(Objects.nonNull(cell) && StringUtils.equals(headers.get(cellIndex).getValue(), "DEPARTMENT") && !this.departments.contains(cell.getStringCellValue()))
                        throw new RuntimeException(cell.getStringCellValue() + " is not a department");
                    else if(Objects.nonNull(cell) && StringUtils.equals(headers.get(cellIndex).getValue(), "DESIGNATION") && !this.designations.contains(cell.getStringCellValue()))
                        throw new RuntimeException(cell.getStringCellValue() + " is not a designation");
                    else if(Objects.nonNull(cell) && StringUtils.equals(headers.get(cellIndex).getValue(), "ROLE") && !this.roles.contains(cell.getStringCellValue()))
                        throw new RuntimeException(cell.getStringCellValue() + " is not a role");

                }
            }
        } catch (Exception e) {
            throw new EmployeeExcelValidationException(e.getMessage());
        }

    }

    /**
     * Method to validate employee excel headers.
     *
     * @author Vishal Tomar
     * @param row
     * @param headers
     * @throws RuntimeException
     */
    private void validateHeaders(Row row, List<EmployeeExcelHeaders> headers) throws RuntimeException {
        for(int cellIndex=0; cellIndex<EMPLOYEE_SHEET_COLUMN_COUNT; cellIndex++) {
            Cell cell = row.getCell(cellIndex);
            if(Objects.isNull(cell)) {
                throw new EmployeeExcelValidationException("Header can not be empty");
            } else {
                String headerValue = cell.getStringCellValue();
                if (!StringUtils.equals(headerValue, headers.get(cellIndex).getValue())) {
                    throw new RuntimeException("Header value " + headerValue + " is not correct or the sequence of header is not correct. Please use sample file.");
                }
            }
        }
    }
}
