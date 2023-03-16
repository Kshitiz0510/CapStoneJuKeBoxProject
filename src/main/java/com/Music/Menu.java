package com.Music;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {

    public static void displayMenu() throws WrongChoiceException, ClassNotFoundException {
        System.out.println("************************************ Menu *************************");
        System.out.println("1- To display list of all Songs"+"\n"+"2- Search Song"+"\n"+"3- Create Playlist "+"\n"+"4- Play the Song"+"\n"+"9- End Jude Box");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        switch (choice) {
            case 1: {
//                String str="select songName,songID from music";
//                Statement st=DataBaseConnection.connection();
//                ResultSet rs=st.executeQuery(str);
//                while(rs.next())
//                {
//                    System.out.println(rs.getString(1)+" "+rs.getString(2));
//                }
                System.out.println("Here is the list of songs which are available in this JudeBox");
                System.out.println("1- Cheap Thrills" + "\n" + "2- We dont talk anymore" + "\n" + "3- Shape Of You" + "\n" + "4- Shayad");
                Menu.displayMenu();
                break;
            }
            case 2:
            {
                try{
                    UserChoiceSearchSong userChoiceSearchSong=new UserChoiceSearchSong();
                    userChoiceSearchSong.displaySongsBasedOnUser();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
                break;
            }
            case 3:
            {
                try{
                    UserChoiceCreatePlayList userChoiceCreatePlayList=new UserChoiceCreatePlayList();
                    userChoiceCreatePlayList.createPlayList();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
                break;
            }
            case 4:
            {
                try{
                    UserChoicePlayMusic userChoicePlayMusic=new UserChoicePlayMusic();
                    userChoicePlayMusic.playSong();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
                break;
            }
            case 9:
            {
                System.out.println("Jude Box Has Ended");
                break;
            }
            default:
            {
                throw new WrongChoiceException("Please choose from the given list only");
            }
        }
    }
}
