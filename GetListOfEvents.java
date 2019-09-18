package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetListOfEvents {

public static void main(String[] args) {
 // TODO Auto-generated method stub

 //Set Property for chromedriver and launch the URL
 
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
 ChromeDriver driver=new ChromeDriver();
 driver.manage().window().maximize();
  driver.get("URL");
 
	//Create an Arraylist
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	        ArrayList<Map<String, List<String> >> myList = new ArrayList<>();

	        //Execute GTM script to fetch values       
	        myList =  (ArrayList<Map<String, List<String>>>) js.executeScript("return window.dataLayer");
	        System.out.println(myList);
	        
	        
	        HashSet<String> set=new HashSet();   
	        
	        //Parse through the values in each of the element and validate against the default value
	        // Parse through GTM arrayList  
	        for(int a=0; a <myList.size(); a++) {
	        	
	        	if(myList.contains("config")) {
	        		
	        	}
	        	else
	            for (String key : myList.get(a).keySet()) {
	           //  System.out.println(key + "      " + myList.get(a).get(key));
	           //   System.out.println("Key Value is "+key);
	              
	             
	             //Check against each of the tracking
	               if(myList.get(a).containsValue("gtm.load")) {
	                if(set.contains(String.valueOf(myList.get(a).get("gtm.uniqueEventId")))) {
	                 
	                }
	                else {
	                System.out.println("Value for Load is "+String.valueOf(myList.get(a).get("gtm.uniqueEventId")));
	                set.add(String.valueOf(myList.get(a).get("gtm.uniqueEventId")));
	                }
	              }
	               
	               if(myList.get(a).containsValue("doneGA")) {
	                if(set.contains(String.valueOf(myList.get(a).get("gtm.uniqueEventId")))) {
	                 
	                }
	                else {
	                System.out.println("Value for doneGA is "+String.valueOf(myList.get(a).get("gtm.uniqueEventId")));
	                set.add(String.valueOf(myList.get(a).get("gtm.uniqueEventId")));
	                }
	              }
	               
	               if(myList.get(a).containsValue("gtm.js")) {
	                if(set.contains(String.valueOf(myList.get(a).get("gtm.start")))) {
	                 
	                }
	                else {
	                System.out.println("Value for JS is "+myList.get(a).get("gtm.uniqueEventId")+" and start value is "+myList.get(a).get("gtm.start"));
	                set.add(String.valueOf(myList.get(a).get("gtm.start")));
	                }
	              }
	               
	               if(myList.get(a).containsValue("gtm.dom")) {
	                if(set.contains(String.valueOf(myList.get(a).get("gtm.uniqueEventId")))) {
	                 
	                }
	                else 
	                {
	                 System.out.println("Value for DOM is "+myList.get(a).get("gtm.uniqueEventId"));
	                 set.add(String.valueOf(myList.get(a).get("gtm.uniqueEventId")));
	                }
	                  
	                
	              }
	               
	               if(key.equals("gtm.start")) {
	                if(set.contains("gtm.start")) {
	                 
	                }
	                else {
	                 System.out.println("Value for start is "+myList.get(a).get("gtm.uniqueEventId") +" and start value is "+myList.get(a).get("gtm.start"));
	                 set.add("gtm.start");
	                }
	                  
	                
	              }
	               
	                             
	        }
	 
	}
	        
	        
	        System.out.println("Set values are "+set);
	        driver.quit();

}
}
