package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelUtil {
    public static Object[][] getData(String path,String sheetName) {
        try {
            FileInputStream fis=new FileInputStream(path);
            Workbook workbook=WorkbookFactory.create(fis);
            Sheet sheet=workbook.getSheet(sheetName);

            int rows=sheet.getPhysicalNumberOfRows();
            int cols=sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data=new Object[rows-1][cols];

            for (int i=1;i<rows;i++) {
                Row row=sheet.getRow(i);
                for (int j=0;j<cols;j++) {
                    Cell cell=row.getCell(j);
                    if (cell==null) {
                        data[i-1][j]="";
                    } else {
                    	data[i-1][j]=cell.toString();
                    }
                }
            }

            workbook.close();
            return data;

        }catch (Exception e) {
            throw new RuntimeException("Error reading Excel file");
        }
    }
}