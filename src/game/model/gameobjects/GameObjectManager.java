/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joren and Sam
 */
public class GameObjectManager {
    
    //Variables
    private List<GameObject> gameObjects = new ArrayList<GameObject>();
    
    /**
     * Create a new GameObjectManager
     */
    public GameObjectManager(){
    }
    
    /**
     * Update all the GameObjects held by the manager
     */
    public void update(){
        for(GameObject gameObject : gameObjects){
            gameObject.update();
        }
    }
    
    /**
     * add a gameObject to the Manager
     * @param gameObject 
     */
    public void addGameObject(GameObject gameObject){
        gameObjects.add(gameObject);
    }
    
    /**
     * Remove a gameObject from the Manager
     * @param gameObject 
     */
    public void removeGameObject(GameObject gameObject){
        gameObjects.remove(gameObject);
    }
    
    /**
     * Return the list of GameObjects
     * @return 
     */
    public List<GameObject> getGameObjects(){
        return gameObjects;
    }
}
