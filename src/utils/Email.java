
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    
   private static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";
    
   public static boolean isValidate(String email) {
       Pattern pattern = Pattern.compile(regex);
       
       Matcher matcher = pattern.matcher(email);
       
       return matcher.matches();
   }
}
    