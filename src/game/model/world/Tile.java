/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.world;

/**
 * @author Joren and Sam
 */
public class Tile {

    // Variables
    private final int id;
    private boolean solid;

    /**
     * Create a new Tile
     * 
     * @param id
     * @param solid
     */
    public Tile(int id, boolean solid) {
        this.id = id;
        this.solid = solid;
    }

    // Methods

    // Getters and Setters
    /**
     * 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @return
     */
    public boolean isSolid() {
        return solid;
    }

}
