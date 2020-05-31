/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game;

import game.controller.FXMLGameController;
import game.controller.StartUpViewController;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Main application class
 * 
 * @author Joren and Sam
 */
public class Main extends Application {

    // Varibles
    private final String gameTitle = "Cluedo";
    private final String startUpView = "view/StartUpView.fxml";
    private final String mainMenuView = "view/MainMenuView.fxml";
    private final String settingsView = "view/SettingsView.fxml";
    private final String loadGameView = "view/LoadGameView.fxml";
    private final String saveGameView = "view/SaveGameView.fxml";
    private final String gameView = "view/GameView.fxml";
    private final String controlView = "view/ControlView.fxml";
    private final String settingsFilePath = "GameFiles/Settings/settings.txt";
    private final FXMLLoader loader = new FXMLLoader();
    private final int DefaultGameVolume = 50;
    private boolean fullScreen;
    private FXMLGameController controller;
    private GameThread gameThread;
    private GameSaver gameSaver;
    private MediaPlayer mediaPlayer;
    private int gameVolume;
    private Stage mainStage;
    private Parent mainRoot;
    private Scene mainScene;

    // Methods
    /**
     * Start the application
     * 
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        // Set mainStage
        mainStage = stage;

        // Set FXML loader path to startUPView
        loader.setLocation(getClass().getResource(startUpView));
        // Load the view
        mainRoot = loader.load();

        // Grab the controller
        controller = loader.getController();
        // Give the controller a reference to this class so it can acces the load new
        // view methods
        controller.setMain(this);

        // Create new Scene
        mainScene = new Scene(mainRoot);
        // Add Scene to the stage
        mainStage.setScene(mainScene);
        // Set the Title of the window
        mainStage.setTitle(gameTitle);

        // Create empty GameThread
        gameThread = new GameThread(1024, 768);

        // Load in the current sound value from the settingsFile
        gameVolume = LoadGameVolume();

        // Set the mainMenu song
        String music = new File("Artwork/Sound/Mainmenusong.mp3").toURI().toString();
        mediaPlayer = new MediaPlayer(new Media(music));
        // Let the sound repeat itself
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        // Set begin volume
        mediaPlayer.setVolume(((double) gameVolume) / 100);

        // Create GameSaver
        gameSaver = new GameSaver(this);

        // Set the quit method to be executed when the window is being closed
        mainStage.setOnCloseRequest((WindowEvent event) -> {
            quit();
        });

        // Show the window
        mainStage.show();
        // Make it the top window
        mainStage.requestFocus();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Load a new scene using the existing width and height
     * 
     * @param fxml
     */
    private void loadNewScene(String fxml) {
        loadNewScene(fxml, mainScene.getWidth(), mainScene.getHeight());
    }

    /**
     * Load a new scene with a specific width and height
     * 
     * @param fxml
     * @param width
     * @param height
     */
    private void loadNewScene(String fxml, double width, double height) {
        try {
            // Load in a new Scene:
            // Check String to avoid nullPointer exceptions
            if (fxml == null)
                return;

            // Set controller and root to null to avoid FXML Loader exceptions
            loader.setRoot(null);
            loader.setController(null);

            // Set the loaders path to the new FXML file
            loader.setLocation(getClass().getResource(fxml));
            // Load the new FXML file
            mainRoot = loader.load();
            // Add Root node to the Scene
            mainScene = new Scene(mainRoot, width, height);
            // Add mainScene to the Stage
            mainStage.setScene(mainScene);
            // Set mainStage to full-screen if needed
            mainStage.setFullScreen(fullScreen);

            // Get the controller from the scene so we can do stuff with it
            controller = loader.getController();
            // Give the controller a reference to this class so it can acces the load new
            // view methods
            controller.setMain(this);
            // Attach an event handler that listens for keyboard input
            controller.attachKeyEventHandler();
            // Get the Pane that is used in the scene and scale its children to the current
            // resolution
            scaleResolution(controller.getPane());

            // Make the window non resizable
            mainStage.setResizable(false);
            // Center the window on the computer screen
            mainStage.centerOnScreen();
            // Make it the top window
            mainStage.requestFocus();
        } catch (IOException ex) {
            Logger.getLogger(StartUpViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Load in a new scene and take the resolution from a String
     * 
     * @param fxml
     * @param resolution
     */
    private void loadNewScene(String fxml, String resolution) {
        if (resolution == null)
            return;
        String[] res = resolution.split(" x ");
        double resX = (double) Integer.parseInt(res[0]);
        double resY = (double) Integer.parseInt(res[1]);
        loadNewScene(fxml, resX, resY);
        // Load twice because weird scalling issue with first scene loaded at new
        // resolution from String
        loadNewScene(fxml);
    }

    /**
     * Load the mainMenuView at the current resolution
     */
    public void loadMainMenuView() {
        loadNewScene(mainMenuView);
        // Start the main menu music
        mediaPlayer.play();
    }

    /**
     * Load the mainMenuView at a specific resolution in String format
     * 
     * @param resolution
     */
    public void loadMainMenuView(String resolution) {
        loadNewScene(mainMenuView, resolution);
        // Start the main menu music
        mediaPlayer.play();
    }

    /**
     * Load the settingsView at the current resolution
     */
    public void loadSettingsMenuView() {
        loadNewScene(settingsView);
        controller.loadGameVolumeFromSettingsFile();
    }

    /**
     * Load the LoadGameView at the current resolution
     */
    public void loadLoadGameMenuView() {
        loadNewScene(loadGameView);
        controller.loadSaveSlots();
    }

    /**
     * Load the GameView at the current resolution and load a new game
     */
    public void loadNewGameView() {
        // Stop the Main menu music
        mediaPlayer.stop();
        // Load the game view
        loadNewScene(gameView);
        // Load new Game
        controller.loadNewGame();
    }

    /**
     * Load the GameView at a given resolution and load a new game
     * 
     * @param resolution
     */
    public void loadNewGameView(String resolution) {
        // Stop the Main menu music
        mediaPlayer.stop();
        loadNewScene(gameView, resolution);
        controller.loadNewGame();
    }

    /**
     * Load the GameView at the current resolution and load a saved Game
     * 
     * @param saveSlot
     */
    public void loadSavedGameView(int saveSlot) {
        // Stop the Main menu music
        mediaPlayer.stop();
        loadNewScene(gameView);
        controller.loadSavedGame(saveSlot);
    }

    /**
     * Load the SaveGameView at the current resolution
     */
    public void loadSaveGameView() {
        loadNewScene(saveGameView);
        // Populate the saveSlot images in the view
        controller.loadSaveSlots();
    }

    /**
     * Load the SaveGameView at the current resolution
     */
    public void reloadGameView() {
        loadNewScene(gameView);
        // Reload the game
        controller.reloadGame();
    }

    /**
     * Load the control view
     */
    public void loadControlView() {
        loadNewScene(controlView);

    }

    /**
     * Load the game volume from a settings file
     * 
     * @return
     */
    private int LoadGameVolume() {

        try {
            // The previous set volume is extracted from the settings.txt file and split
            // arround the : now we can return this number as an intiger.
            byte[] bytes = Files.readAllBytes(Paths.get(settingsFilePath));
            String settingsFile = new String(bytes);
            String[] settings = settingsFile.split(":");
            String setting = settings[1];
            return (int) Double.parseDouble(setting);

        } catch (IOException ex) {

            // If it fails set the Game volume to the Default Volume
            // And save it in a new SettingsFile

            // Write the Default volume into a string
            StringBuilder builder = new StringBuilder();
            builder.append("Volume " + ": " + DefaultGameVolume);
            String fileString = builder.toString();

            // Write the current volume into the new settings file
            try {
                Files.write(Paths.get(settingsFilePath), fileString.getBytes());
            } catch (IOException e) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
            return DefaultGameVolume;
        }
    }

    /**
     * Close down the application
     */
    public void quit() {
        Platform.exit();
        System.exit(0);
    }

    /**
     * Scale the objects in an FXML scene according to the resolution
     * 
     * @param Pane
     */
    private void scaleResolution(Pane Pane) {

        // calculate scale:
        if (Pane == null)
            return;
        // Get the width and height the scene was designed for
        double prefWidth = Pane.getPrefWidth();
        double prefHeight = Pane.getPrefHeight();

        // get the current width and height
        double sceneWidth = mainScene.getWidth();
        double sceneHeight = mainScene.getHeight();

        // calculate the X and Y scale factor
        double scaleX = sceneWidth / prefWidth;
        double scaleY = sceneHeight / prefHeight;

        // Scale UI elements:
        // Create an ArrayList of UiElements (Nodes)
        List<Node> uiElements = new ArrayList<Node>();
        // Add all the children from the pane to the list
        uiElements.addAll(Pane.getChildren());

        // Loop through the list and scale every element
        for (Node element : uiElements) {
            element.setScaleX(scaleX);
            element.setScaleY(scaleY);
        }
    }

    // Getters and Setters
    /**
     * Returns the main application stage
     * 
     * @return
     */
    public Stage getStage() {
        return mainStage;
    }

    /**
     * @return the gameSaver
     */
    public GameSaver getGameSaver() {
        return gameSaver;
    }

    /**
     * @return the gameThread
     */
    public GameThread getGameThread() {
        return gameThread;
    }

    /**
     * @param gameThread the gameThread to set
     */
    public void setGameThread(GameThread gameThread) {
        this.gameThread = gameThread;
    }

    /**
     * @return the mainStage
     */
    public Stage getMainStage() {
        return mainStage;
    }

    /**
     * @return the mainRoot
     */
    public Parent getMainRoot() {
        return mainRoot;
    }

    /**
     * @return the mainScene
     */
    public Scene getMainScene() {
        return mainScene;
    }

    /**
     * @return the mediaPlayer
     */
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    /**
     * @return the settingsFilePath
     */
    public String getSettingsFilePath() {
        return settingsFilePath;
    }

    /**
     * @return the gameVolume
     */
    public int getGameVolume() {
        return gameVolume;
    }

    /**
     * @return the DefaultGameVolume
     */
    public int getDefaultGameVolume() {
        return DefaultGameVolume;
    }

    /**
     * @return the fullScreen
     */
    public boolean isFullScreen() {
        return fullScreen;
    }

    /**
     * @param fullScreen the fullScreen to set
     */
    public void setFullScreen(boolean fullScreen) {
        this.fullScreen = fullScreen;
    }

}
