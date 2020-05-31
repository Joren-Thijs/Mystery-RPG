/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view.sprites;

import javafx.scene.image.Image;

/**
 *
 * @author Joren and Sam
 */
public class SpriteSheet {
    
    //Variables
    private Image image;
    
    /**
     * Create a new SpriteSheet
     * @param image 
     */
    public SpriteSheet(Image image){
        this.image = image;
    }
    
    //Methods
    
    //Getters and Setters
    /**
     * @return the image
     */
    public Image getImage(){
        return image;
    }
}
