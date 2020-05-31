/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.objectives;

/**
 *
 * @author Joren
 */
public abstract class Objective {
    
    //Variables
    private final int id;
    private boolean finished;

    public Objective(int id) {
        this.id = id;
        this.finished = false;
    }
    
    
    
    //Methods
    public abstract void update();
    
    //Getters and Setters
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the finished
     */
    public boolean isFinished() {
        return finished;
    }
}
