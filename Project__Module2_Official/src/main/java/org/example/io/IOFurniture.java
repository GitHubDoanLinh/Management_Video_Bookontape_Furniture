package org.example.io;

import org.example.model.Furniture;

import java.io.*;
import java.util.ArrayList;


public class IOFurniture {
    public static boolean saveFile(ArrayList<Furniture> listFurniture, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            for (Furniture fur : listFurniture) {
                String line = fur.getSerialNumber() + ";" + fur.getName() + ";" + fur.getType() + ";" + fur.getMaterial();
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

    public static ArrayList<Furniture> readFile(String path) {
        ArrayList<Furniture> listFurniture = new ArrayList<Furniture>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(";");
                if (arr.length == 4) {
                    Furniture fur = new Furniture();
                    fur.setSerialNumber(arr[0]);
                    fur.setName(arr[1]);
                    fur.setType(arr[2]);
                    fur.setMaterial(arr[3]);

                    listFurniture.add(fur);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listFurniture;
    }
}
