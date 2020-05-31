/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.events;

import game.model.Game;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joren
 */
public class DialogueManager {
    
    //Variables
    private Game game;
    private List<Dialogue> dialogues = new ArrayList<>();
    private boolean talking;
    
    Dialogue butlerDialogue1;
    Dialogue messengerDialogue1;

    /**
     * Create new Dialogue Manager
     * @param game
     */
    public DialogueManager(Game game) {
        this.game = game;
        initialize();
    }
    
    private void initialize(){
        talking = false;
        dialogues.add(butlerDialogue1 = new Dialogue("GameFiles\\Dialogues\\Butler\\Butler_Dialogue_1.txt"));
        dialogues.add(messengerDialogue1 = new Dialogue("GameFiles\\Dialogues\\Messenger\\Messenger_Dialogue_1.txt"));
    }
    
    public void update(){
        //For checking if we are talking
        boolean activeDialogue = false;
        
        for(Dialogue dialogue : dialogues){
            if(dialogue.isActive()){
                activeDialogue = true;
                dialogue.update(game);
            }
        }
        //If there is an active dialogue then we are talking
        talking = activeDialogue;
    }
    
    public void  startDialogue(int id){
        //Dialogue tree:
        
        //If talking to the butler
        if(id == 1){
            butlerDialogue1.start();
        } 
    }
    
    public boolean isTalking(){
        return talking;
    }
    
}
