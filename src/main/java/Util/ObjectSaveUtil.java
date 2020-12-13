package Util;

import lombok.SneakyThrows;
import org.springframework.util.ResourceUtils;

import java.io.*;

/**
 * @author SiletFlower
 * @date 2020/12/13 16:43:52
 * @description
 */
public class ObjectSaveUtil {

    public static void writeObjectToFile(Object obj) {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("../save_alarm.txt");
            out = new ObjectOutputStream(fos);
            out.writeObject(obj);
            if(fos != null){
                fos.close();
            }
            if(out != null){
                out.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Object readFileToObject(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream("../save_alarm.txt");
            in = new ObjectInputStream(fis);
            Object o = in.readObject();
            if(fis != null){
                fis.close();
            }
            if(in != null){
                in.close();
            }
            return o;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
