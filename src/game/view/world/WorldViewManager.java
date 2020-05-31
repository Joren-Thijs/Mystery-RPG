/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view.world;

import game.model.gameobjects.characters.Player;
import game.model.world.World;
import game.model.world.WorldManager;
import game.view.sprites.GameViewCamera;
import game.view.sprites.SpriteImages;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Joren and Sam
 */
public class WorldViewManager {
    
    //Variables
    //List of WorldViews
    private List<WorldView> worldViews = new ArrayList<WorldView>();
    //GameViewCamera to calculate rendering offset
    private GameViewCamera gameViewCamera;
    //Player to pass on to the camera
    private Player player;
    
    /**
     * Create a new WorldViewManager
     * @param worldManager 
     * @param spriteImages 
     */
    public WorldViewManager(WorldManager worldManager, SpriteImages spriteImages){
        
        //Initialise GameCamera
        gameViewCamera = new GameViewCamera();
        //get Player
        player = worldManager.getPlayer();
        
        //Loop through the list of Worlds and create a worldView for each one
        for(World world : worldManager.getWorlds()){
            worldViews.add(new WorldView(world, gameViewCamera, spriteImages));
        }
    }
    
    //Methods
    /**
     * render the worldView
     * @param g 
     */
    public void render(GraphicsContext g){
        
        
        //Loop through WorldViews
        for(WorldView worldView: worldViews){
            //If game world is active
            if(worldView.getWorld().isActive()){
                
                //Calculate camera offset based on player position
                gameViewCamera.setCurrentWorld(worldView.getWorld());
                gameViewCamera.centerOnGameObject(player);
                
                //Render gameWorld
                worldView.render(g);
            }
        }
    }
    
    //Getters and Setters
    /**
     * @return the gameViewCamera
     */
    public GameViewCamera getGameViewCamera() {
        return gameViewCamera;
    }
}
