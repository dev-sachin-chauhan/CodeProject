package com;

import junit.framework.TestCase;

/**
 * Created by Sachin_Chauhan on 4/19/2016.
 */
public class SolutionTest extends TestCase {

    public void test_Palindrome(){
        HelloWorld sol = new HelloWorld();
        assertTrue("Fail1",sol.palindromString("forgeeksskeeg").equals(new String("geeksskeeg")));
        assertTrue("Fail2",sol.palindromString("forgeekskeeg").equals("geekskeeg"));
        assertTrue("Fail4",sol.palindromString("forrofgeeksskeeg").equals("geeksskeeg"));
        assertTrue("Fail5",sol.palindromString("forrofgeekskeeg").equals("geekskeeg"));
        assertTrue("Fail6",sol.palindromString("gggg").equals("gggg"));
        assertTrue("Fail7",sol.palindromString("ggggg").equals("ggggg"));
        assertTrue("Fail3",sol.palindromString("a").equals("a"));
        assertTrue("Fail8",sol.palindromString("ac").equals("a"));
    }
}
