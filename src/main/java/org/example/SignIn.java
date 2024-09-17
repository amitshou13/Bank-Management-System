package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SignIn extends connection{
    public static void signin() throws SQLException,ClassNotFoundException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Username");
        String username=sc.next();
        System.out.println("Enter Password");
        String password=sc.next();
        if(isValid(username,password)){
            System.out.println("Press 1 for account number");
            System.out.println("Press 2 for amount");
            System.out.println("Press 3 to change pin");
            System.out.println("Press 4 to change mobile number");
            System.out.println("Press any other key to log out");
            int num=sc.nextInt();
            SignInDetails sign=new SignInDetails();
            if(num==1){
                sign.accountNo(username);
            } else if(num==2){
                sign.amount(username);
            } else if(num==3){
                sign.pin(username);
            } else if(num==4){
                sign.mobile(username);
            } else{
                System.out.println(" ");
            }
        }
        else{
            System.out.println("incorrect username or password");
            signin();
        }
    }
    public static boolean isValid(String username,String password) throws SQLException,ClassNotFoundException {
        ArrayList<String> un=new ArrayList<String>();
        ArrayList<String> pass=new ArrayList<String>();

        DatabaseDetails dd=new DatabaseDetails();
        Connection connection=DriverManager.getConnection(dd.url,dd.username,dd.password);
        Statement st=connection.createStatement();

        ResultSet rs=st.executeQuery("select username,password from customer");

        while(rs.next()){
            un.add(rs.getString(1));
            pass.add(rs.getString(2));
        }
        if(un.contains(username) && pass.contains(password)){
            return true;
        }
        else{
            return false;
        }
    }
}
