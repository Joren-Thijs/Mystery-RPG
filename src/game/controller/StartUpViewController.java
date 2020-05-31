/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.controller;

import game.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * FXML Controller class is used for the startupView
 * 
 * @author Joren and Sam
 */
public class StartUpViewController extends FXMLGameController implements Initializable {

    // Variables

    // FXML items
    @FXML
    private ComboBox<String> resolutionComboBox;
    @FXML
    private Text text;
    @FXML
    private Button startBtn;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Rectangle backGroundRect;
    @FXML
    private CheckBox fullScreenCheckBox;

    // Methods
    /**
     * Initialize the controller
     * 
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Set text
        text.setText("Please select a preffered resoltion:");

        // Uncheck full-screen textBox
        fullScreenCheckBox.setSelected(false);

        // Add the resolution options to the combobox
        resolutionComboBox.getItems().addAll("320 x 200", "320 x 240", "400 x 300", "512 x 384", "640 x 480",
                "800 x 600", "1024 x 768", "1152 x 864", "1280 x 600", "1280 x 720", "1280 x 800", "1280 x 960",
                "1280 x 1024", "1360 x 768", "1366 x 768", "1400 x 1050", "1600 x 900", "1680 x 1050", "1920 x 1080");
    }

    // Event methods
    /**
     * When the button is clicked
     * 
     * @param event
     */
    @FXML
    private void startBtnClicked(ActionEvent event) {
        // Get resolution in format String
        String resolution = resolutionComboBox.getSelectionModel().getSelectedItem();
        // Load next scene
        if (main != null && resolution != null) {
            main.setFullScreen(fullScreenCheckBox.isSelected());
            main.loadMainMenuView(resolution);
        }

    }

    // Getters and Setters
    /**
     * @param main
     */
    @Override
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * return the Pane used by this scene
     * 
     * @return
     */
    @Override
    public Pane getPane() {
        return anchorPane;
    }
}
