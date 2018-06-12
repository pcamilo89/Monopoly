/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Camilo
 */
public class UserJson {
    
    public static void createJson(){
        
        JSONObject jSonObjList = new JSONObject();

        jSonObjList.put("sequence", 0);
        jSonObjList.put("lista", new JSONArray());

        saveJson(jSonObjList);
    }
    
    public static void saveJson(JSONObject objList){
        try {
            FileWriter file;
            file = new FileWriter(Utils.SERVER_USER_PATH);
            file.write(objList.toString());
            file.flush();
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(UserJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static JSONObject readJson(){
        try {
            
            FileReader reader = new FileReader(Utils.SERVER_USER_PATH);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            reader.close();
            return (JSONObject) obj;
            
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(UserJson.class.getName()).log(Level.SEVERE, null, ex);
            createJson();
            return readJson();
            
        } catch (IOException ex) {
            Logger.getLogger(UserJson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(UserJson.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void addUser(User user){
        JSONObject jSonObjList = readJson();
        
        JSONArray jSonArray = (JSONArray) jSonObjList.get("lista");
        int sequence = 1 + Integer.parseInt(jSonObjList.get("sequence").toString());
        
        JSONObject jSonObjUser = new JSONObject();
        jSonObjUser.put("id", sequence);
        jSonObjUser.put("name", user.getName());
        jSonObjUser.put("lastname", user.getLastname());
        jSonObjUser.put("username", user.getUsername());
        jSonObjUser.put("password", user.getPassword());
        
        jSonArray.add(jSonObjUser);
        
        jSonObjList.put("sequence", sequence);
        jSonObjList.put("lista", jSonArray);
        
        saveJson(jSonObjList);
    }
    
    public static void deleteUser(User user){
        JSONObject jSonObjList = readJson();
        
        JSONArray jSonArray = (JSONArray) jSonObjList.get("lista");
        Iterator iterator = jSonArray.iterator();
        
        JSONObject jSonObjTemp = null;
                
        while(iterator.hasNext()){
            JSONObject jSonObjUser = (JSONObject) iterator.next();
            
            String jsonUserID = jSonObjUser.get("id").toString();
            
            if( user.getId() ==  Integer.parseInt(jsonUserID)){
                jSonObjTemp = jSonObjUser;
            }
        }
        
        if (jSonObjTemp != null) {
            jSonArray.remove(jSonObjTemp);
        }
        
        saveJson(jSonObjList);
    }
    
    public static void editUser(User user){
        JSONObject jSonObjList = readJson();
        
        JSONArray jSonArray = (JSONArray) jSonObjList.get("lista");
        Iterator iterator = jSonArray.iterator();
        
        //JSONObject jSonObjTemp = null;
        
        
        while(iterator.hasNext()){
            JSONObject jSonObjUser = (JSONObject) iterator.next();
            
            if( user.getId() ==  Integer.parseInt(jSonObjUser.get("id").toString())){
                
                jSonObjUser.put("name", user.getName());
                jSonObjUser.put("lastname", user.getLastname());
                jSonObjUser.put("username", user.getUsername());
                jSonObjUser.put("password", user.getPassword());
            }
        }
        
        saveJson(jSonObjList);
    }
    
    public static User loginUser(String username, String password){
        JSONObject jSonObjList = readJson();
        
        JSONArray jSonArray = (JSONArray) jSonObjList.get("lista");
        Iterator iterator = jSonArray.iterator();
        
        String jsonUsername;
        String jsonPassword;
        
        while(iterator.hasNext()){
            JSONObject jSonObjUser = (JSONObject) iterator.next();
            
            jsonUsername = jSonObjUser.get("username").toString();
            jsonPassword = jSonObjUser.get("password").toString();
            
            if( username.equals(jsonUsername) && password.equals(jsonPassword) ){
                return new User (
                        jSonObjUser.get("name").toString(), 
                        jSonObjUser.get("lastname").toString(), 
                        jSonObjUser.get("username").toString(), 
                        "" );
            }
            
        }
        return null;
    }
    
    public static void loadUserList(){
        Core.userList.clear();
        
        JSONObject jSonObjList = readJson();
        
        JSONArray jSonArray = (JSONArray) jSonObjList.get("lista");
        Iterator iterator = jSonArray.iterator();

        while(iterator.hasNext()){
            JSONObject jSonObjUser = (JSONObject) iterator.next();
            
            //cada usuario del archivo se agrega a la lista en core
            Core.userList.addUser(new User (
                    Integer.parseInt(jSonObjUser.get("id").toString()),
                    jSonObjUser.get("name").toString(),
                    jSonObjUser.get("lastname").toString(),
                    jSonObjUser.get("username").toString(), 
                    jSonObjUser.get("password").toString())
            );          
            
        }
    }
}
