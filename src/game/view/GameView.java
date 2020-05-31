/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view;

import game.model.Game;
import game.view.dialogue.DialogueViewManager;
import game.view.events.EventViewManager;
import game.view.inventory.InventoryView;
import game.view.sprites.SpriteImages;
import game.view.world.WorldViewManager;
import javafx.scene.canvas.GraphicsContext;

/**
 * Main View class
 * @author Joren and Sam
 */
public class GameView {
    
    //Variables
    //GameView
    private Game game;
    private double width;
    private double height;
    
    //Sprite Images
    private SpriteImages spriteImages;
    
    //ViewManagers
    private WorldViewManager worldViewManager;
    private DialogueViewManager dialogueViewManager;
    private EventViewManager eventViewManager;
    private InventoryView inventoryView;
    
    //DEFAULT VALUES:
    //Resolution
    public static final int DEFAULT_WIDTH = 1024;
    public static final int DEFAULT_HEIGHT = 768;
    //TileWidth
    public static final int DEFAULT_TILEWIDTH = 64;
    public static final int DEFAULT_TILEHEIGHT = 64;
    //GameObjectSize
    public static final int DEFAULT_GAMEOBJECTWIDTH = 64;
    public static final int DEFAULT_GAMEOBJECTHEIGHT = 64;
    
    /**
     * Create a new GameView
     * @param game
     * @param width
     * @param height 
     */
    public GameView(Game game, double width, double height){
        this.game = game;
        this.width = width;
        this.height = height;
        
        //Load in sprite images
        spriteImages = new SpriteImages();
        
        //set worldViewManager
        worldViewManager = new WorldViewManager(game.getWorldManager(), spriteImages);
        dialogueViewManager = new DialogueViewManager(game.getDialogueManager());
        eventViewManager = new EventViewManager(game.getEventManager(), width, height);
        inventoryView = new InventoryView(game);
    }
    
    //Methods
    /**
     * render the gameView
     * @param g 
     */
    public void render(GraphicsContext g){
        //Clear Canvas
        g.clearRect(0, 0, width, height);
        
        //Draw stuff
        worldViewManager.render(g);
        dialogueViewManager.render(g);
        inventoryView.render(g);
        eventViewManager.render(g);
        
        //End drawing
    }
    
    //Getters and Setters
    /**
     * Set the game
     * @param game the Game to be set
     */
    public void setGame(Game game){
        this.game = game;
    }
}
