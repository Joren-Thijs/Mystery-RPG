/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author Joren and Sam
 */
public class Sprite {
    
    //Variables
    //Spritesheet holding the sprites
    private final SpriteSheet spriteSheet;
    //the X position of this sprite on the spritesheet
    private final int xPos;
    //the Y position of this sprite on the spritesheet
    private final int yPos;
    //the width of this sprite on the spritesheet
    private final int width;
    //the height position of this sprite on the spritesheet
    private final int height;
    //the width relation between the top left corner of the sprite and the gameObjects collisionBox
    private final int xRelation;
    //the height relation between the top left corner of the sprite and the gameObjects collisionBox
    private final int yRelation;
    //the width the sprite has to be drawn at
    private final int targetWidth;
    //the height the sprite has to be drawn at
    private final int targetHeight;

    /**
     * Create a new Sprite
     * @param spriteSheet
     * @param xPos
     * @param yPos
     * @param width
     * @param height
     * @param yRelation
     * @param xRelation 
     * @param targetWidth 
     * @param targetHeight 
     */
    public Sprite(SpriteSheet spriteSheet, int xPos, int yPos, int width, int height, int xRelation, int yRelation, int targetWidth, int targetHeight){
        this.spriteSheet = spriteSheet;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.xRelation = xRelation;
        this.yRelation = yRelation;
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
    }

    //Methods
    /**
     * render the Sprite
     * @param g
     * @param x
     * @param y 
     */
    public void render(GraphicsContext g, double x, double y) {
        //Draw the sprite onto the screen
        g.drawImage(spriteSheet.getImage(), xPos, yPos, width, height, x - xRelation, y - yRelation, targetWidth, targetHeight);
        
        //Parameters from the method and what they mean:
        //g.drawImage(img, sx, sy, sw, sh, dx, dy, dw, dh);
        //Parameters:
        //img - the image to be drawn or null.
        //sx - the source rectangle's X coordinate position.
        //sy - the source rectangle's Y coordinate position.
        //sw - the source rectangle's width.
        //sh - the source rectangle's height.
        //dx - the destination rectangle's X coordinate position.
        //dy - the destination rectangle's Y coordinate position.
        //dw - the destination rectangle's width.
        //dh - the destination rectangle's height.
    }
    
    //Getters and Setters
    /**
     * @return the spriteSheet
     */
    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    /**
     * @return the xPos
     */
    public int getXPos() {
        return xPos;
    }

    /**
     * @return the yPos
     */
    public int getYPos() {
        return yPos;
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
    
}
