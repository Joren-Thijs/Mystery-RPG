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
public class Item {

    //Variables
    protected String name;
    protected int id;

    /**
     * Create a new Item
     * @param name
     * @param id 
     */
    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    //Methods
    /**
     * @return the name and id of the item
     */
    @Override
    public String toString(){
        return "name: " + name + " id: "+ id;
    }
    
    //Getters and Setters
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
}
