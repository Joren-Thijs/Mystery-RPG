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
public class Violet extends GameCharacter {
    
    //Variables
    
    /**
     * Create a new Violet
     * @param game
     * @param x
     * @param y 
     */
    public Violet(Game game, double x, double y) {
        super(game, 5, x, y);
        direction = Direction.DOWN;
        collisionBox.setWidth(35);
        collisionBox.setHeight(21);
        speed = DEFAULT_SPEED;
    }
    
    //Methods
    /**
     * Update Violet
     */
    @Override
    public void update() {
        
    }
    
    /**
     * Update Violet's AI
     */
    private void updateAI(){
        
    }
    
    /**
     * Interact with Violet
     */
    @Override
    public void interact(){
        game.getDialogueManager().startDialogue(id);
    }
    
    //Getters and Setters
    
}
