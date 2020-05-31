/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects;

import game.model.Game;
import game.model.gameobjects.characters.Direction;

/**
 *
 * @author Joren and Sam
 */
public class DoorToBottomFloor extends GameObject {

    //Variables
    private int targetWorld = 2;
    private double targetX = 205;
    private double targetY = 665;
    private Direction targetDirection = Direction.DOWN;
    
    /**
     * Create a new Door to the bottom floor
     * @param game
     * @param x
     * @param y 
     */
    public DoorToBottomFloor(Game game, double x, double y) {
        super(game, 1, x, y);
        collisionBox.setWidth(60);
        collisionBox.setHeight(90);
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
        //Teleport player to bottom floor:
        //Change active world
        game.getWorldManager().setWorld(targetWorld);
        //Change player position and orientation
        game.getWorldManager().getPlayer().setX(targetX);
        game.getWorldManager().getPlayer().setY(targetY);
        game.getWorldManager().getPlayer().setDirection(targetDirection);
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
    
}
