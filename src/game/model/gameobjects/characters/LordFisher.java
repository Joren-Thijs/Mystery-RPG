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
public class LordFisher extends GameCharacter {
    
    //Variables
    
    /**
     * Create a new Lord Fisher
     * @param game
     * @param x
     * @param y 
     */
    public LordFisher(Game game, double x, double y) {
        super(game, 7, x, y);
        direction = Direction.DOWN;
        collisionBox.setWidth(35);
        collisionBox.setHeight(25);
        speed = DEFAULT_SPEED;
    }
    
    //Methods
    /**
     * Update Lord Fisher
     */
    @Override
    public void update() {
        
    }
    
    /**
     * Update Lord Fisher's AI
     */
    private void updateAI(){
        
    }
    
    @Override
    public void interact(){
        game.getDialogueManager().startDialogue(id);
    }
    
    //Getters and Setters
    
}
