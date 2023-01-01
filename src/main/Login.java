package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.*;

public class Login {
	
	WebDriver driver;
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.marketalertum.com/Alerts/Login");
	}
		
	void goodLogin(){
		setup();
		driver.get("https://www.marketalertum.com/Alerts/Login");
		WebElement userId = driver.findElement(By.id("UserId"));
		userId.click();
		userId.sendKeys("b96e4c56-188e-4745-b07f-a480e1ae94b1");
		userId.submit();

		String loginTitle = driver.getCurrentUrl();
        Assert.assertEquals("https://www.marketalertum.com/Alerts/List", loginTitle);
		System.out.println("valid login successful");
	}
	
	void invalidLogin() {
		setup();
        driver.get("https://www.marketalertum.com/Alerts/Login");
        WebElement userId = driver.findElement(By.id("UserId"));
        userId.click();
        userId.sendKeys("this-is-an-invalid-user-id");
        userId.submit();

        String loginTitle = driver.getCurrentUrl();
        Assert.assertEquals("https://www.marketalertum.com/Alerts/Login", loginTitle);
	}
	
	void logout() {
        driver.get("https://www.marketalertum.com/Alerts/List");

       //in order to first log out, you need to log in
        goodLogin();
      //finding Logout button
        WebElement logOutButton = driver.findElement(By.xpath("/html/body/header/nav/div/div/ul/li[3]/a"));
        logOutButton.click();
        
        String loginTitle = driver.getCurrentUrl();
        Assert.assertEquals("https://www.marketalertum.com/", loginTitle);
	}
	
	public static int read()
	{
		try{
		return Integer.parseInt(br.readLine());
		}
		catch(Exception ex)
		{ex.printStackTrace();}
		return -1;
	}
	
	public void menu()
	{
		while (true)
		{
			System.out.println("****LOGIN MENU****");
			System.out.println("1. good login");
			System.out.println("2. bad login");
			System.out.println("3. logout");
			System.out.println("4. exit");
			switch(Login.read())
			{
			case 1:goodLogin();break;
			case 2:invalidLogin();break;
			case 3:logout();break;
			case 4:System.out.println("exiting program");return;
			default:
				System.out.println("please enter a valid integer");
			}
		}
	}
	
	public static void main(String[] args) {
		try{
			new Login().menu();
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
	}
}
