/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author ahmed
 */
public class SessionStorage {
    private static Object data = null;
    
    
    public static Object getData(){
        return data;
    }
    
    public static void setData(Object data){
        SessionStorage.data = data;
    }
    
}
