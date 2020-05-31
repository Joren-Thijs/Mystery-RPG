/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects;

import game.model.Game;

/**
 * Abstract GameObject class
 * 
 * @author Joren and Sam
 */
public abstract class GameObject {

    // Variables
    protected Game game;
    protected CollisionBox collisionBox;
    protected final int id;
    protected boolean active;

    /**
     * Create a new GameObject
     * 
     * @param game
     * @param x
     * @param y
     * @param id
     */
    public GameObject(Game game, int id, double x, double y) {
        this.game = game;
        this.id = id;
        collisionBox = new CollisionBox(x, y, 10, 10);
        active = true;
    }

    // Methods
    /**
     * update the GameObject
     */
    public abstract void update();

    /**
     * return the GameObjects collisionBox with a specific offset
     * 
     * @param xOffset
     * @param yOffset
     * @return CollisionBox that represents the area of the GameObject that is solid
     */
    public CollisionBox getCollisionBox(double xOffset, double yOffset) {
        return new CollisionBox((double) (collisionBox.getX() + xOffset), (double) (collisionBox.getY() + yOffset),
                collisionBox.getWidth(), collisionBox.getHeight());
    }

    /**
     * When the Player wants to interact with the object
     */
    public void interact() {

    }

    /**
     * Return String representation of gameObject
     * 
     * @return
     */
    @Override
    public String toString() {
        if (active) {
            return "ID: " + id + "X: " + collisionBox.getX() + "Y: " + collisionBox.getY() + "Width: "
                    + collisionBox.getWidth() + "Height: " + collisionBox.getHeight() + "Active: TRUE";
        } else {
            return "ID: " + id + "X: " + collisionBox.getX() + "Y: " + collisionBox.getY() + "Width: "
                    + collisionBox.getWidth() + "Height: " + collisionBox.getHeight() + "Active: FALSE";
        }
    }

    // Getters and Setters
    /**
     * @return the x
     */
    public double getX() {
        return collisionBox.getX();
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        collisionBox.setX(x);
    }

    /**
     * @return the y
     */
    public double getY() {
        return collisionBox.getY();
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        collisionBox.setY(y);
    }

    /**
     * @return the collisionBox
     */
    public CollisionBox getCollisionBox() {
        return collisionBox;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

}
