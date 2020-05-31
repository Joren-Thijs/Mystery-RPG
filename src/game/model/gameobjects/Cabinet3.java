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
public class Cabinet3 extends StaticGameObject {
    
    //Variables
    private Item item = new Item("key to storage room", 6);
    private Note note = new Note("Storage room", 6, "Note:", "I found the key to the storage room"
                                                        + "\n maybe i should have a look in there");
    
    /**
     * Create a new Cabinet3
     * @param game
     * @param x
     * @param y
     * @param message 
     */
    public Cabinet3(Game game, double x, double y, String message) {
        super(game, 6, x, y, 64, 128, message);
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
    public void interact(){
        
        //Give the player an item
        if(!game.getWorldManager().getPlayer().getInventory().hasItem(item) &&
           !game.getWorldManager().getPlayer().getInventory().hasNote(note)){
            
            game.getWorldManager().getPlayer().getInventory().addItem(item);
            game.getWorldManager().getPlayer().getInventory().addNote(note);
            game.getEventManager().showMessage(2500, "You found the storage room key!");
            game.getEventManager().showMessage(2500, "You made a note");
        }
        else{
            super.interact();
        }
    }
    
    //Getters and Setters
    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @return the note
     */
    public Note getNote() {
        return note;
    }
}
