# Lerntagebuch vom JDBC Intro!

## Teil 1:

### 1. Video:
- Im ersten Video haben wir alles in diesem Java-Projekt eingerichtet!

### 2. Video:
- Es wurde zuerst eine neue Datenbank namens "jdbcdemo" erstellt!
- Danach wurde in Dieser eine neue Tabelle namens "stundent" erstellt!

### 3. Video:
- Im 3. Video wurde nun der Code für die Connection zur Datenbank geschrieben!
- Diesen haben wir aber schon in einer vorherigen Stunde ausprogrammieret!

### 4. Video:
- Nun wurde in der Main ein PreparedStatement codiert!
- Auch eine while-Schleife, die die ganzen Inhalte ausgibt, wurde deklariert!

### 5. Video:
- Nun wurde der vorherige Code zuerst in die Methode selectAllDemo hinzugefügt!
- Danach wurde die Methode insertStudentDemo hinzugefügt!
- Dort wurde der Code von der anderen Methode hinein kopiert und es wurde statt einem SELECT-Statement ein INSERT Statement verwendet!
- Mit diesem wird ein neuer Student in die Tabelle hinzugefügt!

### 6. Video:
- Es wurde eine neue Methode namens updateStudentDemo erstellt!
- In dieser wurde dann der Code von der anderen Methode selectAllDemo eingefügt und dann wurde dieser noch umgeschrieben!

### 7. Video:
- Es wurde eine Methode namens deleteStudentDemo erstellt!
- In dieser wurde wieder der Code von einer anderen Methode hinein kopiert und dann abgeändert, sodass diese jetzt einen bestimmten Studenten herauslöscht!

### 8. Video:
- Zum Abschluss wurde noch eine Methoden namens findAllByNameLike erstellt!
- Mit dieser Methode kann man anhand von Buchstaben einen Studenten herausfiltern!

## Teil 2:

- Es wurde eine neue Tabelle namens adress erstellt!
- Darin wurde drei Spalten namens adress_id, plz und place erstellt!
- In diesen wurden schon Beispiele hinzugefügt!
- Danach wurden alle Methoden, die auf student zugreifen dupliziert so umgeändert, dass sie jetzt auf adress zugreifen!