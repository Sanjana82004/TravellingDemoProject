package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class myclassTest {
   public static void main(String[] args) {
	   WebDriver d=new ChromeDriver();
	   d.get("https://mern-travel-tourism-app.onrender.com/login");
	   
	   d.findElement(By.id("email")).sendKeys("annu12@gmail.com");
	   d.findElement(By.id("password")).sendKeys("annu@12");
	   d.findElement(By.className("p-3")).click();
   }
}
