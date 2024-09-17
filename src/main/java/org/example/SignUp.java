package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SignUp {
    public static void signup() throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter username ");
        String user=sc.next();
        System.out.println("enter password ");
        String pass=sc.next();
        System.out.println("enter your name");
        String name=sc.next();
        System.out.println("enter your mobile number");
        long mb=sc.nextLong();
        System.out.println("enter your date of birth in 'YYYY-MM-DD' format");
        String dob=sc.next();
        System.out.println("how much amount would you like to deposit in your account");
        int amount=sc.nextInt();
        System.out.println("set up 4-digit pin for your account ");
        int pin=sc.nextInt();

        ArrayList<Integer> un=new ArrayList<Integer>();
        DatabaseDetails dd=new DatabaseDetails();
        Connection connection= DriverManager.getConnection(dd.url,dd.username,dd.password);
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery("select accountNo from customer");
        while(rs.next()){
            un.add(rs.getInt(1));
        }
        int accountno=un.get(un.size()-1)+1;
        System.out.println("Your account number is "+accountno);
        st.execute("insert into customer Values("+"'"+accountno+"'" + "," +"'"+user+"'"+ "," +"'"+pass+"'"+","+ "'"+name+"'"+","+ "'"+mb+"'"+","+ "'"+dob+"'"+","+ "'"+pin+"'"+","+ "'"+amount+"'"+ ")");

        System.out.println("Thank you for making account in State Bank of India ");
    }

}
