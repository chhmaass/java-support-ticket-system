package org.example;
import java.util.Scanner;
public class Main {
 private static final Scanner SCANNER=new Scanner(System.in);
 private static final TicketService TICKET_SERVICE=new TicketService();
 public static void main(String[] args){
 Database.createTable();boolean programmLaeuft=true;
 while(programmLaeuft){
 menueAnzeigen();int auswahl=ganzeZahlEinlesen("Auswahl: ");
 switch(auswahl){
 case 1 -> ticketAnlegen();
 case 2 -> TICKET_SERVICE.alleTicketsAnzeigen();
 case 3 -> ticketStatusAendern();
 case 4 -> ticketLoeschen();
 case 0 -> {programmLaeuft=false;System.out.println("Das Ticket-System wurde beendet.");}
 default -> System.out.println("Ungültige Auswahl. Bitte erneut versuchen.");
 }
 System.out.println();
 }
 SCANNER.close();
 }
 private static void menueAnzeigen(){
 System.out.println("================================");
 System.out.println("        TICKET-SYSTEM");
 System.out.println("================================");
 System.out.println("1 - Ticket anlegen");
 System.out.println("2 - Alle Tickets anzeigen");
 System.out.println("3 - Ticketstatus ändern");
 System.out.println("4 - Ticket löschen");
 System.out.println("0 - Programm beenden");
 System.out.println("================================");
 }
 private static void ticketAnlegen(){
 System.out.println();System.out.println("--- Neues Ticket ---");
 String titel=textEinlesen("Titel: ");
 String beschreibung=textEinlesen("Beschreibung: ");
 String prioritaet=prioritaetEinlesen();
 Ticket ticket=new Ticket(titel,beschreibung,prioritaet);
 TICKET_SERVICE.ticketAnlegen(ticket);
 }
 private static void ticketStatusAendern(){
 System.out.println();System.out.println("--- Ticketstatus ändern ---");
 int ticketId=ganzeZahlEinlesen("Ticket-ID: ");
 String neuerStatus=statusEinlesen();
 TICKET_SERVICE.statusAendern(ticketId,neuerStatus);
 }
 private static void ticketLoeschen(){
 System.out.println();System.out.println("--- Ticket löschen ---");
 int ticketId=ganzeZahlEinlesen("Ticket-ID: ");
 System.out.print("Ticket wirklich löschen? (j/n): ");
 String bestaetigung=SCANNER.nextLine().trim();
 if(bestaetigung.equalsIgnoreCase("j"))TICKET_SERVICE.ticketLoeschen(ticketId);
 else System.out.println("Der Löschvorgang wurde abgebrochen.");
 }
 private static int ganzeZahlEinlesen(String aufforderung){
 while(true){System.out.print(aufforderung);String eingabe=SCANNER.nextLine().trim();
 try{return Integer.parseInt(eingabe);}catch(NumberFormatException e){System.out.println("Bitte eine gültige ganze Zahl eingeben.");}}
 }
 private static String textEinlesen(String aufforderung){
 while(true){System.out.print(aufforderung);String eingabe=SCANNER.nextLine().trim();
 if(!eingabe.isEmpty())return eingabe;System.out.println("Die Eingabe darf nicht leer sein.");}
 }
 private static String prioritaetEinlesen(){
 while(true){System.out.print("Priorität (niedrig, mittel, hoch): ");
 String prioritaet=SCANNER.nextLine().trim().toLowerCase();
 if(prioritaet.equals("niedrig")||prioritaet.equals("mittel")||prioritaet.equals("hoch"))return prioritaet;
 System.out.println("Bitte niedrig, mittel oder hoch eingeben.");}
 }
 private static String statusEinlesen(){
 while(true){System.out.print("Neuer Status (offen, in Bearbeitung, erledigt): ");
 String status=SCANNER.nextLine().trim();
 if(status.equalsIgnoreCase("offen")||status.equalsIgnoreCase("in Bearbeitung")||status.equalsIgnoreCase("erledigt"))return status.toLowerCase();
 System.out.println("Bitte offen, in Bearbeitung oder erledigt eingeben.");}
 }
}