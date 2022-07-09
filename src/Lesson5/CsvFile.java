package Lesson5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class CsvFile {
    public static ArrayList<File> fIleObjectArrayList = new ArrayList<>();
    public static final String pathToFile = "C:/Users/HP/Desktop/GEEKBRAINS_study/JavaCoreHW/src/Lesson5/demo.csv";
    public static final String title = "Value1" + "; " + "Value2"
            + "; " + "Value3" + ";" + System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {
        createFileObjects();

        writeStream();

        AppData appData = readToObject();
    }

    public static void createFileObjects() {
        Random random = new Random();

        for (int i = 1; i < 500; i++) {
            fIleObjectArrayList.add(new File(i, random.nextInt(500), random.nextInt(1000)));
        }
    }

    public static void writeStream() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(pathToFile)) {
            for (byte b : title.getBytes(StandardCharsets.UTF_8)) {
                fileOutputStream.write(b);
            }
            for (File fIleObject : fIleObjectArrayList) {
                String raw = fIleObject.getValue() + "; " + fIleObject.getValueFrom()
                        + "; " + fIleObject.getValueTo() + ";" + System.getProperty("line.separator");
                for (byte b : raw.getBytes(StandardCharsets.UTF_8)) {
                    fileOutputStream.write(b);
                }
            }
        }
    }

    public static AppData readToObject() throws IOException {
        AppData appData = new AppData();
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line = br.readLine();
            appData.setHeader(line.split(";"));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }
        }
        return appData;
    }
}
