/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.controller;

import game.Main;
import game.GameThread;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * FXML Controller class Is used for the GameView
 *
 * @author Joren and Sam
 */
public class GameViewController extends FXMLGameController implements Initializable {

    // Variables
    private GraphicsContext g;

    // FXML items
    @FXML
    private GridPane gridPane;
    @FXML
    private Canvas canvas;
    @FXML
    private Rectangle pauseRect;
    @FXML
    private Text quitGameText;
    @FXML
    private Text saveGameText;
    @FXML
    private ImageView imageView;
    @FXML
    private Text mainMenuText;

    // Methods
    /**
     * Initializes the controller class.
     * 
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Create GraphicsContext
        g = canvas.getGraphicsContext2D();

        // Hide the PauseMenu
        setPauzeMenuVisibility(false);
    }

    /**
     * When a key is pressed update the model accordingly
     * 
     * @param event
     */
    @Override
    protected void onKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                main.getGameThread().getGame().getInputManager().setWKey(true);
                break;
            case S:
                main.getGameThread().getGame().getInputManager().setSKey(true);
                break;
            case A:
                main.getGameThread().getGame().getInputManager().setAKey(true);
                break;
            case D:
                main.getGameThread().getGame().getInputManager().setDKey(true);
                break;
            case SHIFT:
                main.getGameThread().getGame().getInputManager().setShiftKey(true);
                break;
            case E:
                main.getGameThread().getGame().getInputManager().setEKey(true);
                break;
            case F:
                main.getGameThread().getGame().getInputManager().setFKey(true);
                break;
            case P:
                // Pause the game
                main.getGameThread().togglePause();
                setPauzeMenuVisibility(main.getGameThread().isPaused());
                break;
            case TAB:
                main.getGameThread().getGame().getInputManager().setTabKey(true);
                break;
            case UP:
                main.getGameThread().getGame().getInputManager().setUpKey(true);
                break;
            case DOWN:
                main.getGameThread().getGame().getInputManager().setDownKey(true);
                break;
            case LEFT:
                main.getGameThread().getGame().getInputManager().setLeftKey(true);
                break;
            case RIGHT:
                main.getGameThread().getGame().getInputManager().setRightKey(true);
                break;
            case ENTER:
                main.getGameThread().getGame().getInputManager().setEnterKey(true);
                break;
        }
    }

    /**
     * When a key is released update the model accordingly
     * 
     * @param event
     */
    @Override
    protected void onKeyReleased(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                main.getGameThread().getGame().getInputManager().setWKey(false);
                break;
            case S:
                main.getGameThread().getGame().getInputManager().setSKey(false);
                break;
            case A:
                main.getGameThread().getGame().getInputManager().setAKey(false);
                break;
            case D:
                main.getGameThread().getGame().getInputManager().setDKey(false);
                break;
            case SHIFT:
                main.getGameThread().getGame().getInputManager().setShiftKey(false);
                break;
            case E:
                main.getGameThread().getGame().getInputManager().setEKey(false);
                break;
            case F:
                main.getGameThread().getGame().getInputManager().setFKey(false);
                break;
            case P:
                break;
            case TAB:
                main.getGameThread().getGame().getInputManager().setTabKey(false);
                break;
            case UP:
                main.getGameThread().getGame().getInputManager().setUpKey(false);
                break;
            case DOWN:
                main.getGameThread().getGame().getInputManager().setDownKey(false);
                break;
            case LEFT:
                main.getGameThread().getGame().getInputManager().setLeftKey(false);
                break;
            case RIGHT:
                main.getGameThread().getGame().getInputManager().setRightKey(false);
                break;
            case ENTER:
                main.getGameThread().getGame().getInputManager().setEnterKey(false);
                break;
        }
    }

    /**
     * Create a new GameThread and load up a new Game;
     */
    @Override
    public void loadNewGame() {
        main.setGameThread(new GameThread(canvas.getWidth(), canvas.getHeight()));
        main.getGameThread().setGraphicsContext(g);
        main.getGameThread().loadNewGame();
        main.getGameThread().start();
    }

    /**
     * Save the current Game to a file
     */
    public void saveGame() {

        // Take a snapchot of the canvas to ad to the saveslot items
        WritableImage image = new WritableImage((int) main.getMainScene().getWidth(),
                (int) main.getMainScene().getHeight());
        canvas.snapshot(null, image);
        main.getGameSaver().setCurrentImage(image);
        main.loadSaveGameView();

    }

    /**
     * Load an existing game from a file
     * 
     * @param saveSlot
     */
    @Override
    public void loadSavedGame(int saveSlot) {
        main.setGameThread(new GameThread(canvas.getWidth(), canvas.getHeight()));
        main.getGameThread().setGraphicsContext(g);
        main.getGameThread().loadNewGame();
        main.getGameSaver().loadGame(saveSlot);
        main.getGameThread().start();

    }

    /**
     * Reload the current game
     */
    @Override
    public void reloadGame() {
        main.getGameThread().setGraphicsContext(g);
        imageView.setImage(main.getGameSaver().getCurrentImage());
        setPauzeMenuVisibility(main.getGameThread().isPaused());
    }

    /**
     * Set the visibility of the pause menu
     * 
     * @param visible
     */
    private void setPauzeMenuVisibility(boolean visible) {
        // Set the visibility
        pauseRect.setVisible(visible);
        quitGameText.setVisible(visible);
        mainMenuText.setVisible(visible);
        saveGameText.setVisible(visible);
    }

    // Event methods
    @FXML
    private void onMouseExitedQuitGameText(MouseEvent event) {
        quitGameText.setFill(exitColor);
    }

    @FXML
    private void onMouseEnteredQuitGameText(MouseEvent event) {
        quitGameText.setFill(enterColor);
    }

    @FXML
    private void onMouseClickedQuitGameText(MouseEvent event) {
        if (quitGameText.isVisible()) {
            // Quit the game
            main.quit();
        }
    }

    @FXML
    private void onMouseExitedMainMenuText(MouseEvent event) {
        mainMenuText.setFill(exitColor);
    }

    @FXML
    private void onMouseEnteredMainMenuText(MouseEvent event) {
        mainMenuText.setFill(enterColor);
    }

    @FXML
    private void onMouseClickedMainMenuText(MouseEvent event) {
        if (mainMenuText.isVisible()) {

            // Stop the game sounds
            main.getGameThread().getGame().getEventManager().getOpeningForestMediaPlayer().stop();
            main.getGameThread().getGame().getEventManager().getToastSceneMediaPlayer().stop();
            main.getGameThread().getGame().getEventManager().getVillaFisherMediaPlayer().stop();
            main.getGameThread().getGame().getEventManager().getCreditsMediaPlayer().stop();

            // Go to the Main Menu
            main.loadMainMenuView();
        }
    }

    @FXML
    private void onMouseExitedSaveGameText(MouseEvent event) {
        saveGameText.setFill(exitColor);
    }

    @FXML
    private void onMouseEnteredNewGameText(MouseEvent event) {
        saveGameText.setFill(enterColor);
    }

    @FXML
    private void onMouseClickedSaveGameText(MouseEvent event) {
        if (saveGameText.isVisible()) {
            // Save the game
            saveGame();
        }
    }

    // Getters and Setters
    /**
     *
     * @param main
     */
    @Override
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * return the pane used by this scene
     * 
     * @return
     */
    @Override
    public Pane getPane() {
        return gridPane;
    }
}
