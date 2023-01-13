package com.wissen.service.impl;

import static com.wissen.constants.ExcelConstant.*;

import com.wissen.entity.Department;
import com.wissen.entity.Designation;
import com.wissen.entity.Employee;
import com.wissen.entity.Role;
import com.wissen.repository.EmployeeRepository;
import com.wissen.service.BulkUploadService;
import com.wissen.service.DepartmentService;
import com.wissen.service.DesignationService;
import com.wissen.service.RoleService;
import com.wissen.validate.BulkUploadValidation;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * Implementation class for employee bulk upload related things.
 */
@Service("EmployeeBulkUpload")
@Slf4j
public class EmployeeBulkUploadServiceImpl implements BulkUploadService {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DesignationService designationService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BulkUploadValidation employeeBulkUploadValidation;

    /**
     * {@inheritDoc}
     */
    @Override
    public void bulkUploadToDb(MultipartFile dataFile) {
        this.employeeBulkUploadValidation.validate(dataFile);
        try {
            List<Employee> employeeList = new ArrayList<>();
            XSSFWorkbook workBook = new XSSFWorkbook(dataFile.getInputStream());
            XSSFSheet sheet = workBook.getSheetAt(0);
            for(int rowIndex=1; rowIndex<sheet.getLastRowNum()+1; rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                Employee employee = new Employee();
                for(int cellIndex=0; cellIndex<EMPLOYEE_SHEET_COLUMN_COUNT; cellIndex++) {
                    Cell cell = row.getCell(cellIndex);
                    String header = sheet.getRow(0)
                            .getCell(cellIndex).getStringCellValue();
                    if(Objects.nonNull(cell)) {
                        setEmployeeValue(header, employee, cell);
                    }
                }
                employeeList.add(employee);
            }
            this.employeeRepository.saveAll(employeeList);
        } catch (Exception e) {

        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validateExcel(MultipartFile dataFile) {
        this.employeeBulkUploadValidation.validate(dataFile);
    }

    /**
     * Set employee value.
     *
     * @param header
     * @param employee
     * @param cell
     */
    private void setEmployeeValue(String header, Employee employee, Cell cell) {
        CellType cellType = cell.getCellType();
        switch (header) {
            case BLOOD_GROUP:
                employee.setBloodGroup(cell.getStringCellValue());
                break;
            case DOB:
                employee.setDob(cell.getDateCellValue());
                break;
            case DOJ:
                employee.setDoj(cell.getDateCellValue());
                break;
            case EMAIL:
                employee.setEmail(cell.getStringCellValue());
                break;
            case EXIT_DATE:
                employee.setExitDate(cell.getDateCellValue());
                break;
            case EXP_DOJ:
                employee.setExpDoj(cell.getStringCellValue());
                break;
            case FIRST_NAME:
                employee.setFirstName(cell.getStringCellValue());
                break;
            case GENDER:
                employee.setGender(cell.getStringCellValue());
                break;
            case JOINING_LOCATION:
                employee.setJoiningLocation(cell.getStringCellValue());
                break;
            case LAST_NAME:
                employee.setLastName(cell.getStringCellValue());
                break;
            case MANAGER:
                employee.setManager(cell.getStringCellValue());
                break;
            case MARITAL_STATUS_DATE:
                employee.setMaritalStatusDate(cell.getDateCellValue());
                break;
            case PRIMARY_EMERGENCY_CONTACT_NUMBER:
                employee.setPrimaryEmergencyContactNumber(Long.valueOf(cell.getStringCellValue()));
                break;
            case PRIMARY_PHONE_NUMBER:
                employee.setPrimaryPhoneNumber(Long.valueOf(cell.getStringCellValue()));
                break;
            case SECONDARY_PHONE_NUMBER:
                employee.setSecondaryPhoneNumber(Long.valueOf(cell.getStringCellValue()));
                break;
            case SECONDARY_EMERGENCY_CONTACT_NUMBER:
                employee.setSecondaryEmergencyContactNumber(Long.valueOf(cell.getStringCellValue()));
                break;
            case STATUS:
                employee.setStatus(cell.getStringCellValue());
                break;
            case TYPE:
                employee.setType(cell.getStringCellValue());
                break;
            case WORK_PHONE:
                employee.setWorkPhone(Long.valueOf(cell.getStringCellValue()));
                break;
            case DEPARTMENT:
                Department department = this.departmentService
                        .getDepartmentByDepName(cell.getStringCellValue());
                employee.setDepartment(department);
                break;
            case DESIGNATION:
                Designation designation = this.designationService
                        .getDesignationByName(cell.getStringCellValue());
                employee.setDesignation(designation);
                break;
            case ROLE:
                Role role = this.roleService
                        .getRoleByName(cell.getStringCellValue());
                employee.setRole(role);
                break;
            default:
        }
    }
}
