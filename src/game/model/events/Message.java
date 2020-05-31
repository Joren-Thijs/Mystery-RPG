/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.events;

/**
 *
 * @author Joren
 */
public class Message {
    
    //Variables
    private String title;
    private String message;
    private double displayTime;
    private Timer timeMessageVisible;
    private boolean messageDisplayed;
    private boolean doneShowing;

    /**
     * Create a new Message
     * @param title
     * @param message
     * @param displayTime 
     */
    public Message(String title, String message, double displayTime){
        this.title = title;
        this.message = message;
        this.displayTime = displayTime;
        timeMessageVisible = new Timer();
        messageDisplayed = false;
        doneShowing = false;
    }

    //Methods
    /**
     * updates the message timer and variables
     */
    public void update(){
        //Update the Timer
        timeMessageVisible.update();
        //If the massage has not started yet
        if(!messageDisplayed){
            //Start the timer
            timeMessageVisible.start(displayTime);
            messageDisplayed = true;
        }
        //If the timer has started on the current message and is done running
        if(messageDisplayed && !timeMessageVisible.isRunning()){
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
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return the displayTime
     */
    public double getDisplayTime() {
        return displayTime;
    }

    /**
     * @return the messageDisplayed
     */
    public boolean isMessageDisplayed() {
        return messageDisplayed;
    }

    /**
     * @return the doneShowing
     */
    public boolean isDoneShowing() {
        return doneShowing;
    }

    /**
     * @return the timeMessageVisible
     */
    public Timer getTimeMessageVisible() {
        return timeMessageVisible;
    }
}
