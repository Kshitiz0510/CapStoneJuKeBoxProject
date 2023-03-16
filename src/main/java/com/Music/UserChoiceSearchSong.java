package com.Music;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class UserChoiceSearchSong   {

    public static void displaySongsBasedOnUser() throws SQLException, ClassNotFoundException, IOException {
        Scanner sc=new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Press 1 to Search the Song on the based of Genere"+"\n"+"Press 2 to Search the Song on the based of Artist"+"\n"+"Press 3 to Search any specific song");
        int search=sc.nextInt();
        String SqlQueries="";
            switch(search) {
                case 1: {
                    System.out.println("select any one genre from below" + "\n" + "Jass" + "\n" + "Rock" + "\n" + "Indie");
                    String userGenereChioce = sc.next();
                    Statement st = DataBaseConnection.connection();
                    System.out.println("Genre " + "\t" + "Artist " + "\t" + "SongName");
                    SqlQueries = ("SELECT * from music where genre='" + userGenereChioce + "'");
                    ResultSet rs = st.executeQuery(SqlQueries);
                    while (rs.next()) {

                        System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
                    }
                    break;
                }
                case 2: {
                    System.out.println("select any one Artist from below" + "\n" + "Sean Paul" + "\n" + "Charlie Puth" + "\n" + "Ed Sheeran" + "\n" + "Arijit Singh");
                    String userArtistChioce = br.readLine();
                    Statement st = DataBaseConnection.connection();
                    //Use Of Collection
                    List<String> li = new ArrayList<String>();
                    SqlQueries = ("SELECT * from music where Artist='" + userArtistChioce + "'");
                    System.out.println("Genre " + "\t" + "Artist Name " + "\t" + "SongName");
                    ResultSet rs = st.executeQuery(SqlQueries);
                    while (rs.next()) {

                        li.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
                    }
                    Iterator<String> it = li.iterator();
                    while (it.hasNext()) {
                        System.out.println(it.next());
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter the song name");
                    String userSongChioce = br.readLine();
                    Statement st = DataBaseConnection.connection();
                    SqlQueries = ("Select * from music where songName='" + userSongChioce + "'");
                    System.out.println("Genre " + "\t" + "Artist Name " + "\t" + "SongName");
                    ResultSet rs = st.executeQuery(SqlQueries);
                    while (rs.next()) {

                        System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
                    }
                    break;
                }
                default:
                    System.out.println("Invalid Choice Entered");
            }
        try
        {
            Menu.displayMenu();
        }catch(WrongChoiceException e)
        {
            e.printStackTrace();
        }
    }
}

