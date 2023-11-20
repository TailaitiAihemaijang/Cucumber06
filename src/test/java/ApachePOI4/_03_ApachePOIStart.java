package ApachePOI4;

import org.apache.poi.ss.usermodel.*;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI4/resource/ApacheExcel2.xlsx";
        FileInputStream dosyaOkumaBaglantisi = new FileInputStream(path);

        Workbook calismaKitabi = WorkbookFactory.create(dosyaOkumaBaglantisi);
        Sheet calismaSayfasi = calismaKitabi.getSheet("Sheet1");
        Row satir = calismaSayfasi.getRow(3);
        Cell hucre = satir.getCell(0);
        System.out.println(hucre);
    }
}
