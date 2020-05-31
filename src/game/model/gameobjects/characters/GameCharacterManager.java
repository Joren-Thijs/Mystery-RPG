/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects.characters;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joren and Sam
 */
public class GameCharacterManager {
    
    //Variables
    private List<GameCharacter> gameCharacters = new ArrayList<GameCharacter>();
    private Player player;
    
    /**
     * Create a new CharacterManager
     * @param player 
     */
    public GameCharacterManager(Player player){
        this.player = player;
        gameCharacters.add(player);
    }
    
    /**
     * Update all the Characters held by the manager
     */
    public void update(){
        for(GameCharacter character : gameCharacters){
            character.update();
        }
    }
    
    /**
     * add a character to the Manager 
     * @param gameCharacter
     */
    public void addGameCharacter(GameCharacter gameCharacter){
        gameCharacters.add(gameCharacter);
    }
    
    /**
     * Remove a character from the Manager 
     * @param gameCharacter
     */
    public void removeGameCharacter(GameCharacter gameCharacter){
        gameCharacters.remove(gameCharacter);
    }
    
    /**
     * Returns the gameCharacter with matching ID from the GameCharacterManager
     * @param id
     * @return 
     */
    public GameCharacter getGameCharacterWithId(int id){
        for(GameCharacter character : gameCharacters){
            if(character.getId() == id){
                return character;
            }
        }
        return null;
    }
    
    /**
     * orients the gameCharacter with matching ID towards the player
     * @param id 
     */
    public void orientGameCharacterWithIdTowardsPlayer(int id){

        for(GameCharacter character : gameCharacters){
            if(character.getId() == id){
                //Get position relative to player
                double relativeX = character.getCollisionBox().getX() - player.getX();
                double relativeY = character.getCollisionBox().getY() - player.getY();
                
                //Orient GameCharacter towards player
                //If we are right of the player
                if(relativeX > 5){
                    if(Math.abs(relativeY) < Math.abs(relativeX)){
                        character.setDirection(Direction.LEFT);
                    }
                }
                //If we are left of the player
                else if(relativeX < -5){
                    if(Math.abs(relativeY) < Math.abs(relativeX)){
                        character.setDirection(Direction.RIGHT);
                    }
                }    
                //If we are underneath the player
                if(relativeY > 5){
                    if(Math.abs(relativeY) > Math.abs(relativeX)){
                        character.setDirection(Direction.UP);
                    }
                }
                //If we are above the player
                else if(relativeY < -5){
                    if(Math.abs(relativeY) > Math.abs(relativeX)){
                        character.setDirection(Direction.DOWN);
                    }
                }
            }
        } 
    }
    
    //Getters and Setters
    /**
     * 
     * @return 
     */
    public Player getPlayer(){
        return player;
    }
    
    /**
     * Return the list of Characters
     * @return 
     */
    public List<GameCharacter> getGameCharacters(){
        return gameCharacters;
    }
    
}
