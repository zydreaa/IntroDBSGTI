package com.company.controllers;

import com.company.objects.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DbConnection.getConnection;

public class StudentController {


    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;


    //add student controller
    public static boolean addStudent() {
        //prompt the user for date
        System.out.println("Enter the name of the student: ");
        String name = scanner.next();

        System.out.println("Enter the age of the student: ");
        int age = scanner.nextInt();

        try{
            //INSERT INTO students(name, age) VALUES('name', age);
            ps = getConnection().prepareStatement("INSERT INTO students(name, age) VALUES('" + name + "', " + age + ") ");

            ps.execute(); //execute the sql command
            return true; //return true if successful

        }catch (SQLException e){
            System.out.println("Database Error");
            return false;
        }
    }
    //get student by ID
    public static Student getStudentById(){
        //prompt the user to enter the id of the student they want
        //to retrieve
        System.out.println("Enter the id of the student: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM students WHERE id=" + id);
            rs = ps.executeQuery();

            //define variables to temporarily hold
            //each field in the result set
            int studentId, age;
            String name;

            //initialise the student object to return at the end of the method execution
            Student student = new Student();

            //loop  through the result set and add the necessary values to the student object
            while (rs.next()){
                studentId = rs.getInt("id");
                name = rs.getString("name");
                age = rs.getInt("age");
                student.setName(name);
                student.setId(id);
                student.setAge(age);
            }
            return student;


        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        }

}
