package org.example;
import java.sql.*;
public class Database {
 private static final String DATABASE_URL="jdbc:sqlite:tickets.db";
 private Database(){}
 public static Connection connect() throws SQLException {return DriverManager.getConnection(DATABASE_URL);}
 public static void createTable(){
 String sql=""" 
 CREATE TABLE IF NOT EXISTS tickets (
 id INTEGER PRIMARY KEY AUTOINCREMENT,
 titel TEXT NOT NULL,
 beschreibung TEXT NOT NULL,
 prioritaet TEXT NOT NULL,
 status TEXT NOT NULL
 );
 """;
 try(Connection connection=connect();Statement statement=connection.createStatement()){
 statement.execute(sql);System.out.println("Datenbank wurde erfolgreich vorbereitet.");
 }catch(SQLException e){System.out.println("Fehler beim Vorbereiten der Datenbank:");System.out.println(e.getMessage());}
 }
}