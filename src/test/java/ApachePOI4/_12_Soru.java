package ApachePOI4;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class _12_Soru {
    public static void main(String[] args) {
        String path = "src/test/java/ApachePOI4/resource/SenaryoSonuc.xlsx";
        String bilgi = "senaryo Passed";

        writeToExcel(path,bilgi);
        writeToExcel(path,bilgi);
    }
    public static void writeToExcel(String path,String bilgi){

        File file = new File(path);
        if (!file.exists()){
            XSSFWorkbook workbook =new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Test");
            Row yeniSatir = sheet.createRow(0);
            Cell hucre = yeniSatir.createCell(0);
            hucre.setCellValue(bilgi);
            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            }catch (Exception ex){
                System.out.println("ex.getMessage " + ex.getMessage());
            }

        }
        else {
            FileInputStream inputStream = null;
            Sheet sheet = null;
            Workbook workbook = null;

            try {
                 inputStream = new FileInputStream(path);
                 workbook = WorkbookFactory.create(inputStream);
                 sheet = workbook.getSheetAt(0);
            }catch(Exception e ){
                System.out.println(e.getMessage());
            }
            int sonSatirIndex = sheet.getPhysicalNumberOfRows();
            Row yeniSatir = sheet.createRow(sonSatirIndex);
            Cell yeniHucre = yeniSatir.createCell(0);
            yeniHucre.setCellValue(bilgi);
            try {
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }



        }
    }


}
