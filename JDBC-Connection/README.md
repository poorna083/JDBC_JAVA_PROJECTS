# JDBC_Connection

Create a folder called lib and place the mysql connector jar file in that folder

Note : change the Mysql password in DriverManager.getconnection()
       create a database called jdbc in Mysql WorkBench

import all the statements which are required for a JDBC connection

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbcconnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        There is class called Class in java
        in that we have a method called forName()
        pass the driver as a parameter to forName() method

        There are 3 steps to establish a JDBC connection

        step-1: Load the Driver
        step-2: Establish connection using DriverManager
        step-3: Check weather the connection is sucessfully established or not

        step-1: Load the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        A Java static method used to load and register a class by name.
        When the specified class is loaded, its static blocks are executed automatically.
        If the driver class is not found, it will throw and print a ClassNotFoundException.

        "com.mysql.cj.jdbc.Driver" This is the fully qualified class name of the MySQL JDBC driver.

        step-2: Establish connection using DriverManager
        Connection is an interface from the java.sql package.
        It represents a connection to a specific database.

        getConnection is a static method it takes 3 parameters as input
        1->database URL
        2->database username
        3->database password
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC", "root", "Your mysql password");
        It returns a Connection object if successful.

        step-3: Check weather the connection is sucessfully established or not

        if the getConnection() doesn't return a successful object then
        the Connection variable conn will return null

        if conn!=null the connection will be established
        if (con != null) {
            System.out.println("Connection Established");
        } else {
            System.out.println("Connection not Established");
            return;
        }
    }
}

Wrapping your code block in a try-except block helps handle connection errors gracefully 
rather than letting the program crash when something goes wrong 
 (like wrong credentials or server not running).

The following code will be Wrapped in a try-except block

import java.sql.*;
import java.util.Scanner;
public class Jdbccrud {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC", "root", "Your Mysql password");
        if (con != null) {
            System.out.println("Connection Established");
        } else {
            System.out.println("Connection not Established");
            return;
        }
    }
}