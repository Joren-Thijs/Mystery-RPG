/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.world;

import game.model.Game;
import game.model.gameobjects.BookCase;
import game.model.gameobjects.Cabinet1;
import game.model.gameobjects.Cabinet2;
import game.model.gameobjects.Cabinet3;
import game.model.gameobjects.Cabinet4;
import game.model.gameobjects.DoorToBottomFloor;
import game.model.gameobjects.DoorToMasterBedroom;
import game.model.gameobjects.DoorToSecondFloor;
import game.model.gameobjects.DoorToStorageRoom;
import game.model.gameobjects.GameObjectManager;
import game.model.gameobjects.NightStand;
import game.model.gameobjects.StaticGameObject;
import game.model.gameobjects.characters.Butler;
import game.model.gameobjects.characters.GameCharacterManager;
import game.model.gameobjects.characters.Jeffrey;
import game.model.gameobjects.characters.Jonny;
import game.model.gameobjects.characters.LadyFisher;
import game.model.gameobjects.characters.LordFisher;
import game.model.gameobjects.characters.Player;
import game.model.gameobjects.characters.Sofie;
import game.model.gameobjects.characters.Suzie;
import game.model.gameobjects.characters.Violet;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Joren and Sam
 */
public class World {

    // Variables
    private Game game;
    private int width, height;
    private int[][] tiles;
    private boolean active;

    // GameObjects
    private final GameObjectManager gameObjectManager;
    private final GameCharacterManager gameCharacterManager;
    private TileManager tileManager;

    /**
     * Create a new World
     * 
     * @param game
     * @param worldPath
     * @param player
     */
    public World(Game game, String worldPath, Player player) {
        this.game = game;
        tileManager = new TileManager();
        gameObjectManager = new GameObjectManager();
        gameCharacterManager = new GameCharacterManager(player);
        loadWorld(worldPath + "_world.txt");
        loadGameObjects(worldPath + "_gameobjects.txt");
    }

    // Methods
    /**
     * Update the world
     */
    public void update() {
        gameObjectManager.update();
        gameCharacterManager.update();
    }

    /**
     * Load the world from a file at path worldPath
     * 
     * @param worldPath
     */
    private void loadWorld(String worldPath) {

        String file = loadFileAsString(worldPath);
        if (file == null)
            return;

        // Split the String around any whitespace
        String[] tileIds = file.split("\\s+");

        // load the main world data
        width = Integer.parseInt(tileIds[0]);
        height = Integer.parseInt(tileIds[1]);

        // load the main world
        tiles = new int[getWidth()][getHeight()];

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                // (x + y * width)=conversion from 2D array to 1D array
                // and + 2 because our first 2 tileIds are world size
                tiles[x][y] = Integer.parseInt(tileIds[(x + y * getWidth()) + 2]);
            }
        }
    }

    private void loadGameCharacters(int id, double spawnX, double spawnY) {
        switch (id) {
            case 0:
                // id 0 = Player
                break;
            case 1:
                // id 1 = Butler
                gameCharacterManager.addGameCharacter(new Butler(game, spawnX, spawnY));
                break;
            case 2:
                // id 2 = Sofie
                gameCharacterManager.addGameCharacter(new Sofie(game, spawnX, spawnY));
                break;
            case 3:
                // id 3 = Suzie
                gameCharacterManager.addGameCharacter(new Suzie(game, spawnX, spawnY));
                break;
            case 4:
                // id 4 = Jonny
                gameCharacterManager.addGameCharacter(new Jonny(game, spawnX, spawnY));
                break;
            case 5:
                // id 5 = Violet
                gameCharacterManager.addGameCharacter(new Violet(game, spawnX, spawnY));
                break;
            case 6:
                // id 6 = Lady Fisher
                gameCharacterManager.addGameCharacter(new LadyFisher(game, spawnX, spawnY));
                break;
            case 7:
                // id 7 = Lord Fisher
                gameCharacterManager.addGameCharacter(new LordFisher(game, spawnX, spawnY));
                break;
            case 8:
                // id 8 = Jeffrey
                gameCharacterManager.addGameCharacter(new Jeffrey(game, spawnX, spawnY));
                break;
            default:
                break;
        }
    }

    private void loadStoryGameObjects(int id, double spawnX, double spawnY, String message) {
        switch (id) {
            case 0:
                // id 0 = Door to second floor
                gameObjectManager.addGameObject(new DoorToSecondFloor(game, spawnX, spawnY, message));
                break;
            case 1:
                // id 1 = Door to bottom floor
                gameObjectManager.addGameObject(new DoorToBottomFloor(game, spawnX, spawnY));
                break;
            case 2:
                // id 2 = Door to master bedroom
                gameObjectManager.addGameObject(new DoorToMasterBedroom(game, spawnX, spawnY, message));
                break;
            case 3:
                // id 3 = Door to storage bedroom
                gameObjectManager.addGameObject(new DoorToStorageRoom(game, spawnX, spawnY, message));
                break;
            case 4:
                // id 4 = Cabinet 1
                gameObjectManager.addGameObject(new Cabinet1(game, spawnX, spawnY, message));
                break;
            case 5:
                // id 5 = Cabinet 2
                gameObjectManager.addGameObject(new Cabinet2(game, spawnX, spawnY, message));
                break;
            case 6:
                // id 6 = Cabinet 3
                gameObjectManager.addGameObject(new Cabinet3(game, spawnX, spawnY, message));
                break;
            case 7:
                // id 7 = Cabinet 4
                gameObjectManager.addGameObject(new Cabinet4(game, spawnX, spawnY, message));
                break;
            case 8:
                // id 8 = NightStand
                gameObjectManager.addGameObject(new NightStand(game, spawnX, spawnY, message));
                break;
            case 9:
                // id 9 = Book case
                gameObjectManager.addGameObject(new BookCase(game, spawnX, spawnY, message));
                break;
            default:
                break;
        }
    }

    /**
     * Load GameObjects from a file
     * 
     * @param gameObjectsPath
     */
    private void loadGameObjects(String gameObjectsPath) {

        List<String> gameObjects = new ArrayList<>();
        try {
            gameObjects = Files.readAllLines(Paths.get(gameObjectsPath));
        } catch (IOException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
        }

        // split the string at "><"
        // to get the game object information from the file
        for (String gameObject : gameObjects) {
            String[] gameObjectInfo = gameObject.split("><");

            // Check for commentary exception
            if (cutOutStringAtFront("//", gameObjectInfo[0]).equalsIgnoreCase("//")
                    || gameObjectInfo[0].equalsIgnoreCase(""))
                continue;

            // Check to see if its a gameObject/gameStoryObject/gameCharacter
            // If GameObject
            if (cutOutStringAtFront("<//GameObject", gameObjectInfo[0]).equalsIgnoreCase("<//GameObject")) {

                // Add new GameObject to gameObjectManager
                gameObjectManager.addGameObject(new StaticGameObject(game, // Game
                        Integer.parseInt(subtractStringAtFront("id:", gameObjectInfo[2])), // ID
                        Double.parseDouble(subtractStringAtFront("X:", gameObjectInfo[3])), // X position
                        Double.parseDouble(subtractStringAtFront("Y:", gameObjectInfo[4])), // Y position
                        Double.parseDouble(subtractStringAtFront("width:", gameObjectInfo[5])), // CollisionBox width
                        Double.parseDouble(subtractStringAtFront("height:", gameObjectInfo[6])), // CollisionBox height
                        subtractStringAtFront("text:", gameObjectInfo[7]) // Message text
                ));
            }
            // If GameStoryObject
            else if (cutOutStringAtFront("<//GameStoryObject", gameObjectInfo[0])
                    .equalsIgnoreCase("<//GameStoryObject")) {
                loadStoryGameObjects(Integer.parseInt(subtractStringAtFront("id:", gameObjectInfo[2])), // Id
                        Double.parseDouble(subtractStringAtFront("X:", gameObjectInfo[3])), // X position
                        Double.parseDouble(subtractStringAtFront("Y:", gameObjectInfo[4])), // Y position
                        subtractStringAtFront("text:", gameObjectInfo[5])); // Message
            }
            // If GameCharacter
            else if (cutOutStringAtFront("<//GameCharacter", gameObjectInfo[0]).equalsIgnoreCase("<//GameCharacter")) {
                loadGameCharacters(Integer.parseInt(subtractStringAtFront("id:", gameObjectInfo[2])), // Id
                        Double.parseDouble(subtractStringAtFront("X:", gameObjectInfo[3])), // X position
                        Double.parseDouble(subtractStringAtFront("Y:", gameObjectInfo[4]))); // Y position
            }
        }
    }

    /**
     * Load a file as a String
     * 
     * @param path
     * @return the file in String format
     */
    public String loadFileAsString(String path) {
        try {
            // Load file as String
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            return new String(bytes);
        } catch (IOException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * This method cuts out the front of a string and returns it so it can be
     * compared
     * 
     * @param cutOut the length of this string is cut out from text
     * @param text
     * @return
     */
    private String cutOutStringAtFront(String cutOut, String text) {
        try {
            // Create String builder
            StringBuilder front = new StringBuilder(text);
            // Delete the back part
            front.delete(cutOut.length(), text.length());
            // Return the front part
            return front.toString();
        } catch (StringIndexOutOfBoundsException e) {
            return "";
        }
    }

    // Getters and Setters
    /**
     * return the Tile from the tiles[][] array
     * 
     * @param x
     * @param y
     * @return
     */
    public Tile getTile(int x, int y) {

        // To avoid any array out of bounds exceptions
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return tileManager.getTiles()[0]; // Standard tile for when the player accidentally walks off the map
                                              // (GrassTile)
        }

        // tiles[]contains the tiles and tiles[][] contains the id wich we need to
        // select a tile
        Tile tile = tileManager.getTiles()[tiles[x][y]];
        if (tile == null) {
            // If the tile is not found return a default tile
            // because later trying to render a tile equal to null gives errors
            return tileManager.getTiles()[0]; // (Wooden floor1 Tile)
        }
        return tile;
    }

    /**
     * This method will determine if a tile at a given coordinate is solid
     * 
     * @param x
     * @param y
     * @return boolean is the tile solid y/n
     */
    public boolean isTileSolid(int x, int y) {
        return getTile(x, y).isSolid();
    }

    /**
     * Subtracts a piece of String from the front of another String if it contains
     * it Else it returns the original text
     * 
     * @param subtraction
     * @param text
     * @return
     */
    private String subtractStringAtFront(String subtraction, String text) {
        try {
            // Create Two String Builders
            StringBuilder front = new StringBuilder(text);
            StringBuilder back = new StringBuilder(text);

            // Delete the back part of the String
            front.delete(subtraction.length(), text.length());
            // Delete the front part of the String
            back.delete(0, subtraction.length());

            String frontString = front.toString();
            String backString = back.toString();

            // If the frontString equals what was to be subtracted
            if (frontString.equalsIgnoreCase(subtraction)) {
                return backString;
            }
            // If there was nothing to subtract return the original text
            else {
                return text;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return "";
        }
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the tiles
     */
    public int[][] getTiles() {
        return tiles;
    }

    /**
     * @return
     */
    public GameObjectManager getGameObjectManager() {
        return gameObjectManager;
    }

    /**
     * @return
     */
    public GameCharacterManager getGameCharacterManager() {
        return gameCharacterManager;
    }

    /**
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return
     */
    public boolean isActive() {
        return active;
    }
}
