/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects.characters;

import game.model.Game;
import game.model.inventory.Item;

/**
 *
 * @author Joren and Sam
 */
public class Butler extends GameCharacter {
    
    //Variables
    
    /**
     * Create new Butler
     * @param game
     * @param x
     * @param y 
     */
    public Butler(Game game, double x, double y) {
        super(game, 1, x, y);
        direction = Direction.DOWN;
        collisionBox.setWidth(35);
        collisionBox.setHeight(21);
        speed = DEFAULT_SPEED;
    }
    
    //Methods
    /**
     * Update the butler
     */
    @Override
    public void update() {
        
    }
    
    /**
     * update the butler AI
     */
    private void updateAI(){
        
    }
    
    /**
     * @return the Butler in String format
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        
        builder.append("Butler:\n");
        
        //Print his position
        builder.append("Position:\n");
        builder.append("X: " + collisionBox.getX() + "\n");
        builder.append("Y: " + collisionBox.getY() + "\n");
        
        //Print his direction
        builder.append("Direction: " + "\n" + direction.toString() + "\n");

        return builder.toString();
    }
    
    /**
     * Interact with the butler
     */
    @Override
    public void interact(){
        game.getDialogueManager().startDialogue(id);
    }
    
    //Getters and Setters
    
}
