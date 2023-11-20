package ApachePOI4;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _07_Soru1 {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI4/resource/ApacheExcel2.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int satirIndex = sheet.getPhysicalNumberOfRows();
        for (int k = 1;k<= 10;k++){
            for (int i = 1;i <=10;i++){
                Row satir = sheet.createRow(satirIndex++);
                Cell hucre1 = satir.createCell(0);
                hucre1.setCellValue(k);
                Cell hucre2 = satir.createCell(1);
                hucre2.setCellValue("X");
                Cell hucre3 = satir.createCell(2);
                hucre3.setCellValue(i);
                Cell hucre4 = satir.createCell(4);
                hucre4.setCellValue("=");
                Cell hucre5 = satir.createCell(5);
                hucre5.setCellValue(k*i);
            }
            Row bosSatir = sheet.createRow(satirIndex++);
        }
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        outputStream.close();
        System.out.println("bitti");

    }
}
