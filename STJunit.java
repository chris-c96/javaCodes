/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chris Cullen
 */
public class STJunit {
    
   WebDriver driver;
    @BeforeClass
    public static void setUpClass() throws Exception {
        String exePath = "C:\\Users\\Chris Cullen\\Documents\\NetBeansProjects\\Software Analysis and Testing\\Chrome\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", exePath);

	// Create a new instance of the Chrome driver
	
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception{
        
    }
    
    @Before
    public  void setUp(){
        driver = new ChromeDriver();
    }
    
    @After
    public  void tearDown()  {
         driver.quit();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void test() {
     //Launch the leeds website through the Chrome browser
     driver.get("https://www.leeds.ac.uk");
     driver.manage().window().fullscreen();
     
	// Print a Log message to the screen
        Assert.assertEquals("the current page is the leeds home page", "https://www.leeds.ac.uk/", driver.getCurrentUrl());
	System.out.println("Successfully opened the Leeds website");

	//Wait for 1 Sec for demonstration purpose only
	try {
            Thread.sleep(1000);
            } catch (InterruptedException e) {
		e.printStackTrace();
	}
        
	//find and click the right arrow button to change image
        WebElement rightArrow = driver.findElement(By.className("arrow-right"));

        rightArrow.click();
        //wait 1s to allow elements to load
        try {
            Thread.sleep(1000);
            } catch (InterruptedException e) {
		e.printStackTrace();
	}
        //find and select the course search button
        WebElement CourseSearchbtn = driver.findElement(By.xpath("//*[@id=\"slide2\"]/div/p/a"));
        try {
            Thread.sleep(1000);
            } catch (InterruptedException e) {
		e.printStackTrace();
	}
        CourseSearchbtn.click();
        //Check that the website is currently on the course search page
        Assert.assertEquals("The current page is the leeds course search page", "https://courses.leeds.ac.uk/", driver.getCurrentUrl());
        System.out.println("Successfully opened the Course Search page");
	//Wait for 1 Sec for demonstration purpose only, 
	//let everything on the new page load
	try {
            Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
	}
        
        //Store 4 key words to be inputted in to the search bar of the 
        //course search page
        String[] keyWord = new String[4];
        keyWord[0]="Computing";
        keyWord[1]="Computer Science";
        keyWord[2]="Comp science";
        keyWord[3]="Computer";
        
        for(int i=0;i<4;i++){
            try {
            Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
        WebElement searchBox= driver.findElement(By.id("searchCourse"));
        searchBox.sendKeys(keyWord[i]);
        
        
        
	//Wait for 1 Sec for demonstration purpose only
	// You should be able the keyword in the search bar
	try {
            Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
	}
        searchBox.submit();
        //wait 1 second the results of the search should appear
        try {
            Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
        //Find and click the computer science link from the search results
        WebElement compSciLink = driver.findElement(By.linkText("Computer Science"));
        compSciLink.click();
        //Asserts to make sure the code is on the correct website but testing the URL  
        //and an image on the computer science page
        Assert.assertEquals("The current page is the leeds computer science page", "https://courses.leeds.ac.uk/f919/computer-science-meng-bsc", driver.getCurrentUrl());
        WebElement compScipicture = driver.findElement(By.xpath("//*[@id=\"course-header\"]/div/img"));
        Assert.assertTrue(compScipicture.isDisplayed());
        try {
            Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
        //Find and select the button that goes back to the course search page.
        WebElement backToSearch = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div[2]/ul/li[1]/a"));
        backToSearch.click();
        //Test that the URL is now back to the course search page
        Assert.assertEquals("the current page is the leeds course search page", "https://courses.leeds.ac.uk/?type=UG", driver.getCurrentUrl());
        System.out.println("Successfully went back to the Course Search page.");
        }
        try {
            Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
        //once all the key words have been tested return back to the leeds 
        //university homepage
        driver.get("https:\\www.leeds.ac.uk");
        
        //once on the homepage find and click the accept cookie hyper link 
        //and click the undergraduate hyperlink
        WebElement undergradLink = driver.findElement(By.linkText("Undergraduate"));
        WebElement cookieAccept = driver.findElement(By.linkText("Accept"));
        cookieAccept.click();
        try {
            Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
        
        undergradLink.click();
        try {
            Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
        //Once clicked test to see that the code is on the undergraduate page
        //by finding the undergrad picture on the website
        WebElement undergradPic = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div"));
        Assert.assertTrue(undergradPic.isDisplayed());
        System.out.println("On the undergraduate main page");
        
        //Find and click the course search button on the undergraduate main page
        //also test to make sure that the course search page is the current page being shown
        WebElement uCoursesearch = driver.findElement(By.cssSelector(".btn--hollow"));
        
        try {
            Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
        uCoursesearch.click();
        Assert.assertEquals("the current page is the leeds course search page", "https://courses.leeds.ac.uk/?type=UG", driver.getCurrentUrl());
        System.out.println("Successfully went to the Course Search page.");
        try {
            Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
       driver.get("https:\\www.leeds.ac.uk");
        WebElement coursesearchLink = driver.findElement(By.linkText("Course search"));
        try {
            Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
        coursesearchLink.click(); 
        Assert.assertEquals("the current page is the leeds course search page", "https://courses.leeds.ac.uk/", driver.getCurrentUrl());
        System.out.println("Successfully went to the Course Search page.");
        try {
            Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
        driver.get("https:\\www.leeds.ac.uk");
        
         try {
            Thread.sleep(600);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
         //find and click the drop down link labelled "study"
        WebElement studyDrop = driver.findElement(By.id("navItem1000"));
        
        studyDrop.click();
        
        //wait to let ribbon  appear and for the elements on the ribbon to load
        try {
            Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
        //find and click the "undergraduate" link on the ribbon
        WebElement underDropLink = driver.findElement(By.id("navItem116000"));
        underDropLink.click();
        try {
            Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
        //assert that the picture on the undergraduate page is being shown
        
        WebElement undergradPic1 = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div"));
        Assert.assertTrue(undergradPic1.isDisplayed());
        System.out.println("On the undergraduate main page");
        //also find and click the course search link on the left of the page
        WebElement csLink = driver.findElement(By.linkText("Course search"));
        csLink.click();
        System.out.println("Successfully opened the Course Search page");
        try {
            Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
         driver.get("https:\\www.leeds.ac.uk");
        
         try {
            Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
         //find and click the drop down link labelled "study"
        WebElement studyDrop2 = driver.findElement(By.id("navItem1000"));
        
        studyDrop2.click();
        
        //wait to let ribbon  appear and for the elements on the ribbon to load
        try {
            Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
        //find and click the "search for a course" picture/button
        WebElement courseSearchPic = driver.findElement(By.xpath("//*[@id=\"flyout1000\"]/div/figure[1]/a"));
        courseSearchPic.click();
         Assert.assertEquals("the current page is the leeds course search page", "https://courses.leeds.ac.uk/", driver.getCurrentUrl());
         try {
            Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
            }
     }
}
