/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects.characters;

import game.model.Game;

/**
 *
 * @author Joren
 */
public class LadyFisher extends GameCharacter {
    
    //Variables
    
    /**
     * Create a new Lady Fisher
     * @param game
     * @param x
     * @param y 
     */
    public LadyFisher(Game game, double x, double y) {
        super(game, 6, x, y);
        direction = Direction.DOWN;
        collisionBox.setWidth(35);
        collisionBox.setHeight(21);
        speed = DEFAULT_SPEED;
    }
    
    //Methods
    /**
     * update Lady Fisher
     */
    @Override
    public void update() {
        
    }
    
    /**
     * Update Lady Fisher's AI
     */
    private void updateAI(){
        
    }
    
    /**
     * Interact with Lady Fisher
     */
    @Override
    public void interact(){
        game.getDialogueManager().startDialogue(id);
    }
    
    //Getters and Setters
    
}
