/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;


/**
 *
 * @author ahmed
 */
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class GenUniqueFName {
   
    public static String generate(String p){
        
        String destImgName = "";
        
        Path srcImgPath = Paths.get(p);
        
        Path fNamePath = srcImgPath.getFileName();
        
        if(fNamePath != null){
            String[] fNameWExt = fNamePath.toString().split("\\.");

            destImgName = fNameWExt[0] + '-' + UUID.randomUUID().toString() + '.' + fNameWExt[1];
        }
        return destImgName;
    }
    
}
