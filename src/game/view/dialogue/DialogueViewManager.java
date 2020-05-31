/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view.dialogue;

import game.model.dialogue.Dialogue;
import game.model.dialogue.DialogueManager;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Joren
 */
public class DialogueViewManager {
    
    //Variables
    private List<DialogueView> dialogueViews = new ArrayList<>();

    /**
     * Create new DialogueViewManager
     * @param dialogueManager 
     */
    public DialogueViewManager(DialogueManager dialogueManager) {
        for(Dialogue dialogue : dialogueManager.getDialogues()){
            dialogueViews.add(new DialogueView(dialogue));
        }
    }
    
    /**
     * Render any active dialogues
     * @param g 
     */
    public void render(GraphicsContext g){
        //Check to see if any views have an active dialogue
        for(DialogueView dialogueView : dialogueViews){
            if(dialogueView.getDialogue().isActive()){
                dialogueView.render(g);
            }
        }
    }
    
}
