package PreRequisites;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reusable {
    public static void Sleep(int t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static List<String[]> read(){
        //initialize the result array
        List<String[]> result = new ArrayList<>();
        //file path
        String path="C:\\Users\\kribansal\\Downloads\\Customers.xlsx";
        //intializing the fileinputstream with file path
        FileInputStream file= null;
        try {
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //initialize the XSSFWorkbook at given file stream
        XSSFWorkbook xssfWorkbook= null;
        try {
            xssfWorkbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //getting the sheet in the workbook
        XSSFSheet sheet=xssfWorkbook.getSheetAt(0);
        //iterate over the sheet
        Iterator<Row> rowIterator = sheet.iterator();
        // Traversing over each row of XLSX fil
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // For each row, iterate through each columns \
            Iterator<Cell> cellIterator = row.cellIterator();
            String[] res = new String[3];
            int i = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (i == 2) {
                    //storing values in result array
                    res[i] = String.valueOf(cell.getNumericCellValue()).substring(0,6);
                } else {
                    //storing values in result array
                    res[i] = cell.getStringCellValue();
                }
                i++;
            }
            result.add(res);
        }
        return result;
    }
}
