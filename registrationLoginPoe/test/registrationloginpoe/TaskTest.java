/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package registrationloginpoe;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jasha
 */
public class TaskTest {
    
    public TaskTest() {
    }

    /**
     * Test of welcomeMessage method, of class Task.
     */
    @Test
    public void testWelcomeMessage() {
        System.out.println("welcomeMessage");
        Task instance = new Task();
        instance.welcomeMessage();
       
    }

    /**
     * Test of newSwitch method, of class Task.
     */
    String DetailDone;
    String Report;
    String TaskFoundMessage;
    String DevelopersTasksFound;
    boolean TaskFound;
    String Name;
    String Description;
    String DeveloperName;
    String TaskInfo;
    
    @Test
    public void testNewSwitch() {
        System.out.println("newSwitch");
        Task instance = new Task();
        instance.newSwitch(DetailDone, Report, TaskFoundMessage, DevelopersTasksFound, TaskFound, Name, Description, DeveloperName, TaskInfo);
       
    }

    /**
     * Test of taskMain method, of class Task.
     */
    @Test
    public void testTaskMain() {
        System.out.println("taskMain");
        Task instance = new Task();
        instance.taskMain();
        
    }

    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
    public void testCheckTaskDescription() {
        System.out.println("checkTaskDescription");
        String Description = "Create Login to authenticate users";
        Description = "Task successfully captured";
        Task instance = new Task();
        boolean expResult = true;
        boolean result = instance.checkTaskDescription(Description);
        assertEquals(expResult, result);
        
    }
    
        @Test
    public void testCheckTaskDescriptionFail() {
        System.out.println("checkTaskDescription");
        String Description = "Please enter a task description of less than 50 characters";
        Task instance = new Task();
        boolean expResult = false;
        boolean result = instance.checkTaskDescription(Description);
        assertEquals(expResult, result);
        
    }
    
        @Test
    public void testCheckTaskDescription2() {
        System.out.println("checkTaskDescription");
        String Description = "Create Add Task feature to add task users";
        Description = "Task successfully captured";
        Task instance = new Task();
        boolean expResult = true;
        boolean result = instance.checkTaskDescription(Description);
        assertEquals(expResult, result);
        
    }
    
        @Test
    public void testCheckTaskDescription2Fail() {
        System.out.println("checkTaskDescription");
        String Description = "Please enter a task description of less than 50 characters";
        Task instance = new Task();
        boolean expResult = false;
        boolean result = instance.checkTaskDescription(Description);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of createTaskID method, of class Task.
     */
    @Test
    public void testCreateTaskID1() {
        System.out.println("createTaskID");
        String Name = "Login Feature";
        String DeveloperName = "Robyn Harrison";
        Task instance = new Task();
        String expResult = "LO:0:SON";
        String result = instance.createTaskID(Name, DeveloperName);
        assertEquals(expResult, result);
       
    }
    
    @Test
    public void testCreateTaskID2() {
        System.out.println("createTaskID");
        String Name = "Add Task Feature”";
        String DeveloperName = "Mike Smith ";
        Task instance = new Task();
        String[] expResult = {"CR:0:IKE", "CR:1:ARD", "CR:2:THA", "CR:3:ND"};
        String result = instance.createTaskID(Name, DeveloperName);
        String taskID = instance.createTaskID(Name, DeveloperName);
        assertEquals(expResult, result);
           
        
        
       
    }

    /**
     * Test of taskStatus method, of class Task.
     */
    @Test
    public void testTaskStatus() {
        System.out.println("taskStatus");
        Task instance = new Task();
        String expResult = "";
        String result = instance.taskStatus();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of printTaskDetails method, of class Task.
     */
    @Test
    public void testPrintTaskDetails() {
        System.out.println("printTaskDetails");
        String Name = "";
        String Description = "";
        String DeveloperName = "";
        String TaskStatus = "";
        int TaskDuration = 0;
        Task instance = new Task();
        String expResult = "";
        String result = instance.printTaskDetails(Name, Description, DeveloperName, TaskDuration, TaskStatus);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of returnTotalHours method, of class Task.
     */
    @Test
    public void testReturnTotalHours() {
        System.out.println("returnTotalHours");
        
        
        int TotalNumTasks = 5;
        int[] TaskDurations = { 10,12,55,11,1};
        int TotalHours = 18;
        int TotalHours2 = 89; 
        int TaskDuration = 0;
        Task instance = new Task();
        int expResult = 0;
        int result = instance.returnTotalHours(TotalHours, TaskDuration);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of Caller method, of class Task.
     */
    /* @Test
    public void testCaller(String DetailDone, String Report, String TaskFoundMessage, String DevelopersTasksFound, boolean TaskFound, String Name, String Description, String DeveloperName, String TaskInfo) {
    System.out.println("Caller");
    Task.Caller(DetailDone, Report, TaskFoundMessage, DevelopersTasksFound, TaskFound, Name, Description, DeveloperName, TaskInfo);
    
    }*/

    /**
     * Test of createTaskID method, of class Task.
     */
    @Test
    public void testCreateTaskID() {
        System.out.println("createTaskID");
        String Name = "";
        String DeveloperName = "";
        Task instance = new Task();
        String expResult = "";
        String result = instance.createTaskID(Name, DeveloperName);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of userChoiceForDisplayReport method, of class Task.
     */
    @Test
    public void testUserChoiceForDisplayReport() {
        System.out.println("userChoiceForDisplayReport");
        String DetailDone = "";
        String Report = "";
        String TaskFoundMessage = "";
        String DevelopersTasksFound = "";
        boolean TaskFound = false;
        String Name = "";
        String Description = "";
        String DeveloperName = "";
        String TaskInfo = "";
        Task instance = new Task();
        instance.userChoiceForDisplayReport(DetailDone, Report, TaskFoundMessage, DevelopersTasksFound, TaskFound, Name, Description, DeveloperName, TaskInfo);
       
    }

    /**
     * Test of displayTasksDone method, of class Task.
     */
    @Test
    public void testDisplayTasksDone() {
        System.out.println("displayTasksDone");
        String DetailDone = "";
        Task instance = new Task();
        instance.displayTasksDone(DetailDone);
        
    }

    /**
     * Test of findingMax method, of class Task.
     */
    @Test
    public void testFindingMax() {
        System.out.println("findingMax");
        int TaskDuration = 11;
        String Developer = "Glenda Oberholzer";
        String Report = "Glenda Oberholzer, 11";
        Task instance = new Task();
        instance.findingMax(Report);
        assertEquals(TaskDuration, Report);
        
    }

    /**
     * Test of searchingTask method, of class Task.
     */
    @Test
    public void testSearchingTask() {
        System.out.println("searchingTask");
        String SearchTaskName = "Create Login";
        String TaskFoundMessage = "Mike Smith, Create Login";
        Task instance = new Task();
        instance.searchingTask(SearchTaskName);
        instance.searchingTask(TaskFoundMessage);
        assertEquals(SearchTaskName, TaskFoundMessage);
    }

    /**
     * Test of searchingDeveloper method, of class Task.
     */
    @Test
    public void testSearchingDeveloper() {
        System.out.println("searchingDeveloper");
        String Developer = "Samantha Paulson";
        String DevelopersTasksFound = "Create Reports";
        Task instance = new Task();
        instance.searchingDeveloper(DevelopersTasksFound);
        assertEquals(Developer, DevelopersTasksFound);
    }

    /**
     * Test of deleteTask method, of class Task.
     */
    @Test
    public void testDeleteTask() {
        System.out.println("deleteTask");
        boolean TaskFound = true;
        String TaskName = "Create Reports";
        String Report = "Entry “Create reports” successfully deleted";
        Task instance = new Task();
        instance.deleteTask(TaskFound);
        assertEquals(TaskFound, Report);
        
    }

    /**
     * Test of displayAllTasks method, of class Task.
     */
    @Test
    public void testDisplayAllTasks() {
        System.out.println("displayAllTasks");
        String Name = "";
        String Description = "";
        String DeveloperName = "";
        String TaskInfo = "";
        Task instance = new Task();
        instance.displayAllTasks(Name, Description, DeveloperName, TaskInfo);
        
    }

    /**
     * Test of Caller method, of class Task.
     */
    @Test
    public void testCaller() {
        System.out.println("Caller");
        String DetailDone = "";
        String Report = "";
        String TaskFoundMessage = "";
        String DevelopersTasksFound = "";
        boolean TaskFound = true;
        String Name = "";
        String Description = "";
        String DeveloperName = "";
        String TaskInfo = "";
        Task.Caller(DetailDone, Report, TaskFoundMessage, DevelopersTasksFound, TaskFound, Name, Description, DeveloperName, TaskInfo);
        
    }
    
}
