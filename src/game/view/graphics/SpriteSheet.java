/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view.graphics;

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
     *
     * @return
     */
    public Image getImage(){
        return image;
    }
}
