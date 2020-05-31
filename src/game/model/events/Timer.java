/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.events;

/**
 * @author Joren
 */
public class Timer {

    //Variables
    private double duration;
    private long lastTime, timePassed;
    private boolean flag, running;
    
    /**
     * Create a new Timer
     */
    public Timer() {
        //Set the duration of the timer
        this.duration = 10;
        
        //Create the timer
        timePassed = 0;
        lastTime = System.currentTimeMillis();
        flag = false;
        running = false;
    }
    
    //Methods
    /**
     * Start the Timer
     * @param duration 
     */
    public void start(double duration){
        flag = false;
        running = true;
        this.duration = duration;
        timePassed = 0;
        lastTime = System.currentTimeMillis();
    }
    
    /**
     * Update the timer
     */
    public void update(){
        //Update the timer
        timePassed += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        
        //See if the timer is finished
        if(timePassed > duration && running){
            timePassed=0;
            flag = true;
            running = false;
        }
    }

    //Getters and Setters
    /**
     * @return the flag
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * @return the running
     */
    public boolean isRunning() {
        return running;
    }
}
