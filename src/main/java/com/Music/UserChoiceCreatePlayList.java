package com.Music;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class UserChoiceCreatePlayList {

    private int songId;

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    private String SongPath;

    public String getSongPath() {
        return SongPath;
    }

    public void setSongPath(String songPath) {
        SongPath = songPath;
    }

    public void createPlayList() throws ClassNotFoundException {
        boolean playlist=true;
        String Sqlquery="";
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Name of the Playlist");
        try {
            String userPlayList = br.readLine();
            Statement st = DataBaseConnection.connection();
                //Check if the Song is Already present or not in the playlist
                    System.out.println("Enter the Name of the Song which you want to add it in your Playlist");
                    String UserSongName = br.readLine();
                    Sqlquery = "SELECT * from playlist where songName='" + UserSongName + "'" + "and PlaylistName='" + userPlayList + "'";
                    ResultSet rs = st.executeQuery(Sqlquery);
                    if (rs.next() == true) {
                        System.out.println("Existing Playlist, Song is already present in the playlist=" + userPlayList);
                        }
                    else {
                    //Get the Id and Path of the Song whoes Name has been entered by User
                        Sqlquery = ("SELECT * from music where songName='" + UserSongName + "'");
                        rs = st.executeQuery(Sqlquery);
                        while (rs.next())
                            {
                                setSongId(rs.getInt(4));//SongID
                                setSongPath((rs.getString(5)));//SongPath
                            }
                        Sqlquery = ("insert into playlist values('" + userPlayList + "','" + UserSongName + "','" + getSongId() + "','" + getSongPath() + "')");
                        st.executeUpdate(Sqlquery);
                        System.out.println("The value has been successfulluy Update");
                    }

            Menu.displayMenu();
        }
        catch(WrongChoiceException e)
        {
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
