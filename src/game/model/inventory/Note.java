/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.inventory;

/**
 *
 * @author Joren and Sam
 */
public class Note extends Item {
    
    //Variables
    private String title;
    private String text;
    
    /**
     * Create a new Note
     * @param name
     * @param id
     * @param title
     * @param text 
     */
    public Note(String name, int id, String title, String text) {
        super(name, id);
        this.title = title;
        this.text = text;
    }

    //Methods
    
    //Getters and Setters
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }
}
