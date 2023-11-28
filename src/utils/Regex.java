/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.regex.*;

/**
 *
 * @author ahmed
 */
public class Regex {
    public String val;
    
    public Regex(String regex){
        this.val = regex;
    }
    
    public boolean test(String s){
        if(val != null){
            Pattern pattern = Pattern.compile(val);
       
            Matcher matcher = pattern.matcher(s);
       
            return matcher.matches();
        }
        return false;
    }
}
