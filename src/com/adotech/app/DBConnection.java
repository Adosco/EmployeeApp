package com.adotech.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection con;
    public static Connection createDBConnection(){
        try {
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //get connection
            String url ="jdbc:mysql://localhost:3306/employeeDB";
            String username = "root";
            String password = "[/Ados*$2";

            con =DriverManager.getConnection(url,username,password);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return con;

    }
}
