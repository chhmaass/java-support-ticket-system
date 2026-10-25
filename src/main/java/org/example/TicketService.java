package org.example;
import java.sql.*;
public class TicketService {
 public boolean ticketAnlegen(Ticket ticket){
 String sql="INSERT INTO tickets (titel,beschreibung,prioritaet,status) VALUES (?,?,?,?)";
 try(Connection connection=Database.connect();PreparedStatement statement=connection.prepareStatement(sql)){
 statement.setString(1,ticket.getTitel());statement.setString(2,ticket.getBeschreibung());statement.setString(3,ticket.getPrioritaet());statement.setString(4,ticket.getStatus());
 statement.executeUpdate();System.out.println("Ticket wurde erfolgreich angelegt.");return true;
 }catch(SQLException e){System.out.println("Fehler beim Anlegen des Tickets:");System.out.println(e.getMessage());return false;}
 }
 public void alleTicketsAnzeigen(){
 String sql="SELECT id,titel,beschreibung,prioritaet,status FROM tickets ORDER BY id";
 try(Connection connection=Database.connect();PreparedStatement statement=connection.prepareStatement(sql);ResultSet resultSet=statement.executeQuery()){
 boolean ticketsVorhanden=false;
 while(resultSet.next()){ticketsVorhanden=true;Ticket ticket=new Ticket(resultSet.getInt("id"),resultSet.getString("titel"),resultSet.getString("beschreibung"),resultSet.getString("prioritaet"),resultSet.getString("status"));System.out.println(ticket);}
 if(!ticketsVorhanden)System.out.println("Es sind noch keine Tickets vorhanden.");
 }catch(SQLException e){System.out.println("Fehler beim Anzeigen der Tickets:");System.out.println(e.getMessage());}
 }
 public void statusAendern(int ticketId,String neuerStatus){
 String sql="UPDATE tickets SET status = ? WHERE id = ?";
 try(Connection connection=Database.connect();PreparedStatement statement=connection.prepareStatement(sql)){
 statement.setString(1,neuerStatus);statement.setInt(2,ticketId);
 int geaenderteDatensaetze=statement.executeUpdate();
 if(geaenderteDatensaetze>0)System.out.println("Der Ticketstatus wurde geändert.");
 else System.out.println("Es wurde kein Ticket mit dieser ID gefunden.");
 }catch(SQLException e){System.out.println("Fehler beim Ändern des Status:");System.out.println(e.getMessage());}
 }
 public void ticketLoeschen(int ticketId){
 String sql="DELETE FROM tickets WHERE id = ?";
 try(Connection connection=Database.connect();PreparedStatement statement=connection.prepareStatement(sql)){
 statement.setInt(1,ticketId);int geloeschteDatensaetze=statement.executeUpdate();
 if(geloeschteDatensaetze>0)System.out.println("Das Ticket wurde erfolgreich gelöscht.");
 else System.out.println("Es wurde kein Ticket mit dieser ID gefunden.");
 }catch(SQLException e){System.out.println("Fehler beim Löschen des Tickets:");System.out.println(e.getMessage());}
 }
}