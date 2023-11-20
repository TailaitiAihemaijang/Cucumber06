package ApachePOI4;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class _11_Soru {
    public static void main(String[] args) {
        String path = "src/test/java/ApachePOI4/resource/ApacheExcel2.xlsx";
        String sheetName = "testCitizen";
        int sutunSayisi = 3;

        ArrayList<ArrayList<String>> data = getData(path, sheetName, sutunSayisi);
        System.out.println("data : " + data);
    }

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

}
