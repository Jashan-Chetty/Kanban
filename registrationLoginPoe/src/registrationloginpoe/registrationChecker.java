/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrationloginpoe;
import javax.swing.JOptionPane;


/**
 *
 * @author jashan
 */
public class registrationChecker {
    
    /*
        https://www.edureka.co/blog/instance-variable-in-java/
        Author: Anamika Kalwan
        Instance Varibles used to store user's Username and Password
        Used again in lines 123,140,159,160
    */
    public String registeredUsername;
    public String registeredPassword;
    public String firstName;
    public String lastName;
    public String TaskID;
    String DetailDone;
    String Report;
    String TaskFoundMessage;
    String DevelopersTasksFound;
    boolean TaskFound;
    String Name;
    String Description;
    String DeveloperName;
    String TaskInfo;
    
    
    
    public void switchClass()
    {
        //Scanner Declaration 
        registrationChecker checker = new registrationChecker();
        Task TaskCheck = new Task();
        
  
        String option;
        
        /*
           Loops the switch till the option "Exit" is chosen
        */
                
        do{
             option =  JOptionPane.showInputDialog( """
                           What would you like to do:
                                1.(Register)
                                2.(Login)
                                3.(Exit)                                
                           """);
        
        /*
            https://stackoverflow.com/questions/26520452/java-do-while-loop-with-switch-statement
        */
        
      
        switch(option)
        {
            case "1": 
            {
                String fName = JOptionPane.showInputDialog("Please Enter your First Name: ");
                String lName = JOptionPane.showInputDialog("Please Enter your Last Name: ");
                String userName = JOptionPane.showInputDialog("Please Enter a Username: ");
                String passWord = JOptionPane.showInputDialog("Please Enter a Password: ");
                
                checker.registerUser(userName, fName, lName);
                checker.registerUserPassword(passWord);
                
                break;
            }
                
            case "2": 
            {
                String userName = JOptionPane.showInputDialog("Please Enter your Username: ");
                String passWord = JOptionPane.showInputDialog("Please Enter your Password: ");
                
                /*
                    Assistance Gareth (ST 10203395)
                */
                boolean LoginVar = checker.loginUser(userName, passWord);
                if (LoginVar)
                {
                    TaskCheck.welcomeMessage();
                    TaskCheck.newSwitch(DetailDone, Report, TaskFoundMessage, DevelopersTasksFound, TaskFound, Name, Description, DeveloperName, TaskInfo);
                }
                
                break;
            }
                               
                
            case "3":
            {
               JOptionPane.showMessageDialog(null,"Thank You for using our application");
                break;
            }
                
            default: 
            {
                 JOptionPane.showMessageDialog(null,"Please enter one of the  provided Options!!!");
                break;
            }                   

        }
        } while (!option.equals("3"));
       
    }
    
    /*
      https://www.youtube.com/watch?v=rioHqpj5xWo
      Author Max O'Didily
    
      User restictions for the Username
    */
    
    public boolean checkUsername(String uName)
    {
        return ((uName.length()) <= 5 && uName.contains("_"));
    }
    
    /*
      User restrictions for the Password
    */
    public boolean checkPasswordComplexity(String passW)
    {
        /*
        https://mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/
        Author Mkyong
        */

        return (passW.length() >= 8 && (passW.matches
        ("(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=!]).*")));
    }
    
    /*
      Displays the correct message for the Username, if it is Valid or Invalid
      and stores user's Username
    */
    public String registerUser(String uName, String firstName, String lastName)
    {
        if (checkUsername(uName))
        {
            JOptionPane.showMessageDialog(null,"Username Successfully Captured");
            this.registeredUsername = uName;
            this.firstName = firstName;
            this.lastName = lastName;
            
        }
        
        else
        {
            JOptionPane.showMessageDialog(null,"Username is not correctly formatted, "
                    + "please ensure that your username contains an underscore "
                    + "and is no more than 5 characters in length ");
        }
        
        return (uName);       
    }
    
    /*
      Displays the correct message for the Password, if it is Valid or Invalid
      and stores user's Password
    */
    public String registerUserPassword(String passW)
    {
        if (checkPasswordComplexity(passW))
        {
            JOptionPane.showMessageDialog(null,"Password Successfully Captured");
            this.registeredPassword = passW;
        }
        else
        {
           JOptionPane.showMessageDialog(null,"Password is not correctly formatted, please "
                    + "ensure that the password contains at least 8 characters, "
                    + "a capital letter, a number and a special character");
           
        }
          return (passW);
    }
    
    /*
        https://careerkarma.com/blog/java-this/        
        JAMES GALLAGHER
    
        Instance Varibles used to get the Users data inorder for them to login 
        and displays correct login message, whether the user is registered or not 
    */
    
    public boolean loginUser(String uName, String passW)
    {
       if ((uName.equals(this.registeredUsername)) && 
                (passW.equals(this.registeredPassword))) 
       {
           JOptionPane.showMessageDialog(null,"Login Successful!!! Welcome Back " + this.firstName + " " + this.lastName);
           return true;
       }
       else
       {
           JOptionPane.showMessageDialog(null,"Login Failed.Please enter a valid Username and Password");
           return false;
       }          
       
    } 
}