/*
 * Game Cluedo
 * 
 *  @Author Joren Thijs and Sam Vanhove
 */
package game.model.events;

/**
 *
 * @author Joren
 */
public class TransitionFrame {
    
    //Variables
    private String title;
    private double displayTime;
    private Timer timeFrameVisible;
    private boolean frameDisplayed;
    private boolean doneShowing;

    /**
     * Create a new Message
     * @param title
     * @param displayTime 
     */
    public TransitionFrame(String title, double displayTime){
        this.title = title;
        this.displayTime = displayTime;
        timeFrameVisible = new Timer();
        frameDisplayed = false;
        doneShowing = false;
    }

    //Methods
    /**
     * updates the message timer and variables
     */
    public void update(){
        //Update the Timer
        timeFrameVisible.update();
        //If the massage has not started yet
        if(!frameDisplayed){
            //Start the timer
            timeFrameVisible.start(displayTime);
            frameDisplayed = true;
        }
        //If the timer has started on the current message and is done running
        if(frameDisplayed && !timeFrameVisible.isRunning()){
            doneShowing = true;
        }
    }

    //Getters and Setters
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the displayTime
     */
    public double getDisplayTime() {
        return displayTime;
    }

    /**
     * @return the frameDisplayed
     */
    public boolean isFrameDisplayed() {
        return frameDisplayed;
    }

    /**
     * @return the doneShowing
     */
    public boolean isDoneShowing() {
        return doneShowing;
    }

    /**
     * @return the timeFrameVisible
     */
    public Timer getTimeFrameVisible() {
        return timeFrameVisible;
    }
}
