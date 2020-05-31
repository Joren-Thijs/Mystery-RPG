/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.objectives;

import game.model.Game;
import game.model.gameobjects.characters.Direction;
import game.model.inventory.Item;
import game.model.inventory.Note;

/**
 * @author Joren and Sam
 */
public class ObjectivesManager {
    
    //Variables
    private Game game;
    private int currentObjectiveId;

    /**
     * Create a new objectivesManager
     * @param game 
     */
    public ObjectivesManager(Game game) {
        this.game = game;
        currentObjectiveId = 0;
    }
    
    //Methods
    /**
     * Update the objectives manager
     */
    public void update(){
        //Check witch objective is currently active
        switch(currentObjectiveId){
            //Opening frame chapter 1
            case 0:
                if(!game.getEventManager().isInUse()){
                        advanceCurrentObjectiveId(1);
                    }
                game.getEventManager().showTransitionFrame(3500, "Chapter 1: A sunny day");
                break;
            //Jeffrey approaches and gives invitation
            case 1:
                //advanceCurrentObjectiveId happens in dialogue managers dialogue tree
                break;
            //Chapter 2 frame
            case 2:
                //Check if jeffrey is done talking
                if(game.getDialogueManager().isTalking()) break;
                    
                    advanceCurrentObjectiveId(3);
                    
                    //Show chapter 2 frame
                    game.getEventManager().showTransitionFrame(2500, "Chapter 2: A special toast");
                    
                    //Teleport player to villa Fisher
                    game.getWorldManager().setWorld(1);
                    //Adjust player position
                    game.getWorldManager().getPlayer().setX(1690);
                    game.getWorldManager().getPlayer().setY(460);
                    //Turn all the guests towards lord fisher:
                    //Player
                    game.getWorldManager().getWorld().getGameCharacterManager().getGameCharacterWithId(0).setDirection(Direction.UP);
                    //Sofie
                    game.getWorldManager().getWorld().getGameCharacterManager().getGameCharacterWithId(2).setDirection(Direction.UP);
                    //Suzie
                    game.getWorldManager().getWorld().getGameCharacterManager().getGameCharacterWithId(3).setDirection(Direction.UP);
                    //Jonny
                    game.getWorldManager().getWorld().getGameCharacterManager().getGameCharacterWithId(4).setDirection(Direction.UP);
                    //Violet
                    game.getWorldManager().getWorld().getGameCharacterManager().getGameCharacterWithId(5).setDirection(Direction.UP);
                    //Jeffrey
                    game.getWorldManager().getWorld().getGameCharacterManager().getGameCharacterWithId(8).setDirection(Direction.UP);
                    
                break;
            //Lord Fisher gives Speech
            case 3:
                if(!game.getEventManager().isInUse()){
                    //Start dialogue
                    game.getDialogueManager().startDialogue(7);
                }
                break;
            //Fade to black
            case 4:
                //Wait until the dialogue is over
                if(game.getDialogueManager().isTalking()) break;
                if(game.getEventManager().isInUse()) break;
                //Show fade to black
                game.getEventManager().showTransitionFrame(2500, "");
                //Kill Jeffrey
                game.getWorldManager().getWorld().getGameCharacterManager().getGameCharacterWithId(8).setActive(false);
                advanceCurrentObjectiveId(5);
                break;
            //Dead body found
            case 5:
                //Start body found Dialogue
                if(!game.getEventManager().isInUse()){
                    //Start dialogue
                    game.getDialogueManager().startDialogue(7);
                }
                break;
            //Chapter 3 Frame
            case 6:
                //Check if Lord Fisher is done Talking
                if(game.getDialogueManager().isTalking()) break;
                if(game.getEventManager().isInUse()) break;
                //Show chapter 2 frame
                game.getEventManager().showTransitionFrame(2500, "Chapter 3: A search for the truth");
                //Teleport player to new villa Fisher with characters at final positions
                game.getWorldManager().setWorld(2);
                advanceCurrentObjectiveId(7);
                break;
            //Start investigation
            case 7:
                //Create starting note
                Note startingNote = new Note("Jeffrey", 15, "Note:", "Jeffrey has just been poisoned"
                                                                    + "\nIf i want to leave this place i will"
                                                                    + "\nhave to find out who did this");
                
                if(!game.getWorldManager().getPlayer().getInventory().hasNote(startingNote)){
                    game.getWorldManager().getPlayer().getInventory().addNote(startingNote);
                    game.getEventManager().showMessage(1500, "You made a note");
                }
                //Investigation requirements
                if(game.getWorldManager().getPlayer().getInventory().hasItem(new Item("Bottle of Wine", 4)) &&
                   game.getWorldManager().getPlayer().getInventory().hasNote(new Note("Letter to Sofie", 12, "", "")) &&
                   game.getWorldManager().getPlayer().getInventory().hasNote(new Note("Letter to Henry", 5, "", ""))){
                   
                   //Give player a hint
                   game.getWorldManager().getPlayer().getInventory().addNote(new Note("Thoughts", 13, "Note:",
                                                                                      "I found a lot of suspicious things"
                                                                                    + "\nregarding Lord Fisher"
                                                                                    + "\nMaybe i should talk to lady Fisher"
                                                                                    + "\nabout this."));
                   advanceCurrentObjectiveId(8);
                    
                }
                break;
            //get the second floor key after presenting evidence to lady fisher
            case 8:
                //Do something
                break;
            //open door to second floor
            case 9:
                //Check if the player entered the second floor to show the chapter 4 frame
                if(game.getWorldManager().getWorldIndex() == 3){
                    advanceCurrentObjectiveId(10);
                }
                break;
            //Chapter 4 Frame
            case 10:
                game.getEventManager().showTransitionFrame(2500, "Chapter 4: Closer to the answer");
                advanceCurrentObjectiveId(11);
                //Do something
                break;
            //find the murder weapon
            case 11:
                //If player has all the evidence and he has gone back downstairs
                //Start the confrontation scene
                if(game.getWorldManager().getPlayer().getInventory().hasItem(new Item("Brown cuffling", 10)) &&
                   game.getWorldManager().getPlayer().getInventory().hasNote(new Note("Letter to Jeffrey", 7,"","")) &&
                   game.getWorldManager().getWorldIndex() == 2){
                    
                    advanceCurrentObjectiveId(12);
                }
                break;
            //Chapter 5 Frame 
            case 12:
                game.getEventManager().showTransitionFrame(2500, "Chapter 5: Conclussion");
                
                //Teleport player to confrontation scene
                game.getWorldManager().setWorld(4);
                //Adjust player position
                game.getWorldManager().getPlayer().setX(1700);
                game.getWorldManager().getPlayer().setY(350);
                
                //Turn all the guests towards the player:
                //Butler
                game.getWorldManager().getWorld().getGameCharacterManager().getGameCharacterWithId(1).setDirection(Direction.UP);
                //Sofie
                game.getWorldManager().getWorld().getGameCharacterManager().getGameCharacterWithId(2).setDirection(Direction.UP);
                //Suzie
                game.getWorldManager().getWorld().getGameCharacterManager().getGameCharacterWithId(3).setDirection(Direction.UP);
                //Jonny
                game.getWorldManager().getWorld().getGameCharacterManager().getGameCharacterWithId(4).setDirection(Direction.UP);
                //Violet
                game.getWorldManager().getWorld().getGameCharacterManager().getGameCharacterWithId(5).setDirection(Direction.UP);
                //Lady Fisher
                game.getWorldManager().getWorld().getGameCharacterManager().getGameCharacterWithId(6).setDirection(Direction.UP);
                //Lord Fisher
                game.getWorldManager().getWorld().getGameCharacterManager().getGameCharacterWithId(7).setDirection(Direction.UP);
                     
                
                advanceCurrentObjectiveId(13);
                break;
            //The butler did it
            case 13:
                //Start confrontation Dialogue
                if(!game.getEventManager().isInUse()){
                    //Start dialogue
                    game.getDialogueManager().startDialogue(7);
                    advanceCurrentObjectiveId(14);
                }
                break;
            //Show credits
            case 14:
                if(game.getDialogueManager().isTalking()) break;
                //Roll credits
                game.getEventManager().setCreditsPlaying(true);
                game.getEventManager().showTransitionFrame(4000, "Credits: Thank you for playing!");
                game.getEventManager().showTransitionFrame(3000, "Credits: By Joren and Sam");
                game.getEventManager().showTransitionFrame(3000, "Credits: Artwork: pixanna.nl");
                game.getEventManager().showTransitionFrame(3000, "Credits: Sound: Youtube.com");
                game.getEventManager().showTransitionFrame(3000, "Credits: Special thanks to:");
                game.getEventManager().showTransitionFrame(2000, "Credits: Dr. Kris Aerts");
                game.getEventManager().showTransitionFrame(2000, "Credits: Dhr. Wouter Groeneveld");
                advanceCurrentObjectiveId(15);
                break;
            //End of credits
            case 15:
                if(!game.getEventManager().isInUse()){
                    game.getEventManager().setCreditsPlaying(false);
                }
                break;
            default:
                //If no matching objective id is found
                break;
        }
    }
    
    /**
     * @param currentObjectiveId the currentObjectiveId to set
     */
    public void advanceCurrentObjectiveId(int currentObjectiveId) {
        if(this.currentObjectiveId < currentObjectiveId){
            this.currentObjectiveId = currentObjectiveId;
        }
    }
    
    //Getters and Setters
    /**
     * @return the currentObjectiveId
     */
    public int getCurrentObjectiveId() {
        return currentObjectiveId;
    }

    /**
     * @param currentObjectiveId the currentObjectiveId to set
     */
    public void setCurrentObjectiveId(int currentObjectiveId) {
        this.currentObjectiveId = currentObjectiveId;
    }
}
