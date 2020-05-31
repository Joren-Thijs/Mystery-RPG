/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view.events;

import game.model.events.EventManager;
import game.view.dialogue.TextBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Joren
 */
public class EventViewManager {
    
    //Variables
    private EventManager eventManager;
    
    //Messages
    private TextBox textBox;
    
    //Transition frames
    //For drawing the frame
    private Color frameColor = Color.BLACK;
    
    //For drawing the Title
    private Color textColor = Color.WHITE;
    private String titleFont = "Italic";
    private double titleFontSize = 35;
    private double xTitle = 50;
    private double yTitle = 700;
    
    private double frameWidth;
    private double frameHeight;
    
    /**
     * Create a new EventViewManager
     * @param eventManager 
     * @param frameWidth 
     * @param frameHeight 
     */
    public EventViewManager(EventManager eventManager, double frameWidth, double frameHeight) {
        this.eventManager = eventManager;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        textBox = new TextBox();
    }
    
    //Methods
    /**
     * render the current events
     * @param g 
     */
    public void render(GraphicsContext g){
        
        //Render the messages
        renderMessages(g);
        //Render the transition frames
        renderTransitionFrames(g);
    }
    
    /**
     * Render the current message
     * @param g 
     */
    private void renderMessages(GraphicsContext g){
        //Messaging:
        if(eventManager.getMessages().isEmpty()) return;
        if(eventManager.isInUse() &&
           eventManager.getMessages().get(0).getTimeMessageVisible().isRunning()){
            
            //Draw the message
            textBox.render(g, eventManager.getMessages().get(0).getTitle(), eventManager.getMessages().get(0).getMessage());
        }
    }
    
    /**
     * Render the current transition frame
     * @param g 
     */
    private void renderTransitionFrames(GraphicsContext g){
        //Transition Frames:
        if(eventManager.getTransitionFrames().isEmpty()) return;
        if(eventManager.isInUse() &&
           eventManager.getTransitionFrames().get(0).getTimeFrameVisible().isRunning()){
            
            //Draw the transition frame
            g.setFill(frameColor);
            g.fillRect(0, 0, frameWidth, frameHeight);
            
            //Draw the frame title
            g.setFill(textColor);
            g.setFont(Font.font(titleFont, titleFontSize));
            g.fillText(eventManager.getTransitionFrames().get(0).getTitle(), xTitle, yTitle);
        }
    }
    
    //Getters and Setters
    
}
