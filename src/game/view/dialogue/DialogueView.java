/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view.dialogue;

import game.model.dialogue.Dialogue;
import javafx.scene.canvas.GraphicsContext;

/**
 * @author Joren
 */
public class DialogueView {
    
    //Variables
    private Dialogue dialogue;
    private TextBox textBox;
    
    
    /**
     * CReate a new DialogueView
     * @param dialogue 
     */
    public DialogueView(Dialogue dialogue) {
        this.dialogue = dialogue;
        textBox = new TextBox();
    }
    
    //Methods
    /**
     * render the dialogue
     * @param g 
     */
    public void render(GraphicsContext g){
        //If we the character is talking
        if(dialogue.isDialoguing()){
            
            //To protect against some random nullpointer exception that only comes when not debugging
            if(dialogue.getCurrentDialogueLines() == null) return;
            
            //Render the dialogue
            textBox.render(g, dialogue.getDialogueTitle(), dialogue.getCurrentDialogueLines()[dialogue.getDialogueIndex()]);
        }
        //If the player is responding
        else{
            String[] text = new String[dialogue.getCurrentResponseBlocks().length];
            for(int i = 0; i < dialogue.getCurrentResponseBlocks().length; i++){
                text[i] = dialogue.getCurrentResponseBlocks()[i].getText();
            }
            textBox.renderTextArrayWithSelection(g, "Sam:", text, dialogue.getResponseIndex(), 0, 30);
        }
    }
    
    //Getters and Setters
    /**
     * @return the dialogue
     */
    public Dialogue getDialogue() {
        return dialogue;
    }
}
