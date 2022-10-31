package data;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Temp {

     @Test
     public void test001() {
         System.out.println("hello");
        List<String> al = new ArrayList<String>();
         al.add("D");
         al.add("A");
         al.add("B");
         al.add("E");
         al.add("C");
         al.add("F");

        /* Collections.sort method is sorting the
        elements of ArrayList in ascending order. */
         Collections.sort(al);

         // Let us print the sorted list
         System.out.println(al);
         Collections.sort(al,Collections.reverseOrder());
         System.out.println(al);

         System.out.println("al.indexOf(\"B\") => " + al.indexOf("B"));
         System.out.println("al.contains(\"B\") => " + al.contains("B"));

         System.out.println("-------------------------");
         List aList = new ArrayList();
         aList.add("Orange");
         aList.add("Apple");
         aList.add("Peach");
         aList.add("Guava");
         aList.add("Mango");
         System.out.println("The index of the element Apple in ArrayList is: " +  aList.indexOf("Apple"));


    }
}
