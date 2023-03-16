package com.userLogins;

import com.Music.WrongChoiceException;
import java.util.Scanner;
public class JudeBoxMain {
    public static void main(String[] args) throws WrongChoiceException {
            Scanner sc=new Scanner(System.in);
            System.out.println("***************************** Welcome To JudeBox *****************************");
            System.out.println("Press 1 for the New user and 2 for the Existing user");
            int choice=sc.nextInt();
    //Task1**********************************Checking if the User is a Existing User or New User********************
        switch(choice)
            {
                case 1:
                {
                    System.out.println("Enter your Name");
                    String name=sc.next();
                    System.out.println("Enter the userName");
                    String userName=sc.next();
                    System.out.println("Enter your Email");
                    String email=sc.next();
                    System.out.println("Create a Password");
                    String password=sc.next();
                    UserLogin userLogin=new UserLogin();
                    userLogin.NewUser(name,userName,email,password);
                    break;
                }
                case 2:
                {
                   System.out.println("Enter your email");
                    String email=sc.next();
                    System.out.println("Enter your Password");
                    String password=sc.next();
                    UserLogin userLogin=new UserLogin();
                    userLogin.ExistingUser(email,password);
                    break;
                }
                default:
                    throw new WrongChoiceException("Please choose from the given list only");
            }
    //******************************************************************************************************
    }
}
