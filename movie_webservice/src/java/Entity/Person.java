/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author Firas
 */
public class Person {
    
    private long id;
    private String name;
    private String lastname;
    private String sex;
    private ArrayList<MovieCharacter> characters;
    
    public Person() {
        
    }

    public Person(String name, String lastname, String sex) {
        this.name = name;
        this.lastname = lastname;
        this.sex = sex;
    }

    public long getId() {
        return id;
    }

    public ArrayList<MovieCharacter> getCharacters() {
        return characters;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCharacters(ArrayList<MovieCharacter> characters) {
        this.characters = characters;
    }
    
    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    
}
