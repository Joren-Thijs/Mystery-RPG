/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects;

import game.model.Game;
import game.model.gameobjects.characters.Direction;
import game.model.inventory.Item;

/**
 *
 * @author Joren and Sam
 */
public class DoorToSecondFloor extends StaticGameObject{
    //Variables
    private Item requiredItem = new Item("StairWay key", 0);
    private int targetWorld = 3;
    private double targetX = 205;
    private double targetY = 815;
    private Direction targetDirection = Direction.DOWN;

    /**
     * Create new door to second floor
     * @param game
     * @param x
     * @param y
     * @param message 
     */
    public DoorToSecondFloor(Game game, double x, double y, String message) {
        super(game, 0, x, y, 60, 90, message);
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
        
        //If the player does not have the key then this door will be locked
        if(game.getWorldManager().getPlayer().getInventory().hasItem(requiredItem)){
            //Teleport player to bottom floor:
            //Change active world
            game.getWorldManager().setWorld(targetWorld);
            //Change player position and orientation
            game.getWorldManager().getPlayer().setX(targetX);
            game.getWorldManager().getPlayer().setY(targetY);
            game.getWorldManager().getPlayer().setDirection(targetDirection);
        }
        else{
            super.interact();
        }
    }
    
    //Getters and Setters
    /**
     * @return the targetWorld
     */
    public int getTargetWorld() {
        return targetWorld;
    }

    /**
     * @return the targetX
     */
    public double getTargetX() {
        return targetX;
    }

    /**
     * @return the targetY
     */
    public double getTargetY() {
        return targetY;
    }

    /**
     * @return the targetDirection
     */
    public Direction getTargetDirection() {
        return targetDirection;
    }

    /**
     * @return the requiredItem
     */
    public Item getRequiredItem() {
        return requiredItem;
    }
    
}
