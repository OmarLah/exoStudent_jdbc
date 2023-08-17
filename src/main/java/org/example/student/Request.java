package org.example.student;

import java.sql.*;

public class Request {


    public void AddStudent(String firstname, String lastname, int numberClass, Date date) throws SQLException {

        Connection connection = DatabaseManager.getPostgreSQLConnection();
        String request = "INSERT INTO student (firstname, lastname, numberClass, diplomeDate) VALUES ('"+ firstname +"', '"+lastname+"', '"+numberClass+"', '"+date+"')";
        Statement statement = connection.createStatement();
        statement.execute(request, Statement.RETURN_GENERATED_KEYS);
        ResultSet resultSet = statement.getGeneratedKeys();
        System.out.println();
        if(resultSet.next()){
            System.out.println(resultSet.getInt(1));
        }
        Student student = new Student(firstname, lastname, numberClass, date);
    }

    public String selectAllStudent() throws SQLException{
        Connection connection = DatabaseManager.getPostgreSQLConnection();

        String request = "SELECT * FROM student";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(request);
        String str = "";
        while(resultSet.next()){
            str += resultSet.getInt("id")+ " , "+ resultSet.getString("firstname")+ " , "+ resultSet.getString("lastname")+ " , dans la classe n°"+ resultSet.getInt("numberClass")+" , diplôme obtenu le : " + resultSet.getString(5 )+ "\n";
        }

        return str;
    }

    public String SelectStudentByClass(int num) throws SQLException{
        Connection connection = DatabaseManager.getPostgreSQLConnection();
        String request = "SELECT * FROM student where numberClass = " + num ;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(request);String str = "";
        while(resultSet.next()){
            str += resultSet.getInt("id")+ " , "+ resultSet.getString("firstname")+ " , "+ resultSet.getString("lastname")+ " , dans la classe n°"+ resultSet.getInt("numberClass")+" , diplôme obtenu le : " + resultSet.getString(5 )+ "\n";
        }

        return str;
    }

    public void deleteStudent(int num) throws SQLException{
        Connection connection = DatabaseManager.getPostgreSQLConnection();
        String request = "DELETE FROM student where id = " + num ;
        Statement statement = connection.createStatement();
        statement.execute(request);

    }
}
