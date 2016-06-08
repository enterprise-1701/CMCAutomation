package automationFramework.Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Robots {

	public static void iRobotMixxenTestFF() throws AWTException {

		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_A);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_A);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.delay(1000);
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_I);
		rb.delay(1000);

	}

	public static void iRobotMixxenTest() throws AWTException {

		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_LEFT);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.delay(8000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.delay(1000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.delay(1000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.delay(1000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.delay(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.delay(5000);

	}

	public static void iRobotDeepBluTest() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_LEFT);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.delay(8000);
	}

	public static void iCloseTab() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_W);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_W);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.delay(5000);

	}

	public static void iOpenWindow() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_N);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.delay(5000);

	}

	public static void iCancel() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_LEFT);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.delay(3000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.delay(1000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.delay(1000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.delay(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.delay(5000);
	}
}
