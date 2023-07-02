package ua.goit;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DBUtils {
    private DBUtils() {
    }

    public static String getSQL(String SQLName) {
        StringBuilder stringBuilder = new StringBuilder();

        try (FileReader reader = new FileReader(SQLName);
             Scanner sc = new Scanner(reader)) {

            while (sc.hasNext()) {
                stringBuilder.append(sc.nextLine());
                stringBuilder.append(" ");
            }
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }

        return stringBuilder.toString();
    }
}
