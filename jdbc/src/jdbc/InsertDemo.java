package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertDemo {
    public static void main(String[] args) {


        try {
            // Load Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to Oracle
            String url = "jdbc:oracle:thin:@localhost:1521:orcl2";
            Connection con = DriverManager.getConnection(url, "c##shashank", "shashank");

            // Prepare SQL statement
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO student10 VALUES (?, ?, ?)");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter roll number: ");
            int roll = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks: ");
            int marks = sc.nextInt();

            // Set values
            pstmt.setInt(1, roll);
            pstmt.setString(2, name);
            pstmt.setInt(3, marks);

            // Execute the query
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Record inserted successfully!");
            } else {
                System.out.println("Insert failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
