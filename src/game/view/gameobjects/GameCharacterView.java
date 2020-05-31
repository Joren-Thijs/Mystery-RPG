/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view.gameobjects;

import game.model.gameobjects.characters.Direction;
import game.model.gameobjects.characters.GameCharacter;
import game.view.sprites.GameViewCamera;
import game.view.sprites.SpriteImages;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Joren and Sam
 */
public class GameCharacterView extends GameObjectView {
    
    private int temp = 1;
    
    //Variables
    private GameCharacter gameCharacter;
    private Animation upAnimation;
    private Animation downAnimation;
    private Animation leftAnimation;
    private Animation rightAnimation;
    
    /**
     * Create new GameCharacterView
     * @param gameCharacter
     * @param gameViewCamera 
     * @param spriteImages 
     */
    public GameCharacterView(GameCharacter gameCharacter, GameViewCamera gameViewCamera, SpriteImages spriteImages) {
        super(gameCharacter, gameViewCamera, spriteImages);
        this.gameCharacter = gameCharacter;  
        upAnimation    = new Animation(gameCharacter.getId(), Direction.UP, spriteImages);
        downAnimation  = new Animation(gameCharacter.getId(), Direction.DOWN, spriteImages);
        leftAnimation  = new Animation(gameCharacter.getId(), Direction.LEFT, spriteImages);
        rightAnimation = new Animation(gameCharacter.getId(), Direction.RIGHT, spriteImages);
    }
    
    //Methods
    /**
     * Render Character
     * @param g 
     */
    @Override
    public void render(GraphicsContext g){
        
        //Update the characters animation timers
        upAnimation.update();
        downAnimation.update();
        leftAnimation.update();
        rightAnimation.update();

        //Check if the character is walking or standing
        switch(gameCharacter.getStatus()){
            case STANDING:
                //Render the static gameCharacter texture
                switch(gameCharacter.getDirection()){
                    //If the direction is UP:
                    case UP:
                        //Render the static image
                        spriteImages.getGameCharacterTextures()[gameObject.getId()][0].render(g,
                                                                                              gameObject.getX() - gameViewCamera.getxOffset(),
                                                                                              gameObject.getY() - gameViewCamera.getyOffset());
                        break;
                    //If the direction is DOWN:
                    case DOWN:
                        //Render the static image
                        spriteImages.getGameCharacterTextures()[gameObject.getId()][1].render(g,
                                                                                              gameObject.getX() - gameViewCamera.getxOffset(),
                                                                                              gameObject.getY() - gameViewCamera.getyOffset());
                        break;
                    //If the direction is LEFT:
                    case LEFT:
                        //Render the static image
                        spriteImages.getGameCharacterTextures()[gameObject.getId()][2].render(g,
                                                                                              gameObject.getX() - gameViewCamera.getxOffset(),
                                                                                              gameObject.getY() - gameViewCamera.getyOffset());
                        break;
                    //If the direction is RIGHT:
                    case RIGHT:
                        //Render the static image
                        spriteImages.getGameCharacterTextures()[gameObject.getId()][3].render(g,
                                                                                              gameObject.getX() - gameViewCamera.getxOffset(),
                                                                                              gameObject.getY() - gameViewCamera.getyOffset());
                        break;    
                }
                break;
            case WALKING:
                //Render the apropriate game character animation
                //Check wich direction its facing
                switch(gameCharacter.getDirection()){
                    //If the direction is UP:
                    case UP:
                        //render the current animation frame
                        upAnimation.getCurrentFrame().render(g,
                                                             gameCharacter.getX() - gameViewCamera.getxOffset(),
                                                             gameCharacter.getY() - gameViewCamera.getyOffset());
                        break;

                    //If the direction is DOWN:
                    case DOWN:
                        //render the current animation frame
                        downAnimation.getCurrentFrame().render(g,
                                                               gameCharacter.getX() - gameViewCamera.getxOffset(),
                                                               gameCharacter.getY() - gameViewCamera.getyOffset());
                        break;

                    //If the direction is LEFT:    
                    case LEFT:
                        //render the current animation frame
                        leftAnimation.getCurrentFrame().render(g,
                                                               gameCharacter.getX() - gameViewCamera.getxOffset(),
                                                               gameCharacter.getY() - gameViewCamera.getyOffset());
                        break;

                    //If the direction is RIGHT:    
                    case RIGHT:
                        //render the current animation frame
                        rightAnimation.getCurrentFrame().render(g,
                                                                gameCharacter.getX() - gameViewCamera.getxOffset(),
                                                                gameCharacter.getY() - gameViewCamera.getyOffset());
                        break;
                }
                break;
        }
        
        if(temp == 0){
            //Testcode
            //Render the characters collisionBox
            g.setStroke(Color.RED);
            g.strokeRect(gameCharacter.getCollisionBox().getX() - gameViewCamera.getxOffset(),
                       gameCharacter.getCollisionBox().getY() - gameViewCamera.getyOffset(),
                       gameCharacter.getCollisionBox().getWidth(),
                       gameCharacter.getCollisionBox().getHeight());
        }
    }
    
    //Getters and Setters
    /**
     * @return the gameCharacter
     */
    public GameCharacter getGameCharacter() {
        return gameCharacter;
    }

    /**
     * @return the upAnimation
     */
    public Animation getUpAnimation() {
        return upAnimation;
    }

    /**
     * @return the downAnimation
     */
    public Animation getDownAnimation() {
        return downAnimation;
    }

    /**
     * @return the leftAnimation
     */
    public Animation getLeftAnimation() {
        return leftAnimation;
    }

    /**
     * @return the rightAnimation
     */
    public Animation getRightAnimation() {
        return rightAnimation;
    }
    
}
