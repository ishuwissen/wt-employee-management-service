package com.wissen.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Class contains constant related to excel.
 *
 * @author Vishal Tomar
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExcelConstant {


    /******** Employee bulk upload excel meta data constant ********/
    public static final int EMPLOYEE_HEADER_ROW_INDEX = 0;
    public static final int EMPLOYEE_SHEET_COLUMN_COUNT = 22;

    /******** Employee bulk upload excel column name constant ********/
    public static final String BLOOD_GROUP = "BLOOD_GROUP";
    public static final String DOB = "DOB";
    public static final String DOJ = "DOJ";
    public static final String EMAIL = "EMAIL";
    public static final String EXIT_DATE = "EXIT_DATE";
    public static final String EXP_DOJ = "EXP_DOJ";
    public static final String FIRST_NAME = "FIRST_NAME";
    public static final String GENDER = "GENDER";
    public static final String JOINING_LOCATION = "JOINING_LOCATION";
    public static final String LAST_NAME = "LAST_NAME";
    public static final String MANAGER = "MANAGER";
    public static final String MARITAL_STATUS_DATE = "MARITAL_STATUS_DATE";
    public static final String PRIMARY_EMERGENCY_CONTACT_NUMBER = "PRIMARY_EMERGENCY_CONTACT_NUMBER";
    public static final String PRIMARY_PHONE_NUMBER = "PRIMARY_PHONE_NUMBER";
    public static final String SECONDARY_EMERGENCY_CONTACT_NUMBER = "SECONDARY_EMERGENCY_CONTACT_NUMBER";
    public static final String SECONDARY_PHONE_NUMBER = "SECONDARY_PHONE_NUMBER";
    public static final String STATUS = "STATUS";
    public static final String TYPE = "TYPE";
    public static final String WORK_PHONE = "WORK_PHONE";
    public static final String DEPARTMENT = "DEPARTMENT";
    public static final String DESIGNATION = "DESIGNATION";
    public static final String ROLE = "ROLE";
}
