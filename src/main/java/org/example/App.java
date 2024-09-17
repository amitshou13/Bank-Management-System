package org.example;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {
        Entery e=new Entery();
        e.enter();

        SignIn si=new SignIn();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==1){
            si.signin();
        }

        SignUp su=new SignUp();
        if(n==2){
            su.signup();
        }
    }
}
