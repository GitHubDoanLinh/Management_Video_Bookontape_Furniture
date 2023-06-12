package org.example.io;

import org.example.model.BookOnTape;
import org.example.model.Furniture;
import org.example.model.Thing;
import org.example.model.Video;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFavorite {
    public static boolean saveFile(ArrayList<Thing> listFavorite, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            for (Thing fav : listFavorite) {
                if(fav instanceof  BookOnTape) {
                    String line = ((BookOnTape)fav).getSerialNumber() + ";" + ((BookOnTape)fav).getName() + ";" + ((BookOnTape)fav).getCategory();
                    bw.write(line);
                    bw.newLine();
                } else if(fav instanceof Furniture) {
                    String line = ((Furniture)fav).getSerialNumber() + ";" + ((Furniture)fav).getName() + ";" + ((Furniture)fav).getType() + ";" + ((Furniture)fav).getMaterial();
                    bw.write(line);
                    bw.newLine();
                } else if(fav instanceof Video) {
                    String line =  ((Video) fav).getSerialNumber() + ";" + ((Video) fav).getName() + ";" + ((Video) fav).getLength() + ";" + ((Video) fav).getQuality();
                    bw.write(line);
                    bw.newLine();
                }
            }
            bw.close();
            osw.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Thing> readFile(String path) throws FileNotFoundException {
        ArrayList<Thing> listFav = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(";");
                if(arr[0].startsWith("VID")) {
                    Video video = new Video();
                    video.setSerialNumber(arr[0]);
                    video.setName(arr[1]);
                    video.setLength(arr[2]);
                    video.setQuality(arr[3]);

                    listFav.add(video);
                } else if(arr[0].startsWith("FUR")) {
                    Furniture fur = new Furniture();
                    fur.setSerialNumber(arr[0]);
                    fur.setName(arr[1]);
                    fur.setType(arr[2]);
                    fur.setMaterial(arr[3]);

                    listFav.add(fur);
                } else if(arr[0].startsWith("BOT")) {
                    BookOnTape b = new BookOnTape();
                    b.setSerialNumber(arr[0]);
                    b.setName(arr[1]);
                    b.setCategory(arr[2]);

                    listFav.add(b);
                }
                line = br.readLine();
            }
                br.close();
                isr.close();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return listFav;
        }
}
