/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game;

import com.google.gson.Gson;
import game.model.Game;
import game.model.gameobjects.characters.Direction;
import game.model.gameobjects.characters.Player;
import game.model.inventory.Item;
import game.model.inventory.Note;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

/**
 * @author Joren and Sam
 */
public class SaveSlot {

    // Variables
    private final String saveFilePath;
    String slotImagePath;
    String emptySlotImagePath;
    private File imageFile;
    private Image image;
    private boolean empty;
    private String lastModified;

    /**
     * Create a new save slot
     * 
     * @param saveFilePath
     * @param slotImagePath
     * @param emptySlotImagePath
     */
    public SaveSlot(String saveFilePath, String slotImagePath, String emptySlotImagePath) {

        // Set the file paths
        this.saveFilePath = saveFilePath;
        this.slotImagePath = slotImagePath;
        this.emptySlotImagePath = emptySlotImagePath;

        // If the save file exists
        doFileCheck();

    }

    // Methods
    /**
     * Save the game
     * 
     * @param game
     * @param image
     */
    public void SaveGame(Game game, WritableImage image) {

        // Save the new ImageFile
        this.image = image;
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", imageFile);
        } catch (Exception e) {
            Logger.getLogger(SaveSlot.class.getName()).log(Level.SEVERE, null, e);
        }

        // Save the game info to a new File
        StringBuilder builder = new StringBuilder();

        // Save objectives Manager
        builder.append("CurrentObjectivesID:");
        builder.append(game.getObjectivesManager().getCurrentObjectiveId() + "\n");
        // Save worldManager
        builder.append("CurrentWorld:");
        builder.append(game.getWorldManager().getWorldIndex() + "\n");
        // Save Player
        builder.append(convertPlayerToSaveFormat(game.getWorldManager().getPlayer()));

        try {
            Files.write(Paths.get(saveFilePath), builder.toString().getBytes());
        } catch (IOException ex) {
            Logger.getLogger(SaveSlot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Load a game from a file
     * 
     * @param game
     */
    public void loadGame(Game game) {

        // Create new Gson for loading inventory
        Gson gson = new Gson();

        // Load save file as list of Strings
        List<String> saveFile = new ArrayList<>();
        try {
            saveFile = Files.readAllLines(Paths.get(saveFilePath));
        } catch (IOException ex) {
            Logger.getLogger(SaveSlot.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Load objectivesManager objectivesID
        game.getObjectivesManager().setCurrentObjectiveId(
                Integer.parseInt(subtractStringAtFront("CurrentObjectivesID:", saveFile.get(0))));
        // Load current world
        game.getWorldManager().setWorld(Integer.parseInt(subtractStringAtFront("CurrentWorld:", saveFile.get(1))));
        // Load Players X position
        game.getWorldManager().getPlayer().getCollisionBox()
                .setX(Double.parseDouble(subtractStringAtFront("X:", saveFile.get(4))));
        // Load Players Y position
        game.getWorldManager().getPlayer().getCollisionBox()
                .setY(Double.parseDouble(subtractStringAtFront("Y:", saveFile.get(5))));
        // Load Players direction
        if (saveFile.get(7).equalsIgnoreCase("UP")) {
            game.getWorldManager().getPlayer().setDirection(Direction.UP);
        } else if (saveFile.get(7).equalsIgnoreCase("DOWN")) {
            game.getWorldManager().getPlayer().setDirection(Direction.DOWN);
        } else if (saveFile.get(7).equalsIgnoreCase("LEFT")) {
            game.getWorldManager().getPlayer().setDirection(Direction.LEFT);
        } else if (saveFile.get(7).equalsIgnoreCase("RIGHT")) {
            game.getWorldManager().getPlayer().setDirection(Direction.RIGHT);
        }
        // Load isLookingAtInventory
        if (saveFile.get(8).equalsIgnoreCase("IsLookingAtInventory:TRUE")) {
            game.getWorldManager().getPlayer().setLookingAtInventory(true);
        } else if (saveFile.get(8).equalsIgnoreCase("IsLookingAtInventory:FALSE")) {
            game.getWorldManager().getPlayer().setLookingAtInventory(false);
        }
        // Load noteIndex
        game.getWorldManager().getPlayer()
                .setNoteIndex(Integer.parseInt(subtractStringAtFront("NoteIndex:", saveFile.get(9))));

        // Check to see if inventory was empty
        if (!saveFile.get(11).equalsIgnoreCase("EMPTY")) {

            // Load inventory
            int startingPointNotes = 0;
            // Load items
            for (int i = 12; i < saveFile.size(); i++) {
                if (saveFile.get(i).equalsIgnoreCase("Notes:")) {
                    startingPointNotes = i + 1;
                    break;
                }
                game.getWorldManager().getPlayer().getInventory().addItem(gson.fromJson(saveFile.get(i), Item.class));
            }
            for (int i = startingPointNotes; i < saveFile.size(); i++) {
                game.getWorldManager().getPlayer().getInventory().addNote(gson.fromJson(saveFile.get(i), Note.class));
            }
        }

    }

    /**
     * convert player to String according to save Format
     * 
     * @param player
     * @return
     */
    private String convertPlayerToSaveFormat(Player player) {

        // Create new Gson for saving inventory
        Gson gson = new Gson();
        // Create String builder
        StringBuilder builder = new StringBuilder();

        // Create save file player section title
        builder.append("Player:\n");

        // Print his position
        builder.append("Position:\n");
        builder.append("X:" + player.getCollisionBox().getX() + "\n");
        builder.append("Y:" + player.getCollisionBox().getY() + "\n");

        // Print his direction
        builder.append("Direction:" + "\n" + player.getDirection().toString() + "\n");

        // Print is lookinAtInventory
        if (player.isLookingAtInventory()) {
            builder.append("IsLookingAtInventory:TRUE\n");
        } else {
            builder.append("IsLookingAtInventory:FALSE\n");
        }

        // Print note index
        builder.append("NoteIndex:" + player.getNoteIndex() + "\n");

        // Print inventory
        builder.append("Inventory:\n");
        // If the inventory is empty
        if (player.getInventory().isEmpty()) {
            builder.append("EMPTY");
        }
        // If the inventory is not empty
        else {
            // Convert all items to JSON and print them
            builder.append("Items:\n");
            for (Item item : player.getInventory().getItems()) {
                builder.append(gson.toJson(item) + "\n");
            }
            // Convert all notes to JSON and print them
            builder.append("Notes:\n");
            for (Note note : player.getInventory().getNotes()) {
                builder.append(gson.toJson(note) + "\n");
            }
        }

        return builder.toString();
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
     * Check if saveSlot files exist
     */
    public void doFileCheck() {
        // If the save file does exist
        if (Files.exists(Paths.get(saveFilePath), NOFOLLOW_LINKS) && checkSaveFileConsistency()) {
            // Load the save slot image
            imageFile = new File(slotImagePath);
            image = new Image(imageFile.toURI().toString());
            try {

                // Get last modified date from save file
                BasicFileAttributes atribbutes = Files
                        .getFileAttributeView(Paths.get(saveFilePath), BasicFileAttributeView.class).readAttributes();
                FileTime fileTime = atribbutes.lastModifiedTime();
                lastModified = ("" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format((fileTime.toMillis())));
            } catch (IOException ex) {
                Logger.getLogger(SaveSlot.class.getName()).log(Level.SEVERE, null, ex);
            }
            empty = false;
        }
        // If the save file does exist but is corrupted
        else if (Files.exists(Paths.get(saveFilePath), NOFOLLOW_LINKS) && !checkSaveFileConsistency()) {
            // Load the empty save slot image
            imageFile = new File(emptySlotImagePath);
            image = new Image(imageFile.toURI().toString());
            // Set the Image file path back to the slotImagePath
            imageFile = new File(slotImagePath);
            lastModified = "CORRUPTED";
            empty = true;
        }
        // If the save file does not exist
        else {
            // Load the empty save slot image
            imageFile = new File(emptySlotImagePath);
            image = new Image(imageFile.toURI().toString());
            // Set the Image file path back to the slotImagePath
            imageFile = new File(slotImagePath);
            lastModified = "EMPTY";
            empty = true;
        }
    }

    /**
     * Check save file integrity
     * 
     * @return true if check passes
     */
    private boolean checkSaveFileConsistency() {

        // Load save file as list of Strings
        List<String> saveFile = new ArrayList<>();
        try {
            saveFile = Files.readAllLines(Paths.get(saveFilePath));
        } catch (IOException ex) {
            Logger.getLogger(SaveSlot.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Check objectivesManager objectivesID
        if (!doStringsMatchAtFront("CurrentObjectivesID:", saveFile.get(0))) {
            return false;
        }
        // Check current world index
        if (!doStringsMatchAtFront("CurrentWorld:", saveFile.get(1))) {
            return false;
        }
        // Check Player Title
        if (!doStringsMatchAtFront("Player", saveFile.get(2))) {
            return false;
        }
        // Check Player Position title
        if (!doStringsMatchAtFront("Position:", saveFile.get(3))) {
            return false;
        }
        // Check Players X position
        if (!doStringsMatchAtFront("X:", saveFile.get(4))) {
            return false;
        }
        // Check Players Y position
        if (!doStringsMatchAtFront("Y:", saveFile.get(5))) {
            return false;
        }
        // Check Players direction title
        if (!doStringsMatchAtFront("Direction:", saveFile.get(6))) {
            return false;
        }
        // Check Players direction
        if (!doStringsMatchAtFront("UP", saveFile.get(7)) && !doStringsMatchAtFront("DOWN", saveFile.get(7))
                && !doStringsMatchAtFront("LEFT", saveFile.get(7))
                && !doStringsMatchAtFront("RIGHT", saveFile.get(7))) {
            return false;
        }

        // check isLookingAtInventory
        if (!doStringsMatchAtFront("IsLookingAtInventory:", saveFile.get(8))) {
            return false;
        }
        // Check noteIndex
        if (!doStringsMatchAtFront("NoteIndex:", saveFile.get(9))) {
            return false;
        }
        // Check inventory
        if (!doStringsMatchAtFront("Inventory:", saveFile.get(10))) {
            return false;
        }
        // Check EMPTY or Items title
        if (!doStringsMatchAtFront("EMPTY", saveFile.get(11)) && !doStringsMatchAtFront("Items:", saveFile.get(11))) {
            return false;
        }

        // All checks passed
        return true;
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
        try {
            // Create String builder
            StringBuilder front = new StringBuilder(text);
            // Delete the back part
            front.delete(cutOut.length(), text.length());
            // Return the front part
            return front.toString();
        } catch (StringIndexOutOfBoundsException e) {
            return "";
        }
    }

    /**
     * Checks if Strings Match at the beginning
     * 
     * @param front
     * @param text
     * @return true if they match
     */
    private boolean doStringsMatchAtFront(String front, String text) {
        if (cutOutStringAtFront(front, text).equalsIgnoreCase(front)) {
            return true;
        }
        return false;
    }

    // Getters and Setters
    /**
     * @return the saveFilePath
     */
    public String getSaveFilePath() {
        return saveFilePath;
    }

    /**
     * @return the imageFile
     */
    public File getImageFile() {
        return imageFile;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @return the empty
     */
    public boolean isEmpty() {
        return empty;
    }

    /**
     * @return the lastModified
     */
    public String getLastModified() {
        return lastModified;
    }
}
