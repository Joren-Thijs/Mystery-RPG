/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.events;

import game.model.Game;
import game.model.world.World;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joren
 */
public class Dialogue {
    
    //Variables
    private String title;
    private String[] text;
    private boolean active;
    
    //Text feeding
    private int index;
    private boolean printed;

    public Dialogue(String path) {
        initialize(path);
    }
    
    private void initialize(String path){
        
        //Dialogue
        active = false;
        //Load the dialogue from file
        String file = loadFileAsString(path);
        
        //Split the string into title and text
        String[] result = file.split(";");
        title = result[0];
        text = result[1].split("\n");
        
        //Set text feeding
        index = 0;
        printed = false;
    }
    
    
    public void start(){
        active = true;
    }
    
    /**
     *
     * @param game
     */
    public void update(Game game){

        //Show the firstLine automatically
        if(!printed){
            System.out.println(text[0]);
            index++;
            printed = true;
        }
        
        //Show the next lines when the player pressed the nesxt dialogue button
        if(game.getInputManager().isRight()){
            System.out.println(text[index]);
            index++;
        }
        
        if(index >= text.length){
            index = 0;
            active = false;
            printed = false;
        }
    }
    
    /**
     * Load a file as a String
     * @param path
     * @return the file in String format
     */
    public String loadFileAsString(String path){
        try {
            //Load file as String
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            return new String(bytes);
        } catch (IOException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //Getters and Setters
    public boolean isActive(){
        return active;
    }
}
