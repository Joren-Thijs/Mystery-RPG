/*
 * Game Cluedo
 * 
 *  @Author Joren Thijs and Sam Vanhove
 */
package game.model;

import game.model.controls.InputManager;
import game.model.dialogue.DialogueManager;
import game.model.events.EventManager;
import game.model.objectives.ObjectivesManager;
import game.model.world.WorldManager;

/**
 * The Game model
 * @author Joren and Sam
 */
public class Game {
    
    //Variables
    private InputManager inputManager;
    private DialogueManager dialogueManager;
    private EventManager eventManager;
    private ObjectivesManager objectivesManager;
    private WorldManager worldManager;
    
    /**
     * Create a new Game
     */
    public Game(){
        this.inputManager = new InputManager();
        this.dialogueManager = new DialogueManager(this);
        this.eventManager = new EventManager(this);
        this.objectivesManager = new ObjectivesManager(this);
        this.worldManager = new WorldManager(this);
    }
    
    //Methods
    /**
     * Update the game
     */
    public void update(){
        inputManager.update();
        worldManager.update();
        dialogueManager.update();
        eventManager.update();
        objectivesManager.update();
    }
    
    //Getters and Setters
    /**
     * get the worldManager
     * @return 
     */
    public WorldManager getWorldManager(){
        return worldManager;
    }
    
    /**
     * get the inputManager
     * @return 
     */
    public InputManager getInputManager(){
        return inputManager;
    }
    
    /**
     * get the dialogueManager
     * @return 
     */
    public DialogueManager getDialogueManager(){
        return dialogueManager;
    }

    /**
     * @return the eventManager
     */
    public EventManager getEventManager() {
        return eventManager;
    }

    /**
     * @return the objectivesManager
     */
    public ObjectivesManager getObjectivesManager() {
        return objectivesManager;
    }
    
}
