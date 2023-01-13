package com.wissen.enums;

import lombok.Getter;
import org.apache.poi.ss.usermodel.CellType;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Enum class for employee excel properties.
 *
 * @author Vishal Tomar
 */
@Getter
public enum EmployeeExcelHeaders {

    BLOOD_GROUP(0, "BLOOD_GROUP", false, CellType.STRING, false),
    DOB(1, "DOB", false, CellType._NONE, true),
    DOJ(2, "DOJ", false, CellType._NONE, true),
    EMAIL(3, "EMAIL", false, CellType.STRING, false),
    EXIT_DATE(4, "EXIT_DATE", true, CellType._NONE, true),
    EXP_DOJ(5, "EXP_DOJ", false, CellType.STRING, false),
    FIRST_NAME(6, "FIRST_NAME", false, CellType.STRING, false),
    GENDER(7, "GENDER", false, CellType.STRING, false),
    JOINING_LOCATION(8, "JOINING_LOCATION", false, CellType.STRING, false),
    LAST_NAME(9, "LAST_NAME", false, CellType.STRING, false),
    MANAGER(10, "MANAGER", false, CellType.STRING, false),
    MARITAL_STATUS_DATE(11, "MARITAL_STATUS_DATE", true, CellType._NONE, true),
    PRIMARY_EMERGENCY_CONTACT_NUMBER(12, "PRIMARY_EMERGENCY_CONTACT_NUMBER", false, CellType.STRING, false),
    PRIMARY_PHONE_NUMBER(13, "PRIMARY_PHONE_NUMBER", false, CellType.STRING, false),
    SECONDARY_EMERGENCY_CONTACT_NUMBER(14, "SECONDARY_EMERGENCY_CONTACT_NUMBER", false, CellType.STRING, false),
    SECONDARY_PHONE_NUMBER(15, "SECONDARY_PHONE_NUMBER", false, CellType.STRING, false),
    STATUS(16, "STATUS", false, CellType.STRING, false),
    TYPE(17, "TYPE", false, CellType.STRING, false),
    WORK_PHONE(18, "WORK_PHONE", false, CellType.STRING, false),
    DEPARTMENT(19, "DEPARTMENT", false, CellType.STRING, false),
    DESIGNATION(20, "DESIGNATION", false, CellType.STRING, false),
    ROLE(21, "ROLE", false, CellType.STRING, false);

    private int index;
    private String value;
    private boolean isNullAllowed;
    private CellType cellType;
    private boolean isDateType;

    EmployeeExcelHeaders(int index, String value, boolean isNullAllowed, CellType cellType, boolean isDateType) {
        this.value = value;
        this.index = index;
        this.isNullAllowed = isNullAllowed;
        this.cellType = cellType;
        this.isDateType = isDateType;
    }

    public static EmployeeExcelHeaders getHeaders(int i){
        EmployeeExcelHeaders headers[] = EmployeeExcelHeaders.values();
        return headers[i];
    }

    public static Set<String> getValuesSet() {
        return Arrays.asList(EmployeeExcelHeaders.values()).stream().map(employeeExcelHeaders -> employeeExcelHeaders.getValue())
                .collect(Collectors.toSet());
    }
}
