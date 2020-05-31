/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.controller;

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
 *
 * @author Joren and Sam
 */
public class ControlViewController extends FXMLGameController implements Initializable {
    
    //Variables
    
    //FXML Items
    @FXML
    private GridPane gridPane;
    @FXML
    private Rectangle backgroundRect;
    @FXML
    private Text controlsText;
    @FXML
    private Text backText;
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
    }
    
    //Event methods
    /**
     * @param event  
     */
    @FXML
    private void onMouseClickedBackText(MouseEvent event) {
        main.loadSettingsMenuView();
    }
    
    @FXML
    private void onMouseExitedBackText(MouseEvent event) {
        backText.setFill(exitColor);
    }

    @FXML
    private void onMouseEnteredBackText(MouseEvent event) {
        backText.setFill(enterColor);
    }
    
    //Getters and Setters
    /**
     * @return the gridPane 
     */
    @Override
    public Pane getPane() {
        return gridPane;
    }   
 
}
