# Java Support Ticket System

Konsolenbasiertes Ticket-System zur Verwaltung von Supportanfragen mit Java 21, Maven, JDBC und SQLite.

## Funktionen
- Tickets anlegen (Titel, Beschreibung, Priorität)
- Tickets anzeigen
- Status ändern (offen, in Bearbeitung, erledigt)
- Tickets nach Bestätigung löschen
- Automatische Ticket-ID und persistente Speicherung

## Voraussetzungen
- Java Development Kit (JDK) 21
- Apache Maven 3.x

## Starten

```bash
mvn compile
mvn exec:java -Dexec.mainClass=org.example.Main
```

Beim ersten Start wird `tickets.db` im aktuellen Arbeitsverzeichnis erstellt. Die Datenbankdatei ist von der Versionsverwaltung ausgeschlossen.

## Projektstruktur
- `Main.java` – Konsolenmenü und Eingaben
- `Ticket.java` – Datenmodell
- `TicketService.java` – Datenbankoperationen
- `Database.java` – Datenbankverbindung und Tabellenerstellung

## Hinweise
Die Anwendung ist für den lokalen Einzelplatzbetrieb ausgelegt.
