/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects.characters;

import game.model.Game;
import game.model.gameobjects.CollisionBox;
import game.model.gameobjects.GameObject;
import game.model.inventory.Inventory;

/**
 * @author Joren and Sam
 */
public class Player extends GameCharacter {

    // Variables
    private Inventory inventory;
    private boolean lookingAtInventory;
    private int noteIndex;

    /**
     * Create a new Player
     * 
     * @param game
     */
    public Player(Game game) {
        super(game, 0, 300, 550); // 300/550 standard
        collisionBox.setWidth(35);
        collisionBox.setHeight(21);
        speed = DEFAULT_SPEED;
        inventory = new Inventory();
    }

    // Methods
    /**
     * Update the player
     */
    @Override
    public void update() {
        // Check for input
        getInput();
    }

    /**
     * Check for input and set the move variables accordingly
     */
    private void getInput() {

        // If the player doesn't move he will be standing
        status = Status.STANDING;

        // If the player is in a dialogue then he cannot move
        if (game.getDialogueManager().isTalking()) {
            return;
        }

        if (game.getInputManager().isTab()) {
            lookingAtInventory = !lookingAtInventory;
        }

        // If we are looking at the inventory
        // navigate true it and skip the rest
        if (lookingAtInventory) {
            if (game.getInputManager().isUp()) {
                noteIndex--;
                // To avoid array out of bound exceptions
                if (noteIndex < 0) {
                    noteIndex = inventory.getNotes().size() - 1;
                }
            }
            if (game.getInputManager().isDown()) {
                noteIndex++;
                // To avoid array out of bound exceptions
                if (noteIndex >= inventory.getNotes().size()) {
                    noteIndex = 0;
                }
            }
            return;
        }

        // Is the player sprinting?
        if (game.getInputManager().isShiftKey()) {
            speed = DEFAULT_SPEED + 1.2;
        } else {
            speed = DEFAULT_SPEED;
        }

        // is the player moving?
        // Moving up
        if (game.getInputManager().isWKey()) {
            move(0, -speed);
            status = Status.WALKING;
            setDirection(Direction.UP);
        }
        // Moving down
        else if (game.getInputManager().isSKey()) {
            move(0, speed);
            status = Status.WALKING;
            setDirection(Direction.DOWN);
        }
        // Moving left
        else if (game.getInputManager().isAKey()) {
            move(-speed, 0);
            status = Status.WALKING;
            setDirection(Direction.LEFT);
        }
        // Moving right
        else if (game.getInputManager().isDKey()) {
            move(speed, 0);
            status = Status.WALKING;
            setDirection(Direction.RIGHT);
        }

        // If the player presses the use button
        if (game.getInputManager().isE()) {
            use();
        }
    }

    private void use() {
        // Check wich direction the player is facing and draw a new collisionBox there
        CollisionBox tempBox = new CollisionBox(0, 0, 35, 35);
        switch (direction) {
            case UP:
                tempBox.setX(collisionBox.getX());
                tempBox.setY(collisionBox.getY() - tempBox.getHeight());
                break;
            case DOWN:
                tempBox.setX(collisionBox.getX());
                tempBox.setY(collisionBox.getY() + tempBox.getHeight());
                break;
            case LEFT:
                tempBox.setX(collisionBox.getX() - tempBox.getWidth());
                tempBox.setY(collisionBox.getY());
                break;
            case RIGHT:
                tempBox.setX(collisionBox.getX() + tempBox.getWidth());
                tempBox.setY(collisionBox.getY());
                break;
            default:
        }

        // Check GameObjects for interact
        for (GameObject gameObject : game.getWorldManager().getWorld().getGameObjectManager().getGameObjects()) {
            if (gameObject.getCollisionBox().collidesWith(tempBox) && gameObject.isActive()) {
                gameObject.interact();
            }
        }

        // Check GameCharacters for interact
        for (GameCharacter gameCharacter : game.getWorldManager().getWorld().getGameCharacterManager()
                .getGameCharacters()) {
            if (gameCharacter.getCollisionBox().collidesWith(tempBox) && gameCharacter.isActive()) {
                gameCharacter.interact();
            }
        }
    }

    /**
     * @return the player in String format
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Player:\n");

        // Print his position
        builder.append("Position:\n");
        builder.append("X: " + collisionBox.getX() + "\n");
        builder.append("Y: " + collisionBox.getY() + "\n");

        // Print his direction
        builder.append("Direction: " + "\n" + direction.toString() + "\n");

        // Print is lookinAtInventory
        if (isLookingAtInventory()) {
            builder.append("IsLookingAtInventory: TRUE\n");
        } else {
            builder.append("IsLookingAtInventory: FALSE\n");
        }

        // Print note index
        builder.append("NoteIndex: " + noteIndex + "\n");

        // Print inventory
        builder.append("Inventory:\n");
        if (inventory.isEmpty()) {
            builder.append("EMPTY");
        } else {
            builder.append(inventory.toString());
        }

        return builder.toString();
    }

    // Getters and Setters
    /**
     * @return the inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * @return the lookingAtInventory
     */
    public boolean isLookingAtInventory() {
        return lookingAtInventory;
    }

    /**
     * @return the noteIndex
     */
    public int getNoteIndex() {
        return noteIndex;
    }

    /**
     * @param inventory the inventory to set
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * @param lookingAtInventory the lookingAtInventory to set
     */
    public void setLookingAtInventory(boolean lookingAtInventory) {
        this.lookingAtInventory = lookingAtInventory;
    }

    /**
     * @param noteIndex the noteIndex to set
     */
    public void setNoteIndex(int noteIndex) {
        this.noteIndex = noteIndex;
    }
}
