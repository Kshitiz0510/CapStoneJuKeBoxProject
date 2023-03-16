package com.userLogins;
import com.Music.Menu;
import com.Music.WrongChoiceException;

import static com.Music.DataBaseConnection.*;
import java.sql.*;


public class UserLogin implements UserDetails {

    public void NewUser(String name, String userName, String email, String password) {
        try
        {
            Statement st = connection();
            //Checking whether the provided email does not exisitng in the database
            String str = ("select email from logindetails where email='" + email + "'");
            ResultSet rs = st.executeQuery(str);
            if (rs.next()) {
                System.out.println("Email Already Exist");
            }else{
                st.executeUpdate("insert into logindetails value('" + name + "','" + userName + "','" + email + "','" + password + "')");
                System.out.println("Values has been successfully Updated over Database");
                Menu.displayMenu();
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(WrongChoiceException e)
        {
            e.printStackTrace();
        }
    }

    public boolean ExistingUser(String email, String password) {
        boolean flag=true;
        try
        {
            Statement st = connection();
            String SqlQueries = ("select * from logindetails where email='" + email + "' and password='" + password + "'");
            ResultSet rs = st.executeQuery(SqlQueries);
            if (rs.next()) {
                System.out.println("Yes you're a Existing User");
                flag=true;
                Menu.displayMenu();

            }
            else{
                System.out.println("Email or password does not match");
                flag=false;
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(WrongChoiceException e)
        {
            e.printStackTrace();
        }
        return flag;
    }
}