/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import java.util.ArrayList;


public interface IDeveloper {

    ArrayList<dataTypes.Bug> getAssignedBugs(Integer projectId) throws Exception;

    void changeBugStatus(Integer bugId) throws Exception;

    void sendEmailToTester(String testerEmail, Integer bugId);
}
