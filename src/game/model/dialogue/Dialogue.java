/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.dialogue;

import game.model.Game;
import game.model.world.World;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joren and Sam
 */
public class Dialogue {

    // Variables
    // Main variables
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private Game game;
    // Current state of the dialogue
    private boolean active;

    // Lists of dialogues and responses
    private List<DialogueBlock> dialogues = new ArrayList<>();
    private List<DialogueBlock> responses = new ArrayList<>();
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    // Dialogue System:
    // switch between dialoguing and responding
    private boolean dialoguing;

    // Dialogue:
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // Id of the current Dialogue
    private int dialogueId;
    private String dialogueTitle;
    private String currentDialogueText;
    // Current DialogueText split into lines
    private String[] currentDialogueLines;
    private int dialogueIndex;
    // Responses to jump to
    private int[] dialogueJumps;
    private boolean jumpToNextDialogue;
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    // Response:
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private String[] responseTitles;
    private String[] currentResponseLines;
    // Dialogues to jump to
    private int[] responseJumps;
    private boolean jumpToNextResponse;
    // number of current response selected
    private int responseIndex;
    // Current response selected
    private DialogueBlock currentResponseBlock;
    // List of different responses to current dialogueBlock
    private DialogueBlock[] currentResponseBlocks;
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    /**
     * Create a new Dialogue
     * 
     * @param game
     * @param path
     */
    public Dialogue(Game game, String path) {
        this.game = game;
        initialize(path);
    }

    // Methods
    /**
     * Load in the dialogue and set the variables
     * 
     * @param path
     */
    private void initialize(String path) {

        // Dialogue
        active = false;
        // Load the dialogue from file
        disectDialogueFile(path);

        // Set text feeding
        dialogueId = 0;
        dialogueIndex = 0;
        responseIndex = 0;

        jumpToNextDialogue = true;

        dialoguing = true;
        int[] temp = { 0 };
        // To avoid nullpointer exceptions in the view
        currentResponseBlock = new DialogueBlock("", 0, "", temp);
        currentResponseBlocks = new DialogueBlock[1];
        currentResponseBlocks[0] = currentResponseBlock;
    }

    /**
     * Start the dialogue
     */
    public void start() {
        active = true;
    }

    /**
     * update the current dialogue
     */
    public void update() {

        // If the game character is talking
        if (dialoguing) {
            // If the next block of dialogue has to be loaded in
            if (jumpToNextDialogue) {
                // Load the next block of dialogue:
                DialogueBlock currentDialogueBlock = getDialogueBlockAtID(dialogueId);

                // Load in the information from the new block:
                dialogueTitle = currentDialogueBlock.getTitle();
                currentDialogueText = currentDialogueBlock.getText();
                currentDialogueLines = null;
                currentDialogueLines = currentDialogueText.split("\n");
                dialogueJumps = null;
                dialogueJumps = currentDialogueBlock.getJumps();

                // Reset variables
                dialogueIndex = 0;
                jumpToNextDialogue = false;
            }

            // Show the next lines when the player has pressed the next dialogue button
            if (game.getInputManager().isRight()) {
                dialogueIndex++;
            }

            // If we are at the end of the current dialogueBlock
            if (dialogueIndex >= currentDialogueLines.length) {
                // Check to see if this was the last dialogue
                if (dialogueJumps[0] == 0) {
                    // Reset variables
                    dialogueIndex = 0;
                    dialoguing = true;
                    jumpToNextDialogue = true;
                    dialogueId = 0;
                    active = false;
                    return;
                }

                // There is a response coming
                dialogueIndex = 0;
                jumpToNextResponse = true;
                dialoguing = false;
            }

        }
        // If the player is responding
        else if (!dialoguing) {
            // If the next block of responses has to be loaded in
            if (jumpToNextResponse) {
                // Load the next block of responses:
                currentResponseBlocks = null;
                currentResponseBlocks = new DialogueBlock[dialogueJumps.length];

                // Load in the information from the new blocks
                // de-initialize the arrays
                responseTitles = null;
                currentResponseLines = null;
                responseJumps = null;

                // Re-initialize the arrays
                responseTitles = new String[dialogueJumps.length];
                currentResponseLines = new String[dialogueJumps.length];
                responseJumps = new int[dialogueJumps.length];

                // re-fill the arrays
                for (int i = 0; i < dialogueJumps.length; i++) {
                    currentResponseBlocks[i] = getResponseBlockAtID(dialogueJumps[i]);
                    responseTitles[i] = currentResponseBlocks[i].getTitle();
                    currentResponseLines[i] = currentResponseBlocks[i].getText();
                    responseJumps[i] = currentResponseBlocks[i].getJumps()[0];
                }
                // Reset variables
                responseIndex = 0;
                jumpToNextResponse = false;
            }

            // select the next response when the player presses the up button
            if (game.getInputManager().isUp()) {
                responseIndex--;
            }
            // select the previous response when the player presses the down button
            if (game.getInputManager().isDown()) {
                responseIndex++;
            }

            // Check for array out of bounds exxceptions
            if (responseIndex >= currentResponseBlocks.length) {
                responseIndex = 0;
            }
            if (responseIndex < 0) {
                responseIndex = currentResponseBlocks.length - 1;
            }

            // Set the current response
            currentResponseBlock = currentResponseBlocks[responseIndex];

            // If the player presses the enter button go to next block of dialogue
            if (game.getInputManager().isEnter()) {
                // Check to see if this was the last dialogue
                if (responseJumps[0] == 0) {
                    // Reset variables
                    dialoguing = true;
                    jumpToNextDialogue = true;
                    dialogueId = 0;
                    active = false;
                    return;
                }

                // There is a dialogue coming
                dialogueId = responseJumps[responseIndex];
                jumpToNextDialogue = true;
                dialoguing = true;
            }
        }
    }

    /**
     * returns the dialogueBlock with the corresponding id
     * 
     * @param id
     * @return
     */
    private DialogueBlock getDialogueBlockAtID(int id) {
        for (DialogueBlock dialogueblock : dialogues) {
            if (dialogueblock.getId() == id) {
                return dialogueblock;
            }
        }

        return null;
    }

    /**
     * returns the responseBlock with the corresponding id
     * 
     * @param id
     * @return
     */
    private DialogueBlock getResponseBlockAtID(int id) {
        for (DialogueBlock dialogueblock : responses) {
            if (dialogueblock.getId() == id) {
                return dialogueblock;
            }
        }
        return null;
    }

    /**
     * Converts a dialogueFile into blocks of text and loads them into the dialogues
     * and responses lists
     * 
     * @param path
     */
    private void disectDialogueFile(String path) {

        String file = loadFileAsString(path);
        String[] blocks = file.split("//>\\s+<//");
        String[][] elements = new String[blocks.length][];
        for (int i = 0; i < blocks.length; i++) {
            elements[i] = blocks[i].split("><");
        }

        for (int i = 0; i < blocks.length; i++) {

            if (!checkDialogueBlockIntegrety(elements[i])) {
                // Print error message
                System.out.println("Dialogue TextBlock failed integrety check!" + "\n" +
                // Number of the block
                        "block: " + i + "\n" +
                        // Path of the Dialogue file
                        "At path: " + path);
                // Go to the next Block
                continue;
            }

            if (subtractStringAtFront("<//", elements[i][0]).equalsIgnoreCase("dialogue")) {
                dialogues.add(new DialogueBlock(subtractStringAtFront("title:", elements[i][1]),
                        Integer.parseInt(subtractStringAtFront("id:", elements[i][2])),
                        subtractStringAtFront("text:", elements[i][3]),
                        parseIntArray(subtractStringAtFront("jump:", elements[i][4]))));
            } else if (subtractStringAtFront("<//", elements[i][0]).equalsIgnoreCase("response")) {
                responses
                        .add(new DialogueBlock("Player", Integer.parseInt(subtractStringAtFront("id:", elements[i][1])),
                                subtractStringAtFront("text:", elements[i][2]),
                                parseIntArray(subtractStringAtFront("jump:", elements[i][3]))));
            }
        }
    }

    /**
     * Check if a dialogue block is correctly structured
     * 
     * @param block
     * @return
     */
    private boolean checkDialogueBlockIntegrety(String[] block) {
        // Check the first element
        if (!subtractStringAtFront("<//", block[0]).equalsIgnoreCase("dialogue")
                && !subtractStringAtFront("<//", block[0]).equalsIgnoreCase("response")) {
            return false;
        }

        // Check if its a dialogue or a response

        // If its a dialogue
        if (subtractStringAtFront("<//", block[0]).equalsIgnoreCase("dialogue")) {
            if (!cutOutStringAtFront("title:", block[1]).equalsIgnoreCase("title:")) {
                return false;
            }
            if (!cutOutStringAtFront("id:", block[2]).equalsIgnoreCase("id:")) {
                return false;
            }
            if (!cutOutStringAtFront("text:", block[3]).equalsIgnoreCase("text:")) {
                return false;
            }
            if (!cutOutStringAtFront("jump:", block[4]).equalsIgnoreCase("jump:")) {
                return false;
            }
        }
        // If its a response
        else if (subtractStringAtFront("<//", block[0]).equalsIgnoreCase("response")) {
            if (!cutOutStringAtFront("id:", block[1]).equalsIgnoreCase("id:")) {
                return false;
            }
            if (!cutOutStringAtFront("text:", block[2]).equalsIgnoreCase("text:")) {
                return false;
            }
            if (!cutOutStringAtFront("jump:", block[3]).equalsIgnoreCase("jump:")) {
                return false;
            }
        }

        // No integrety errors found
        return true;
    }

    /**
     * Load a file as a String
     * 
     * @param path
     * @return the file in String format
     */
    private String loadFileAsString(String path) {
        try {
            // Load file as String
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            return new String(bytes);
        } catch (IOException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Converts a String of integers separated by a comma to an integer Array
     * 
     * @param array String with format "a,b,c"
     * @return
     */
    private int[] parseIntArray(String array) {
        String[] integers = array.split(",");
        int[] newArray = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            newArray[i] = Integer.parseInt(integers[i]);
        }
        return newArray;
    }

    /**
     * Subtracts a piece of String from the front of another String if it contains
     * it Else it returns the original text
     * 
     * @param subtraction
     * @param text
     * @return
     */
    private String subtractStringAtFront(String subtraction, String text) {
        try {
            // Create Two String Builders
            StringBuilder front = new StringBuilder(text);
            StringBuilder back = new StringBuilder(text);

            // Delete the back part of the String
            front.delete(subtraction.length(), text.length());
            // Delete the front part of the String
            back.delete(0, subtraction.length());

            String frontString = front.toString();
            String backString = back.toString();

            // If the frontString equals what was to be subtracted
            if (frontString.equalsIgnoreCase(subtraction)) {
                return backString;
            }
            // If there was nothing to subtract return the original text
            else {
                return text;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return "";
        }
    }

    /**
     * This method cuts out the front of a string and returns it so it can be
     * compared
     * 
     * @param cutOut the length of this string is cut out from text
     * @param text
     * @return
     */
    private String cutOutStringAtFront(String cutOut, String text) {
        // Create String builder
        StringBuilder front = new StringBuilder(text);
        // Delete the back part
        front.delete(cutOut.length(), text.length());
        // Return the front part
        return front.toString();
    }

    // Getters and Setters
    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @return the dialogueTitle
     */
    public String getDialogueTitle() {
        return dialogueTitle;
    }

    /**
     * @return the currentDialogueText
     */
    public String getCurrentDialogueText() {
        return currentDialogueText;
    }

    /**
     * @return the currentDialogueLines
     */
    public String[] getCurrentDialogueLines() {
        return currentDialogueLines;
    }

    /**
     * @return the dialogueIndex
     */
    public int getDialogueIndex() {
        return dialogueIndex;
    }

    /**
     * @return the state of the dialogue
     */
    public boolean isDialoguing() {
        return dialoguing;
    }

    /**
     * @return the currentResponseBlock
     */
    public DialogueBlock getCurrentResponseBlock() {
        return currentResponseBlock;
    }

    /**
     * @return the currentResponseBlocks
     */
    public DialogueBlock[] getCurrentResponseBlocks() {
        return currentResponseBlocks;
    }

    /**
     * @return the responseIndex
     */
    public int getResponseIndex() {
        return responseIndex;
    }

}
