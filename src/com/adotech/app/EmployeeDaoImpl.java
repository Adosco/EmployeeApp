package com.adotech.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.Scanner;

public class EmployeeDaoImpl implements EmployeeDaoIntrf{

    Connection con;
    @Override
    public void createEmployee(Employee emp) {
        con= DBConnection.createDBConnection();
        String query = "INSERT INTO employee VALUES(?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,emp.getId());
            pstm.setString(2,emp.getName());
            pstm.setDouble(3,emp.getSalary());
            pstm.setInt(4,emp.getAge());
            int cnt = pstm.executeUpdate();

            if (cnt != 0){
                System.out.println("Employee Inserted Successfully");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }



    }

    @Override
    public void showAllEmployee() {
        con = DBConnection.createDBConnection();
        String query = "SELECT * FROM employee";
        System.out.println("Employee Details:");
        System.out.println("------------------------------");
        System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Salary","Age");
        System.out.println("------------------------------");

        try {
            Statement stm = con.createStatement();
            ResultSet rst = stm.executeQuery(query);

            while (rst.next()){
                System.out.format("%d\t%s\t%.2f\t%d\n",
                        rst.getInt(1),
                        rst.getString(2),
                        rst.getDouble(3),
                        rst.getInt(4) );
                System.out.println("------------------------------");


            }
        }catch (Exception ex){
            ex.printStackTrace();

        }

    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        con = DBConnection.createDBConnection();
        String query = "SELECT * FROM employee WHERE id=" + id;

        try {
            Statement stm = con.createStatement();
            ResultSet rst = stm.executeQuery(query);

            while (rst.next()){
                System.out.format("%d\t%s\t%.2f\t%d\n",
                        rst.getInt(1),
                        rst.getString(2),
                        rst.getDouble(3),
                        rst.getInt(4) );



            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void updateEmployee(int id, String name) {
        con = DBConnection.createDBConnection();
        String query = "UPDATE employee SET name=? WHERE id=?";

        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int cnt = pstm.executeUpdate();

            if (cnt != 0){
                System.out.println("Employee Details updated successfully!!");
            }


        }catch (Exception ex){
            ex.printStackTrace();

        }

    }

    @Override
    public void deleteEmployee(int id) {
        con = DBConnection.createDBConnection();
        String query = "DELETE FROM employee WHERE id = ?";

        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,id);
            int cnt = pstm.executeUpdate();

            if (cnt !=0){
                System.out.println("Employee deleted successfully!!!" + id);
            }
        }catch (Exception ex){
            ex.printStackTrace();

        }


    }
}
