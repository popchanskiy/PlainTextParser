import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
    public static void main(String[] args)  {
ParsedFileHelper parsedFileHelper =new ParsedFileHelper();
Writer writer= new Writer();
writer.convertToExcel("text_test.txt",new File("C:\\Users\\ilya\\IdeaProjects\\PlainTextParser\\src\\test\\resources\\file.xls"));

    }
}
