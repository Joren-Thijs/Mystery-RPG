/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game;

import game.model.Game;
import game.view.GameView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;

/**
 * The Thread that will run our game
 * 
 * @author Joren and Sam
 */
public class GameThread implements Runnable {

    // Variables
    private boolean running;
    private boolean paused;
    private Thread thread;
    private Game game;
    private GameView gameView;
    private GraphicsContext g;
    private double width;
    private double height;

    /**
     * Create a new GameThread
     * 
     * @param width
     * @param height
     */
    public GameThread(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Methods
    /**
     * load a new game
     */
    public void loadNewGame() {
        game = new Game();
        gameView = new GameView(game, width, height);
    }

    /**
     * Load a saved game
     */
    public void loadSavedGame() {
        // TODO
    }

    /**
     * Update the current game
     */
    private void update() {
        game.update();
    }

    /**
     * render the current gameView
     */
    private void render() {
        gameView.render(g);
    }

    /**
     * The main method of this thread Create a timer and run the game 60 times per
     * second
     */
    @Override
    public void run() {
        // Create timer
        int fps = 60;
        double timePerUpdate = 1000000000 / fps;// 10^9 nanoseconds in one second
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        // While the game is running keep updating and rendering it
        while (running) {
            // If the game is not paused update and render it
            if (!paused) {
                // Calculate the time passed
                now = System.nanoTime();
                delta += (now - lastTime) / timePerUpdate;
                lastTime = now;

                // If enough time has passed update and render the game
                if (delta >= 1) {
                    update();
                    Platform.runLater(() -> render());
                    delta--;
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * starts the game thread
     */
    public synchronized void start() {
        running = true;
        paused = false;
        // Create an new thread
        thread = new Thread(this);
        // Make this thread stop automatically when the JavaFX apliccation is closed
        thread.setDaemon(true);
        // start the thread
        thread.start();
    }

    // Getters and Setters
    /**
     * @param running
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * @return
     */
    public Game getGame() {
        return game;
    }

    // give the gameThread a paint brush to pass on to the gameView
    /**
     * @param g
     */
    public void setGraphicsContext(GraphicsContext g) {
        this.g = g;
    }

    /**
     * pause and unpause the update and render loop
     */
    public void togglePause() {
        paused = !paused;
    }

    /**
     * @return
     */
    public boolean isPaused() {
        return paused;
    }
}
