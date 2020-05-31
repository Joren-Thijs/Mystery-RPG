/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.dialogue;

import game.model.Game;
import game.model.inventory.Item;
import game.model.inventory.Note;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joren and Sam
 */
public class DialogueManager {
    
    //Variables
    private Game game;
    private List<Dialogue> dialogues = new ArrayList<>();
    private boolean talking;
    
    //DialoguePaths
    String butlerDialogue1Path = "GameFiles\\Dialogues\\Butler_Dialogue_1.txt";
    String butlerDialogue2Path = "GameFiles\\Dialogues\\Butler_Dialogue_2.txt";
    String sofieDialogue1Path = "GameFiles\\Dialogues\\Sofie_Dialogue_1.txt";
    String sofieDialogue2Path = "GameFiles\\Dialogues\\Sofie_Dialogue_2.txt";
    String suzieDialogue1Path = "GameFiles\\Dialogues\\Suzie_Dialogue_1.txt";
    String suzieDialogue2Path = "GameFiles\\Dialogues\\Suzie_Dialogue_2.txt";
    String jonnyDialogue1Path = "GameFiles\\Dialogues\\Jonny_Dialogue_1.txt";
    String jonnyDialogue2Path = "GameFiles\\Dialogues\\Jonny_Dialogue_2.txt";
    String violetDialogue1Path = "GameFiles\\Dialogues\\Violet_Dialogue_1.txt";
    String violetDialogue2Path = "GameFiles\\Dialogues\\Violet_Dialogue_2.txt";
    String ladyFisherDialogue1Path = "GameFiles\\Dialogues\\LadyFisher_Dialogue_1.txt";
    String ladyFisherKeyGivingDialoguePath = "GameFiles\\Dialogues\\LadyFisherKeyGiving_Dialogue.txt";
    String ladyFisherDialogue2Path = "GameFiles\\Dialogues\\LadyFisher_Dialogue_2.txt";
    String lordFisherToastSceneDialoguePath = "GameFiles\\Dialogues\\LordFisherToastScene_Dialogue.txt";
    String lordFisherBodyFoundDialoguePath = "GameFiles\\Dialogues\\LordFisherBodyFound_Dialogue.txt";
    String lordFisherDialogue1Path = "GameFiles\\Dialogues\\LordFisher_Dialogue_1.txt";
    String lordFisherDialogue2Path = "GameFiles\\Dialogues\\LordFisher_Dialogue_2.txt";
    String lordFisherConfrontationDialoguePath = "GameFiles\\Dialogues\\LordFisherConfrontation_Dialogue.txt";
    String jeffreyDialogue1Path = "GameFiles\\Dialogues\\Jeffrey_Dialogue_1.txt";
    
    //Dialogues
    Dialogue butlerDialogue1;
    Dialogue butlerDialogue2;
    Dialogue sofieDialogue1;
    Dialogue sofieDialogue2;
    Dialogue suzieDialogue1;
    Dialogue suzieDialogue2;
    Dialogue jonnyDialogue1;
    Dialogue jonnyDialogue2;
    Dialogue violetDialogue1;
    Dialogue violetDialogue2;
    Dialogue ladyFisherDialogue1;
    Dialogue ladyFisherKeyGivingDialogue;
    Dialogue ladyFisherDialogue2;
    Dialogue lordFisherToastSceneDialogue;
    Dialogue lordFisherBodyFoundDialogue;
    Dialogue lordFisherDialogue1;
    Dialogue lordFisherDialogue2;
    Dialogue lordFisherConfrontationDialogue;
    Dialogue jeffreyDialogue1;

    /**
     * Create new Dialogue Manager
     * @param game
     */
    public DialogueManager(Game game) {
        this.game = game;
        initialize(game);
    }
    
    //Methods
    /**
     * Create the dialogues
     * @param game 
     */
    private void initialize(Game game){
        talking = false;
        dialogues.add(butlerDialogue1 = new Dialogue(game, butlerDialogue1Path));
        dialogues.add(butlerDialogue2 = new Dialogue(game, butlerDialogue2Path));
        dialogues.add(sofieDialogue1 = new Dialogue(game, sofieDialogue1Path));
        dialogues.add(sofieDialogue2 = new Dialogue(game, sofieDialogue2Path));
        dialogues.add(suzieDialogue1 = new Dialogue(game, suzieDialogue1Path));
        dialogues.add(suzieDialogue2 = new Dialogue(game, suzieDialogue2Path));
        dialogues.add(jonnyDialogue1 = new Dialogue(game, jonnyDialogue1Path));
        dialogues.add(jonnyDialogue2 = new Dialogue(game, jonnyDialogue2Path));
        dialogues.add(violetDialogue1 = new Dialogue(game, violetDialogue1Path));
        dialogues.add(violetDialogue2 = new Dialogue(game, violetDialogue2Path));
        dialogues.add(ladyFisherDialogue1 = new Dialogue(game, ladyFisherDialogue1Path));
        dialogues.add(ladyFisherKeyGivingDialogue = new Dialogue(game, ladyFisherKeyGivingDialoguePath));
        dialogues.add(ladyFisherDialogue2 = new Dialogue(game, ladyFisherDialogue2Path));
        dialogues.add(lordFisherToastSceneDialogue = new Dialogue(game, lordFisherToastSceneDialoguePath));
        dialogues.add(lordFisherBodyFoundDialogue = new Dialogue(game, lordFisherBodyFoundDialoguePath));
        dialogues.add(lordFisherDialogue1 = new Dialogue(game, lordFisherDialogue1Path));
        dialogues.add(lordFisherDialogue2 = new Dialogue(game, lordFisherDialogue2Path));
        dialogues.add(lordFisherConfrontationDialogue = new Dialogue(game, lordFisherConfrontationDialoguePath));
        dialogues.add(jeffreyDialogue1 = new Dialogue(game, jeffreyDialogue1Path));
    }
    
    /**
     * update the current dialogue
     */
    public void update(){
        //For checking if we are talking
        boolean activeDialogue = false;
        
        for(Dialogue dialogue : dialogues){
            if(dialogue.isActive()){
                activeDialogue = true;
                dialogue.update();
            }
        }
        //If there is an active dialogue then we are talking
        talking = activeDialogue;
    }
    
    /**
     * Start a new dialogue
     * @param id 
     */
    public void  startDialogue(int id){
        
        //Check if eventManager is not Busy
        if(game.getEventManager().isInUse()) return;
        
        //Orient Character towards player
        game.getWorldManager().getWorld().getGameCharacterManager().orientGameCharacterWithIdTowardsPlayer(id);
        
        //Dialogue tree:
        switch(id){
            case 0:
                //id 0 = Player
                break;
            case 1:
                //id 1 = Butler
                //Choose a different dialogue depending on the objectiveManager
                if(game.getObjectivesManager().getCurrentObjectiveId() >= 7 &&
                    game.getObjectivesManager().getCurrentObjectiveId() < 11){
                    //Start the dialogue
                    butlerDialogue1.start();
                }
                else if(game.getObjectivesManager().getCurrentObjectiveId() == 11){
                    butlerDialogue2.start();
                }
                
                //Dialogue is in use so talking = true
                talking = true;
                break;
            case 2:
                //id 2 = Sofie
                //Choose a different dialogue depending on the objectiveManager
                if(game.getObjectivesManager().getCurrentObjectiveId() >= 7 &&
                    game.getObjectivesManager().getCurrentObjectiveId() < 11){
                    //Start the dialogue
                    sofieDialogue1.start();
                    
                    //Give the player the letter from sofie
                    Note note = new Note("Letter to Sofie", 12, "Dear Sofie", "I made a terrible mistake."
                            + "\nI accidentaly broke one of Lord Fishers"
                            + "\npriceless artifacts from his journey"
                            + "\nto the amazone, he is furious with me"
                            + "\n\nI have never seen him this mad"
                            + "\nhe's starting to scare me"
                            + "\nWish me luck asking his forgivenis"
                            + "\nKind regards Jeffrey");
                    if(!game.getWorldManager().getPlayer().getInventory().hasNote(note)){
                        game.getWorldManager().getPlayer().getInventory().addNote(note);
                        game.getEventManager().showMessage(1500, "You got a letter from Sofie");
                    }
                    
                }
                else if(game.getObjectivesManager().getCurrentObjectiveId() == 11){
                    //Different dialogue
                    sofieDialogue2.start();
                }
                
                //Dialogue is in use so talking = true
                talking = true;
                break;
            case 3:
                //id 3 = Suzie
                //Choose a different dialogue depending on the objectiveManager
                if(game.getObjectivesManager().getCurrentObjectiveId() >= 7 &&
                    game.getObjectivesManager().getCurrentObjectiveId() < 11){
                    //Start the dialogue
                    suzieDialogue1.start();
                }
                else if(game.getObjectivesManager().getCurrentObjectiveId() == 11){
                    //Different dialogue
                    suzieDialogue2.start();
                }
                
                //Dialogue is in use so talking = true
                talking = true;
                break;
            case 4:
                //id 4 = Jonny
                //Choose a different dialogue depending on the objectiveManager
                if(game.getObjectivesManager().getCurrentObjectiveId() >= 7 &&
                    game.getObjectivesManager().getCurrentObjectiveId() < 11){
                    //Start the dialogue
                    jonnyDialogue1.start();
                }
                else if(game.getObjectivesManager().getCurrentObjectiveId() == 11){
                    //Different dialogue
                    jonnyDialogue2.start();
                }
                
                //Dialogue is in use so talking = true
                talking = true;
                break;
            case 5:
                //id 5 = Violet
                //Choose a different dialogue depending on the objectiveManager
                if(game.getObjectivesManager().getCurrentObjectiveId() >= 7 &&
                    game.getObjectivesManager().getCurrentObjectiveId() < 11){
                    //Start the dialogue
                    violetDialogue1.start();
                }
                else if(game.getObjectivesManager().getCurrentObjectiveId() == 11){
                    //Different dialogue
                    violetDialogue2.start();
                }
                
                //Dialogue is in use so talking = true
                talking = true;
                break;
            case 6:
                //id 6 = Lady Fisher
                //Choose a different dialogue depending on the objectiveManager
                if(game.getObjectivesManager().getCurrentObjectiveId() >= 7 &&
                    game.getObjectivesManager().getCurrentObjectiveId() < 8){
                    //Start the dialogue
                    ladyFisherDialogue1.start();
                    break;
                }
                else if(game.getObjectivesManager().getCurrentObjectiveId() == 8){
                    //Start the keyGiving dialogue
                    ladyFisherKeyGivingDialogue.start();
                    
                    //Give the player the key to the second floor
                    Item item = new Item("StairWay key", 0);
                    if(!game.getWorldManager().getPlayer().getInventory().hasItem(item)){
                        game.getWorldManager().getPlayer().getInventory().addItem(item);
                        game.getEventManager().showMessage(1500, "You got the stairways key");
                    }
                    //Advance the game objective manager
                    game.getObjectivesManager().advanceCurrentObjectiveId(9);
                    talking = true;
                    break;
                }
                if(game.getObjectivesManager().getCurrentObjectiveId() >= 9 &&
                    game.getObjectivesManager().getCurrentObjectiveId() <= 11){
                    //Start the dialogue
                    ladyFisherDialogue2.start();
                }
                //Dialogue is in use so talking = true
                talking = true;
                break;
            case 7:
                //id 7 = Lord Fisher
                //Choose a different dialogue depending on the objectiveManager
                if(game.getObjectivesManager().getCurrentObjectiveId() == 3){
                    //Start the opening toasting dialogue
                    lordFisherToastSceneDialogue.start();
                    
                    //Show Jeffrey collapsing at end of dialogue
                    game.getEventManager().showMessage(1500, "Jeffrey", "I don't feel so good");
                    game.getEventManager().showMessage(1500, "Jeffrey", "urgggh my stomach");
                    game.getEventManager().showMessage(1500, "Jeffrey", "*cough cough cough*");
                    game.getEventManager().showMessage(1500, "Jeffrey", "Aaarrgggghhhhh!!!!");
                    game.getEventManager().showMessage(1500, "*Jeffrey collapses*");
                    //Advance the game objective manager
                    game.getObjectivesManager().advanceCurrentObjectiveId(4);
                }
                else if(game.getObjectivesManager().getCurrentObjectiveId() == 5){
                    //Body found dialogue
                    lordFisherBodyFoundDialogue.start();
                    //Advance the game objective manager
                    game.getObjectivesManager().advanceCurrentObjectiveId(6);
                }
                else if(game.getObjectivesManager().getCurrentObjectiveId() >= 7 &&
                        game.getObjectivesManager().getCurrentObjectiveId() < 11){
                    
                    lordFisherDialogue1.start();
                }
                else if(game.getObjectivesManager().getCurrentObjectiveId() == 11){
                    //Different dialogue
                    lordFisherDialogue2.start();
                }
                else if(game.getObjectivesManager().getCurrentObjectiveId() == 13){
                    lordFisherConfrontationDialogue.start();
                }
                
                //Dialogue is in use so talking = true
                talking = true;
                break;
            case 8:
                //id 8 = Jeffrey
                //Choose a different dialogue depending on the objectiveManager
                if(game.getObjectivesManager().getCurrentObjectiveId() == 1){
                    //Start the dialogue
                    jeffreyDialogue1.start();
                    //Advance the game objective manager
                    game.getObjectivesManager().advanceCurrentObjectiveId(2);
                }
                //Dialogue is in use so talking = true
                talking = true;
                break;
            
            //If wrong id number do nothing
            default:
                break;
        }
    }
    
    //Getters and Setters
    /**
     * @return the dialogues
     */
    public List<Dialogue> getDialogues() {
        return dialogues;
    }

    /**
     * @return the talking
     */
    public boolean isTalking() {
        return talking;
    }   
}
