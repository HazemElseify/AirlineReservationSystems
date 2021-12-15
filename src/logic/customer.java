/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import database.database;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ahmed Abdallah
 */
public class customer {
    private String usernmae;
    private String Password;
    private String email;
    private String name;
    private int age;

    public customer() {
        
    }

    public customer(String usernmae, String Password, String email, String name, int age) {
        this.usernmae = usernmae;
        this.Password = Password;
        this.email = email;
        this.name = name;
        this.age = age;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getUsernmae() {
        return usernmae;
    }

    public String getPassword() {
        return Password;
    }

    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    public boolean login(customer c) throws SQLException{
        return database.GetCustomer(c.getUsernmae(),c.getPassword());
    }

    public customer(String usernmae, String Password) {
        this.usernmae = usernmae;
        this.Password = Password;
    }
}
