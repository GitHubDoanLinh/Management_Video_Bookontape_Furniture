package org.example.io;

import org.example.model.BookOnTape;

import java.io.*;
import java.util.ArrayList;

public class IOBookOnTape {
    public static boolean saveFile(ArrayList<BookOnTape> listBookOnTape, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            for (BookOnTape b : listBookOnTape) {
                String line = b.getSerialNumber() + ";" + b.getName() + ";" + b.getCategory();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            osw.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<BookOnTape> readFile(String path) {
        ArrayList<BookOnTape> listBookOnTape = new ArrayList<BookOnTape>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(";");
                if (arr.length == 3) {
                    BookOnTape b = new BookOnTape();
                    b.setSerialNumber(arr[0]);
                    b.setName(arr[1]);
                    b.setCategory(arr[2]);

                    listBookOnTape.add(b);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBookOnTape;
    }
}

