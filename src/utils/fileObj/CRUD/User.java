/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.fileObj.CRUD;

import java.io.IOException;
import java.util.regex.*;
import java.util.ArrayList;

public class User extends Obj<dataTypes.User> {

    public User() {
        super("user");
    }

    @Override
    protected void validateData(dataTypes.User user) throws Exception {
        if (user == null) {
            throw new Exception("Provide user details");
        }

        if (user.name == null || user.email == null || user.password == null || user.name.isBlank() || user.email.isBlank() || user.password.isBlank()) {
            throw new Exception("provide all user information");
        }
        
        if(!utils.Email.isValidate(user.email)) throw new Exception("Provide a valid email");

        String rgex = "Tester|Developer|Project Manager|Admin";

        Pattern pattern = Pattern.compile(rgex);

        Matcher matcher = pattern.matcher(user.role);

        if (!matcher.matches()) {
            throw new Exception("valid roles are: " + rgex);
        }

        checkUnique(user);

    }

    private void checkUnique(dataTypes.User user) throws Exception {
        if (file.length() != 0) {

            openInput();

            ArrayList<dataTypes.User> storedUserList = (ArrayList<dataTypes.User>) ois.readObject();

            for (dataTypes.User storedUser : storedUserList) {
                if (storedUser.email.equals(user.email) && storedUser.id.intValue() != user.id.intValue()) {
                    closeInput();
                    throw new Exception("This email is used");
                }
            }

            closeInput();
        }
    }

}

//    
//    @Override
//    public  ResultSet create(String[] data) throws SQLException{
//        
//        String dataEdit = String.join("','", data);
//        
//        
//        this.statement.executeUpdate("INSERT INTO user (name, email, password, role)\n" +
//        "VALUES ('" + dataEdit +"')");
//        
//        return this.statement.executeQuery("SELECT last_insert_id() AS id");
//    
//    }
//    
//    public ResultSet getProjects(int id) throws SQLException{
//        return this.statement.executeQuery(
//                "SELECT id, name\n" +
//                "FROM project_member\n" +
//                "INNER JOIN project\n" +
//                "ON project.id = project_member.project_id\n" +
//                "WHERE member_id = " + id);
//    }
//    
//    
//    public void addToProject(String[] data) throws SQLException{
//        
//        String dataEdit = String.join("','", data);
//        
//        this.statement.executeUpdate("INSERT INTO project_member\n" +
//                                     "VALUES ('" + dataEdit + "')");
//    }
//    
//    
//    public void deleteFromProject(int id, int projectId)throws SQLException{
//        this.statement.executeUpdate("DELETE FROM project_member\n" + 
//                                    "WHERE project_id= "+ projectId + " AND member_id = "+id 
//                );
//    }

