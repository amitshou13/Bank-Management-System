package org.example;
import java.sql.*;
import java.util.*;

public class SignInDetails {
    public static void accountNo(String username) throws SQLException {
        DatabaseDetails dd=new DatabaseDetails();
        Connection connection= DriverManager.getConnection(dd.url,dd.username,dd.password);
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery("select accountNo from customer where username="+"'"+username+"'");
        System.out.println("Account Number = ");
        while(rs.next()){
            System.out.println(rs.getString(1));
        }

    }

    public static void amount(String user) throws SQLException{
        DatabaseDetails dd=new DatabaseDetails();
        Connection connection=DriverManager.getConnection(dd.url,dd.username,dd.password);
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery("select amount from customer where username="+"'"+user+"'");
        System.out.println("Amount = ");
        while(rs.next()){
            System.out.print(rs.getInt(1));
        }
    }

    public static void pin(String user) throws SQLException{
        DatabaseDetails dd=new DatabaseDetails();
        Connection connection=DriverManager.getConnection(dd.url,dd.username,dd.password);
        Statement st=connection.createStatement();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter new pin");
        int p=sc.nextInt();
        st.execute("update customer set pin="+"'"+p+"'");
        System.out.println("Pin has been Updated");
    }

    public static void mobile(String user) throws SQLException{
        DatabaseDetails dd=new DatabaseDetails();
        Connection connection=DriverManager.getConnection(dd.url,dd.username,dd.password);
        Statement st=connection.createStatement();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter new mobile number");
        long p=sc.nextLong();
        st.execute("update customer set mobileNo="+"'"+p+"'");
        System.out.println("Mobile number has been Updated");
    }
}
