/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view.gameobjects;

import game.model.gameobjects.characters.Direction;
import game.view.sprites.SpriteImages;
import game.view.sprites.Sprite;

/**
 *
 * @author Joren and Sam
 */
public class Animation {

    // Variables
    private int speed, index;
    private long lastTime, timer;
    private Sprite[] frames;

    /**
     * Create a new animation
     * 
     * @param id
     * @param direction
     * @param spriteImages
     */
    public Animation(int id, Direction direction, SpriteImages spriteImages) {
        // Set the speed of the animation
        this.speed = 250;

        // Create the animation timer
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();

        // Use the ID and direction to determine wich array of images have to be loaded
        // from the SpriteImages class
        switch (direction) {
            case UP:
                frames = spriteImages.getGameCharacterAnimationFrames()[id][0];
                break;
            case DOWN:
                frames = spriteImages.getGameCharacterAnimationFrames()[id][1];
                break;
            case LEFT:
                frames = spriteImages.getGameCharacterAnimationFrames()[id][2];
                break;
            case RIGHT:
                frames = spriteImages.getGameCharacterAnimationFrames()[id][3];
                break;
        }
    }

    // Methods
    /**
     * Update the animation timer
     */
    public void update() {
        // Update the timer
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        // See if enough time is passed to update the timers index
        if (timer > speed) {
            index++;
            timer = 0;
            if (index >= frames.length) {
                index = 0;
            }
        }
    }

    // Getters and Setters
    /**
     * Uses the index to determine the current animation frame
     * 
     * @return
     */
    public Sprite getCurrentFrame() {
        return frames[index];
    }
}
