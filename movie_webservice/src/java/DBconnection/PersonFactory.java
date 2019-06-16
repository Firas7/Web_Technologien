/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBconnection;

import Entity.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author vvaske
 */
public class PersonFactory {
    
    public PersonFactory(){
        
    }
    
    public static Person findUserByID(long id) throws ClassNotFoundException{
        Person person = null;
        
        try{
            Connection conn = DBConnector.getConnector();
            String sql = "select * from person where personID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                person = new Person();
                person.setId(result.getLong("personID"));
                person.setName(result.getString("name"));
                person.setLastname(result.getString("lastname"));
                person.setSex(result.getString("sex"));
            }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return person;
    }
    
    /*
     @para personName */
    public static Person findUserByPersonName(String personName) throws SQLException, ClassNotFoundException{
        
        Person person = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            
            conn = DBConnector.getConnector();
            String sql = "select * from person where name = ? ";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, personName);
            ResultSet result = stmt.executeQuery();
           if(result.next()){
               person = new Person();
               person.setId(result.getLong("personID"));
               person.setName(result.getString("name"));
               //person.setLastname(result.getString("lastname"));
               person.setSex(result.getString("sex"));
           }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return person;
    }
    
    public static ArrayList<Person> findAllPersons() throws SQLException, ClassNotFoundException{
        
        ArrayList<Person> persons = new ArrayList<Person>();
        String sql = "select * from person ";
        try{
          
            Connection conn = DBConnector.getConnector();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            
            if(result.next()){
                for(Person person : persons){
                    person = new Person();
                    person.setName(result.getString("name")); 
                    person.setLastname(result.getString("lastname")); 
                    person.setSex(result.getString("sex")); 
                    persons.add(person);
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return persons;
    }
    
    
}



