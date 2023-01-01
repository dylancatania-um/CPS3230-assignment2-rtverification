package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.ws.rs.WebApplicationException;

public class Alert {
		
	WebDriver driver;
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	//considering the test case this time are the alerts, 
	//first a login is required to be able to view the alerts
	void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.marketalertum.com/Alerts/Login");
	}
	
	void viewAlerts() {				   
			setup();
			WebElement userId = driver.findElement(By.id("UserId"));
			userId.click();
			userId.sendKeys("b96e4c56-188e-4745-b07f-a480e1ae94b1");
			userId.submit();

			String loginTitle = driver.getCurrentUrl();
	        Assert.assertEquals("https://www.marketalertum.com/Alerts/List", loginTitle);
			System.out.println("valid login successful");
	}
	
	void createAlert() throws IOException {		
		URL url = new URL ("https://api.marketalertum.com/Alert");

        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        JSONObject obj = new JSONObject();
        obj.put("alertType", 6);
        obj.put("heading", "Jumper Windows 11 Laptop");
        obj.put("description", "Jumper Windows 11 Laptop 1080P Display,12GB RAM 256GB SSD");
        obj.put("url", "https://www.amazon.co.uk/Windows-Display-Ultrabook-Processor-Bluetooth");
        obj.put("imageUrl", "https://m.media-amazon.com/images/I/712Xf2LtbJL._AC_SX679_.jpg");
        obj.put("postedBy", "b96e4c56-188e-4745-b07f-a480e1ae94b1");
        obj.put("priceInCents", 24999);

        //json string
        final String payload = obj.toString();

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = payload.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println("alert created with details:" +response.toString());
        }
	}
	
	void createAlertInvalid() throws IOException {
			URL url = new URL ("https://api.marketalertum.com/Alert");
	
	        HttpURLConnection con = (HttpURLConnection)url.openConnection();
	        con.setRequestMethod("POST");
	        con.setRequestProperty("Content-Type", "application/json");
	        con.setRequestProperty("Accept", "application/json");
	        con.setDoOutput(true);
	
	        JSONObject obj = new JSONObject();
	        obj.put("alertType", 6);
	        obj.put("heading", "Jumper Windows 11 Laptop");
	        obj.put("description", "Jumper Windows 11 Laptop 1080P Display,12GB RAM 256GB SSD");
	        obj.put("url", "https://www.amazon.co.uk/Windows-Display-Ultrabook-Processor-Bluetooth");
	        obj.put("imageUrl", "https://m.media-amazon.com/images/I/712Xf2LtbJL._AC_SX679_.jpg");
	        obj.put("postedBy", "this-is-an-invalid-attribute");
	        
	        //passing string instead of integer
	        obj.put("priceInCents", "this-is-an-invalid-attribute");
	
	        //json string
	        final String payload = obj.toString();
	
	        try(OutputStream os = con.getOutputStream()) {
	            byte[] input = payload.getBytes("utf-8");
	            os.write(input, 0, input.length);
	        }
	
            int status = con.getResponseCode();
            System.out.println("Creating alert failed: response code: " +status);
	}
	
	 void deleteAlerts() throws IOException {
	       URL url;
			try {
				url = new URL("https://api.marketalertum.com/Alert?userId=b96e4c56-188e-4745-b07f-a480e1ae94b1");

	            HttpURLConnection con = (HttpURLConnection) url.openConnection();

	            con.setRequestMethod("DELETE");
	            con.setRequestProperty("Content-Type", "application/json");

	            int status = con.getResponseCode();

	            BufferedReader in = new BufferedReader(
	                    new InputStreamReader(con.getInputStream()));
	            String inputLine;
	            StringBuffer content = new StringBuffer();
	            while ((inputLine = in.readLine()) != null) {
	                content.append(inputLine);
	            }
	            in.close();

	            con.disconnect();
	            System.out.println("Successfully deleted all alerts");
			}
	        catch (IOException e) {
				e.printStackTrace();
			}
 	}
	 
	 void deleteAlertsInvalid() throws IOException {
	       URL url;
			try {
				url = new URL("https://api.marketalertum.com/Alert?userId=this-is-an-invalid-user-id");

	            HttpURLConnection con = (HttpURLConnection) url.openConnection();

	            con.setRequestMethod("DELETE");
	            con.setRequestProperty("Content-Type", "application/json");

	            int status = con.getResponseCode();

	            con.disconnect();
	            System.out.println("Deleting all alerts failed: response code: " +status);
			}
	        catch (IOException e) {
				e.printStackTrace();
			}
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
		
		public void menu() throws IOException
		{
			while (true)
			{
				System.out.println("****Alert MENU****");
				System.out.println("1. view alerts");
				System.out.println("2. create an alert");
				System.out.println("3. delete all alerts");
				System.out.println("4. try to create an invalid alert");
				System.out.println("5. delete all alerts (invalid)");
				System.out.println("6. exit");
				switch(Alert.read())
				{
				case 1:viewAlerts();break;
				case 2:createAlert();break;
				case 3:deleteAlerts();break;
				case 4:createAlertInvalid();break;
				case 5:deleteAlertsInvalid();break;
				case 6:return;
				default:
					System.out.println("please enter a valid integer");
				}
			}
		}
		
		public static void main(String[] args) throws IOException {
			try{
			new Alert().menu();
			}catch(WebApplicationException ex)
			{
				ex.printStackTrace();
			}
		}
}

	



