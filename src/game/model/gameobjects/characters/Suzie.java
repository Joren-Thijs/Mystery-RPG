/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects.characters;

import game.model.Game;

/**
 *
 * @author Joren and Sam
 */
public class Suzie extends GameCharacter {
    
    //Variables
    
    /**
     * Create a new Suzie
     * @param game
     * @param x
     * @param y 
     */
    public Suzie(Game game, double x, double y) {
        super(game, 3, x, y);
        direction = Direction.DOWN;
        collisionBox.setWidth(35);
        collisionBox.setHeight(21);
        speed = DEFAULT_SPEED;
    }
    
    //Methods
    /**
     * Update Suzie
     */
    @Override
    public void update() {
        
    }
    
    /**
     * Update Suzie's AI
     */
    private void updateAI(){
        
    }
    
    /**
     * Interact with Suzie
     */
    @Override
    public void interact(){
        game.getDialogueManager().startDialogue(id);
    }
    
    //Getters and Setters
    
}
