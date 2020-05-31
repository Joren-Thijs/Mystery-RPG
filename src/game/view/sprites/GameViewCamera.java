/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view.sprites;

import game.model.gameobjects.GameObject;
import game.model.world.World;
import game.view.GameView;

/**
 *
 * @author Joren and Sam
 */
public class GameViewCamera {

    // Variables
    private World currentWorld;
    private double xOffset = 0, yOffset = 0;

    // Methods
    /**
     * Center the Camera on a gameObject
     * 
     * @param gameObject
     */
    public void centerOnGameObject(GameObject gameObject) {
        // gameObject position - half of the screen + half of the size of the gameObject
        // without (+ half of the gameObject) we will be centered around the top left
        // corner of the gameObjects collisionBox
        xOffset = (gameObject.getX() + gameObject.getCollisionBox().getWidth() / 2) - GameView.DEFAULT_WIDTH / 2;
        yOffset = (gameObject.getY() + gameObject.getCollisionBox().getHeight() / 2) - GameView.DEFAULT_HEIGHT / 2;
        checkWorldEdges();
    }

    /**
     * Check to see if the camera offset will not cause any blank space outside the
     * game world to show
     */
    private void checkWorldEdges() {
        // If it wants to show blank space at the left side of the map
        if (xOffset < 0) {
            xOffset = 0;
        }
        // If it wants to show blank space at the right side of the map
        if (xOffset > currentWorld.getWidth() * GameView.DEFAULT_TILEWIDTH - GameView.DEFAULT_WIDTH) {
            xOffset = currentWorld.getWidth() * GameView.DEFAULT_TILEWIDTH - GameView.DEFAULT_WIDTH;
        }

        // If it wants to show blank space at the top side of the map
        if (yOffset < 0) {
            yOffset = 0;
        }
        // If it wants to show blank space at the bottom side of the map
        if (yOffset > currentWorld.getHeight() * GameView.DEFAULT_TILEHEIGHT - GameView.DEFAULT_HEIGHT) {
            yOffset = currentWorld.getHeight() * GameView.DEFAULT_TILEHEIGHT - GameView.DEFAULT_HEIGHT;
        }
    }

    // Getters and Setters
    /**
     * @return the xOffset
     */
    public double getxOffset() {
        return xOffset;
    }

    /**
     * @return the yOffset
     */
    public double getyOffset() {
        return yOffset;
    }

    /**
     * @return the currentWorld
     */
    public World getCurrentWorld() {
        return currentWorld;
    }

    /**
     * @param currentWorld the currentWorld to set
     */
    public void setCurrentWorld(World currentWorld) {
        this.currentWorld = currentWorld;
    }

}
