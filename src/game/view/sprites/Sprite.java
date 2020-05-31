/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view.sprites;

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
    private final double xPos;
    //the Y position of this sprite on the spritesheet
    private final double yPos;
    //the width of this sprite on the spritesheet
    private final double width;
    //the height position of this sprite on the spritesheet
    private final double height;
    //the width relation between the top left corner of the sprite and the gameObjects collisionBox
    private final double xRelation;
    //the height relation between the top left corner of the sprite and the gameObjects collisionBox
    private final double yRelation;
    //the width the sprite has to be drawn at
    private final double targetWidth;
    //the height the sprite has to be drawn at
    private final double targetHeight;

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
    public Sprite(SpriteSheet spriteSheet, double xPos, double yPos, double width, double height, double xRelation, double yRelation, double targetWidth, double targetHeight){
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
    public double getXPos() {
        return xPos;
    }

    /**
     * @return the yPos
     */
    public double getYPos() {
        return yPos;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }
    
}
