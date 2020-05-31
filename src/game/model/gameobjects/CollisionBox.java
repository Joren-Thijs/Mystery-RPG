/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.gameobjects;

/**
 * @author Joren and Sam
 */
public class CollisionBox {

    //Variables
    private double x, y, width, height;

    /**
     * Create new CollisionBox
     * @param x
     * @param y
     * @param width
     * @param height 
     */
    public CollisionBox(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    //Methods
    /**
     * Check if collisionBox c collides with this one
     * @param c
     * @return 
     */
    public boolean collidesWith(CollisionBox c){
        //Check this within collisionbox c
        //Check upper left corner
        if(this.x > c.x && this.x < c.x + c.width &&
           this.y > c.y && this.y < c.y + c.height){
            return true;
        }
        //Check upper right corner
        if(this.x + this.width > c.x && this.x + this.width < c.x + c.width &&
           this.y > c.y && this.y < c.y + c.height){
            return true;
        }
        //Check bottom left corner
        if(this.x > c.x && this.x < c.x + c.width &&
           this.y + this.height > c.y && this.y + this.height < c.y + c.height){
            return true;
        }
        //Check bottom right corner
        if(this.x + this.width > c.x && this.x + this.width < c.x + c.width &&
           this.y + this.height > c.y && this.y + this.height < c.y + c.height){
            return true;
        }
        
        //Check collisionbox c within this
        //Check upper left corner
        if(c.x > this.x && c.x < this.x + this.width &&
           c.y > this.y && c.y < this.y + this.height){
            return true;
        }
        //Check upper right corner
        if(c.x + c.width > this.x && c.x + c.width < this.x + this.width &&
           c.y > this.y && c.y < this.y + this.height){
            return true;
        }
        //Check bottom left corner
        if(c.x > this.x && c.x < this.x + this.width &&
           c.y + c.height > this.y && c.y + c.height < this.y + this.height){
            return true;
        }
        //Check bottom right corner
        if(c.x + c.width > this.x && c.x + c.width < this.x + this.width &&
           c.y + c.height > this.y && c.y + c.height < this.y + this.height){
            return true;
        }
        
        //Check if they are the same size:
        //For same width
        if(c.width == this.width){
            if(Math.abs(c.x - this.x) < c.width && c.y == this.y){
                return true;
            }
        }
        
        //For same height
        if(c.height == this.height && c.x == this.x){
            if(Math.abs(c.y - this.y) < c.height){
                return true;
            }
        }
        
        return false;
    }
    
    //Getters and Setters
    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }
}
