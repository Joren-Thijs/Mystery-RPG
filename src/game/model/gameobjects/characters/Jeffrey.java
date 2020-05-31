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
public class Jeffrey extends GameCharacter {
    
    //Variables
    
    /**
     * Create new Jeffrey
     * @param game
     * @param x
     * @param y 
     */
    public Jeffrey(Game game, double x, double y) {
        super(game, 8, x, y);
        direction = Direction.DOWN;
        collisionBox.setWidth(35);
        collisionBox.setHeight(21);
        speed = DEFAULT_SPEED;
    }
    
    //Methods
    /**
     * Update Jeffrey
     */
    @Override
    public void update() {
        updateAI();
    }
    
    /**
     * Update Jeffreys AI
     */
    private void updateAI(){
        if(game.getObjectivesManager().getCurrentObjectiveId() == 1){
            approachPlayerAndStartDialogue();
        } 
    }
    
    /**
     * Aproach the player
     */
    private void approachPlayerAndStartDialogue(){
        //Get position relative to player
        double PlayerX = game.getWorldManager().getPlayer().getX();
        double PlayerY = game.getWorldManager().getPlayer().getY();
        double relativeX = collisionBox.getX() - PlayerX;
        double relativeY = collisionBox.getY() - PlayerY;
        
        //Create distance vector
        double distance = Math.sqrt((relativeX*relativeX)+(relativeY*relativeY));
        
        //Reset status
        status = Status.STANDING;
        
        //Check if movement is necesarry
        if(distance >= 64){
            
            if(relativeX > 5){
                //go left
                move(-speed, 0);
                //Update direction
                direction = Direction.LEFT;
                //Update Status
                status = Status.WALKING;
            }
            else if(relativeX < -5){
                //go right
                move(speed, 0);
                //Update direction
                direction = Direction.RIGHT;
                //Update Status
                status = Status.WALKING;
            }
            else if(relativeY > 5){
                //go up
                move(0, -speed);
                //Update direction
                direction = Direction.UP;
                //Update Status
                status = Status.WALKING;
            }
            else if (relativeY < -5){
                //go down
                move(0, speed);
                //Update direction
                direction = Direction.DOWN;
                //Update Status
                status = Status.WALKING;
            }
            
        }
        else{
            //Start Dialogue
            game.getDialogueManager().startDialogue(id);
            
            //Orient Player towards Jeffrey
            //If we are right of the player
            if(relativeX > 5){
                if(Math.abs(relativeY) < Math.abs(relativeX)){
                    game.getWorldManager().getPlayer().setDirection(Direction.RIGHT);
                }
            }
            //If we are left of the player
            else if(relativeX < -5){
                if(Math.abs(relativeY) < Math.abs(relativeX)){
                    game.getWorldManager().getPlayer().setDirection(Direction.LEFT);
                }
            }    
            //If we are underneath the player
            if(relativeY > 5){
                if(Math.abs(relativeY) > Math.abs(relativeX)){
                    game.getWorldManager().getPlayer().setDirection(Direction.DOWN);
                }
            }
            //If we are above the player
            else if(relativeY < -5){
                if(Math.abs(relativeY) > Math.abs(relativeX)){
                    game.getWorldManager().getPlayer().setDirection(Direction.UP);
                }
            }
        }
    }
    
    /**
     * Interact with Jeffrey
     */
    @Override
    public void interact(){
        game.getDialogueManager().startDialogue(id);
    }
    
    //Getters and Setters
    
}
