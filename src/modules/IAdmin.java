/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;


import java.util.ArrayList;


public interface IAdmin {

    ArrayList<dataTypes.Bug> viewAllBugs(Integer projectId) throws Exception;

    dataTypes.User addUser(dataTypes.User user) throws Exception;

    void deleteUser(Integer userId) throws Exception;

    void addUserToProject(Integer userId, Integer projectId) throws Exception;

    void deleteUserFromProject(Integer memberId, Integer projectId) throws Exception;

    void updateUser(Object newData[][], Integer userId) throws Exception;
}
