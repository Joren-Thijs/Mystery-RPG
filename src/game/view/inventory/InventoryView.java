/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view.inventory;

import game.model.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * @author Joren
 */
public class InventoryView {

    // Variables
    private Game game;

    // Drawing inventory
    // BackGround
    private double xPos = 100;
    private double yPos = 100;
    private double width = 850;
    private double height = 550;
    private double arcWidth = 50;
    private double arcHeight = 50;
    private Color backGroundColor = Color.web("#313131");

    // For drawing the frame
    private Color frameColor = Color.WHITE;

    // Seperation Bar
    private double barWidth = 15;
    private Color barColor = Color.WHITE;

    // title of list of items
    private String itemsTitle = "Items:";
    private String itemsTitleFont = "Calibri";
    private double itemsTitleFontSize = 20;
    private double itemsTitleX = 30;
    private double itemsTitleY = 50;

    // List of items
    private String itemsTextFont = "Calibri";
    private double itemsTextFontSize = 16;
    private double itemsTextX = 90;
    private double itemsTextY = 15;
    private double itemsTextOffsetY = 30;

    // title of list of notes
    private String notesTitle = "Notes:";
    private String notesTitleFont = "Calibri";
    private double notesTitleFontSize = 20;
    private double notesTitleX = 30;
    private double notesTitleY = 0;
    // "Calibri"
    // List of notes
    private String notesTextFont = "Calibri";
    private double notesTextFontSize = 16;
    private double notesTextX = 90;
    private double notesTextY = 20;
    private double notesTextOffsetY = 30;

    // The active Note BackGround
    private double spacingX = 15;
    private double spacingY = 20;
    private double noteBackGroundX = xPos + (width / 2) + (barWidth / 2) + spacingX;
    private double noteBackGroundY = yPos + spacingY;
    private double noteBackWidth = (width / 2) - (barWidth) - (spacingX * 2);
    private double noteBackHeight = (height - (spacingY * 2));
    private double noteBackArcWidth = 40;
    private double noteBackArcHeight = 40;
    private Color noteBackGroundColor = Color.WHITE;

    // The active note
    private String noteTitleFont = "Italic";
    private double noteTitleFontSize = 18;
    private String noteTextFont = "Italic";
    private double noteTextFontSize = 14;
    private String noNotesTitle = "";
    private String noNotesText = "You have not made any notes";
    private Color noteTextColor = Color.BLACK;
    private double noteTitleX = noteBackGroundX + 25;
    private double noteTitleY = noteBackGroundY + 35;
    private double noteTextX = noteTitleX - 8;
    private double noteTextY = noteTitleY + 30;

    /**
     * Create new InventoryView
     * 
     * @param game
     */
    public InventoryView(Game game) {
        this.game = game;
    }

    // Methods
    /**
     * renders the inventoryView
     * 
     * @param g
     */
    public void render(GraphicsContext g) {
        if (game.getWorldManager().getPlayer().isLookingAtInventory()) {
            // Render the inventory:

            // Background:
            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            // Draw the background
            g.setFill(backGroundColor);
            g.fillRoundRect(xPos, yPos, width, height, arcWidth, arcHeight);

            // Draw the Frame for the dialogueBox
            g.setStroke(frameColor);
            g.setLineWidth(2);
            g.strokeRoundRect(xPos, yPos, width, height, arcWidth, arcHeight);

            // Draw the separation Bar
            g.setFill(barColor);
            g.fillRect(xPos + (width / 2) - (barWidth / 2), yPos, barWidth, height);
            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            // List of Items:
            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            // Make Font Bigger for titles
            g.setFont(Font.font(itemsTitleFont, itemsTitleFontSize));

            // Draw the title for items
            g.fillText(itemsTitle, xPos + itemsTitleX, yPos + itemsTitleY);

            // Make Font smaller for lists
            g.setFont(Font.font(itemsTextFont, itemsTextFontSize));

            // Draw the list of items
            for (int i = 0; i < game.getWorldManager().getPlayer().getInventory().getItems().size(); i++) {
                g.fillText("-" + game.getWorldManager().getPlayer().getInventory().getItems().get(i).getName(),
                        xPos + itemsTextX, yPos + itemsTitleY + itemsTextY + (i * itemsTextOffsetY));
            }
            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            // List of Notes:
            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            // Get wich note the player is currently looking at
            int noteIndex = game.getWorldManager().getPlayer().getNoteIndex();

            // Make Font Bigger for titles
            g.setFont(Font.font(notesTitleFont, notesTitleFontSize));

            // Draw the title for the notes
            g.fillText(notesTitle, xPos + notesTitleX, yPos + notesTitleY + (height / 2));

            // Make Font smaller for lists
            g.setFont(Font.font(notesTextFont, notesTextFontSize));

            // Draw the list of notes
            for (int i = 0; i < game.getWorldManager().getPlayer().getInventory().getNotes().size(); i++) {

                // If this note matches the one the player has selected with the noteIndex
                if (i == noteIndex) {
                    g.fillText(
                            "-> " + game.getWorldManager().getPlayer().getInventory().getNotes().get(i).getName()
                                    + " <-",
                            xPos + notesTextX, yPos + notesTitleY + notesTextY + (height / 2) + (i * notesTextOffsetY));
                }
                // If this note is not selected
                else {
                    g.fillText("-" + game.getWorldManager().getPlayer().getInventory().getNotes().get(i).getName(),
                            xPos + notesTextX, yPos + notesTitleY + notesTextY + (height / 2) + (i * notesTextOffsetY));
                }
            }
            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            // The current note:
            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            // Draw the background for the current note
            g.setFill(noteBackGroundColor);
            g.fillRoundRect(noteBackGroundX, noteBackGroundY, noteBackWidth, noteBackHeight, noteBackArcWidth,
                    noteBackArcHeight);

            //// Draw the current note
            g.setFill(noteTextColor);
            // If the player has no notes yet
            if (game.getWorldManager().getPlayer().getInventory().getNotes().size() == 0) {

                // Make Font Bigger for titles
                g.setFont(Font.font(noteTitleFont, noteTitleFontSize));

                // Draw note title
                g.fillText(noNotesTitle, noteTitleX, noteTitleY);

                // Make Font smaller for text
                g.setFont(Font.font(noteTextFont, noteTextFontSize));

                // Draw note text
                g.fillText(noNotesText, noteTextX, noteTextY);
            } else {

                // Make Font Bigger for titles
                g.setFont(Font.font(noteTitleFont, noteTitleFontSize));

                // Draw note title
                g.fillText(game.getWorldManager().getPlayer().getInventory().getNotes().get(noteIndex).getTitle(),
                        noteTitleX, noteTitleY);

                // Make Font smaller for text
                g.setFont(Font.font(noteTextFont, noteTextFontSize));

                // Draw note text
                g.fillText(game.getWorldManager().getPlayer().getInventory().getNotes().get(noteIndex).getText(),
                        noteTextX, noteTextY);
            }
            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        }
    }

    // Getters and Setters

}
