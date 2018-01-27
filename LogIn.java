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
        }
        else{
          passwords.add(line);
        }
        counter += 1;
      }
      br.close();
      fr.close();
    }
    catch(Exception e){
      System.out.println("No such file exists");
    }
}


  public static boolean validate(String username, String password){
      extractUserData();
      if (usernames.indexOf(username) != -1){
        if (password.equals(passwords.get(usernames.indexOf(username))) ){
          System.out.println("Logged in as " + username);
          return true;
        }
        else{
          System.out.println("Incorrect password");
          return false;
        }
      }
      else{
        System.out.println("Invalid username");
        return false;
      }
  }
  public static void main(String[] args) {
    System.out.println(validate("Bob","1234"));
    System.out.println(validate("Bob","1234"));
    System.out.println(validate("Kaitlin","123123123"));
    System.out.println(validate("Maryann","ilikecookies"));
    System.out.println(validate("Crystal","imhatemakingforms"));
    System.out.println(validate("Joyce","stuyhacksqueen"));
    System.out.println(validate("Taylor","rockstar"));
    System.out.println(validate("Grace","kindsoul"));
    System.out.println(validate("Shannon","Iball"));
    System.out.println(validate("Shannon","1234"));
  }
}
