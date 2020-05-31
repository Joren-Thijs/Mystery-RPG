
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view.graphics;

import java.io.File;
import java.nio.file.Files;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.nio.file.Paths;
import javafx.scene.image.Image;

/**
 * Class containing static Arraylists of images for rendering
 * @author Joren and Sam
 */
public class SpriteImages {

    //DEFAULT VALUES:
    //Standard width and height of individual sprites on our spritesheet (in pixels)
    private static final int WIDTH = 32,
                             HEIGHT = 32;
    
    public static final int DEFAULT_TILEWIDTH = 64;
    public static final int DEFAULT_TILEHEIGHT = 64;
    
    public static final int DEFAULT_GAMEOBJECTWIDTH = 64;
    public static final int DEFAULT_GAMEOBJECTHEIGHT = 64;
    
    public static final int DEFAULT_GAMECHARACTERWIDTH = 64;
    public static final int DEFAULT_GAMECHARACTERHEIGHT = 64;
    
    //Variables
    //SpriteSheets:
    //<editor-fold defaultstate="collapsed" desc="SpriteSheets">
    //Tiles:
    private static SpriteSheet sheet;
    private static SpriteSheet chessTile;
    
    //GameObjects:
    
    //GameCharacters:
    private static SpriteSheet playerSheet;
    private static SpriteSheet basicSheet;
    private static SpriteSheet foxSheet;
    //</editor-fold>
    
    //Sprites:
    //<editor-fold defaultstate="collapsed" desc="Sprites">
    //Tiles:
    private static Sprite grass,
            sand,
            stone,
            water,
            chess;
    
    //GameObjects:
    public static Sprite fox;
    private static Sprite cactus,
            flowers,
            bush,
            tree,
            rock,
            wood;
    //Game Characters:
    //Animation frames:
    private static Sprite[] player_down, player_up, player_left, player_right;
    private static Sprite[] butler_down, butler_up, butler_left, butler_right;
    private static Sprite[] messenger_down, messenger_up, messenger_left, messenger_right;
    //</editor-fold>
    
    //Final ArrayLists:
    //<editor-fold defaultstate="collapsed" desc="Final ArrayLists">
    //Tiles:
    private static Sprite[] tileTextures = new Sprite[256];
    
    //GameObjects:
    private static Sprite[] gameObjectTextures = new Sprite[256];
    
    //GameCharacters:
    private static Sprite[][][] gameCharacterTextures = new Sprite[256][4][];
    //</editor-fold>

    //Methods
    /**
    * Load and initialize the SpriteImages
    */
    public static void initialize(){
       
        //Load Spritesheets
        //<editor-fold defaultstate="collapsed" desc="Load SpriteSheets">
        //Tiles
        sheet = new SpriteSheet(loadImage("artwork/textures/tiles/tiles.png"));
        chessTile = new SpriteSheet(loadImage("artwork/textures/tiles/ChessTile.png"));

        //GameObjects

        //GameCharacters
        playerSheet = new SpriteSheet(loadImage("artwork/textures/gamecharacters/hero.png"));
        basicSheet = new SpriteSheet(loadImage("artwork/textures/gamecharacters/sheet.png"));
        foxSheet = new SpriteSheet(loadImage("artwork/textures/gameobjects/fox.png"));
        //</editor-fold>

        //Crop SpriteImages from Spritesheet:
        
        //Explenation:
        //new Sprite(spriteSheet, x, y, width, height, Xrel, Yrel)
        
        //Spritesheet = the sheet the sprite is located on
        //x = x position of the top left corner of the Sprite on the spriteSheet
        //y = y position of the top left corner of the Sprite on the spriteSheet
        //width = width of the sprite on the spriteSheet
        //height = height of the sprite on the spriteSheet
        //Xrel = X relationship between the top left corner of the Sprite and the top left corner of the collisionBox
        //Yrel = Y relationship between the top left corner of the Sprite and the top left corner of the collisionBox
        //targetWidth = the width the sprite has to be drawn at
        //targetHeight = the height the sprite has to be drawn at
        
        //Tiles
        grass = new Sprite(sheet, WIDTH, 2*HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH, DEFAULT_TILEHEIGHT);
        sand = new Sprite(sheet, 4*WIDTH, 6*HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH, DEFAULT_TILEHEIGHT);
        stone = new Sprite(sheet, 4*WIDTH, 3*HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH, DEFAULT_TILEHEIGHT);
        water = new Sprite(sheet, 5*WIDTH, 21*HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH, DEFAULT_TILEHEIGHT);
        chess = new Sprite(chessTile, 0, 0, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH, DEFAULT_TILEHEIGHT);
        
        //GameObjects
        fox = new Sprite(foxSheet, 0, 0, WIDTH, HEIGHT, 0, 0, DEFAULT_GAMEOBJECTWIDTH, DEFAULT_GAMEOBJECTHEIGHT);
        cactus = new Sprite(sheet, 0, 11*HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_GAMEOBJECTWIDTH, DEFAULT_GAMEOBJECTHEIGHT);
        flowers = new Sprite(sheet, 2*WIDTH, 10*HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_GAMEOBJECTWIDTH, DEFAULT_GAMEOBJECTHEIGHT);
        bush = new Sprite(sheet, 3*WIDTH, 11*HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_GAMEOBJECTWIDTH, DEFAULT_GAMEOBJECTHEIGHT);
        tree = new Sprite(basicSheet, 0, 0, WIDTH, 2*HEIGHT, 0, 0, DEFAULT_GAMEOBJECTWIDTH, DEFAULT_GAMEOBJECTHEIGHT);
        rock = new Sprite(basicSheet, 0, 2*HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_GAMEOBJECTWIDTH, DEFAULT_GAMEOBJECTHEIGHT);
        wood = new Sprite(basicSheet, WIDTH, HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_GAMEOBJECTWIDTH, DEFAULT_GAMEOBJECTHEIGHT);
        
        //Initialize Animations: (has to happen before cropping)
        //Game Characters
        //PLayer
        player_down = new Sprite[4];
        player_up = new Sprite[4];
        player_left = new Sprite[4];
        player_right = new Sprite[4];

        //Butler
        butler_down = new Sprite[2];
        butler_up = new Sprite[2];
        butler_left = new Sprite[2];
        butler_right = new Sprite[2];
        
        //Messenger
        
        
        //Crop Animations from Spritesheet
        //GameCharacters
        //Player
        player_up[0] = new Sprite(playerSheet, 0 * WIDTH, 0, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        player_up[1] = new Sprite(playerSheet, 1 * WIDTH, 0, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        player_up[2] = new Sprite(playerSheet, 2 * WIDTH, 0, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        player_up[3] = new Sprite(playerSheet, 3 * WIDTH, 0, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        player_down[0] = new Sprite(playerSheet, 4 * WIDTH, 0, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        player_down[1] = new Sprite(playerSheet, 5 * WIDTH, 0, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        player_down[2] = new Sprite(playerSheet, 6 * WIDTH, 0, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        player_down[3] = new Sprite(playerSheet, 7 * WIDTH, 0, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        player_left[0] = new Sprite(playerSheet, 0 * WIDTH, HEIGHT, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        player_left[1] = new Sprite(playerSheet, 1 * WIDTH, HEIGHT, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        player_left[2] = new Sprite(playerSheet, 2 * WIDTH, HEIGHT, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        player_left[3] = new Sprite(playerSheet, 3 * WIDTH, HEIGHT, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        player_right[0] = new Sprite(playerSheet, 4 * WIDTH, HEIGHT, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        player_right[1] = new Sprite(playerSheet, 5 * WIDTH, HEIGHT, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        player_right[2] = new Sprite(playerSheet, 6 * WIDTH, HEIGHT, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        player_right[3] = new Sprite(playerSheet, 7 * WIDTH, HEIGHT, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        
        //Butler
        butler_up[0] = new Sprite(basicSheet, 6 * WIDTH, 2*HEIGHT, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        butler_up[1] = new Sprite(basicSheet, 7 * WIDTH, 2*HEIGHT, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        butler_down[0] = new Sprite(basicSheet, 4 * WIDTH, 2*HEIGHT, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        butler_down[1] = new Sprite(basicSheet, 5 * WIDTH, 2*HEIGHT, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        butler_left[0] = new Sprite(basicSheet, 6 * WIDTH, 3*HEIGHT, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        butler_left[1] = new Sprite(basicSheet, 7 * WIDTH, 3*HEIGHT, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        butler_right[0] = new Sprite(basicSheet, 4 * WIDTH, 3*HEIGHT, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        butler_right[1] = new Sprite(basicSheet, 5 * WIDTH, 3*HEIGHT, WIDTH, HEIGHT, 20, 38, DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        
        //Put Sprites into Texture Arrays
        //Put Tiletextures into array (tileTextures[ID])
        tileTextures[0] = grass;
        tileTextures[1] = sand;
        tileTextures[2] = stone;
        tileTextures[3] = water;
        tileTextures[4] = chess;
        
        //Put GameObject textures into array (gameObjectTextures[ID])
        gameObjectTextures[0] = fox;
        
        //Put game Character animations into array (gameCharacterTextures[ID][Direction])
        gameCharacterTextures[0][0] = player_up;
        gameCharacterTextures[0][1] = player_down;
        gameCharacterTextures[0][2] = player_left;
        gameCharacterTextures[0][3] = player_right;
        gameCharacterTextures[1][0] = butler_up;
        gameCharacterTextures[1][1] = butler_down;
        gameCharacterTextures[1][2] = butler_left;
        gameCharacterTextures[1][3] = butler_right;
        
    }
    
    /**
     * Load an image from a file
     * @param path
     * @return 
     */
    public static Image loadImage(String path){
        //Testcode:
        if(Files.exists(Paths.get(path), NOFOLLOW_LINKS)){
            System.out.println("File found:" + "   " + path);
        } else{
            System.out.println("File not found:" + "   " + path);
        }
        
        //Create new file from path
        File file = new File(path);
        //Load iamge from file
        return new Image(file.toURI().toString());
    }
    
    //Getters and Setters
    /**
     * Returns the array that holds the Tile images
     * @return 
     */
    public static Sprite[] getTileTextures(){
        return tileTextures;
    }
    
    /**
     * Returns the array that holds the static GameObject images
     * @return 
     */
    public static Sprite[] getGameObjectTextures(){
        return gameObjectTextures;
    }
    
    /**
     * Returns the array that holds the Creature animation frames
     * @return 
     */
    public static Sprite[][][] getGameCharacterTextures(){
        return gameCharacterTextures;
    }
}
