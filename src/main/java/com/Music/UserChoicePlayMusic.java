package com.Music;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserChoicePlayMusic extends PlayMusicImp{

    private String songUserWantToPlay;

    public String getSongUserWantToPlay() {
        return songUserWantToPlay;
    }

    public void setSongUserWantToPlay(String songUserWantToPlay) {
        this.songUserWantToPlay = songUserWantToPlay;
    }

    public void playSong() throws LineUnavailableException, UnsupportedAudioFileException {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String SqlQuery = "";
            String songFixedPath = "D:\\NIIT\\Intellij Projects\\CapStoneJudeBoxProject\\src\\resources\\";
            Statement st = DataBaseConnection.connection();
            System.out.println("Do you want to play song from your Existing Playlist or from the library");
            String PlaylistChoice =br.readLine();
            if(PlaylistChoice.equalsIgnoreCase("Existing Playlist"))
            //If User Chooses to play the song from the Exsisting Playlist
            {
                //Display the List of Playlist
                SqlQuery="Select distinct PlaylistName from playlist";
                ResultSet rs=st.executeQuery(SqlQuery);
                while(rs.next())
                {
                    System.out.println(rs.getString(1));
                }
                System.out.println("Enter the Name of your Playlist");
                String UserPlaylistName=br.readLine();
                //Display All the Songs Present in the Playlist
                SqlQuery="select * from playlist where PlaylistName='" + UserPlaylistName + "'";
                rs=st.executeQuery(SqlQuery);
                System.out.println("Songs Available in your Playlist");
                while(rs.next())
                {
                    System.out.println(rs.getString(2));
                }
                //In-Order to play the Song from the playList
                System.out.println("Enter the Name of the song which you want to play");
                setSongUserWantToPlay(br.readLine());
                SqlQuery = ("select * from playlist where SongName='" + getSongUserWantToPlay() + "'"+"and PlaylistName='" + UserPlaylistName + "'");
                rs = st.executeQuery(SqlQuery);
                while(rs.next())
                {
                    songFixedPath = songFixedPath+rs.getString(4);
                    playSong(songFixedPath);
                }
            }
            else
            {
                // If User Chooses to play the song from the Main Library
                System.out.println("Here is the list of songs available in the Library");
                SqlQuery="select * from music";
                ResultSet rs=st.executeQuery(SqlQuery);
                while(rs.next())
                {
                    System.out.println(rs.getString(3));
                }
                //Asking User Which song he wants to play
                System.out.println("Enter the Name of the song which you want to play");
                setSongUserWantToPlay(br.readLine());
                SqlQuery = ("select * from music where SongName='" + getSongUserWantToPlay() + "'");
                rs = st.executeQuery(SqlQuery);
                while (rs.next()) {
                    songFixedPath = songFixedPath+rs.getString(5);
                    System.out.println(songFixedPath);
                }
                playSong(songFixedPath);
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
