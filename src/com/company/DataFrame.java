package com.company;

import sun.font.AttributeValues;

import java.io.*;
import java.util.Scanner;

/**
 * Created by cedric on 02/10/15.
 */
public class DataFrame {
    private String fileName = "save.txt";

    public String makeContent(){
        return "";
    }
    public void writeFile(){
        try {
            String content = makeContent();
            File file = new File(fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFile(String fileName) {

       /* try {
            DataFrame f = new DataFrame(fileName);
            Scanner scanner = new Scanner(f);

            String name;

            // first line : names of attributes
            Scanner sc = new Scanner(scanner.nextLine());
            while(sc.hasNext()) {
                names.add(sc.next());
                AttributeValues v = new AttributeValues();
                values.add(v);
            }
            sc.close();

            // examples
            String v;
            int id;
            while(scanner.hasNext()) {
                sc = new Scanner(scanner.nextLine());
                Example example = new Example();
                int j = 0;
                while(sc.hasNext()) {
                    v = sc.next();
                    id = values.get(j).add(v);
                    example.add(id);
                    j++;
                }
                sc.close();
                examples.add(example);
            }

            scanner.close();

        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }*/
    }
}
