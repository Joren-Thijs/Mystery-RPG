/*
 * Game Cluedo
 * 
 *  @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects;

import game.model.Game;
import game.model.inventory.Item;
import game.model.inventory.Note;

/**
 *
 * @author Joren
 */
public class BookCase extends StaticGameObject {
    
    //Variables
    private Item item = new Item("Master bedroom key", 9);
    private Note note = new Note("I found the key", 9, "Note:", "I found the key to the master bedroom,"
                                                                + "\nnow we can find out the truth.");
    
    /**
     * Create a new BookCase
     * @param game
     * @param x
     * @param y
     * @param message
     */
    public BookCase(Game game, double x, double y, String message) {
        super(game, 9, x, y, 64, 128, message);
    }

    //Methods
    /**
     * Update the GameObject
     */
    @Override
    public void update() {
        
    }
    
    /**
     * When the Player wants to interact with the book case
     */
    @Override
    public void interact(){
        
        //Give the player an item
        if(!game.getWorldManager().getPlayer().getInventory().hasItem(item) &&
           !game.getWorldManager().getPlayer().getInventory().hasNote(note)){
            
            game.getWorldManager().getPlayer().getInventory().addItem(item);
            game.getWorldManager().getPlayer().getInventory().addNote(note);
            game.getEventManager().showMessage(1500, "You found the master bedroom key!");
            game.getEventManager().showMessage(1500, "You made a note");
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
