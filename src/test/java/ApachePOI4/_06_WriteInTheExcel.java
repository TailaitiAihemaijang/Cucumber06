package ApachePOI4;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI4/resource/WriteInTheExcelFile.xlsx";

        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int endRowIndex = sheet.getPhysicalNumberOfRows();
        Row newRow = sheet.createRow(endRowIndex);
        Cell yeniHucre = newRow.createCell(0);
        yeniHucre.setCellValue("Hello Word");

        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("Finishd");
    }
}
