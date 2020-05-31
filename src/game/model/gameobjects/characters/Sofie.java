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
public class Sofie extends GameCharacter {
    
    //Variables
    
    /**
     * Create a new Sofie
     * @param game
     * @param x
     * @param y 
     */
    public Sofie(Game game, double x, double y) {
        super(game, 2, x, y);
        direction = Direction.DOWN;
        collisionBox.setWidth(35);
        collisionBox.setHeight(21);
        speed = DEFAULT_SPEED;
    }
    
    //Methods
    /**
     * Update Sofie
     */
    @Override
    public void update() {
        
    }
    
    /**
     * Update Sofie's AI
     */
    private void updateAI(){
        
    }
    
    /**
     * Interact with Sofie
     */
    @Override
    public void interact(){
        game.getDialogueManager().startDialogue(id);
    }
    
    //Getters and Setters
    
}
