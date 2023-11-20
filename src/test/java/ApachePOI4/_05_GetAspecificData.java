package ApachePOI4;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _05_GetAspecificData {

        public static void main(String[] args) throws IOException {
            String donenSonuc = exceldenGetir("Address");
            System.out.println(donenSonuc);
        }

        public static String exceldenGetir(String aranacakKelime) throws IOException {
            String donecek = "";

            String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

                //aradığım satırı buldum :  i.satır
                if (sheet.getRow(i).getCell(0).toString().toLowerCase().contains(aranacakKelime.toLowerCase())) {

                    for (int j = 1; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                        donecek = donecek + sheet.getRow(i).getCell(j);
                    }
                }
            }

            return donecek;
        }
}
