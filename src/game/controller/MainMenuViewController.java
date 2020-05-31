/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.controller;

import game.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 * Is used for the main menu View
 * @author Joren and Sam
 */
public class MainMenuViewController extends FXMLGameController implements Initializable {

    //Variables
    
    //FXML Items
    @FXML
    private Text newGameText;
    @FXML
    private Text loadGameText;
    @FXML
    private Text settingsText;
    @FXML
    private GridPane gridPane;
    @FXML
    private Rectangle backgroundRect;
    @FXML
    private Rectangle titleRect;
    @FXML
    private Text titleText;
    
    //Methods
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
    
    //Event Methods
    /**
     * make text white
     * @param event 
     */
    @FXML
    private void onMouseExitedNewGameText(MouseEvent event) {
        newGameText.setFill(exitColor);
    }
    
    /**
     * make text purple
     * @param event 
     */
    @FXML
    private void onMouseEntereNewGameText(MouseEvent event) {
        newGameText.setFill(enterColor);
    }

    /**
     * Load in a new Game
     * @param event 
     */
    @FXML
    private void onMouseClickedNewGameText(MouseEvent event) {
        main.loadNewGameView();
    }

    /**
     * make text white
     * @param event 
     */
    @FXML
    private void onMouseExitedLoadGameText(MouseEvent event) {
        loadGameText.setFill(exitColor);
    }

    /**
     * make text purple
     * @param event 
     */
    @FXML
    private void onMouseEnteredLoadGameText(MouseEvent event) {
        loadGameText.setFill(enterColor);
    }

    /**
     * Load in the Load Game Menu
     * @param event 
     */
    @FXML
    private void onMouseClickedLoadGameText(MouseEvent event) {
        main.loadLoadGameMenuView();
    }

    /**
     * make text white
     * @param event 
     */
    @FXML
    private void onMouseExitedSettingsText(MouseEvent event) {
        settingsText.setFill(exitColor);
    }

    /**
     * make text purple
     * @param event 
     */
    @FXML
    private void onMouseEnteredSettingsText(MouseEvent event) {
        settingsText.setFill(enterColor);
    }

    /**
     * Load the settings menu
     * @param event 
     */
    @FXML
    private void onMouseClickedSettingsText(MouseEvent event) {
        main.loadSettingsMenuView();
    }
    
    //Getters and Setters
    /**
     *
     * @param main
     */
    @Override
    public void setMain(Main main){
        this.main = main;
    }
    
    /**
     * return the Pane used by this scene
     * @return
     */
    @Override
    public Pane getPane(){
        return gridPane;
    }
    
}
