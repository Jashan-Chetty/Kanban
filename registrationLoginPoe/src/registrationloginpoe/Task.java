/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrationloginpoe;

import javax.swing.JOptionPane;
import java.util.ArrayList;


/**
 *
 * @author jashan
 */
public class Task {
    
     // Global Varible adn ArrayList Declaration 
     int TaskNum = 0;
     ArrayList <String> DeveloperNameList = new ArrayList<>();
     ArrayList <String> NameList = new ArrayList<>();
     ArrayList <String> TaskIDList = new ArrayList<>();
     ArrayList <Integer> DurationList = new ArrayList<>();
     ArrayList <String> TaskStatusList = new ArrayList<>();
     ArrayList <String> TaskDescriptionList = new ArrayList<>();

     // Calls the methods
    public static void Caller(String DetailDone, String Report, String TaskFoundMessage, String DevelopersTasksFound, boolean TaskFound, String Name, String Description, String DeveloperName, String TaskInfo){
        
        Task taskCall = new Task();
        taskCall.welcomeMessage();
        taskCall.newSwitch(DetailDone, Report, TaskFoundMessage, DevelopersTasksFound, TaskFound, Name, Description, DeveloperName, TaskInfo);
    }

    //Displays Welcome message when user enters
    public void welcomeMessage() {
        
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanBan");
    }

    public void newSwitch(String DetailDone, String Report, String TaskFoundMessage, String DevelopersTasksFound, boolean TaskFound, String Name, String Description, String DeveloperName, String TaskInfo) {
        int Option;

        do {
            // Allows user to choose what they would like to do
            Option = Integer.parseInt(JOptionPane.showInputDialog("""
            What would you like to do:
                1. Add Tasks
                2. Show Report
                3. Exit
            """));

            switch (Option) {
                case 1:
                    taskMain();
                    break;
                case 2:
                    //JOptionPane.showMessageDialog(null, "Coming Soon");
                    userChoiceForDisplayReport(DetailDone, Report, TaskFoundMessage, DevelopersTasksFound, TaskFound, Name, Description, DeveloperName, TaskInfo);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Thank you for using EasyKanBan");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please select one of the options provided!!!");
                   break; 
            }
            
        } while (Option != 3);
    }

    public void taskMain() {
        
        int NumTasks = Integer.parseInt(JOptionPane.showInputDialog
        (null, "How many tasks would you like to add"));
        int TotalHours = 0; 
        

        for (int i = 0; i < NumTasks; i++) {
            String Name = JOptionPane.showInputDialog("Enter task name");
            
            String Description = JOptionPane.showInputDialog("Enter task description");
            
            String DeveloperName = JOptionPane.showInputDialog
            ("Enter developer's name");
            
            int TaskDuration = Integer.parseInt(JOptionPane.showInputDialog
            ("Please enter task duration"));
            

            // Checks if Description entered by user meets requirments and displays the accurate message
            if (checkTaskDescription(Description)) {
                String TaskID = createTaskID(Name, DeveloperName);

                DeveloperNameList.add(DeveloperName);
                NameList.add(Name);
                TaskDescriptionList.add(Description);
                TaskIDList.add(TaskID);
                DurationList.add(TaskDuration);
                String TaskStatus = taskStatus();
                TaskStatusList.add(TaskStatus);
                //TaskStatusList.add(taskStatus());
                
                
                JOptionPane.showMessageDialog
            (null, "Task Successfully Captured");
                
                JOptionPane.showMessageDialog
            (null, printTaskDetails(Name, Description, DeveloperName, TaskDuration, TaskStatus)); 
                
                TotalHours = returnTotalHours(TotalHours, TaskDuration); 
                
            } else {
                JOptionPane.showMessageDialog
            (null, "Please enter a task description of less than 50 characters");
                // Decrements by 1 allowing user to re-enter description if over 
                i--;
            }
        }
        // Display total hours
        JOptionPane.showMessageDialog(null, "Total Hours: " + TotalHours); 
    }

    public boolean checkTaskDescription(String Description) {
        
        // Code ensures Description is less than 50 characters
        return Description.length() <= 50;
    }

    public String createTaskID(String Name, String DeveloperName) {
        
        /*
            Takes first two letters of the Task Name: the Task Number: last three letters of the developer
            Author: Ravikiran A S
            Site: https://www.simplilearn.com/tutorials/java-tutorial/substring-in-java#:~:text=The%20substring()%20function%20in,to%20the%20specified%20end%20index.
        */
        String TaskID = Name.substring(0, 2) + ":" + TaskNum + ":" 
                + DeveloperName.substring(DeveloperName.length() - 3);
        
        return TaskID.toUpperCase();
    }

    public String taskStatus() {
        int Option;
        String taskStatus = "";

        while (true) {
            // Asks user what the current status of task is using a switch.
            Option = Integer.parseInt(JOptionPane.showInputDialog("""
            What is your task status:
                1. To Do
                2. Done
                3. Doing
            """));

            switch (Option) {
                case 1:
                    taskStatus = "TO DO";
                    break;
                case 2:
                    taskStatus = "Done";
                    break;
                case 3:
                    taskStatus = "Doing";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please select one of the options provided!!!");      
            }
          break;
        }

        return taskStatus;
    }

    public String printTaskDetails(String Name, String Description, String DeveloperName, int TaskDuration, String TaskStatus) {
        //Prints task details
        String TaskID = createTaskID(Name, DeveloperName);
       // String TaskStatus = taskStatus();
        String TaskInfo = "Task Status: " + TaskStatus + "\n"
                + "Developer Details: " + DeveloperName + "\n"
                + "Task Number: " + (TaskNum++) + "\n" // 
                + "Task Name: " + Name + "\n"
                + "Task Description: " + Description + "\n"
                + "Task ID: " + TaskID + "\n"
                + "Task Duration: " + TaskDuration + "hrs";

        return TaskInfo;
    }

    public int returnTotalHours(int TotalHours, int TaskDuration) {
        // Calculates Total Hours
        TotalHours += TaskDuration;
        return TotalHours;
    }
    
    public void userChoiceForDisplayReport(String DetailDone, String Report, String TaskFoundMessage, String DevelopersTasksFound, boolean TaskFound, String Name, String Description, String DeveloperName, String TaskInfo){
        
        int Choice;
        do{
            // Provides options using a switch statement allowing user to do what they want with their tasks
        Choice = Integer.parseInt(JOptionPane.showInputDialog
        (null,"""
              What would you like to do:
                1) Display Task that are done
                2) Display task with longest duration
                3) Search for task
                4) Search for developer task
                5) Delete Task
                6) Display all Tasks recorded
                7) Exit
              
              """));
        
        switch(Choice){
            case 1:
                displayTasksDone(DetailDone);
                break;
            case 2:
                findingMax(Report);
                break;
            case 3:
                searchingTask(TaskFoundMessage);
                break;
            case 4:
                searchingDeveloper(DevelopersTasksFound);
                break;
            case 5:
                deleteTask(TaskFound);
                break;
            case 6:
                displayAllTasks(Name, Description, DeveloperName, TaskInfo);
                break;
            case 7:
                return;
      
        }
        
        }while (Choice != 7);
        
    }
    
    /*
        Conepts on ArrayLists
        Author: Coding with John
        https://www.youtube.com/watch?v=NbYgm0r7u6o&t=790s
    */
    
    
    public void displayTasksDone(String DetailDone){
        
        // Looks for tasks with the task status of done and display the required elements
        for (int i = 0; i < TaskIDList.size(); i++){
            if(TaskStatusList.get(i).equals("Done")){
            String DevelopersName = DeveloperNameList.get(i);
            String Name = NameList.get(i);
            String TaskID = TaskIDList.get(i);
            int Duration = DurationList.get(i);
            
            DetailDone = "Task Status: " + TaskStatusList.get(i) + "\n"
                + "Developer Details: " + DevelopersName + "\n"
                + "Task Name: " + Name + "\n"             
                + "Task ID: " + TaskID + "\n"
                + "Task Duration: " + Duration + "hrs";
            
            JOptionPane.showMessageDialog(null, DetailDone);
            } 
        }
    }
    
    public void findingMax(String Report){
        
        /*
            Author: Interview DOT
            https://www.youtube.com/watch?v=ttEj9Sap85k
        
            Finds the task with the longest duration
        */
        
       String TaskName = "";
       int MaxValue = Integer.MIN_VALUE;
       
       for (int j = 0; j < DurationList.size();j++){
           int Duration = DurationList.get(j);
           if (Duration > MaxValue){
               MaxValue = Duration;
               TaskName = NameList.get(j);
               
               Report = "Your Task with the Longest Duration is: \n"
                       + "Task Name: " + TaskName + "\n"
                       + "Task Duration: " + Duration ;
       
                JOptionPane.showMessageDialog(null, Report);
                break;
           }

       }
            
    }
    
    public void searchingTask(String TaskFoundMessage){
        
        /*
            Author: Baeldung
            https://www.baeldung.com/find-list-element-java
        
            Finds the tasks in the array the user searches for using .equals and displays the required elements
        */
        
        String SearchTaskName = JOptionPane.showInputDialog("Enter the task name to search");
        boolean TaskFound = false;
        
        for(int x = 0; x < NameList.size(); x++){

           if (NameList.get(x).equals(  SearchTaskName)){
               
              String TaskName = NameList.get(x);
              String TaskDeveloper = DeveloperNameList.get(x);
              String TaskStatus = TaskStatusList.get(x);
              
              TaskFoundMessage = "The Task you searched for is : \n"  
                       + "Task Name: " + TaskName + "\n"
                       + "Task Developer: " + TaskDeveloper + "\n"
                       + "Task Status: " + TaskStatus ;
              
              JOptionPane.showMessageDialog(null, TaskFoundMessage);
              TaskFound = true;
              break;
           }
        
        }
        
        if (!TaskFound){
            JOptionPane.showMessageDialog(null, "Sorry,your task was not found");
        }
        
    }
    
    public void searchingDeveloper(String DevelopersTasksFound){
        
        // Finds the developer in the array the user searches for using .equals and displays the required elements
        
        String SearchDeveloper = JOptionPane.showInputDialog("Please enter developer name");
        boolean DeveloperFound = false;
        
        for (int y = 0; y < DeveloperNameList.size(); y++){
            if (DeveloperNameList.get(y).equals(SearchDeveloper)){
                String TaskDeveloper = DeveloperNameList.get(y);
                String TaskName = NameList.get(y);
                String TaskStatus = TaskStatusList.get(y);
                
                DevelopersTasksFound = "The Tasks for " + TaskDeveloper + " are: \n"
                        + "Task Name: " + TaskName + "\n"
                        + "Task Status: " + TaskStatus ;
                
                JOptionPane.showMessageDialog(null, DevelopersTasksFound);
                DeveloperFound = true;

            }
        }
        
        if (!DeveloperFound){
            JOptionPane.showMessageDialog(null, "Sorry,developer was not found");
        }
            
    }
    
    public void deleteTask(boolean TaskFound){
        
        /* 
           Deletes the element in the array list using .equals and array list functionalities
           Aid from Lecturer : Mr Sookha
        */
        String DeleteTask = JOptionPane.showInputDialog("What task would you like to delete: ");
        TaskFound = false;
        
        for (int Z = 0; Z < NameList.size(); Z++){
            if(NameList.get(Z).equals(DeleteTask)){
                NameList.remove(Z);
                DeveloperNameList.remove(Z);
                TaskIDList.remove(Z);
                DurationList.remove(Z);
                TaskStatusList.remove(Z);
                TaskDescriptionList.remove(Z);
                TaskFound = true;
                JOptionPane.showMessageDialog(null, "Your Task has been successfully deleted");
                break;
            }      
        }
        if (!TaskFound){
            JOptionPane.showMessageDialog(null, "Sorry,your task was not found");
        }    
    }
    
    public void displayAllTasks(String Name, String Description, String DeveloperName, String TaskInfo){
        
        
        // Displays all tasks in the array 
        for (int k = 0; k < TaskIDList.size(); k++){
            
            String TaskStatus = TaskStatusList.get(k);
            DeveloperName = DeveloperNameList.get(k);
            Name = NameList.get(k);
            Description = TaskDescriptionList.get(k);
            int Duration = DurationList.get(k);
            
             String TaskID = createTaskID(Name, DeveloperName);
             TaskInfo = "Task Status: " + TaskStatus + "\n"
                + "Developer Details: " + DeveloperName + "\n"
                + "Task Number: " + k + "\n" // 
                + "Task Name: " + Name + "\n"
                + "Task Description: " + Description + "\n"
                + "Task ID: " + TaskID + "\n"
                + "Task Duration: " + Duration + "hrs";
             
             JOptionPane.showMessageDialog(null, TaskInfo);
            
        }
    }  
}
