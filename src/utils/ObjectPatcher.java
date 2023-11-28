/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.lang.reflect.Field;

/**
 *
 * @author ahmed
 */
public class ObjectPatcher {

    public static <T> void patch(T object, String fieldName, Object newVal) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);

            field.setAccessible(true);

            field.set(object, newVal);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

    }

    public static <T> void patch(T object, Object newData[][]) {
        try {

            for (Object keyVal[] : newData) {
                Field field = object.getClass().getDeclaredField((String)keyVal[0]);

                field.setAccessible(true);

                field.set(object, keyVal[1]);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

    }
}
