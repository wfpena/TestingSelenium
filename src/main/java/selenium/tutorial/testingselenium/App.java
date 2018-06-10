package selenium.tutorial.testingselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Testing Selenium WebDriver by automating
 * a game of fast-click in the browser
 * 
 * @author Wilson Pena
 */
public class App 
{
    public static void main( String[] args )
    {    		
		String exePath = "\\Users\\User\\Desktop\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;

		driver.get("https://www.humanbenchmark.com/tests/reactiontime/");
		String currentState = (String)js.executeScript("function getElementByXpath(path) {" +
			  "return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
			"}; var a = angular.element(getElementByXpath(\"/html/body/div[4]/div/div[1]/div/div\")).scope(); return a.test.getView();");
		
		System.out.println(currentState);
		
		WebElement scr = driver.findElement(By.xpath("/html/body/div[4]/div/div[1]"));

		while(true){
			currentState = (String)js.executeScript("function getElementByXpath(path) {" +
					  "return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
					"}; var a = angular.element(getElementByXpath(\"/html/body/div[4]/div/div[1]/div/div\")).scope(); return a.test.getView();");

			if(!currentState.equals("waiting")) {
				scr.click();
			}
			System.out.println(currentState);
		}
		
//		driver.close();
//		System.exit(0);
    }
}