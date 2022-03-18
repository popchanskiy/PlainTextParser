import com.codeborne.xlstest.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WriterTest {
    Writer writer;
    XLS xls;
    String fileSourcePath="C:\\Users\\ilya\\IdeaProjects\\PlainTextParser\\src\\test\\resources\\file.xls";
    @BeforeEach
    void setUp() {
        writer =new Writer();
    }
    

    @Test
    void ensureWritingTextToExcelCorrect() throws IOException {
        writer.convertToExcel("text_test.txt",
                new File(fileSourcePath));
        FileInputStream file = new FileInputStream(new File(fileSourcePath));
        xls=new XLS(file);
        assertAll("",
               () -> org.assertj.core.api.Assertions.assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(2)
                        .getStringCellValue()).isEqualTo("puk"),
                () -> org.assertj.core.api.Assertions.assertThat(xls.excel.getSheetAt(0).getRow(2).getCell(0)
                        .getStringCellValue()).isEqualTo("htrhrhrhrhrh"),
                () -> org.assertj.core.api.Assertions.assertThat(xls.excel.getSheetAt(0).getRow(3).getCell(0)
                        .getStringCellValue()).isEqualTo("dfgdf")
        );
    }

}



