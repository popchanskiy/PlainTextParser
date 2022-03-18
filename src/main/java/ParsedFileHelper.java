import java.io.*;
import java.net.*;
import java.util.*;

public class ParsedFileHelper {
    private final String DELIMITER = " ";

    public List<String[]> getParsedTextFromFile(File fileSourcePath) throws FileNotFoundException {
        Scanner in = new Scanner(fileSourcePath);
        List<String[]> textInRows = new ArrayList<>();
        while (in.hasNext()) { // Iterates each line in the file
            String line = in.nextLine();
            textInRows.add(line.split(DELIMITER));
        }
        in.close();
        return textInRows;
    }

    public File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());
            return new File(resource.toURI());
        }

    }
}

