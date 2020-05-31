/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.events;

import game.model.Game;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * @author Joren and Sam
 */
public class EventManager {

    // Variables
    private Game game;

    // Messaging
    private boolean inUse;
    private boolean messagesInUse;
    private boolean transitionFramesInUse;
    private boolean creditsPlaying;
    private List<Message> messages = new ArrayList<>();
    private List<TransitionFrame> transitionFrames = new ArrayList<>();

    // Sound
    // Opening forest
    private final String openingForestSoundPath = "Artwork/sound/openingForestSound.mp3";
    private final String openingForestSoundFile;

    // Toast Scene
    private final String toastSceneSoundPath = "Artwork/sound/toastSceneSound.mp3";
    private final String toastSceneSoundFile;

    // Villa Fisher
    private final String villaFisherSoundPath = "Artwork/sound/villaFisherSound.mp3";
    private final String villaFisherSoundFile;

    // Credits
    private final String creditsSoundPath = "Artwork/sound/creditsSound.mp3";
    private final String creditsSoundFile;

    // MediaPlayers
    private MediaPlayer openingForestMediaPlayer;
    private MediaPlayer toastSceneMediaPlayer;
    private MediaPlayer villaFisherMediaPlayer;
    private MediaPlayer creditsMediaPlayer;

    /**
     * Create a new EventManager
     * 
     * @param game
     */
    public EventManager(Game game) {
        this.game = game;
        inUse = false;
        messagesInUse = false;
        transitionFramesInUse = false;
        creditsPlaying = false;

        openingForestSoundFile = new File(openingForestSoundPath).toURI().toString();
        openingForestMediaPlayer = new MediaPlayer(new Media(openingForestSoundFile));
        openingForestMediaPlayer.setVolume(0.1);
        openingForestMediaPlayer.play();

        toastSceneSoundFile = new File(toastSceneSoundPath).toURI().toString();
        toastSceneMediaPlayer = new MediaPlayer(new Media(toastSceneSoundFile));
        toastSceneMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        toastSceneMediaPlayer.setVolume(0.1);

        villaFisherSoundFile = new File(villaFisherSoundPath).toURI().toString();
        villaFisherMediaPlayer = new MediaPlayer(new Media(villaFisherSoundFile));
        villaFisherMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        villaFisherMediaPlayer.setVolume(0.1);

        creditsSoundFile = new File(creditsSoundPath).toURI().toString();
        creditsMediaPlayer = new MediaPlayer(new Media(creditsSoundFile));
        creditsMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        creditsMediaPlayer.setVolume(0.3);
    }

    /**
     * Create a new message for the eventManager to show
     * 
     * @param time
     * @param title
     * @param message
     */
    public void showMessage(double time, String title, String message) {
        if (!transitionFramesInUse)
            messagesInUse = true;
        messages.add(new Message(title, message, time));
    }

    /**
     * Create a new message for the eventManager to show
     * 
     * @param time
     * @param message
     */
    public void showMessage(double time, String message) {
        if (!transitionFramesInUse)
            messagesInUse = true;
        messages.add(new Message("", message, time));
    }

    /**
     * Create a transition frame for the eventManager to show
     * 
     * @param time
     * @param title
     */
    public void showTransitionFrame(double time, String title) {
        if (!messagesInUse)
            transitionFramesInUse = true;
        transitionFrames.add(new TransitionFrame(title, time));
    }

    /**
     * Look for new Messages and show them
     */
    public void update() {
        // Messaging:
        // If the dilogueManager is not busy
        if (!game.getDialogueManager().isTalking() && !transitionFramesInUse) {
            // If the buffer messages contains a message
            if (messages.size() > 0) {
                messagesInUse = true;
                messages.get(0).update();
                if (messages.get(0).isDoneShowing()) {
                    messages.remove(0);
                }
            } else {
                messagesInUse = false;
            }
        }

        // Check for any transitionFrames
        // Transistion Frames
        // If the dilogueManager is not busy
        if (!game.getDialogueManager().isTalking() && !messagesInUse) {
            // If the buffer messages contains a message
            if (transitionFrames.size() > 0) {
                transitionFramesInUse = true;
                transitionFrames.get(0).update();
                if (transitionFrames.get(0).isDoneShowing()) {
                    transitionFrames.remove(0);
                }
            } else {
                transitionFramesInUse = false;
            }
        }

        inUse = messagesInUse || transitionFramesInUse;

        // Sound:
        // If we leave the opening forest
        if (game.getWorldManager().getWorldIndex() == 1) {
            // Turn off forest sound and start villa song
            openingForestMediaPlayer.stop();
            toastSceneMediaPlayer.play();
        } else if (game.getWorldManager().getWorldIndex() > 1) {
            if (!creditsPlaying) {
                toastSceneMediaPlayer.stop();
                creditsMediaPlayer.stop();
                villaFisherMediaPlayer.play();
            } else {
                villaFisherMediaPlayer.stop();
                creditsMediaPlayer.play();
            }
        }
    }

    /**
     * @return the inUse
     */
    public boolean isInUse() {
        return inUse;
    }

    /**
     * @return the messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * @return the transitionFrames
     */
    public List<TransitionFrame> getTransitionFrames() {
        return transitionFrames;
    }

    /**
     * @return the messagesInUse
     */
    public boolean isMessagesInUse() {
        return messagesInUse;
    }

    /**
     * @return the transitionFramesInUse
     */
    public boolean isTransitionFramesInUse() {
        return transitionFramesInUse;
    }

    /**
     * @return the openingForestMediaPlayer
     */
    public MediaPlayer getOpeningForestMediaPlayer() {
        return openingForestMediaPlayer;
    }

    /**
     * @return the villaFisherMediaPlayer
     */
    public MediaPlayer getVillaFisherMediaPlayer() {
        return villaFisherMediaPlayer;
    }

    /**
     * @return the toastSceneMediaPlayer
     */
    public MediaPlayer getToastSceneMediaPlayer() {
        return toastSceneMediaPlayer;
    }

    /**
     * @return the creditsPlaying
     */
    public boolean isCreditsPlaying() {
        return creditsPlaying;
    }

    /**
     * @param creditsPlaying the creditsPlaying to set
     */
    public void setCreditsPlaying(boolean creditsPlaying) {
        this.creditsPlaying = creditsPlaying;
    }

    /**
     * @return the creditsMediaPlayer
     */
    public MediaPlayer getCreditsMediaPlayer() {
        return creditsMediaPlayer;
    }

}
