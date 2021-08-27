package com.hybernateorm.example1;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {
    public static void main(String[] args) {
        String jdbcUrl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String userName="hbstudent";
        String passWord="HBStudent@123";
        try{
            Connection connection= DriverManager.getConnection(jdbcUrl,userName,passWord);
            System.out.println("Connection Successful!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
