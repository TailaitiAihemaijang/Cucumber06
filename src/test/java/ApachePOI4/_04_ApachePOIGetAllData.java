package ApachePOI4;

import io.cucumber.java.sr_latn.I;
import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI4/resource/ApacheExcel2.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook calisma = WorkbookFactory.create(inputStream);
        Sheet sheet = calisma.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println(rowCount);

        for (int i = 0;i < rowCount;i++){
            Row row = sheet.getRow(i);
            int cellCout = row.getPhysicalNumberOfCells();

            for (int j = 0;j <cellCout;j++ ){
                Cell cell = row.getCell(j);
                System.out.print(cell+" ");
            }
            System.out.println();
        }
        System.out.println("===============2-Yonetem====================");
        for (int i = 0;i < sheet.getPhysicalNumberOfRows();i++){
            for (int j = 0;j < sheet.getRow(i).getPhysicalNumberOfCells();j++){
                System.out.print(sheet.getRow(i).getCell(j) + "\t");
            }
            System.out.println();
        }

    }
}
