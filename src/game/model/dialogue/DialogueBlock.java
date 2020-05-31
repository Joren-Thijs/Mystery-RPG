/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.dialogue;

/**
 *
 * @author Joren and Sam
 */
public class DialogueBlock {

    //Variables
    private String title;
    private int id;
    private String text;
    private int[] jumps;

    /**
     * Create a new dialogueBlock
     * @param title
     * @param id
     * @param text
     * @param jumps 
     */
    public DialogueBlock(String title, int id, String text, int[] jumps){
        this.title = title;
        this.id = id;
        this.text = text;
        this.jumps = jumps;
    }

    //Methods
    
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
    
    /**
     * @return the jumps
     */
    public int[] getJumps() {
        return jumps;
    }

    /**
     * @param jumps the jumps to set
     */
    public void setJumps(int[] jumps) {
        this.jumps = jumps;
    }
    
}
