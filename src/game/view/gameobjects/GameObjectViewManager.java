/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view.gameobjects;

import game.model.gameobjects.GameObject;
import game.model.gameobjects.GameObjectManager;
import game.model.gameobjects.characters.GameCharacter;
import game.model.gameobjects.characters.GameCharacterManager;
import game.view.sprites.GameViewCamera;
import game.view.sprites.SpriteImages;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Joren and Sam
 */
public class GameObjectViewManager {
    
    //Variables
    //List of GameObjectViews
    private List<GameObjectView> gameObjectViews = new ArrayList<GameObjectView>();

    /**
     * Create a new GameObjectView Manager
     * @param gameObjectManager
     * @param gameCharacterManager
     * @param gameViewCamera 
     * @param spriteImages 
     */
    public GameObjectViewManager(GameObjectManager gameObjectManager, GameCharacterManager gameCharacterManager, GameViewCamera gameViewCamera, SpriteImages spriteImages) {
        //add views for all the static Game Objects
        for(GameObject gameObject : gameObjectManager.getGameObjects()){
            gameObjectViews.add(new GameObjectView(gameObject, gameViewCamera, spriteImages));
        }
        
        for(GameCharacter gameCharacter : gameCharacterManager.getGameCharacters()){
            gameObjectViews.add(new GameCharacterView(gameCharacter, gameViewCamera, spriteImages));
        } 
    }
    
    //Methods
    /**
     * render the GameObjects
     * @param g 
     */
    public void render(GraphicsContext g){
        
        //sort gameObjects on Y-pos before rendering
        Collections.sort(
                gameObjectViews, //List that has to be sorted
                (gameObjectView1, gameObjectView2) -> //Two temporary variables to hold the GameObject views that are being compared
                        
                //Equation that subtracts two gameObjects bottom Y-coordinate from the other.
                //If it returns -1 the two objects switch places in the list
                //so that the objects that are closer tot the top of the gameworld are rendered first so eveything is nicely on top of each other
                (int) (gameObjectView1.getGameObject().getY() + gameObjectView1.getGameObject().getCollisionBox().getHeight()) -
                (int) (gameObjectView2.getGameObject().getY() + gameObjectView2.getGameObject().getCollisionBox().getHeight()));
        
        //Loop through the list of gameObject views and render them
        for(GameObjectView gameObjectView : gameObjectViews){
            //If the game object is active
            if(gameObjectView.getGameObject().isActive()){
                //Render the gameObjectView
                gameObjectView.render(g);
            }
        }
    }
    
    //Getters and Setters
    
}
