/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.inventory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joren and Sam
 */
public class Inventory {

    // Variables
    private List<Item> items = new ArrayList<>();
    private List<Note> notes = new ArrayList<>();

    // Methods
    /**
     * add an item to the inventory
     * 
     * @param item
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * remove an item from the inventory
     * 
     * @param item
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * add a note to the inventory
     * 
     * @param note
     */
    public void addNote(Note note) {
        notes.add(note);
    }

    /**
     * remove a note from the inventory
     * 
     * @param note
     */
    public void removeNote(Note note) {
        notes.remove(note);
    }

    /**
     * Does an item already exist in the inventory
     * 
     * @param newItem
     * @return
     */
    public boolean hasItem(Item newItem) {
        for (Item item : items) {
            if (item.getId() == newItem.getId())
                return true;
        }
        return false;
    }

    /**
     * Checks if the inventory is empty
     * 
     * @return
     */
    public boolean isEmpty() {
        if (items.size() == 0 && notes.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Does a note already exist in the inventory
     * 
     * @param newNote
     * @return
     */
    public boolean hasNote(Note newNote) {
        for (Note note : notes) {
            if (note.getId() == newNote.getId())
                return true;
        }
        return false;
    }

    /**
     * @return all the items in the inventory
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (Item item : items) {
            builder.append("Item " + i + ": ");
            builder.append(item.toString());
            builder.append("\n");
            i++;
        }
        i = 0;
        for (Note note : notes) {
            builder.append("Note " + i + ": ");
            builder.append(note.toString());
            builder.append("\n");
            i++;
        }

        return builder.toString();
    }

    // Getters and Setters
    /**
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @return the notes
     */
    public List<Note> getNotes() {
        return notes;
    }
}
