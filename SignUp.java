import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.util.*;


public class SignUp{
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
    }
    catch(Exception e){
      System.out.println("No such file exists");
    }
}



  public static boolean addAccount(String username, String password){
    extractUserData();
    if (usernames.indexOf(username) == -1){
      try{
        File f = new File("names.txt");
        FileWriter r = new FileWriter(f, true);
        BufferedWriter b = new BufferedWriter(r);
        b.append(username);
        b.newLine();
        b.append(password);
        b.newLine();
        b.flush();
        b.close();
        r.close();
        return true;
      }
      catch(Exception e){
        System.out.println("No such file exists");
      }
    }
    else{
      System.out.println("This username has already been taken!");
      return false;
    }
    return false;
}
  public static void main(String[] args){
    System.out.println(addAccount("Bob","1234"));
    System.out.println(addAccount("Kaitlin","123123123"));
    System.out.println(addAccount("Maryann","ilikecookies"));
    System.out.println(addAccount("Crystal","imhatemakingforms"));
    System.out.println(addAccount("Joyce","stuyhacksqueen"));
    System.out.println(addAccount("Taylor","rockstar"));
    System.out.println(addAccount("Grace","kindsoul"));
    System.out.println(addAccount("Shannon","Iball"));
    System.out.println(addAccount("Shannon","1234"));
  }
}
