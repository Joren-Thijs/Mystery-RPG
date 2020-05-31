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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Joren
 */
public class SaveGameViewController extends FXMLGameController implements Initializable {

    // Variables
    private int selectedSaveSlot;

    // FXML Items
    @FXML
    private GridPane gridPane;
    @FXML
    private Rectangle backGroundRect;
    @FXML
    private Text backText;
    @FXML
    private Text slot1Text;
    @FXML
    private Text slot2Text;
    @FXML
    private Text slot3Text;
    @FXML
    private Text slot4Text;
    @FXML
    private Text selectASlotText;
    @FXML
    private ImageView imageView1;
    @FXML
    private ImageView imageView2;
    @FXML
    private ImageView imageView3;
    @FXML
    private ImageView imageView4;
    @FXML
    private Text lastModified1Text;
    @FXML
    private Text lastModified2Text;
    @FXML
    private Text lastModified3Text;
    @FXML
    private Text lastModified4Text;
    @FXML
    private Text overwriteText;
    @FXML
    private Text yesText;
    @FXML
    private Text noText;
    @FXML
    private Rectangle confirmationMenuRect;

    // Methods
    /**
     * Initializes the controller class.
     * 
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setConfirmationMenuVisibility(false);
    }

    /**
     * Load the information from the save slots into the controller
     */
    @Override
    public void loadSaveSlots() {

        // Do file check on save slots
        main.getGameSaver().getSaveSlots()[0].doFileCheck();
        main.getGameSaver().getSaveSlots()[1].doFileCheck();
        main.getGameSaver().getSaveSlots()[2].doFileCheck();
        main.getGameSaver().getSaveSlots()[3].doFileCheck();

        // load save slots
        imageView1.setImage(main.getGameSaver().getSaveSlots()[0].getImage());
        imageView2.setImage(main.getGameSaver().getSaveSlots()[1].getImage());
        imageView3.setImage(main.getGameSaver().getSaveSlots()[2].getImage());
        imageView4.setImage(main.getGameSaver().getSaveSlots()[3].getImage());

        // Load last modified dates
        lastModified1Text.setText(main.getGameSaver().getSaveSlots()[0].getLastModified());
        lastModified2Text.setText(main.getGameSaver().getSaveSlots()[1].getLastModified());
        lastModified3Text.setText(main.getGameSaver().getSaveSlots()[2].getLastModified());
        lastModified4Text.setText(main.getGameSaver().getSaveSlots()[3].getLastModified());
    }

    /**
     * try to save the game if save file already exists this will prompt the
     * confirmation menu
     * 
     * @param saveSlot
     */
    private void saveGame(int saveSlot) {
        selectedSaveSlot = saveSlot;
        if (main.getGameSaver().getSaveSlots()[saveSlot].isEmpty()) {
            main.getGameSaver().saveGame(saveSlot);
            loadSaveSlots();
        } else {
            setConfirmationMenuVisibility(true);
        }
    }

    /**
     * Set the visibility of the confirmation menu
     * 
     * @param visisble
     */
    private void setConfirmationMenuVisibility(boolean visisble) {
        confirmationMenuRect.setVisible(visisble);
        overwriteText.setVisible(visisble);
        yesText.setVisible(visisble);
        noText.setVisible(visisble);
    }

    // Event Methods
    @FXML
    private void OnMouseExitedBackText(MouseEvent event) {
        backText.setFill(exitColor);
    }

    @FXML
    private void OnMouseEnteredBackText(MouseEvent event) {
        backText.setFill(enterColor);
    }

    @FXML
    private void OnMouseClickedBackText(MouseEvent event) {
        main.reloadGameView();
    }

    @FXML
    private void OnMouseExitedImageView1(MouseEvent event) {
        if (!confirmationMenuRect.isVisible())
            slot1Text.setFill(exitColor);
    }

    @FXML
    private void OnMouseEnteredImageView1(MouseEvent event) {
        if (!confirmationMenuRect.isVisible())
            slot1Text.setFill(enterColor);
    }

    @FXML
    private void OnMouseClickedImageView1(MouseEvent event) {
        if (!confirmationMenuRect.isVisible())
            saveGame(0);
    }

    @FXML
    private void OnMouseExitedImageView2(MouseEvent event) {
        if (!confirmationMenuRect.isVisible())
            slot2Text.setFill(exitColor);
    }

    @FXML
    private void OnMouseEnteredImageView2(MouseEvent event) {
        if (!confirmationMenuRect.isVisible())
            slot2Text.setFill(enterColor);
    }

    @FXML
    private void OnMouseClickedImageView2(MouseEvent event) {
        if (!confirmationMenuRect.isVisible())
            saveGame(1);
    }

    @FXML
    private void OnMouseExitedImageView3(MouseEvent event) {
        if (!confirmationMenuRect.isVisible())
            slot3Text.setFill(exitColor);
    }

    @FXML
    private void OnMouseEnteredImageView3(MouseEvent event) {
        if (!confirmationMenuRect.isVisible())
            slot3Text.setFill(enterColor);
    }

    @FXML
    private void OnMouseClickedImageView3(MouseEvent event) {
        if (!confirmationMenuRect.isVisible())
            saveGame(2);
    }

    @FXML
    private void OnMouseExitedImageView4(MouseEvent event) {
        if (!confirmationMenuRect.isVisible())
            slot4Text.setFill(exitColor);
    }

    @FXML
    private void OnMouseEnteredImageView4(MouseEvent event) {
        if (!confirmationMenuRect.isVisible())
            slot4Text.setFill(enterColor);
    }

    @FXML
    private void OnMouseClickedImageView4(MouseEvent event) {
        if (!confirmationMenuRect.isVisible())
            saveGame(3);
    }

    @FXML
    private void onMouseExitedYesText(MouseEvent event) {
        yesText.setFill(exitColor);
    }

    @FXML
    private void onMouseEnteredYesText(MouseEvent event) {
        yesText.setFill(enterColor);
    }

    @FXML
    private void onMouseClickedYesText(MouseEvent event) {
        if (yesText.isVisible()) {
            main.getGameSaver().saveGame(selectedSaveSlot);
            loadSaveSlots();
            setConfirmationMenuVisibility(false);
        }
    }

    @FXML
    private void onMouseExitedNoText(MouseEvent event) {
        noText.setFill(exitColor);
    }

    @FXML
    private void onMouseEnteredNoText(MouseEvent event) {
        noText.setFill(enterColor);
    }

    @FXML
    private void onMouseClickedNoText(MouseEvent event) {
        if (noText.isVisible()) {
            // Hide the confirmation menu
            setConfirmationMenuVisibility(false);

            // Reset the textColors
            slot1Text.setFill(exitColor);
            slot2Text.setFill(exitColor);
            slot3Text.setFill(exitColor);
            slot4Text.setFill(exitColor);
        }
    }

    // Getters and Setters
    @Override
    public Pane getPane() {
        return gridPane;
    }
}
