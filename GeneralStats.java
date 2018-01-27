import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.util.*;

public class GeneralStats{
  private static ArrayList<String> polls;
  private static ArrayList<Double> percentages;

  public static void updatePolls(){
    polls = new ArrayList<String>();
    try{
      File f = new File("Polls/Master Poll List.txt");
      FileReader fr = new FileReader(f);
      BufferedReader br = new BufferedReader(fr);
      String line;
      while ((line = br.readLine()) != null){
        polls.add(line);
      }
      br.close();
      fr.close();
  }catch(Exception e){
  }
}

  public static void updatePercentages(){
    updatePolls();
    percentages = new ArrayList<Double>();
    for (String filename: polls){
      Double numYes = 0.0, total = 0.0;
      try{
        String a = "Polls/" + filename + ".txt";

      File f1 = new File(a);
      FileReader fr1 = new FileReader(f1);
      BufferedReader br1 = new BufferedReader(fr1);
      String line;
      while ((line = br1.readLine()) != null){
        if (line.equals("YES")){
          numYes++;
        }
        total += 0.5;
      }
      br1.close();
      fr1.close();

    }catch(Exception e){
      System.out.println("File not found");
    }

    Double num = numYes * 100 / total;
    percentages.add(num);
    }
  }

  public static void printPollSummar(){
    //Takes the each poll in the polls ArrayList, and matches it with its corresponding
    //approval percentage in the percentages ArrayList (indexes are the same) and prints them out
  }

  public static void main(String[] args){
    updatePercentages();
    System.out.println(polls);
    System.out.println(percentages);

  }
}
