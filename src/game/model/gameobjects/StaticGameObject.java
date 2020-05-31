/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects;

import game.model.Game;

/**
 * @author Joren and Sam
 */
public class StaticGameObject extends GameObject {

    //Variables
    private String message;
    
    /**
     * Create a new StaticGameObject
     * @param game
     * @param x
     * @param y
     * @param id 
     * @param width 
     * @param height 
     * @param message
     */
    public StaticGameObject(Game game, int id, double x, double y, double width, double height, String message) {
        super(game, id, x, y);
        collisionBox.setWidth(width);
        collisionBox.setHeight(height);
        this.message = message;
    }
    
    //Methods
    /**
     * Update the GameObject
     */
    @Override
    public void update() {
        
    }
    
    /**
     * When the Player wants to interact with the object
     */
    @Override
    public void interact(){
        
        //If the message is empty then dont display it
        if(message.equalsIgnoreCase("")) return;
        
        game.getEventManager().showMessage(2000, "", message);
    }
    
    //Getters and Setters
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
}
