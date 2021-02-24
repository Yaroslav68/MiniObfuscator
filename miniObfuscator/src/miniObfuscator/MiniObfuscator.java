package miniObfuscator;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MiniObfuscator {

    public static void main(String[] args) throws IOException {
        String fileWay = "src\\miniObfuscator\\Main.java";

        String listLine = fileReader(fileWay);
        printOut(listLine);
        String multiLine = deleteComments(removesSpaces(listLine));

        String fileName = getFileName(fileWay);
        String renameMultiline = replaceFileName(multiLine, fileName);
        String newFileFullWay = newFileFullWay(fileWay, fileName);
        fileRecorder(renameMultiline, newFileFullWay);

    }

    private static String fileReader(String fileWay) {
        StringBuilder listLine = new StringBuilder();
        try {
            List<String> list = Files.readAllLines(Paths.get(fileWay));
            //получение мультистроки
            for (String s : list) {
                listLine.append(s); //listLine += s
            }
        } catch (IOException e) {
            System.out.println("not found");
        }
        return listLine.toString();
    }

    private static String deleteComments(String listLine) {
        return listLine.replaceAll("(/\\*.+?\\*/)|(//.+?)[:;a-zA-Zа-яА-ЯЁё]*", "");
    }

    private static String replaceFileName(String multiLine, String fileName) {
        String fileNewName = "New" + fileName;
        return multiLine.replaceAll(fileName, fileNewName);
    }

    private static String removesSpaces(String listLine) {
        return listLine.replaceAll("\\s+(?![^\\d\\s])", "");
    }

    private static String getFileName(String fileWay) {
        Path p = Paths.get(fileWay);
        String fileName = p.getFileName().toString();
        String fileNameWithoutExtension = fileName.replaceAll("\\..*", "");
        return fileNameWithoutExtension;
    }

    private static String newFileFullWay(String fileWay, String fileName) {
        return fileWay.replaceAll(fileName, "\\New" + fileName);
    }

    private static void fileRecorder(String renameMultiline, String newFileFullWay) throws IOException {
        try (FileWriter writer = new FileWriter(newFileFullWay)) {
            writer.write(renameMultiline);
        }
    }

    private static void printOut(String listLine) {
        System.out.println(listLine);
    }
}