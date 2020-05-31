/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view.dialogue;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * @author Joren
 */
public class TextBox {

    // Variables
    // For drawing DialogueBox
    private Color backGroundColor = Color.PURPLE;
    private double xPos = 200;
    private double yPos = 550;
    private double boxWidth = 700;
    private double boxHeight = 100;
    private double topBorderHeight = 10;

    // For drawing the frame
    private Color frameColor = Color.WHITE;

    // For drawing the Title
    private Color textColor = Color.WHITE;
    private String titleFont = "Calibri";
    private double titleFontSize = 18;
    private double xTitle = 20;
    private double yTitle = 20;

    // For drawing the text
    private String textFont = "Calibri";
    private double textFontSize = 18;
    private double xText = 20;
    private double yText = 45;

    // Methods
    /**
     * Render a textBox
     * 
     * @param g
     * @param title
     * @param text
     */
    public void render(GraphicsContext g, String title, String text) {
        // Draw the Background for the dialogueBox
        g.setFill(backGroundColor);
        g.fillRect(xPos, yPos, boxWidth, boxHeight);

        // Draw the top border
        g.setFill(frameColor);
        g.fillRect(xPos, yPos, boxWidth, topBorderHeight);

        // Draw the Frame for the dialogueBox
        g.setStroke(frameColor);
        g.setLineWidth(2);
        g.strokeRect(xPos, yPos, boxWidth, boxHeight);

        // Adjust the Font for the title
        g.setFont(Font.font(titleFont, titleFontSize));

        // Draw the title
        g.fillText(title, xPos + xTitle, yPos + topBorderHeight + yTitle);

        // Adjust the Font for the text
        g.setFont(Font.font(textFont, textFontSize));

        // Draw the text
        g.fillText(text, xPos + xText, yPos + topBorderHeight + yText);
    }

    /**
     * Render a Textbox
     * 
     * @param g
     * @param title
     * @param text
     * @param xOffset
     * @param yOffset
     */
    public void render(GraphicsContext g, String title, String[] text, double xOffset, double yOffset) {
        // Draw the Background for the dialogueBox
        g.setFill(backGroundColor);
        g.fillRect(xPos, yPos, boxWidth, boxHeight);

        // Draw the top border
        g.setFill(frameColor);
        g.fillRect(xPos, yPos, boxWidth, topBorderHeight);

        // Draw the Frame for the dialogueBox
        g.setStroke(frameColor);
        g.setLineWidth(2);
        g.strokeRect(xPos, yPos, boxWidth, boxHeight);

        // Adjust the Font for the title
        g.setFont(Font.font(titleFont, titleFontSize));

        // Draw the title
        g.fillText(title, xPos + xTitle, yPos + topBorderHeight + yTitle);

        // Adjust the Font for the text
        g.setFont(Font.font(textFont, textFontSize));

        // Draw the text
        for (int i = 0; i < text.length; i++) {
            g.fillText(text[i], xPos + xText + (i * xOffset), yPos + topBorderHeight + yText + (i * yOffset));
        }
    }

    /**
     * Render a Textbox with an array of text
     * 
     * @param g
     * @param title
     * @param text
     * @param selectionIndex
     * @param xOffset
     * @param yOffset
     */
    public void renderTextArrayWithSelection(GraphicsContext g, String title, String[] text, int selectionIndex,
            double xOffset, double yOffset) {
        // Draw the Background for the dialogueBox
        g.setFill(backGroundColor);
        g.fillRect(xPos, yPos, boxWidth, boxHeight);

        // Draw the top border
        g.setFill(frameColor);
        g.fillRect(xPos, yPos, boxWidth, topBorderHeight);

        // Draw the Frame for the dialogueBox
        g.setStroke(frameColor);
        g.setLineWidth(2);
        g.strokeRect(xPos, yPos, boxWidth, boxHeight);

        // Adjust the Font for the title
        g.setFont(Font.font(titleFont, titleFontSize));

        // Draw the title
        g.fillText(title, xPos + xTitle, yPos + topBorderHeight + yTitle);

        // Adjust the Font for the text
        g.setFont(Font.font(textFont, textFontSize));

        // Draw the text
        for (int i = 0; i < text.length; i++) {
            if (i == selectionIndex) {
                g.fillText("->" + text[i] + " <-", xPos + xText + (i * xOffset) - 18,
                        yPos + topBorderHeight + yText + (i * yOffset));
            } else {
                g.fillText(text[i], xPos + xText + (i * xOffset), yPos + topBorderHeight + yText + (i * yOffset));
            }
        }
    }
}
