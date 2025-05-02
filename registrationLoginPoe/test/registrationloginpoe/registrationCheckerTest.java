/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package registrationloginpoe;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jasha
 */
public class registrationCheckerTest {
    
    public registrationCheckerTest() {
    }

    /**
     * Test of switchClass method, of class registrationChecker.
     */
    @Test
    public void testSwitchClass() {
        System.out.println("switchClass");
        registrationChecker instance = new registrationChecker();
        instance.switchClass();
      
    }

    /**
     * Test of checkUsername method, of class registrationChecker.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String uName = "kyl_1";
        registrationChecker instance = new registrationChecker();
        boolean expResult = true;
        boolean result = instance.checkUsername(uName);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of checkPasswordComplexity method, of class registrationChecker.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String passW = "Ch&&sec@ke99!";
        registrationChecker instance = new registrationChecker();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(passW);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of registerUser method, of class registrationChecker.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String uName = "";
        String firstName = "";
        String lastName = "";
        registrationChecker instance = new registrationChecker();
        String expResult = "";
        String result = instance.registerUser(uName, firstName, lastName);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of registerUserPassword method, of class registrationChecker.
     */
    @Test
    public void testRegisterUserPassword() {
        System.out.println("registerUserPassword");
        String passW = "";
        registrationChecker instance = new registrationChecker();
        String expResult = "";
        String result = instance.registerUserPassword(passW);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of loginUser method, of class registrationChecker.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String uName = "";
        String passW = "";
        registrationChecker instance = new registrationChecker();
        boolean expResult = false;
        boolean result = instance.loginUser(uName, passW);
        assertEquals(expResult, result);
       
    }
    
}
