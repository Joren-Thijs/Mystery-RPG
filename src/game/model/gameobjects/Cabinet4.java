/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects;

import game.model.Game;
import game.model.inventory.Item;
import game.model.inventory.Note;

/**
 * @author Joren and Sam
 */
public class Cabinet4 extends StaticGameObject {
    
    //Variables
    private Note note = new Note("Letter to Jeffrey", 7, "Dear Jeffrey", "I know what you saw and would"
                                                        + "\nlike to keep it our secret"
                                                        + "\nwhen you are older you will undersand."
                                                        + "\nsigned H.");
    
    /**
     * Create a new Cabinet4
     * @param game
     * @param x
     * @param y
     * @param message 
     */
    public Cabinet4(Game game, double x, double y, String message) {
        super(game, 7, x, y, 64, 128, message);
    }

    //Methods
    /**
     * Update the GameObject
     */
    @Override
    public void update() {
        
    }
    
    /**
     * When the Player wants to interact with the cabinet
     */
    @Override
    public void interact(){
        
        //Give the player a note
        if(!game.getWorldManager().getPlayer().getInventory().hasNote(note)){
            
            game.getWorldManager().getPlayer().getInventory().addNote(note);
            game.getEventManager().showMessage(1500, "you found a letter");
        }
        else{
            super.interact();
        }
    }
    
    //Getters and Setters
    /**
     * @return the note
     */
    public Note getNote() {
        return note;
    }
}
