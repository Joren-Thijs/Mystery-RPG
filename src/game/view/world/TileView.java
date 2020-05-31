/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view.world;

import game.model.world.Tile;
import game.view.sprites.Sprite;
import game.view.sprites.SpriteImages;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Joren and Sam
 */
public class TileView {

    //Variables
    private Sprite tileTexture;
    
    /**
     * Create a new TileView
     * @param tile 
     * @param spriteImages 
     */
    public TileView(Tile tile, SpriteImages spriteImages){
        tileTexture = spriteImages.getTileTextures()[tile.getId()];
    }
    
    //Methods
    /**
     * Render a tile
     * @param g
     * @param x
     * @param y
     */
    public void render(GraphicsContext g,int x, int y) {
        tileTexture.render(g, x, y);
    }
    
    //Getters and Setters
    /**
     * @return the tileTexture
     */
    public Sprite getTileTexture() {
        return tileTexture;
    }
    
}
