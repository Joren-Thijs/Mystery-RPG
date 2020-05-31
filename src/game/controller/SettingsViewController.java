/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.controller;

import game.Main;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 * Is used for the settingsView
 * @author Joren and Sam
 */
public class SettingsViewController extends FXMLGameController implements Initializable {

    //Variables
    private int newVolumeValue;
    private int currentVolumeValue;
    
    //FXML items
    @FXML
    private GridPane gridPane;
    @FXML
    private Rectangle backgroundRect;
    @FXML
    private Rectangle titleRect;
    @FXML
    private Text titleText;
    @FXML
    private Text audioText;
    @FXML
    private Text controlsText;
    @FXML
    private Text applyText;
    @FXML
    private Text cancelText;
    @FXML
    private Slider volumeSlider;
    @FXML
    private Text volumeValueText;

    //Methods
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Set the initial volume inside the textbox
        newVolumeValue = (int) volumeSlider.getValue();
        
    }
    
    private void saveVolumeValue(){
        //Write the current volume into a string
        StringBuilder builder = new StringBuilder();
        builder.append("Volume " + ": " + newVolumeValue);
        String fileString = builder.toString();
        
        //Write the current volume into the settings file
        try {
            Files.write(Paths.get(main.getSettingsFilePath()), fileString.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(SettingsViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Load the game volume from the settingsFile
     */
    public void loadGameVolumeFromSettingsFile(){
        
        //Try to get the game volume from the settingsfile
        try {
            //The previous set volume is extracted from the settings.txt file and split
            // arround the : now we can return this number as an intiger.
            byte[] bytes = Files.readAllBytes(Paths.get(main.getSettingsFilePath()));
            String settingsFile = new String(bytes);
            String[] settings = settingsFile.split(":");
            String setting = settings[1];
            newVolumeValue = (int) Double.parseDouble(setting);
            currentVolumeValue = (int) Double.parseDouble(setting);
  
        } catch (IOException ex) {
            
            //If it fails set the Game volume to the Default Volume
            //And save it in a new SettingsFile
            
            //Write the Default volume into a string
            StringBuilder builder = new StringBuilder();
            builder.append("Volume " + ": " + main.getDefaultGameVolume());
            String fileString = builder.toString();

            //Write the current volume into the new settings file
            try {
                Files.write(Paths.get(main.getSettingsFilePath()), fileString.getBytes());
            } catch (IOException e) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            }
            newVolumeValue = main.getDefaultGameVolume();
            currentVolumeValue = main.getDefaultGameVolume();
        }
        volumeSlider.setValue(newVolumeValue);
        volumeValueText.setText("" + newVolumeValue);
    }
    
    //Event methods
    @FXML
    private void onMouseExitedAudioText(MouseEvent event) {
        audioText.setFill(exitColor);
    }

    @FXML
    private void onMouseEnteredAudioText(MouseEvent event) {
        audioText.setFill(enterColor);
    }

    @FXML
    private void onMouseClickedAudioText(MouseEvent event) {
        
        //Make the slider invisible after hitting the audio button
        if (volumeSlider.isVisible()){
            volumeSlider.setVisible(false);
            volumeValueText.setVisible(false);
        }
        //Make the slider visible after hitting the audio button
        else {
            volumeSlider.setVisible(true);
            volumeValueText.setVisible(true);
        }
    }

    @FXML
    private void onMouseExitedControlsText(MouseEvent event) {
        controlsText.setFill(exitColor);
    }

    @FXML
    private void onMouseEnteredControlsText(MouseEvent event) {
        controlsText.setFill(enterColor);
    }

    @FXML
    private void onMouseClickedControlsText(MouseEvent event) {
        main.loadControlView();
    }

    @FXML
    private void onMouseExitedApplyText(MouseEvent event) {
        applyText.setFill(exitColor);
    }

    @FXML
    private void onMouseEnteredApplyText(MouseEvent event) {
        applyText.setFill(enterColor);
    }

    @FXML
    private void onMouseClickedApplyText(MouseEvent event) {
        
        //Save the current volume value to the settingsFile
        saveVolumeValue();
        
        //Load the main menu
        main.loadMainMenuView();
    }

    @FXML
    private void onMouseExitedCancelText(MouseEvent event) {
        cancelText.setFill(exitColor);
    }

    @FXML
    private void onMouseEnteredCancelText(MouseEvent event) {
        cancelText.setFill(enterColor);
    }

    @FXML
    private void onMouseClickedCancelText(MouseEvent event) {
        main.getMediaPlayer().setVolume(((double) currentVolumeValue) / 100);
        main.loadMainMenuView();
    }
    
    @FXML
    private void VolumeValueUpdate(MouseEvent event) {
      //Set the current value of the volume in the textbox
      newVolumeValue = (int) volumeSlider.getValue();
      volumeValueText.setText("" + newVolumeValue);
      //Set the value of the Main mediaPlayer to the current value
      main.getMediaPlayer().setVolume(((double) newVolumeValue) / 100);
    }
    
    //Getters and Setters
    /**
     * @param main
     */
    @Override
    public void setMain(Main main){
        this.main = main;
    }
    
    /**
     * @return
     */
    @Override
    public Pane getPane(){
        return gridPane;
    }
}

    

