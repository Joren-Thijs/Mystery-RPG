/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects.characters;

import game.model.Game;

/**
 * @author Joren and Sam
 */
public class Jonny extends GameCharacter {
    
    //Variables
    
    /**
     * Create a new Jonny
     * @param game
     * @param x
     * @param y
     */
    public Jonny(Game game, double x, double y) {
        super(game, 4, x, y);
        direction = Direction.DOWN;
        collisionBox.setWidth(35);
        collisionBox.setHeight(21);
        speed = DEFAULT_SPEED;
    }
    
    //Methods
    /**
     * Update Jonny
     */
    @Override
    public void update() {
        
    }
    
    /**
     * Update Jonny's AI
     */
    private void updateAI(){
        
    }
    
    /**
     * Interact with Jonny
     */
    @Override
    public void interact(){
        game.getDialogueManager().startDialogue(id);
    }
    
    //Getters and Setters
    
}
