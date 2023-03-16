package com.Music;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class PlayMusicImp {
    public static void playSong(String filepath) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        Scanner sc=new Scanner(System.in);
        File file = new File(filepath);
        Clip clip = AudioSystem.getClip();
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip.open(audioStream);
        int Choice;
        int flag = 0;
        long clippos = 0;

        while (flag == 0)
        {

            System.out.println("\nEnter Your Choice\n----- ---- ------\n 1. play\n 2. Pause\n 3. Resume\n 4. Restart\n 5. Forward\n 6.Backwards\n 7.Back to the main Menu \n ");

            Choice = sc.nextInt();
            switch (Choice) {
                case 1:
                    clip.start();
                    System.out.println("+------------+");
                    System.out.println("|Playing Song|");
                    System.out.println("+------------+");
                    break;
                case 2:
                    clippos = clip.getMicrosecondPosition();
                    clip.stop();
                    System.out.println("+-----------+");
                    System.out.println("|Song Paused|");
                    System.out.println("+-----------+");
                    break;
                case 3:
                    clip.setMicrosecondPosition(clippos);
                    clip.start();
                    System.out.println("+------------+");
                    System.out.println("|Song Resumed|");
                    System.out.println("+------------+");
                    break;
                case 4:
                    clip.setMicrosecondPosition(0);
                    clip.start();
                    System.out.println("+--------------+");
                    System.out.println("|Song Restarted|");
                    System.out.println("+--------------+");
                    break;
                case 5:
                    System.out.println("+-----------------+");
                    System.out.println("|Forwarding by 25s|");
                    System.out.println("+-----------------+");
                    clip.setMicrosecondPosition(clip.getMicrosecondPosition() + 2500000);
                    break;
                case 6:
                    System.out.println("+-----------------+");
                    System.out.println("|Backward by 25s|");
                    System.out.println("+-----------------+");
                    clip.setMicrosecondPosition(clip.getMicrosecondPosition() - 2500000);
                    break;
                case 7:
                {
                    try
                    {
                        clip.close();
                        flag = 1;
                        Menu.displayMenu();
                    }catch(WrongChoiceException | ClassNotFoundException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
                default:
                    System.out.println("Not a valid Input");
            }
        }
    }
}
