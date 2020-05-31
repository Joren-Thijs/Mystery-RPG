/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.world;

import game.model.Game;
import game.model.gameobjects.characters.Player;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joren and Sam
 */
public class WorldManager {
    
    //Variables
    //DEFAULT VALUES
    public static final double TILEWIDTH = 64;
    public static final double TILEHEIGHT = 64;
    
    //Game
    private Game game;
    //Player
    private Player player;
    
    //File paths
    private final String openingForestPath = "GameFiles/Worlds/openingForest";
    private final String villaFisherBottomFloorToastScenePath = "GameFiles/Worlds/villaFisherBottomFloorToastScene";
    private final String villaFisherBottomFloorPath = "GameFiles/Worlds/villaFisherBottomFloor";
    private final String villaFisherTopFloorPath = "GameFiles/Worlds/villaFisherTopFloor";
    private final String villaFisherBottomFloorConfrontationScenePath = "GameFiles/Worlds/villaFisherBottomFloorConfrontationScene";
    
    //Worlds
    private List<World> worlds = new ArrayList<World>();
    private World openingForest;
    private World villaFisherBottomFloorToastScene;
    private World villaFisherBottomFloor;
    private World villaFisherTopFloor;
    private World villaFisherBottomFloorConfrontationScene;
    
    /**
     * Create a new worldManager
     * @param game 
     */
    public WorldManager(Game game){
        this.game = game;
        initialize();
    }
    
    //Methods
    /**
     * Create the worlds
     */
    private void initialize(){
        //Create the player
        player = new Player(game);
        
        //Create the game worlds
        worlds.add(openingForest = new World(game, openingForestPath, player));
        worlds.add(villaFisherBottomFloorToastScene = new World(game, villaFisherBottomFloorToastScenePath, player));
        worlds.add(villaFisherBottomFloor = new World(game, villaFisherBottomFloorPath, player));
        worlds.add(villaFisherTopFloor = new World(game, villaFisherTopFloorPath, player));
        worlds.add(villaFisherBottomFloorConfrontationScene = new World(game, villaFisherBottomFloorConfrontationScenePath, player));
        
        //Activate the first game world
        openingForest.setActive(true);
    }
    
    /**
     * Update the world that is currently active
     */
    public void update(){
        
        for(World world : worlds){
            if(world.isActive()){
                world.update();
            }
        }
    }
    
    //Getters and Setters
    /**
     * Returns the currently active world
     * @return 
     */
    public World getWorld(){
        for(World world : worlds){
            if(world.isActive()){
                return world;
            }
        }
        return null;
    }
    
    /**
     * Returns the index of the current active world
     * @return 
     */
    public int getWorldIndex(){
        for(int i = 0; i < worlds.size(); i++){
            if(worlds.get(i).isActive()){
                return i;
            }
        }
        return 0;
    }
    
    /**
     * Returns the world from the worlds list at index i
     * @param i
     * @return 
     */
    public World getWorld(int i){
        return worlds.get(i);
    }
    
    /**
     * Activate a new game world
     * @param i 
     */
    public void setWorld(int i){
        for(World world : worlds){
            if(world.isActive()){
                world.setActive(false);
            }
        }
        worlds.get(i).setActive(true);
    }
    
    /**
     * return the list of worlds
     * @return 
     */
    public List<World> getWorlds(){
        return worlds;
    }

    /**
     * returns the player
     * @return 
     */
    public Player getPlayer() {
        return player;
    }
}
