/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game;

import javafx.scene.image.WritableImage;

/**
 *
 * @author Joren and Sam
 */
public class GameSaver {
    
    //Variables
    private Main main;
    private WritableImage currentImage;
    
    //FilePaths
    private final String emptySaveSlotImagePath = "gamefiles/resources/EmptySaveSlotImage.png";
    private final String saveFile1Path = "gamefiles/savefiles/saveGame_1.txt";
    private final String saveSlot1ImagePath = "gamefiles/savefiles/saveSlotImage_1.png";
    private final String saveFile2Path = "gamefiles/savefiles/saveGame_2.txt";
    private final String saveSlot2ImagePath = "gamefiles/savefiles/saveSlotImage_2.png";
    private final String saveFile3Path = "gamefiles/savefiles/saveGame_3.txt";
    private final String saveSlot3ImagePath = "gamefiles/savefiles/saveSlotImage_3.png";
    private final String saveFile4Path = "gamefiles/savefiles/saveGame_4.txt";
    private final String saveSlot4ImagePath = "gamefiles/savefiles/saveSlotImage_4.png";
    
    //SaveSlots
    private SaveSlot saveSlot1;
    private SaveSlot saveSlot2;
    private SaveSlot saveSlot3;
    private SaveSlot saveSlot4;
    private SaveSlot[] saveSlots;

    /**
     * Create a new game saver
     * @param main 
     */
    public GameSaver(Main main) {
        //Set the main
        this.main = main;
        
        //Initialize the Image
        currentImage = new WritableImage(10,10);
        
        //Create the saveslots
        saveSlot1 = new SaveSlot(saveFile1Path, saveSlot1ImagePath, emptySaveSlotImagePath);
        saveSlot2 = new SaveSlot(saveFile2Path, saveSlot2ImagePath, emptySaveSlotImagePath);
        saveSlot3 = new SaveSlot(saveFile3Path, saveSlot3ImagePath, emptySaveSlotImagePath);
        saveSlot4 = new SaveSlot(saveFile4Path, saveSlot4ImagePath, emptySaveSlotImagePath);
        
        //Pu them into the array
        saveSlots = new SaveSlot[4];
        saveSlots[0] = saveSlot1;
        saveSlots[1] = saveSlot2;
        saveSlots[2] = saveSlot3;
        saveSlots[3] = saveSlot4;
    }
    
    //Methods
    /**
     * save the current game into the save slot
     * @param saveSlot 
     */
    public void saveGame(int saveSlot){
        saveSlots[saveSlot].SaveGame(main.getGameThread().getGame(), currentImage);
    }
    
    /**
     * load a game from a saveSlot
     * @param saveSlot 
     */
    public void loadGame(int saveSlot){
        saveSlots[saveSlot].loadGame(main.getGameThread().getGame());
    }
    
    //Getters and Setters
    /**
     * @return the currentImage
     */
    public WritableImage getCurrentImage() {
        return currentImage;
    }

    /**
     * @param currentImage the currentImage to set
     */
    public void setCurrentImage(WritableImage currentImage) {
        this.currentImage = currentImage;
    }

    /**
     * @return the saveSlots
     */
    public SaveSlot[] getSaveSlots() {
        return saveSlots;
    }
}
