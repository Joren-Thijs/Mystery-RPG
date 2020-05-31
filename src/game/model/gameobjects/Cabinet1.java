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
public class Cabinet1 extends StaticGameObject {

    //Variables
    private Item item = new Item("Bottle of Wine", 4);
    private Note note = new Note("Poisoned wine?", 4, "Note:", "I found the botlle of wine"
                                                                + "\nthat was being served at the dinner"
                                                                + "\nbut it has no poison in it. Could"
                                                                + "\nit be that someone poisoned Jeffreys"
                                                                + "\nglass?");

    /**
     * Create a new Cabinet1
     * @param game
     * @param x
     * @param y
     * @param message 
     */
    public Cabinet1(Game game, double x, double y, String message) {
        super(game, 4, x, y, 64, 128, message);
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
        
        //Give the player an item
        if(!game.getWorldManager().getPlayer().getInventory().hasItem(item) &&
           !game.getWorldManager().getPlayer().getInventory().hasNote(note)){
            
            game.getWorldManager().getPlayer().getInventory().addItem(item);
            game.getWorldManager().getPlayer().getInventory().addNote(note);
            game.getEventManager().showMessage(1500, "You found a bottle of wine.");
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
