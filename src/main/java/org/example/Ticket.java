package org.example;
public class Ticket {
 private int id;private String titel,beschreibung,prioritaet,status;
 public Ticket(int id,String titel,String beschreibung,String prioritaet,String status){this.id=id;this.titel=titel;this.beschreibung=beschreibung;this.prioritaet=prioritaet;this.status=status;}
 public Ticket(String titel,String beschreibung,String prioritaet){this.titel=titel;this.beschreibung=beschreibung;this.prioritaet=prioritaet;this.status="offen";}
 public int getId(){return id;}
 public String getTitel(){return titel;}
 public String getBeschreibung(){return beschreibung;}
 public String getPrioritaet(){return prioritaet;}
 public String getStatus(){return status;}
 @Override public String toString(){return """
 ------------------------------
 Ticket-ID: %d
 Titel: %s
 Beschreibung: %s
 Priorität: %s
 Status: %s
 ------------------------------
 """.formatted(id,titel,beschreibung,prioritaet,status);}
}