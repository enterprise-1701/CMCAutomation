package automationFramework.Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import com.beust.jcommander.Strings;

public class Robots {
	
	public static void main(String[] args) throws AWTException, IOException{
		
		iRobotTest();	
	}
	
	public static void iRobotTest() throws AWTException, IOException {

		 try {
             
	            Robot robot = new Robot();
	               
	            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"c: && cd c:/Program Files/CTS/ABP Test Client (03.01.0100) && AbpTestClient.exe \"");
	            robot.delay(3000);
	            robot.keyPress(KeyEvent.VK_ALT);
	            robot.keyPress(KeyEvent.VK_T);
	            robot.keyRelease(KeyEvent.VK_ALT);
	            robot.keyPress(KeyEvent.VK_DOWN);
	        	robot.keyPress(KeyEvent.VK_ENTER);
	        	robot.delay(3000);
	        	
	        	robot.keyPress(KeyEvent.VK_TAB);
	        	robot.delay(1000);
	        	robot.keyPress(KeyEvent.VK_TAB);
	        	robot.delay(1000);
	        	robot.keyPress(KeyEvent.VK_TAB);
	        	robot.delay(1000);
	        	robot.keyPress(KeyEvent.VK_TAB);
	        	robot.delay(1000);
	        	robot.keyPress(KeyEvent.VK_TAB);
	        	robot.delay(1000);
	        	robot.keyPress(KeyEvent.VK_TAB);
	        	robot.delay(1000);
	        	robot.keyPress(KeyEvent.VK_ENTER);
	        	robot.delay(1000);
	        	robot.keyPress(KeyEvent.VK_CONTROL);
	        	robot.keyPress(KeyEvent.VK_A);
	        	robot.keyPress(KeyEvent.VK_DELETE);
	        	robot.keyRelease(KeyEvent.VK_CONTROL);
	        	robot.delay(3000);
	        	
	        	//Exit out 
	        	robot.keyPress(KeyEvent.VK_ALT);
	        	robot.keyPress(KeyEvent.VK_F4);
	        	robot.keyPress(KeyEvent.VK_ALT);
	        	robot.keyPress(KeyEvent.VK_F4);
	        	robot.keyPress(KeyEvent.VK_ALT);
	        	robot.keyPress(KeyEvent.VK_F4);
	        	robot.keyRelease(KeyEvent.VK_ALT);
	        	robot.delay(1000);
	        	robot.keyPress(KeyEvent.VK_E);
	        	robot.keyRelease(KeyEvent.VK_E); 
	        	robot.keyPress(KeyEvent.VK_X);
	        	robot.keyRelease(KeyEvent.VK_X); 
	        	robot.keyPress(KeyEvent.VK_I);
	        	robot.keyRelease(KeyEvent.VK_I); 
	        	robot.keyPress(KeyEvent.VK_T);
	        	robot.keyRelease(KeyEvent.VK_T); 
	        	robot.keyPress(KeyEvent.VK_ENTER);
	        	
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	    }
		

	
}
