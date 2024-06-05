package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import dataclass.Member;

/*
 *  Name: Md. Saiful Islam
 *  ID: 1922071
 *  Course: CSE215L.16
 *  Instructor Name: Shaikh Shawon Arefin Shimon
 *  @date 20 Jan 2021
 */
public class Serializer {
  private static String OS = System.getProperty("os.name").toLowerCase();

  public static final String databasePath = OS.indexOf("win") >= 0 ? System.getProperty("user.home") + "\\sbcgymmembersmanagementdatabase.bin"
      : System.getProperty("user.home") + "/sbcgymmembersmanagementdatabase.bin";

  public static boolean serialize(String filePath, ArrayList<Member> membersList) {
    File databaseFile = new File(filePath);
    FileOutputStream fileOutputStream = null;
    ObjectOutputStream objectOutputStream = null;

    boolean success = false;
    try {
      fileOutputStream = new FileOutputStream(databaseFile);
      objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(membersList);
      success = true;
    } catch (Exception exception) {
      success = false;
    }

    return success;
  }

  public static ArrayList<Member> deserialize(String filePath) {

    File databaseFile = new File(filePath);
    FileInputStream fileInputStream = null;
    ObjectInputStream objectInputStream = null;

    ArrayList<Member> list = null;

    try {
      fileInputStream = new FileInputStream(databaseFile);
      objectInputStream = new ObjectInputStream(fileInputStream);

      list = (ArrayList<Member>) objectInputStream.readObject();
    } catch (Exception exception) {
      System.out.println(exception.toString());
    }

    return list;
  }

}
