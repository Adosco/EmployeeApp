package com.adotech.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        int id;

        System.out.println("Welcome to Employee management Application");
        EmployeeDaoIntrf dao = new EmployeeDaoImpl();

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("1. Add Employee\n" +
                    "2. Show all Employee\n" +
                    "3. Show Employee based on id\n" +
                    "4. Update the employee\n" +
                    "5. Delete the employee\n");

            System.out.println("Enter Choice: ");
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    Employee emp = new Employee();
                    System.out.println("Enter ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name ");
                    name = sc.nextLine();
                    System.out.println("Enter Salary: ");
                    double salary = sc.nextDouble();
                    System.out.println("Enter Age: ");
                    int age = sc.nextInt();

                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);

                    dao.createEmployee(emp);
                    break;
                case 2:
                    dao.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter ID to show the details: ");
                    int empid = sc.nextInt();
                    dao.showEmployeeBasedOnID(empid);
                    break;
                case 4:
                    System.out.println("Enter ID to Update the details");
                    int empid1 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the new name:");
                    name = sc.nextLine();
                    dao.updateEmployee(empid1,name);
                    break;
                case 5:
                    System.out.println("Enter the ID to delete: ");
                    id = sc.nextInt();
                    dao.deleteEmployee(id);
                    break;

                case 6:
                    System.out.println("Thank you for using our application!!!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice! ");
                    break;

            }

        }while (true);
    }
}
