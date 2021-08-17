package com.dataBaseTesting;

import com.pageObjectLog.LoginBook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.*;

import static org.testng.Assert.assertEquals;

public class TC_Database {

    @Test
    void testingDatabase () throws SQLException, ClassNotFoundException {

        //Configuring database
        Class.forName("com.mysql.cj.jdbc.Driver");
        String DB_URL = "jdbc:mysql://localhost:3306/postapp?useTimezone=true&serverTimezone=UTC";
        Connection con = DriverManager.getConnection(DB_URL, "root", "think");
        Statement stmt = con.createStatement();

        //Configuring Driver
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
        LoginBook lb = new LoginBook(driver);

        /* (Manipulations that already executed)
            String s = "create table users(" +
                "nome varchar (11), idade int)" ;
            String query = "insert into users values ('carlin', 17, 'Admin3212#')";
             stmt.execute(query);
          */

        //Returning values from the database through the query
        String returnValues = "select * from users";

        ResultSet rs = stmt.executeQuery(returnValues);
        while (rs.next()) {
           String username =  rs.getString("nome");
           if (username.equals("carlin")){
                lb.writeUser(username);
                lb.writePass(rs.getString("senha"));
                lb.clickBtnLogin();
           }
        }

        //Setting a timeout for page loading
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.urlContains("/profile"));

        String urlSuccess = driver.getCurrentUrl();
        assertEquals("https://demoqa.com/profile", urlSuccess);

        //Closing the connection with the database and driver session;
        driver.quit();
        con.close();
        System.out.println("Program finish");
    }
}
