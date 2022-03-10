package az.iktlab;

import az.iktlab.mapper.BookingMapper;
import az.iktlab.mapper.FlightMapper;
import az.iktlab.model.Gender;
import az.iktlab.util.ConsoleColors;
import az.iktlab.util.Validator;
import javafx.scene.control.PasswordField;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.*;

public class test {
    public static void main(String[] args) throws SQLException{

//        DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern("H:mm");
//        Scanner sc = new Scanner(System.in);
//        String timeString = sc.nextLine();
//        LocalTime time = LocalTime.parse(timeString, parseFormat);
//        System.out.println(time);
//String str = "23:59:00";
//Time time = Time.valueOf(str);
//time.DateTimeFormatter.ofPattern("hh:MM");
//        System.out.println(time);
//        final String url = "jdbc:postgresql://localhost:5432/flights";
//        final String user = "postgres";
//        final String pass = "root1234";
//        LocalDate date = LocalDate.now();
//        LocalTime time = LocalTime.now();
//        System.out.println(date);
//        System.out.println(time);
//        LocalDateTime dateTime = LocalDateTime.now();
//        System.out.println(dateTime+ "   "+dateTime.plusHours(24));
//        Long bookingId = 10l;
//        Connection con = DriverManager.getConnection(url,user,pass);
//        Statement stmt = con.createStatement();
//            String query = String.format("select flightid from fb_sc.bookings where\n" +
//                    "bookingid='%s'", bookingId);
//       ResultSet rs = stmt.executeQuery(query);
//        System.out.println(rs);
//        System.out.println(BookingMapper.mapFromRsToCount(rs));
//        System.out.println(BookingMapper.mapFromRsToEntity(rs));

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

//        boolean f = true;
//        while (true && f){
//            System.out.println("Ender gender (Male or Female):");
//            String gender = sc.nextLine();
//            Gender gen = Validator.validateGender(gender);
//            if (gen!=Gender.female){
//                if (gen!=Gender.male)
//                    System.out.println("Enter valid gender!");
//            }else{
//                f=false;
//            }
//        }
//        String password = sc.nextLine();
//        int n= password.length();
//        boolean checker = true;
//        for (int i = 0; i < n; i++) {
//            String s = Character.toString(password.charAt(i));
//            if (Pattern.matches("[a-zA-Z0-9!@#$%^&*]", s)== false) {
//                System.out.println("You cannot use the "+s+" symbol in the password");
//                System.out.println("password can contain upper" +
//                        " and lower case letters, numbers and ! @ # $ % ^ & * characters");
//                checker = false;
//            }
//        }
//        if (checker){
//            System.out.println("Valid password");
//        }else{
//            System.out.println("Invalid password");
//        }
//        System.out.println(ConsoleColors.RED + "RED COLORED" +
//                ConsoleColors.RESET + " NORMAL");
//        String str = "Babayev";
//        System.out.printf(ConsoleColors.RED+"ein %s",str);
    }
}
