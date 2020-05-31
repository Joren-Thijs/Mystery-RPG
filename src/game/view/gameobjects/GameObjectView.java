/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view.gameobjects;

import game.model.gameobjects.GameObject;
import game.view.sprites.SpriteImages;
import game.view.sprites.GameViewCamera;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Joren and Sam
 */
public class GameObjectView {
    
    private int temp = 1;
    
    //Variables
    protected GameObject gameObject;
    protected GameViewCamera gameViewCamera;
    protected SpriteImages spriteImages;
    
    /**
     * Create a new GameObjectView
     * @param gameObject
     * @param gameViewCamera 
     * @param spriteImages 
     */
    public GameObjectView(GameObject gameObject, GameViewCamera gameViewCamera, SpriteImages spriteImages) {
        this.gameObject = gameObject;
        this.gameViewCamera = gameViewCamera;
        this.spriteImages = spriteImages;
    }
    
    //Methods
    /**
     * render the GameObject
     * @param g 
     */
    public void render(GraphicsContext g){

        //Render the image
        spriteImages.getGameObjectTextures()[gameObject.getId()].render(g,
                                                                        gameObject.getX() - gameViewCamera.getxOffset(),
                                                                        gameObject.getY() - gameViewCamera.getyOffset());
        //Testcode
        if(temp==0){
            
            //Render the objects collisionBox
            g.setStroke(Color.RED);
            g.strokeRect(gameObject.getCollisionBox().getX() - gameViewCamera.getxOffset(),
                       gameObject.getCollisionBox().getY() - gameViewCamera.getyOffset(),
                       gameObject.getCollisionBox().getWidth(),
                       gameObject.getCollisionBox().getHeight());
        }
    }
    
    //Getters and Setters
    /**
     * @return 
     */
    public GameObject getGameObject(){
        return gameObject;
    }
}
