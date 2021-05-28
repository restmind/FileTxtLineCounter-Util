package com.rostyk;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write directory name: ");
        String directoryName = scanner.next();
        scanner.close();

        File directory = new File("src/com/rostyk/" + directoryName);
        File[] listOfFiles = directory.listFiles();
        FileWriter myResultWriter = new FileWriter("result.txt");

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                int linesQuantity = 0;
                while (reader.readLine() != null) linesQuantity++;
                reader.close();

                System.out.println(file + " has " + linesQuantity + " number of lines\n");

                myResultWriter.write(file + " has " + linesQuantity + " number of lines\n");
            }
        }
        myResultWriter.close();

    }

}
