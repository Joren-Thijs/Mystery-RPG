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
public class LoadGameViewController extends FXMLGameController implements Initializable {

    // Variables

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

    // Methods
    /**
     * Initializes the controller class.
     * 
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        main.loadMainMenuView();
    }

    @FXML
    private void OnMouseExitedImageView1(MouseEvent event) {
        slot1Text.setFill(exitColor);
    }

    @FXML
    private void OnMouseEnteredImageView1(MouseEvent event) {
        slot1Text.setFill(enterColor);
    }

    @FXML
    private void OnMouseClickedImageView1(MouseEvent event) {
        loadSaveSlots();
        if (main.getGameSaver().getSaveSlots()[0].isEmpty())
            return;
        main.loadSavedGameView(0);
    }

    @FXML
    private void OnMouseExitedImageView2(MouseEvent event) {
        slot2Text.setFill(exitColor);
    }

    @FXML
    private void OnMouseEnteredImageView2(MouseEvent event) {
        slot2Text.setFill(enterColor);
    }

    @FXML
    private void OnMouseClickedImageView2(MouseEvent event) {
        loadSaveSlots();
        if (main.getGameSaver().getSaveSlots()[1].isEmpty())
            return;
        main.loadSavedGameView(1);
    }

    @FXML
    private void OnMouseExitedImageView3(MouseEvent event) {
        slot3Text.setFill(exitColor);
    }

    @FXML
    private void OnMouseEnteredImageView3(MouseEvent event) {
        slot3Text.setFill(enterColor);
    }

    @FXML
    private void OnMouseClickedImageView3(MouseEvent event) {
        loadSaveSlots();
        if (main.getGameSaver().getSaveSlots()[2].isEmpty())
            return;
        main.loadSavedGameView(2);
    }

    @FXML
    private void OnMouseExitedImageView4(MouseEvent event) {
        slot4Text.setFill(exitColor);
    }

    @FXML
    private void OnMouseEnteredImageView4(MouseEvent event) {
        slot4Text.setFill(enterColor);
    }

    @FXML
    private void OnMouseClickedImageView4(MouseEvent event) {
        loadSaveSlots();
        if (main.getGameSaver().getSaveSlots()[3].isEmpty())
            return;
        main.loadSavedGameView(3);
    }

    // Getters and Setters
    @Override
    public Pane getPane() {
        return gridPane;
    }
}
