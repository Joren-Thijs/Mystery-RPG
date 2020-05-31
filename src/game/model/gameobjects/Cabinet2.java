/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects;

import game.model.Game;
import game.model.inventory.Item;
import game.model.inventory.Note;

/**
 * @author Joren and Sam
 */
public class Cabinet2 extends StaticGameObject {
    
    //Variables
    private Note note1 = new Note("Letter to Henry", 5, "Dear henry", "As you know we aprreciate everything"
                                                                + "\nyou have done for us over the years."
                                                                + "\nYou told me last month that your"
                                                                + "\nsons illness is getting worse"
                                                                + "\nunfortunatly i cannot lend you the money"
                                                                + "\nto take him on a journey to canada to find"
                                                                + "\nthis strange doctor you speak of"
                                                                + "\nthere is simply no cure, and"
                                                                + "\nyou are in no position to pay me back."
                                                                + "\nI am sorry old friend"
                                                                + "\n\nKind regards Lord Fisher");
    
    private Note note2 = new Note("Henry's son", 10, "Note:", "Henry's son is sick"
                                                                + "\nHe wanted to borrow money to cure him"
                                                                + "\nBut there is no cure"
                                                                + "\nthats so sad. but thats no reason"
                                                                + "\nto kill Jeffrey");
    
    /**
     * Create a new Cabinet2
     * @param game
     * @param x
     * @param y
     * @param message 
     */
    public Cabinet2(Game game, double x, double y, String message) {
        super(game, 5, x, y, 64, 128, message);
    }

    //Methods
    /**
     * Update the GameObject
     */
    @Override
    public void update() {
        
    }
    
    /**
     * When the Player wants to interact with the cabinet
     */
    @Override
    public void interact(){
        
        //Give the player an item
        if(!game.getWorldManager().getPlayer().getInventory().hasNote(note1) &&
           !game.getWorldManager().getPlayer().getInventory().hasNote(note2)){
            
            game.getWorldManager().getPlayer().getInventory().addNote(note1);
            game.getWorldManager().getPlayer().getInventory().addNote(note2);
            game.getEventManager().showMessage(1500, "You found a letter");
            game.getEventManager().showMessage(1500, "You made a note");
        }
        else{
            super.interact();
        }
    }
    
    //Getters and Setters
    /**
     * @return the notes
     */
    public Note[] getNotes() {
        Note[] notes = new Note[2];
        notes[0] = note1;
        notes[1] = note2;
        return notes;
    }
}
