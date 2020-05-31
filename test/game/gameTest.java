/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.model.gameobjects.CollisionBox;
import game.model.world.World;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Joren and Sam
 */
public class gameTest {

    //CollisionBox tests:
    @Test
    public void testCollisions_None(){
        CollisionBox a = new CollisionBox(0,0,10,10);
        CollisionBox b = new CollisionBox(15,15,10,10);

        CollisionBox c = new CollisionBox(30,30,20,20);
        CollisionBox d = new CollisionBox(51,51,10,10);

        boolean test = a.collidesWith(b) || b.collidesWith(a) || c.collidesWith(d) || d.collidesWith(c);

        assertEquals(false, test);
    }

    @Test
    public void testCollisions_Hit(){
        CollisionBox c = new CollisionBox(0,0,10,10);
        CollisionBox d = new CollisionBox(9,9,10,10);

        boolean test = d.collidesWith(c);

        assertEquals(true, test);
    }

    @Test
    public void testCollisionsBigInSmall_Hit(){
        CollisionBox c = new CollisionBox(0,0,100,100);
        CollisionBox d = new CollisionBox(9,9,10,10);

        boolean test = d.collidesWith(c);

        assertEquals(true, test);
    }

    @Test
    public void testCollisionsSmallInBig_Hit(){
        CollisionBox c = new CollisionBox(20,20,10,10);
        CollisionBox d = new CollisionBox(0,0,100,100);

        boolean test = d.collidesWith(c);

        assertEquals(true, test);
    }

    

    //OLD TESTCODE:
    
    /**
     * Disect a dialogue file into dialogues and responses
     */
    public void disectDialogueString(){
        String path = "GameFiles\\Dialogues\\Butler_Dialogue_1.txt";

        List<TextBlock> dialogues = new ArrayList<>();
        List<TextBlock> responses = new ArrayList<>();

        String file = loadFileAsString(path);
        String[] blocks = file.split("//>\\s+<//");
        String[][] elements = new String[blocks.length][];
        for(int i = 0; i < blocks.length; i++){
            elements[i] = blocks[i].split("><");
        }

        for (String chunk : blocks) {
            System.out.println("responses: " + chunk);
        }

        for(int i = 0; i < blocks.length; i++){

            if(!checkTextBlockIntegrety(elements[i])){
                System.out.println("Dialogue TextBlock failed integrety check!" + "\n" +
                                   //Number of the block
                                   "block: " + i + "\n" +
                                   //Path of the Dialogue file
                                   "At path: " + path);
                //Go to the next Block
                continue;
            }

            if(subtractStringAtFront("<//",elements[i][0]).equalsIgnoreCase("dialogue")){
                dialogues.add(new TextBlock(subtractStringAtFront("title:",elements[0][1]),
                                            Integer.parseInt(subtractStringAtFront("id:", elements[i][2])),
                                            subtractStringAtFront("text:", elements[i][3]),
                                            parseIntArray(subtractStringAtFront("jump:", elements[i][4]))));
            }
            else if(subtractStringAtFront("<//",elements[i][0]).equalsIgnoreCase("response")){
                responses.add(new TextBlock("Player",
                                            Integer.parseInt(subtractStringAtFront("id:", elements[i][1])),
                                            subtractStringAtFront("text:", elements[i][2]),
                                            parseIntArray(subtractStringAtFront("jump:", elements[i][3]))));
            }

        }

        System.out.println("subtraction: " + subtractStringAtFront("title:",elements[0][1]));
        System.out.println("subtraction2: " + subtractStringAtFront("<//","<//dialogue"));
        System.out.println("subtraction3: " + subtractStringAtFront("<//","dialogue"));
         
    }
    
    /**
     * Check dialogue block integrity
     * @param block
     * @return 
     */
    private boolean checkTextBlockIntegrety(String[] block){
        //Check the first element
        if(!subtractStringAtFront("<//",block[0]).equalsIgnoreCase("dialogue") &&
           !subtractStringAtFront("<//",block[0]).equalsIgnoreCase("response")){
            return false;
        }
         
        //Check if its a dialogue or a response
         
        //If its a dialogue
        if(subtractStringAtFront("<//",block[0]).equalsIgnoreCase("dialogue")){
            if(!cutOutStringAtFront("title:",block[1]).equalsIgnoreCase("title:")){
                return false;
            }
            if(!cutOutStringAtFront("id:",block[2]).equalsIgnoreCase("id:")){
                return false;
            }
            if(!cutOutStringAtFront("text:",block[3]).equalsIgnoreCase("text:")){
                return false;
            }
            if(!cutOutStringAtFront("jump:",block[4]).equalsIgnoreCase("jump:")){
                return false;
            }
        }
        //If its a response
        else if(subtractStringAtFront("<//",block[0]).equalsIgnoreCase("response")){
            if(!cutOutStringAtFront("id:",block[1]).equalsIgnoreCase("id:")){
               return false;
            }
            if(!cutOutStringAtFront("text:",block[2]).equalsIgnoreCase("text:")){
                return false;
            }
            if(!cutOutStringAtFront("jump:",block[3]).equalsIgnoreCase("jump:")){
                return false;
            }
        }
         
        return true;
    }
    
    /**
     * Turn String numbers array separated by comma into Int Array
     * @param array
     * @return 
     */
    private int[] parseIntArray(String array){
        String[] integers = array.split(",");
        int[] newArray = new int[integers.length];
        for(int i=0; i< integers.length; i++){
            newArray[i] = Integer.parseInt(integers[i]);
        }
        return newArray;
    }
    
    /**
     * Attempt to subtract string at beginning of String if it exists there
     * @param subtraction
     * @param text
     * @return 
     */
    public String subtractStringAtFront(String subtraction, String text){
        
        //Create Two String Builders
        StringBuilder front = new StringBuilder(text);
        StringBuilder back = new StringBuilder(text);
        
        //Delete the back part of the String
        front.delete(subtraction.length() , text.length());
        //Delete the front part of the String
        back.delete(0, subtraction.length());
        
        String frontString = front.toString();
        String backString = back.toString();
        
        //If the frontString equals what was to be subtracted
        if(frontString.equalsIgnoreCase(subtraction)){
            return backString;
        }
        //If there was nothing to subtract return the original text
        else{
            return text;
        }
    }
    
    /**
     * Attempt to subtract string at end of String if it exists there
     * @param subtraction
     * @param text
     * @return 
     */
    public String subtractStringAtBack(String subtraction, String text){
        
        StringBuilder front = new StringBuilder(text);
        StringBuilder back = new StringBuilder(text);
        
        front.delete(text.length() - subtraction.length() , text.length());
        back.delete(0, text.length() - subtraction.length());
        
        String frontString = front.toString();
        String backString = back.toString();
        
        System.out.println("backString: " + backString);
        System.out.println("frontString: " + frontString);
        
        if(backString.equalsIgnoreCase(subtraction)){
            System.out.println("returning frontString");
            return frontString;
        }
        else{
            System.out.println("returning text");
            return text;
        }
        
    }
    
    /**
     * This method cuts out the front of a string and returns it
     * so it can be compared
     * @param cutOut the length of this string is cut out from text
     * @param text
     * @return 
     */
    public String cutOutStringAtFront(String cutOut, String text){
        //Create String builder
        StringBuilder front = new StringBuilder(text);
        //Delete the back part        
        front.delete(cutOut.length() , text.length());
        //Return the front part
        return front.toString();
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
    
    //Nested Class for testing purposes
    private class TextBlock{

        //Variables
        private String title;
        private int id;
        private String text;
        private int[] jumps;
        
        /**
         * Constructor
         * @param title
         * @param id
         * @param text
         * @param jumps 
         */
        public TextBlock(String title, int id, String text, int[] jumps){
            this.title = title;
            this.id = id;
            this.text = text;
            this.jumps = jumps;
        }
        
        //Getters and Setters
        /**
         * @return the title
         */
        public String getTitle() {
            return title;
        }

        /**
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * @return the text
         */
        public String getText() {
            return text;
        }
    }
    
}
