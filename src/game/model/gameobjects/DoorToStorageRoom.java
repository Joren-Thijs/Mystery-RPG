/*
 * Game Cluedo
 * 
 *  @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects;

import game.model.Game;
import game.model.inventory.Item;

/**
 *
 * @author Joren
 */
public class DoorToStorageRoom extends StaticGameObject{
        
    //Variables
    private Item requiredItem = new Item("key to storage room", 6);

    /**
     * Create a new Door to the bottom floor
     * @param game
     * @param x
     * @param y 
     * @param message 
     */
    public DoorToStorageRoom(Game game, double x, double y, String message) {
        super(game, 2, x, y, 60, 90, message);
    }

    //Methods
    /**
     * Update the gameObject
     */
    @Override
    public void update() {
        
    }
    
    /**
     * When the Player wants to interact with the door
     */
    @Override
    public void interact(){
        
        //If the player has the required item then unlock the door
        if(game.getWorldManager().getPlayer().getInventory().hasItem(requiredItem)){
            active = false;
            game.getEventManager().showMessage(1500, "You unlocked the door");
        }
        else{
            super.interact();
        }
    }
    
    //Getters and Setters

    /**
     * @return the requiredItem
     */
    public Item getRequiredItem() {
        return requiredItem;
    }
    
}
