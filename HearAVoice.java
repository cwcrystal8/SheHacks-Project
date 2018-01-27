import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.util.*;

public class HearAVoice{
  public static String getAVoice(){
    ArrayList<String> stories = getStories();
    Random a = new Random(stories.size());
    return stories.get(a.nextInt());
  }

  public static ArrayList<String> getStories(){
    ArrayList<String> ans = new ArrayList<String>();
    try{
    File f = new File("stories.txt");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    int counter = 0;
    String line;
    while ((line = br.readLine()) != null){
      if ( counter % 2 != 0){
        ans.add(line);
      }
      counter += 1;
    }
    br.close();
    fr.close();
  }catch(Exception e){
  }
    return ans;
  }
}
