/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apari
 */
public class FileUtil{
    static public void serializeToFile(String path, HashMap hash){
        try(FileOutputStream fos=new FileOutputStream(path);
            ObjectOutputStream oos=new ObjectOutputStream(fos)){
            oos.writeObject(hash);
        }catch(IOException e){
            System.out.println("Problema de IO al serializar");
            e.printStackTrace();
        }
    }
    
    static public HashMap deserializeFromFile(String path){
        HashMap hmRet=null;
        try(FileInputStream fis=new FileInputStream(path);
            ObjectInputStream oos=new ObjectInputStream(fis)){
            hmRet=(HashMap)oos.readObject();
        }catch(ClassNotFoundException e){
            System.out.println("No se ha encontrado la clase al deserializar");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Problema de IO al deserializar");
            e.printStackTrace();
        }
        return hmRet;
    }
    
}
