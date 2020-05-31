/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.controller;

import game.Main;
import game.GameThread;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Abstract controller class that contains all methods we want to call on every
 * FXML controller
 * 
 * @author Joren and Sam
 */
public abstract class FXMLGameController {

    // Variables
    protected Main main;
    protected Color exitColor = Color.WHITE;
    protected Color enterColor = Color.web("#810c8c");

    // Methods
    /**
     * attaches keyEventHandler to Scene
     */
    public void attachKeyEventHandler() {
        main.getStage().getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                onKeyPressed(keyEvent);
            }
        });
        main.getStage().getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                onKeyReleased(keyEvent);
            }
        });
    }

    /**
     * When a key is pressed do...
     * 
     * @param event
     */
    protected void onKeyPressed(KeyEvent event) {
    }

    /**
     * When a key is released do...
     * 
     * @param event
     */
    protected void onKeyReleased(KeyEvent event) {
    }

    /**
     * load a new Game
     */
    public void loadNewGame() {
    }

    /**
     * Load a saved Game
     * 
     * @param saveSlot
     */
    public void loadSavedGame(int saveSlot) {
    }

    /**
     * Reload the current Game
     */
    public void reloadGame() {
    }

    /**
     * Load the information from the save slots into the controller
     */
    public void loadSaveSlots() {
    }

    /**
     * Load the game volume from the settingsFile
     */
    public void loadGameVolumeFromSettingsFile() {
    }

    // Getters and Setters
    /**
     * returns the GameThread if the controller has one
     * 
     * @return
     */
    public GameThread getGameThread() {
        return null;
    }

    /**
     * Returns the pane that is used in the Scene
     * 
     * @return
     */
    public abstract Pane getPane();

    /**
     * add a reference to the Main class tot the controller
     * 
     * @param main
     */
    public void setMain(Main main) {
        this.main = main;
    }
}
