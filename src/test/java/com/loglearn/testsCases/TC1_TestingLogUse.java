package com.loglearn.testsCases;

import com.loglearn.baseClass.BaseClass;
import com.loglearn.utility.Log;
import org.testng.annotations.Test;

public class TC1_TestingLogUse extends BaseClass {

    @Test
    void testCase () {
        Log.initTestCase("testCase");
        Log.info("Executing test Case");
        Log.info("Finish testCase");
    }

    @Test
    void testCase2 () {
        Log.initTestCase("testCase2");
        Log.info("Executing test Case2");
        Log.info("Finish testCase2");
    }

    @Test
    void testCase3 () {
        Log.initTestCase("testCase3");
        Log.info("Executing test Case3");
        Log.info("Finish testCase3");
    }
}
