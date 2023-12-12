/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataTypes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ahmed
 */
public class dataTypes {
    
    @Override
    public String toString() {

        ArrayList<Field> fields = new ArrayList<Field>(Arrays.asList(this.getClass().getDeclaredFields()));

        String strRepresentation = "{";

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                strRepresentation += " " + field.getName() + ": " + String.valueOf(field.get(this));

                if (fields.indexOf(field) != fields.size() - 1) {
                    strRepresentation += ",";
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        strRepresentation += " }";

        return strRepresentation;
    }

}
