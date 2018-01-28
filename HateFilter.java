import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.util.*;

public class HateFilter{
  private static ArrayList<String> allWords;
  public static ArrayList hateWords;
  public static ArrayList triggerWords;

  public static boolean checkForHate(String message){
    String messageCopy = message.toLowerCase();
    allWords = new ArrayList<String>();
    hateWords = new ArrayList<String>();
    int i = 0;
    int nextWordStart = 0;
    while (i < messageCopy.length()){
      if (messageCopy.substring(i,i+1).equals(" ")){
        allWords.add(messageCopy.substring(nextWordStart,i));
        nextWordStart = (i + 1);
      }
      i = (i + 1);
    }
    try{
      File f1 = new File("hate.txt");
      FileReader fr = new FileReader(f1);
      BufferedReader br = new BufferedReader(fr);
      String line;
      int counter = 0;
      while ((line = br.readLine()) != null){
        hateWords.add(line);
        counter += 1;
      }
      br.close();
      fr.close();
    }
    catch(Exception e){
      System.out.println("No such file exists");
    }

    int presence = -1;
    i = 0;
    for (String hat: allWords){
      presence = hateWords.indexOf(hat);
      if (presence != -1){
        return true;
      }
    }
    return false;
  }

  public static boolean checkForTriggers(String message){
    String messageCopy = message.toLowerCase();
    allWords = new ArrayList<String>();
    int i = 0;
    int nextWordStart = 0;
    while (i < messageCopy.length()){
      if (messageCopy.substring(i,i+1).equals(" ")){
        allWords.add(messageCopy.substring(nextWordStart,i));
        nextWordStart = (i + 1);
      }
      i = (i + 1);
    }

    triggerWords = new ArrayList<String>();
    try{
      File f1 = new File("triggers.txt");
      FileReader fr = new FileReader(f1);
      BufferedReader br = new BufferedReader(fr);
      String line;
      int counter = 0;
      while ((line = br.readLine()) != null){
        triggerWords.add(line);
        counter += 1;
      }
      br.close();
      fr.close();
    }
    catch(Exception e){
      System.out.println("No such file exists");
    }
    int presence = -1;

    for (String hat: allWords){
      presence = triggerWords.indexOf(hat);
      if (presence != -1){
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println("Hats are so weird");
    if (!(checkForHate("Hats are so weird"))){
      System.out.println("Good to go");
    }
    else{
      System.out.println("Thats a little offensieve");
    }
    System.out.println("Fuck you bitch");
      if (!(checkForHate("Fuck you bitch"))){
        System.out.println("Good to go");
      }
      else{
        System.out.println("Thats a little offensieve");
      }
      System.out.println("Hi I am good");
      if (!(checkForTriggers("Hi I am good"))){
        System.out.println("Good to go");
      }
      else{
        System.out.println("Trigger warning needed");
      }
      System.out.println("Spider blood");
      if (!(checkForTriggers("Spider blood"))){
        System.out.println("Good to go");
      }
      else{
        System.out.println("Trigger warning needed");
      }
  }
}
