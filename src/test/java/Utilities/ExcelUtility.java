package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtility {
    public static ArrayList<ArrayList<String>> getData(String path, String sheetname, int sutunsayisi) {
        ArrayList<ArrayList<String>> tablo = new ArrayList<>();
        Sheet sheet = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = null;
            workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetname);
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
        for (int i = 0;i < sheet.getPhysicalNumberOfRows();i++){
            ArrayList<String> satir = new ArrayList<>();
            for (int j = 0;j < sutunsayisi;j++){
                satir.add(sheet.getRow(i).getCell(j).toString());
            }
            tablo.add(satir);
        }
        return tablo;
    }

    public static void writeToExcel(String path, Scenario senaryo){

        File file = new File(path);
        if (!file.exists()){
            XSSFWorkbook workbook =new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Test");
            Row yeniSatir = sheet.createRow(0);
            Cell hucre = yeniSatir.createCell(0);
            hucre.setCellValue(senaryo.getName());
            Cell hucre2 = yeniSatir.createCell(1);
            hucre2.setCellValue(senaryo.getStatus().toString());
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
            yeniHucre.setCellValue(senaryo.getName());
            Cell hucre2 = yeniSatir.createCell(1);
            hucre2.setCellValue(senaryo.getStatus().toString());
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