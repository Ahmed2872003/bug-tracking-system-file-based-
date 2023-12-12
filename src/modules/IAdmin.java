/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;


import java.util.ArrayList;


public interface IAdmin {

    ArrayList<dataTypes.Bug> viewAllBugs(Integer projectId);

    dataTypes.User addUser(dataTypes.User user);

    void deleteUser(Integer userId);

    void addUserToProject(Integer userId, Integer projectId);

    void deleteUserFromProject(Integer memberId, Integer projectId);

    void updateUser(Object newData[][], Integer userId);
}
