package com.loglearn.baseClass;

import org.apache.log4j.xml.DOMConfigurator;
import com.loglearn.utility.Log;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    @BeforeClass
    public void initConfiguring () {
        DOMConfigurator.configure("log4j.xml");
        Log.info("Configuring the file log4j.xml");
    }

    @AfterClass
    public void finishExecution () {
        Log.info("Finishing..");
    }
}
