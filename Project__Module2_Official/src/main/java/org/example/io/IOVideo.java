package org.example.io;

import org.example.model.Video;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class IOVideo {
    public static boolean saveFile(ArrayList<Video> listVideo, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            for (Video vid : listVideo) {
                String line = vid.getSerialNumber() + ";" + vid.getName() + ";" + vid.getLength() + ";" + vid.getQuality();
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

    public static ArrayList<Video> readFile(String path) {
        ArrayList<Video> listVideo = new ArrayList<Video>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(";");
                if (arr.length == 4) {
                    Video video = new Video();
                    video.setSerialNumber(arr[0]);
                    video.setName(arr[1]);
                    video.setLength(arr[2]);
                    video.setQuality(arr[3]);

                    listVideo.add(video);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listVideo;
    }
}