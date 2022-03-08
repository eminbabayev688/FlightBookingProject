package az.iktlab;

import az.iktlab.util.Validator;
import javafx.scene.control.PasswordField;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.*;

public class test {
    public static void main(String[] args) {


//        final String url = "jdbc:postgresql://localhost:5432/flights";
//         final String user = "postgres";
//        final String pass = "root1234";
//
//        Connection con = DriverManager.getConnection(url,user,pass);
//        Statement stmt = con.createStatement();
//
//        String username="emin_babayev";
//        String pass1 = "emin1234";
//        String password = Validator.doHashPassword(pass1);
//
//
//        String query=String.format("select count(username) from fb_sc.users where\n" +
//                "username='%s' and password ='%s'", username,password);
//
//
////        ResultSet rs = DatabaseService.statementDataBase().executeQuery(query);
////        while(rs.next())
////            count=rs.getInt(1);
//        ResultSet rs = stmt.executeQuery(query);
//        int count = 0;
//        while(rs.next())
//            count=rs.getInt(1);
//
//        System.out.println("count="+count);
//        Scanner sc = new Scanner(System.in);
//        String username = sc.nextLine();
//        int n = username.length();
//        String firstCharacter = Character.toString(username.charAt(0));
//        Pattern.matches("[a-z]", firstCharacter);
//        if (username.length() < 8) {
//            System.out.println("username cannot be less than 8 digits");
//        } else if (Pattern.matches("[a-z]", firstCharacter) == false) {
//            System.out.println("username can only start with a lowercase letter");
//        } else if (Pattern.matches("[ ]", firstCharacter)) {
//            for (int i = 0; i < n; i++) {
//                String s = Character.toString(username.charAt(i));
//                if(Pattern.matches("[ ]", s)));
//
//            }
//            System.out.println("bosluq olmaz");
//        } else if (Pattern.matches("[a-zA-Z0-9]", username) == false) {
//            System.out.println("Only lowercase letters, numbers, underscores(_) and dot(.) " +
//                    "can be used in the username");
//        }

//        System.out.println(Pattern.compile("[a-z]"));
//
//        String username = "emin.123 4_";
//
//        System.out.println(username.length());
//        int n = username.length();
//        for (int i = 0; i < n; i++) {
//            String s = Character.toString(username.charAt(i));
//            System.out.println(i+"."+s);
//            System.out.println((Pattern.matches("[ ]",s)));
//
//        }


    }
}
