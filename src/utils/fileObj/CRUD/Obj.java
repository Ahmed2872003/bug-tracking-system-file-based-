/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.fileObj.CRUD;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import utils.Identifiable;
import java.util.function.Predicate;

/**
 *
 * @author ahmed
 */
abstract public class Obj<T extends Identifiable> {

    protected String name;
    protected ObjectInputStream ois;
    protected ObjectOutputStream oos;
    protected FileInputStream fis;
    protected FileOutputStream fos;
    protected File file;
    protected Path path;

    public Obj(String name) {
        this.name = name;

        Path path = Paths.get("storage\\" + name + ".txt");

        file = new File(path.toString());

        try {

            if (!file.isFile()) {
                Files.createFile(path);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    protected void openInput() {
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    protected void openOutput() {

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    protected void closeInput() {
        try {
            if (fis != null) {
                fis.close();
            }
            if (ois != null) {
                ois.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    protected void closeOutput() {
        try {
            if (fos != null) {
                fos.close();
            }
            if (oos != null) {
                oos.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    protected boolean isEmpty() throws IOException, ClassNotFoundException {

        if (file.length() != 0) {
            openInput();

            if (((ArrayList<T>) ois.readObject()).isEmpty()) {
                closeInput();
                return true;
            } else {
                closeInput();
                return false;
            }
        }

        return true;

    }

    abstract protected void validateData(T obj) throws Exception;

    private boolean matchFilters(T obj, Predicate<T> predicates[]) {

        if (predicates == null || predicates.length == 0) {
            return true;
        }

        for (Predicate<T> predicate : predicates) {
            if (!predicate.test(obj)) {
                return false;
            }
        }
        return true;
    }

    protected Integer getLastInsertedId() throws IOException, ClassNotFoundException {
        if (!isEmpty()) {
            openInput();

            ArrayList<T> list = (ArrayList<T>) ois.readObject();

            return list.get(list.size() - 1).getId();
        }

        return null;
    }

    public void create(T obj) throws Exception {
        validateData(obj);

        ArrayList<T> list = new ArrayList<T>();

        if (!isEmpty()) {
            openInput();

            list = (ArrayList<T>) ois.readObject();

            closeInput();
        }

        Integer LastInsertedId = getLastInsertedId();

        if (LastInsertedId != null) {
            obj.setId(LastInsertedId + 1);
        } else {
            obj.setId(1);
        }

        list.add(obj);

        openOutput();

        oos.writeObject(list);

        closeOutput();
    }

    public T getByID(Integer id) throws IOException, ClassNotFoundException {
        if (!isEmpty()) {
            openInput();

            ArrayList<T> list = (ArrayList<T>) ois.readObject();
            
            closeInput();

            for(T obj: list){
                if(obj.getId().intValue() == id.intValue())
                    return obj;
            }
            return null;
        }
        return null;
    }

    public ArrayList<T> get(Predicate<T>... predicates) throws IOException, ClassNotFoundException {
        ArrayList<T> res = new ArrayList<T>();

        if (!isEmpty()) {
            openInput();
            for (T obj : (ArrayList<T>) ois.readObject()) {

                if (matchFilters(obj, predicates)) {
                    res.add(obj);
                }
            }

            closeInput();
        }

        return res;
    }

    public void delete(Predicate<T>... predicates) throws IOException, ClassNotFoundException {
        if (!isEmpty()) {
            ArrayList<T> ObjectsAfterdelete = new ArrayList<T>();

            openInput();

            for (T obj : (ArrayList<T>) ois.readObject()) {

                if (!matchFilters(obj, predicates)) {
                    ObjectsAfterdelete.add(obj);
                }
            }
            closeInput();

            openOutput();

            oos.writeObject(ObjectsAfterdelete);

            closeOutput();

        }
    }

    public void updateOne(T newObj ,Predicate<T>... predicates) throws Exception{
        if(!isEmpty() && predicates != null && predicates.length != 0){
            
            validateData(newObj);
            
            openInput();
            
            ArrayList<T> storedList = (ArrayList<T>) ois.readObject();
            
            closeInput();
            
            
            for(int i = 0 ; i < storedList.size() ; i++){
                if(matchFilters(storedList.get(i), predicates)){
                    storedList.set(i, newObj);
                    break;
                }
            }
            
            openOutput();
            
            oos.writeObject(storedList);
            
            closeOutput();
            
        }
    }
    
}
