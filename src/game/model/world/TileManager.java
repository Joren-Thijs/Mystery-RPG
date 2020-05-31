/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.world;

/**
 *
 * @author Joren
 */
public class TileManager {
    
    //Variables
    //List of all the possible tiles (tiles[ID])
    private  Tile[] tiles = new Tile[100];

    public TileManager() {
        initialize();
    }
    
    private void initialize(){

        //Fill Tiles array solid property here:
        //indoor Tiles:
        //Floor tiles 0-20
        for(int i = 0; i < 20; i++){
            tiles[i] = new Tile(i, false);
        }
        
        //Wall Tiles 20-50
        for(int i = 20; i < 50; i++){
            tiles[i] = new Tile(i, true);
        }
        
        //Outdoor Tiles
        //Ground Tiles
        for(int i = 50; i < 70; i++){
            tiles[i] = new Tile(i, false);
        }
        //Wall Tiles
        for(int i = 70; i < 100; i++){
            tiles[i] = new Tile(i, true);
        }
    }
    
    //Getters and Setters

    /**
     * @return the tiles
     */
    public Tile[] getTiles() {
        return tiles;
    }
    
}
