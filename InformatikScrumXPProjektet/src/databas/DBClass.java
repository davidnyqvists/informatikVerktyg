/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databas;
// Test 11:44
/**
 *
 * @author David Nyqvist
 */

//KLASSER VI IMPORTERAR
import grafiskinterface.GrafikHelper;
import java.util.ArrayList;
import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;

//Klass som anrop till databasen görs




public class DBClass {
    private InfDB idb;
    private HashMap<String, String> primeKeys;
    public DBClass()
    {
    primeKeys = new HashMap<String, String>();
        addPrimeKeys();
        
        
        
        // Anslut till databasen
     try {
            idb = new InfDB(System.getProperty("user.dir") + "\\" + "BOOKFACE.FDB"); // Ändra namn till nuvarande databas
            System.out.println("Uppkopplingen lyckades");
        } catch (InfException e) {
            System.out.println(e.getMessage());
        }
    
    
    }
   
    
     /**
     * Lists all hired persons and returns them in the form of an 
     * ArrayList<HashMap<String, String>>.
     * @return 
     */
    public ArrayList<HashMap<String, String>> listAllHired()
    {
        String sqlFraga = "select * from ANSTALLD";
        
        try
        {
           ArrayList<HashMap<String, String>> allHired = idb.fetchRows(sqlFraga);
           return allHired;
        }
        catch (InfException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public ArrayList<HashMap<String, String>> listAllRooms()
    {
        String sqlFraga = "select * from ROOM";
        
        try
        {
           ArrayList<HashMap<String, String>> allRooms = idb.fetchRows(sqlFraga);
           return allRooms;
        }
        catch (InfException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public InfDB returnDatabase(){
        return idb;
    }
    //Metod för att hämta alla "" från tabell
    public ArrayList<HashMap<String, String>> hamtaAlla(String sql) {
        //String sqlFraga = sql; // "Select BENAMNING FROM PLATTFORM";
        ArrayList<HashMap<String, String>> lista = new ArrayList<HashMap<String, String>>();

        try {
            lista = idb.fetchRows(sql);

        } catch (InfException e) {
            System.out.println("Något gick fel");
        }
        return lista;
    }
    
    //METOD FÖR ATT HÄMTA ANSTÄLLDS PID MED MOTSVARANDE NAMN
    public String getId(String sql) {
       String id = "";
       // String sqlFraga = "SELECT PERSONID FROM PERSON WHERE NAME = "
               // + "'" + namnIn + "'";

        //System.out.println("getNameAid() ger " + namn);

        try {
            id = idb.fetchSingle(sql);
        
            System.out.println("Lyckades att hämta namn");
        } catch (InfException e) {
            System.out.println(e.getMessage());
        }

        return id;
    }
    
    //Metod Lägger till nya värden i tabeller med autoinkrementering
    public boolean insertIntoTableWithAutoIncrement(String table, String query) {
        String wholeQuery;
        try {
            System.out.println("tabellnamnet är" +"" +table + "sql frågan in är" + query);
            wholeQuery = "INSERT INTO " + table + " VALUES("
                    + idb.getAutoIncrement(table, "MEETINGID") + ", " + query + ")";
            // + idb.getAutoIncrement(table, primeKeys.get(table)) + ", " + query + ")";
           System.out.println(wholeQuery);
            idb.insert(wholeQuery);
            System.out.println("lyckades uppdatera, ny anstalld tillagd");
            
            return true;
        } catch (InfException e) {
            //JOptionPane.showMessageDialog(null, "Ett fel har uppstått, kontrollera värdena du angett i textfälten");
           
            System.out.println("något gick fel kunde inte lägga till nytt möte");
            return false;
        }
    }
    /**
     * Get the roomid by inserting the room name.
     * @param roomname is the name of the room
     * @return returns the roomID or null.
     */
    public String getRoomIDfromRoomname(String roomname) {
        String sql = "Select ROOMID from ROOM where RNAME ='" +roomname+ "'";
        try {
            String ROOMID = idb.fetchSingle(sql);
            return ROOMID;
        }
        catch (InfException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /**
     * inserts the date into date_time. Also returns the sql query.
     * @param date A string, and should be in the form: YYYY-MM-dd HH:mm:ss
     * @return Returns the sql query.
     */
    public String insertDateToDate_Time(String date) {
        try {
            String sql = "INSERT INTO DATE_TIME VALUES (" + idb.getAutoIncrement("DATE_TIME", "DATE_TIMEID") + ",'" + date + "')";
            idb.insert(sql);
            
            //Return the created ID.
            return sql;
        }
        catch (InfException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /**
     * inserts meetingID and datetimeID to the database(MEETING_TIME)
     * @param meetingID
     * @param dateTimeID
     * @return the sql query
     */
    public String addMeetingTime(String meetingID, String dateTimeID) {
        try {
            String sql = "INSERT INTO meeting_time values (" + idb.getAutoIncrement("meeting_time", "MEETING_TIMEID") + ",'" + meetingID + "','" + dateTimeID + "')";
            idb.insert(sql);
            return sql;
        }
        catch (InfException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /**
     * Add a meeting. It also returns the sql query
     * @param title
     * @param description
     * @param roomID
     * @return Returns the sql query.
     */
    public String addMeeting (String title, String description, String roomID /*, String personID, String meeting_timeID*/ ) {
        try {
            String sql = "INSERT INTO MEETING (MEETINGID, TITLE, DESCRIPTION, ROOMID) VALUES (" + idb.getAutoIncrement("MEETING", "MEETINGID") + ",'" + title + "'"
                    + ",'" + description + "','" + roomID + "')";
            idb.insert(sql);
            return sql;
        }
        catch (InfException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    // Metod Lägger till nyckeltyp kopplat till tabell i HashMap primeKeys;
    private void addPrimeKeys() {
        primeKeys.put("MEETING", "MEETINGID");
        primeKeys.put("MEETING_TIME", "MEETING_TIMEID");
       System.out.println(primeKeys);
    }
    
    public void addMeetingTimeToMeeting (String meetingID, String meetingTimeID){
        String sql = "UPDATE MEETING SET meeting_timeID =" + meetingTimeID + " where meetingID =" + meetingID;
        try {
            
            idb.update(sql);
            
        }
        catch (InfException e) {
            System.out.println(e.getMessage());
           
        }
    
    }
    
    public boolean logIn(String user, String pass) {
            
        String sqlDbPassword = "Select PASSWORD1 from PERSON where username ='" + user + "'";
        
        
        try {
            String dbPassword = idb.fetchSingle(sqlDbPassword);
            if (dbPassword != null && dbPassword.equals(pass)){
                return true;
            }
            else {
                return false;
            }
        }
        catch (InfException e) {
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    //METOD FÖR ATT HÄMTA ANSTÄLLDS PERSONID MED MOTSVARANDE NAMN
    public String hamtaAnstalldPid(String namnIn) {
        String namn = "";
        String sqlFraga = "SELECT PERSONID FROM PERSON WHERE NAME = "
                + "'" + namnIn + "'";

        System.out.println("hamtaAnstalldAid() ger " + namn);

        try {
            namn = idb.fetchSingle(sqlFraga);
        
            System.out.println("Lyckades att hämta namn");
        } catch (InfException e) {
            System.out.println(e.getMessage());
        }

        return namn;
    }
    
    
    //METOD FÖR ATT HÄMTA ALLA ANSTÄLLDAS NAMN OCH PID 
    public ArrayList<HashMap<String, String>> hamtaAllNamnPid() {
        ArrayList<HashMap<String, String>> lista = new ArrayList<HashMap<String, String>>();
        String sqlFraga = "Select PERSONID,NAME FROM PERSON";

        try {
            ArrayList<HashMap<String, String>> anstalldLista = idb.fetchRows(sqlFraga);
            lista = anstalldLista;
            System.out.println(lista);
        } catch (InfException e) {
            System.out.println("Något gick fel");
        }
        return lista;
    }
    
    
    
    
    
    
    
    
    
}
