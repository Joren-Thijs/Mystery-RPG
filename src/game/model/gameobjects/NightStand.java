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
public class NightStand extends StaticGameObject {
    //Variables
    private Item item1 = new Item("Ville of poison", 8);
    private Item item2 = new Item("Brown cuffling", 10);
    private Note note = new Note("Poison note", 8, "Note:", "I found a ville of poison in Lord"
                                                            + "\nFishers nightstand. This points to "
                                                            + "\nhim as the murderer. except I"
                                                            + "\nalso found this brown cuffling"
                                                            + "\nwich does not match the"
                                                            + "\nblack ones he is wearing"
                                                            + "\n\nI am not sure about this...");
    
    /**
     * Create a new NightStand
     * @param game
     * @param x
     * @param y
     * @param message
     */
    public NightStand(Game game, double x, double y, String message) {
        super(game, 8, x, y, 50, 50, message);
    }

    //Methods
    /**
     * Update the GameObject
     */
    @Override
    public void update() {
        
    }
    
    /**
     * When the Player wants to interact with the nightstand
     */
    @Override
    public void interact(){
        
        //Give the player an item
        if(!game.getWorldManager().getPlayer().getInventory().hasItem(item1) &&
            !game.getWorldManager().getPlayer().getInventory().hasItem(item2) &&
           !game.getWorldManager().getPlayer().getInventory().hasNote(note)){
            
            game.getWorldManager().getPlayer().getInventory().addItem(item1);
            game.getWorldManager().getPlayer().getInventory().addItem(item2);
            game.getWorldManager().getPlayer().getInventory().addNote(note);
            game.getEventManager().showMessage(1500, "You found a vile of poison");
            game.getEventManager().showMessage(1500, "You found a brown cuffling");
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
    public Item[] getItems() {
        Item[] items = new Item[2];
        items[0] = item1;
        items[1] = item2;
        return items;
    }

    /**
     * @return the note
     */
    public Note getNote() {
        return note;
    }
}
