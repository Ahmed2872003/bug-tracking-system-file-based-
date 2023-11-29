/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.fileObj.CRUD;

import java.io.IOException;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.function.Predicate;
import utils.fileObj.CRUD.*;

public class UserF extends ObjF<dataTypes.User> {
    
    private String regex = "Tester|Developer|Project Manager|Admin";
    

    public UserF() {
        super("user");
    }

    @Override
    protected void validateData(dataTypes.User newUser) throws Exception {
        if (newUser == null) {
            throw new Exception("User can not be null");
        }

        if (newUser.name == null || newUser.email == null || newUser.password == null || newUser.name.isBlank() || newUser.email.isBlank() || newUser.password.isBlank()) {
            throw new Exception("provide all user information");
        }

        if (!utils.Email.isValidate(newUser.email)) {
            throw new Exception("Provide a valid email");
        }

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(newUser.role);

        if (!matcher.matches()) {
            throw new Exception("valid roles are: " + regex);
        }

        checkUnique(newUser);

    }

    @Override
    protected void checkUnique(dataTypes.User newUser) throws Exception {
        if (!isEmpty()) {

            openInput();

            ArrayList<dataTypes.User> storedUserList = (ArrayList<dataTypes.User>) ois.readObject();

            for (dataTypes.User storedUser : storedUserList) {
                if (storedUser.email.equals(newUser.email) && storedUser.getId().intValue() != newUser.getId().intValue()) {
                    closeInput();
                    throw new Exception("This email is used");
                }
            }

            closeInput();
        }
    }

    public int delete(Predicate<dataTypes.User>... predicates) throws Exception {
        int c = 0;

        for (dataTypes.User removedUser : get(predicates)) {

            c = super.delete((user) -> user.getId().equals(removedUser.getId())); // remove the user

            ProjectMemberF ProjectMemberFile = new ProjectMemberF();

            ProjectMemberFile.delete((projectMember) -> projectMember.member_id.equals(removedUser.getId()));

            // handling other files when deleting a user
            switch (removedUser.role) {
                case "Admin": {

                    ProjectF projectFile = new ProjectF();

                    projectFile.delete((project) -> project.admin_id.equals(removedUser.getId()));

                    break;
                }

                case "Tester": {
                    BugF bugFile = new BugF();

                    bugFile.delete((bug) -> bug.tester_id.equals(removedUser.getId()));

                    break;
                }

                case "Developer": {
                    BugF bugFile = new BugF();

                    bugFile.update(new Object[][]{{"developer_id", null}}, (bug) -> bug.developer_id.equals(removedUser.getId()));

                    break;
                }
            }
        }
        return c;

    }
    
    
     public int update(Object newData[][], Predicate<dataTypes.User>... predicates) throws Exception{
                 
         for(Object arr[]: newData){
            if(String.valueOf(arr[0]).equals("role")){
                utils.Regex regex = new utils.Regex(this.regex);
                
                if(!regex.test((String)arr[1])) throw new Exception("valid roles are: "+this.regex);
                else break;
            }
             
         }
         
     
         return super.update(newData, predicates);
     }

}


