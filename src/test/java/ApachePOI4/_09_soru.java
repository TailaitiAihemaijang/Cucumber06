package ApachePOI4;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _09_soru {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sayfa1");

        int yiniSatiIndx = sheet.getPhysicalNumberOfRows();
        for (int k = 1;k<= 10;k++){
            for (int i = 1;i <=10;i++){
                Row satir = sheet.createRow(yiniSatiIndx++);
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
            Row bosSatir = sheet.createRow(yiniSatiIndx++);
        }
        String path = "src/test/java/ApachePOI4/resource/carpmaYeni.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();


    }
}
