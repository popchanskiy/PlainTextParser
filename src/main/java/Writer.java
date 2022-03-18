import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.net.*;

public class Writer {
    public void convertToExcel(String fileName, File fileDistPath) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("TestSheet");
        XSSFRow row;
        ParsedFileHelper helper = new ParsedFileHelper();
        if (fileName == null || fileDistPath == null) {
            throw new IllegalArgumentException("file not found!");
        }
        File fileSource = null;
        FileOutputStream out = null;
        try {
            fileSource = helper.getFileFromResource(fileName);
            for (int i = 0; i < helper.getParsedTextFromFile(fileSource).size(); i++) {
                row = spreadsheet.createRow(i);
                String[] values = helper.getParsedTextFromFile(fileSource).get(i);
                for (int j = 0; j < values.length; j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(values[j]);
                }
            }
            out = new FileOutputStream(
                    new File(String.valueOf(fileDistPath)));
            workbook.write(out);
            out.close();
        }
        catch (URISyntaxException | FileNotFoundException e) {
            System.out.println("error in file destination path or there is no such file in resource directory");
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...

    }
}
