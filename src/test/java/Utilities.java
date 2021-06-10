
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by gtripathi on 6/10/2021.
 */
public class Utilities {

    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static String excelFilePath="./resources/TestData.xlsx";


    public static Object[][] getCellData(String sheetName)throws IOException{
        File file = new File(excelFilePath);
        FileInputStream inputStream = new FileInputStream(file);
        workbook = new XSSFWorkbook(inputStream);

        //creating a Sheet object
        sheet = workbook.getSheet(sheetName);
        //getting the cell value from rowNumber and cell Number
        Object data[][]= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        DataFormatter formatter = new DataFormatter();
        for(int i=0;i< sheet.getLastRowNum();i++){
            for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                cell=sheet.getRow(i+1).getCell(j);
                String value=formatter.formatCellValue(cell);
                data[i][j]= value;

            }
        }
        return data;
    }
    public static int getRowCountInSheet(){
        int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        return rowcount;
    }




    }
