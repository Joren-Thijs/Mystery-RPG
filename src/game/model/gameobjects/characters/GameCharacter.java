/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects.characters;

import game.model.Game;
import game.model.gameobjects.CollisionBox;
import game.model.gameobjects.GameObject;
import game.model.world.WorldManager;

/**
 * @author Joren and Sam
 */
public abstract class GameCharacter extends GameObject {

    // Variables
    // Defeault value's
    public static final double DEFAULT_SPEED = 1.8;

    // Character Variables
    protected double speed;
    protected Direction direction;
    protected Status status;

    /**
     * Create a new character
     * 
     * @param game
     * @param x
     * @param y
     * @param id
     */
    public GameCharacter(Game game, int id, double x, double y) {
        super(game, id, x, y);
        this.game = game;
        direction = Direction.DOWN;
        status = Status.STANDING;
        speed = DEFAULT_SPEED;
    }

    // Methods
    /**
     * Attempt to move the GameCharacter to offset XY
     * 
     * @param moveX
     * @param moveY
     */
    protected void move(double moveX, double moveY) {

        // Check collision with GameObjects first
        if (checkCollisionsWithGameObjects(moveX, moveY))
            return;

        // For moving left and right
        // If the character is moving right
        // We want to check the top right and the bottom right corner of the
        // collisionbox for collisions
        if (moveX > 0) {
            int newX = (int) ((moveX + collisionBox.getX() + collisionBox.getWidth()) / WorldManager.TILEWIDTH);
            // If no collisin with a solid tile is detected then move right
            if (!game.getWorldManager().getWorld().isTileSolid(newX,
                    (int) (collisionBox.getY() / WorldManager.TILEHEIGHT))
                    && !game.getWorldManager().getWorld().isTileSolid(newX,
                            (int) ((collisionBox.getY() + collisionBox.getHeight()) / WorldManager.TILEHEIGHT))) {
                collisionBox.setX(collisionBox.getX() + moveX);
            }
            // If a collision with a tile is detected then move up to the Tile
            else {
                collisionBox.setX(newX * WorldManager.TILEWIDTH - collisionBox.getWidth() - 1);
            }
        }
        // If the character is moving left
        // We want to check the top left and the bottom left corner of the collisionbox
        // for collisions
        else if (moveX < 0) {
            int newX = (int) ((moveX + collisionBox.getX()) / WorldManager.TILEWIDTH);
            // If no collisin with a solid tile is detected then move left
            if (!game.getWorldManager().getWorld().isTileSolid(newX,
                    (int) (collisionBox.getY() / WorldManager.TILEHEIGHT))
                    && !game.getWorldManager().getWorld().isTileSolid(newX,
                            (int) ((collisionBox.getY() + collisionBox.getHeight()) / WorldManager.TILEHEIGHT))) {
                collisionBox.setX(collisionBox.getX() + moveX);
            }
            // If a collision with a tile is detected then move up to the Tile
            else {
                collisionBox.setX(newX * WorldManager.TILEWIDTH + WorldManager.TILEWIDTH + 1);
            }
        }

        // For moving up and down
        // If the character is moving up
        // We want to check the top right and the top left corner of the collisionbox
        // for collisions
        if (moveY < 0) {
            int newY = (int) ((moveY + collisionBox.getY()) / WorldManager.TILEHEIGHT);
            // If no collisin with a solid tile is detected then move right
            if (!game.getWorldManager().getWorld()
                    .isTileSolid((int) ((collisionBox.getX() + collisionBox.getWidth()) / WorldManager.TILEWIDTH), newY)
                    && !game.getWorldManager().getWorld()
                            .isTileSolid((int) (collisionBox.getX() / WorldManager.TILEWIDTH), newY)) {
                collisionBox.setY(collisionBox.getY() + moveY);
            }
            // If a collision with a tile is detected then move up to the Tile
            else {
                collisionBox.setY(newY * WorldManager.TILEHEIGHT + WorldManager.TILEHEIGHT + 1);
            }
        }
        // If the character is moving down
        // We want to check the bottom left and the bottom right corner of the
        // collisionbox for collisions
        else if (moveY > 0) {
            int newY = (int) ((moveY + collisionBox.getY() + collisionBox.getHeight()) / WorldManager.TILEHEIGHT);
            // If no collisin with a solid tile is detected then move right
            if (!game.getWorldManager().getWorld()
                    .isTileSolid((int) ((collisionBox.getX() + collisionBox.getWidth()) / WorldManager.TILEWIDTH), newY)
                    && !game.getWorldManager().getWorld()
                            .isTileSolid((int) (collisionBox.getX() / WorldManager.TILEWIDTH), newY)) {
                collisionBox.setY(collisionBox.getY() + moveY);
            }
            // If a collision with a tile is detected then move up to the Tile
            else {
                collisionBox.setY(newY * WorldManager.TILEHEIGHT - collisionBox.getHeight() - 1);
            }
        }

    }

    /**
     * Check for collision with GameObject at offset XY
     * 
     * @param moveX
     * @param moveY
     * @return
     */
    private boolean checkCollisionsWithGameObjects(double moveX, double moveY) {
        CollisionBox tempBox = getCollisionBox(moveX, moveY);

        // Check GameObjects for collisions
        for (GameObject gameObject : game.getWorldManager().getWorld().getGameObjectManager().getGameObjects()) {
            if (gameObject.getCollisionBox().collidesWith(tempBox) && gameObject.isActive()) {
                return true;
            }
        }

        // Check GameCharacters for collisions
        for (GameCharacter gameCharacter : game.getWorldManager().getWorld().getGameCharacterManager()
                .getGameCharacters()) {
            // If the gameCharacter from the list is ourselves then skip
            if (gameCharacter.equals(this))
                continue;

            if (gameCharacter.getCollisionBox().collidesWith(tempBox) && gameCharacter.isActive()) {
                return true;
            }
        }

        // No collisions detected
        return false;
    }

    // Getters and Setters
    /**
     * get the direction the character is facing
     * 
     * @return
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
