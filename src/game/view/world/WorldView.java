/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view.world;

import game.model.world.World;
import game.view.GameView;
import game.view.gameobjects.GameObjectViewManager;
import game.view.sprites.GameViewCamera;
import game.view.sprites.SpriteImages;
import javafx.scene.canvas.GraphicsContext;

/**
 * @author Joren and Sam
 */
public class WorldView {
    
    //Variabels
    private World world;
    private GameObjectViewManager gameObjectViewManager;
    private GameViewCamera gameViewCamera;
    int worldWidth;
    int worldHeight;
    private TileView[][] tileViews;
    
    /**
     * Create a new WorldView
     * @param world
     * @param gameViewCamera 
     * @param spriteImages 
     */
    public WorldView(World world, GameViewCamera gameViewCamera, SpriteImages spriteImages){
        this.world = world;
        worldWidth = world.getWidth();
        worldHeight = world.getHeight();
        this.gameViewCamera = gameViewCamera;
        gameObjectViewManager = new GameObjectViewManager(world.getGameObjectManager(), world.getGameCharacterManager(), gameViewCamera, spriteImages);
        tileViews = new TileView[worldWidth][worldHeight];
        for(int y = 0; y < worldHeight; y++){
            for(int x = 0; x < worldWidth; x++){
                tileViews[x][y] = new TileView(world.getTile(x, y), spriteImages);
            }
        }
    }
    
    //Methods
    /**
     * Render the WorldView
     * @param g 
     */
    public void render(GraphicsContext g){
        
        //Render map from left to right and top to bottom
        for(int y = 0; y < worldHeight; y++){
            for(int x = 0; x < worldWidth; x++){
                tileViews[x][y].render(g,
                                x * GameView.DEFAULT_TILEWIDTH - (int) gameViewCamera.getxOffset(),
                                y * GameView.DEFAULT_TILEHEIGHT - (int) gameViewCamera.getyOffset());
            }
        }
        
        //Render GameObjectViews
        gameObjectViewManager.render(g);
    }
    
    //Getters and Setters
    /**
     * returns the world
     * @return 
     */
    public World getWorld(){
        return world;
    }
}
