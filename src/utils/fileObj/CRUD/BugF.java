/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.fileObj.CRUD;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;

/**
 *
 * @author ahmed
 */
public class BugF extends ObjF<dataTypes.Bug> {

    private static String typeRegex = "Functional|Logical|Workflow|Unit Level|System-Level Integration|Out of Bound|Security";
    private static String priorityRegex = "Low|Mid|High";
    private static String levelRegex = "Low|Minor|Major|Critical";

    public BugF() {
        super("bug");
    }

    @Override
    protected void validateData(dataTypes.Bug newBug) throws Exception {

        if (newBug == null) {
            throw new Exception("Bug can not be null");
        }

        if (newBug.getName() == null || newBug.getName().isBlank() || newBug.getProject_id() == null) {
            throw new Exception("Provide all the data");
        }
        
        utils.Regex regex = new utils.Regex(typeRegex);

        if (!regex.test(newBug.getType())) {
            throw new Exception("Valid types are: " + typeRegex);
        }

        regex.val = priorityRegex;

        if (!regex.test(newBug.getPriority())) {
            throw new Exception("Valid priority are: " + priorityRegex);
        }

        regex.val = levelRegex;

        if (!regex.test(newBug.getLevel())) {
            throw new Exception("Valid Levels are: " + levelRegex);
        }
    }

    @Override
    protected void checkUnique(dataTypes.Bug newBug) throws Exception {
    }
    
    
    public int delete(Predicate<dataTypes.Bug>... predicates) throws Exception{
        int c = 0;
        
        for(dataTypes.Bug removedBug: get(predicates)){
            c+=super.delete((bug)-> bug.getId().equals(removedBug.getId()));
            Files.delete(Paths.get("Images\\" + removedBug.getImgPath()));
        }
        return c;
    }
    
    
}
