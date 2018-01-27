import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.util.*;

public class LogIn{
  private static ArrayList<String> usernames;
  private static ArrayList<String> passwords;

  public static void extractUserData(){
    usernames = new ArrayList<String>();
	  passwords = new ArrayList<String>();
    try{
      File f1 = new File("names.txt");
      FileReader fr = new FileReader(f1);
      BufferedReader br = new BufferedReader(fr);
      String line;
      int counter = 0;
      while ((line = br.readLine()) != null){
        if ( counter % 2 == 0){
          usernames.add(line);
          counter += 1;
        }
        else{
          passwords.add(line);
          counter += 1;
        }
      }
      br.close();
      fr.close();
      System.out.println("username: " + usernames.get(0));
      System.out.println("password: "+passwords.get(0));
    }
    catch(Exception e){
      System.out.println("No such file exists");
    }
}





  public static int findUsername(String username){
    usernames = new ArrayList<String>();
	  passwords = new ArrayList<String>();
    try{
      File f1 = new File("names.txt");
      FileReader fr = new FileReader(f1);
      BufferedReader br = new BufferedReader(fr);
      String line;
      int counter = 0;
      while ((line = br.readLine()) != null){
        if ( counter % 2 == 0){
          usernames.add(line);
        }
        else{
          passwords.add(line);
        }
        counter +=1;
      }
      fr.close();
      br.close();
      System.out.println("username: " + usernames.get(0));
      System.out.println("password: "+passwords.get(0));
      return (usernames.indexOf(username));

    }
    catch(Exception e){
      System.out.println("No such file exists");
      return (-1);
    }

  }

  public static boolean validate(String username, String password){
      extractUserData();
      if (usernames.indexOf(username) > -1){
        if (password == passwords.get(usernames.indexOf(username)) ){
          System.out.println("Logged in as " + username);
          return (true);
        }
        else{
          System.out.println("Incorrect password");
        }
      }
      else{
        System.out.println("Invalid username");
      }
      return (false);
  }
  public static void main(String[] args) {

  }
}
