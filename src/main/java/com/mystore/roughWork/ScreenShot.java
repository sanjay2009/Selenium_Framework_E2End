package com.mystore.roughWork;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShot {
	WebDriver driver;
	public void fullPageScreenShot()
	{
			
	//Create object of Ashot() class and set image strategy by shootings 
	//viewportpasting method and take screen shot using takeScreenShot() method
	
	AShot ashot = new AShot();
	Screenshot screenshot = ashot.shootingStrategy(ShootingStrategies.viewportPasting(500))
			.takeScreenshot(driver);
	
	//copy screen shot to desired location
	try {
		ImageIO.write(screenshot.getImage(),"png", new File("F:\\Selenium_projects\\9Aug2020\\MyStore\\MyStoreProject\\ScreenShot\\fullScreenShot.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	public void elementScreenShot(WebElement element)
	{
		AShot ashot = new AShot();
		Screenshot screenshot = ashot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, element);
		
		//copy screen shot to desired location
		try {
			ImageIO.write(screenshot.getImage(),"png", new File("F:\\Selenium_projects\\9Aug2020\\MyStore\\MyStoreProject\\ScreenShot\\ElementScreenShot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void cropImages(WebElement element) throws IOException
	{
		
		//take full page screenshot
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		BufferedImage fullImage = ImageIO.read(screenshot);
		
		
		//get location, height, width of element
		Point point = element.getLocation();
		int elementHt = element.getSize().getHeight();
		int elementwdth = element.getSize().getWidth();
		
		//crop entire page image to get only element screenshot
		
		BufferedImage eleScreenshot = fullImage.getSubimage(point.getX(), point.getY(),elementHt,elementwdth);
		
		try {
			ImageIO.write(eleScreenshot,"png",screenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//copy element screenshot to desired location
		
		File screenshotLocation = new File("F:\\Selenium_projects\\9Aug2020\\MyStore\\MyStoreProject\\ScreenShot\\croppedImage.png");
		org.apache.commons.io.FileUtils.copyFile(screenshot, screenshotLocation);
	}
	
	
}
