package com.wissen.helper;

import com.wissen.entity.Address;
import com.wissen.entity.Employee;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String SHEET = "Employees";
    public static boolean hasExcelFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }
    public static List<Employee> excelToTutorials(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet("Sheet1");
            Iterator<Row> rows = sheet.iterator();
            List<Employee> employees = new ArrayList<>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                Employee employee1 = new Employee();
                Address address = new Address();
//                Client client = new Client();
//                int cellIdx = 0;
//                while (cellsInRow.hasNext()) {
//                    Cell currentCell = cellsInRow.next();
//                    switch (cellIdx) {
//                        case 0 -> employee1.setFirstName(currentCell.getStringCellValue());
//                        case 1 -> employee1.setPan(currentCell.getStringCellValue());
//                        case 2 -> employee1.setLastName(currentCell.getStringCellValue());
//                        case 3 -> employee1.setDateOfJoining(currentCell.getStringCellValue());
//                        case 4 -> employee1.setYearExperience(currentCell.getNumericCellValue());
//                        case 5 -> employee1.setManager(currentCell.getStringCellValue());
//                        case 6 -> employee1.setRole((int) currentCell.getNumericCellValue());
//                        case 7 -> address.setFlatNumber(currentCell.getStringCellValue());
//                        case 8 -> address.setCity(currentCell.getStringCellValue());
//                        case 9 -> address.setState(currentCell.getStringCellValue());
//                        case 10 -> address.setPincode((long)currentCell.getNumericCellValue());
//                        case 11 -> address.setCountry(currentCell.getStringCellValue());
//                        case 12 -> client.setCname(currentCell.getStringCellValue());
//                        case 13 -> client.setLocation(currentCell.getStringCellValue());
//                        case 14 -> client.setRemoteManager(currentCell.getStringCellValue());
//                        case 15 -> client.setHiringManager(currentCell.getStringCellValue());
//                        case 16 -> employee1.setDesignation((int) currentCell.getNumericCellValue());
//                        case 17 -> employee1.setEmail(currentCell.getStringCellValue());
//                        default -> {
//                        }
//                    }
//                    cellIdx++;
//                }
//                employee1.setClient(client);
//                employee1.setActive(true);
//                employees.add(employee1);
            }
            workbook.close();
            return employees;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
