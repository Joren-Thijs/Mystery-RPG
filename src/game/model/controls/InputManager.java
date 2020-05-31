/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.model.controls;

/**
 *
 * @author Joren and Sam
 */
public class InputManager {

    // Controls:
    // WASD = move
    // Shift = sprint
    // E = use
    // P = pause/menu
    // Tab = inventory/journal for notes
    // Up/Down = choose dialogue response
    // Right = next dialogue
    // Enter = choose dialogue response

    // Variables
    // Are only true for one cycle
    private boolean w, s, a, d, shift, e, f, tab, up, down, left, right, enter;
    // To indicate a control has already been true without releasing the key
    private boolean wUsed, sUsed, aUsed, dUsed, shiftUsed, eUsed, fUsed, tabUsed, upUsed, downUsed, leftUsed, rightUsed,
            enterUsed;
    // Keyboard keys
    private boolean wKey, sKey, aKey, dKey, shiftKey, eKey, fKey, tabKey, upKey, downKey, leftKey, rightKey, enterKey;

    // Methods
    /**
     * Update the control variables
     */
    public void update() {

        // Go through all the different control keys and see if they have been pressed
        // for one cycle
        // If they are set them to false until the keyboard key is released and pressed
        // again
        // This stops the user from spamming the keys by holding them down

        // For w
        if (wUsed && !wKey) {// If a key is released
            wUsed = false;
        } else if (w) { // If a key has been pressed for one cycle
            wUsed = true;
            w = false;
        }
        if (!wUsed && wKey) {// If a key is just pressed
            w = true;
        }

        // For s
        if (sUsed && !sKey) {// If a key is released
            sUsed = false;
        } else if (s) { // If a key has been pressed for one cycle
            sUsed = true;
            s = false;
        }
        if (!sUsed && sKey) {// If a key is just pressed
            s = true;
        }

        // For a
        if (aUsed && !aKey) {// If a key is released
            aUsed = false;
        } else if (a) { // If a key has been pressed for one cycle
            aUsed = true;
            a = false;
        }
        if (!aUsed && aKey) {// If a key is just pressed
            a = true;
        }

        // For d
        if (dUsed && !dKey) {// If a key is released
            dUsed = false;
        } else if (d) { // If a key has been pressed for one cycle
            dUsed = true;
            d = false;
        }
        if (!dUsed && dKey) {// If a key is just pressed
            d = true;
        }

        // For shift
        if (shiftUsed && !shiftKey) {// If a key is released
            shiftUsed = false;
        } else if (shift) { // If a key has been pressed for one cycle
            shiftUsed = true;
            shift = false;
        }
        if (!shiftUsed && shiftKey) {// If a key is just pressed
            shift = true;
        }

        // For e
        if (eUsed && !eKey) {// If a key is released
            eUsed = false;
        } else if (e) { // If a key has been pressed for one cycle
            eUsed = true;
            e = false;
        }
        if (!eUsed && eKey) {// If a key is just pressed
            e = true;
        }

        // For f
        if (fUsed && !fKey) {// If a key is released
            fUsed = false;
        } else if (f) { // If a key has been pressed for one cycle
            fUsed = true;
            f = false;
        }
        if (!fUsed && fKey) {// If a key is just pressed
            f = true;
        }

        // For tab
        if (tabUsed && !tabKey) {// If a key is released
            tabUsed = false;
        } else if (tab) { // If a key has been pressed for one cycle
            tabUsed = true;
            tab = false;
        }
        if (!tabUsed && tabKey) {// If a key is just pressed
            tab = true;
        }

        // For up
        if (upUsed && !upKey) {// If a key is released
            upUsed = false;
        } else if (up) { // If a key has been pressed for one cycle
            upUsed = true;
            up = false;
        }
        if (!upUsed && upKey) {// If a key is just pressed
            up = true;
        }

        // For down
        if (downUsed && !downKey) {// If a key is released
            downUsed = false;
        } else if (down) { // If a key has been pressed for one cycle
            downUsed = true;
            down = false;
        }
        if (!downUsed && downKey) {// If a key is just pressed
            down = true;
        }

        // For left
        if (leftUsed && !leftKey) {// If a key is released
            leftUsed = false;
        } else if (left) { // If a key has been pressed for one cycle
            leftUsed = true;
            left = false;
        }
        if (!leftUsed && leftKey) {// If a key is just pressed
            left = true;
        }

        // For right
        if (rightUsed && !rightKey) {// If a key is released
            rightUsed = false;
        } else if (right) { // If a key has been pressed for one cycle
            rightUsed = true;
            right = false;
        }
        if (!rightUsed && rightKey) {// If a key is just pressed
            right = true;
        }

        // For enter
        if (enterUsed && !enterKey) {// If a key is released
            enterUsed = false;
        } else if (enter) { // If a key has been pressed for one cycle
            enterUsed = true;
            enter = false;
        }
        if (!enterUsed && enterKey) {// If a key is just pressed
            enter = true;
        }
    }

    // Getters and Setters
    /**
     * @return the w
     */
    public boolean isW() {
        return w;
    }

    /**
     * @return the s
     */
    public boolean isS() {
        return s;
    }

    /**
     * @return the a
     */
    public boolean isA() {
        return a;
    }

    /**
     * @return the d
     */
    public boolean isD() {
        return d;
    }

    /**
     * @return the shift
     */
    public boolean isShift() {
        return shift;
    }

    /**
     * @return the e
     */
    public boolean isE() {
        return e;
    }

    /**
     * @return the f
     */
    public boolean isF() {
        return f;
    }

    /**
     * @return the tab
     */
    public boolean isTab() {
        return tab;
    }

    /**
     * @return the up
     */
    public boolean isUp() {
        return up;
    }

    /**
     * @return the down
     */
    public boolean isDown() {
        return down;
    }

    /**
     * @return the left
     */
    public boolean isLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public boolean isRight() {
        return right;
    }

    /**
     * @return the enter
     */
    public boolean isEnter() {
        return enter;
    }

    /**
     * @return the wKey
     */
    public boolean isWKey() {
        return wKey;
    }

    /**
     * @param wKey the wKey to set
     */
    public void setWKey(boolean wKey) {
        this.wKey = wKey;
    }

    /**
     * @return the sKey
     */
    public boolean isSKey() {
        return sKey;
    }

    /**
     * @param sKey the sKey to set
     */
    public void setSKey(boolean sKey) {
        this.sKey = sKey;
    }

    /**
     * @return the aKey
     */
    public boolean isAKey() {
        return aKey;
    }

    /**
     * @param aKey the aKey to set
     */
    public void setAKey(boolean aKey) {
        this.aKey = aKey;
    }

    /**
     * @return the dKey
     */
    public boolean isDKey() {
        return dKey;
    }

    /**
     * @param dKey the dKey to set
     */
    public void setDKey(boolean dKey) {
        this.dKey = dKey;
    }

    /**
     * @return the shiftKey
     */
    public boolean isShiftKey() {
        return shiftKey;
    }

    /**
     * @param shiftKey the shiftKey to set
     */
    public void setShiftKey(boolean shiftKey) {
        this.shiftKey = shiftKey;
    }

    /**
     * @return the eKey
     */
    public boolean isEKey() {
        return eKey;
    }

    /**
     * @param eKey the eKey to set
     */
    public void setEKey(boolean eKey) {
        this.eKey = eKey;
    }

    /**
     * @return the fKey
     */
    public boolean isFKey() {
        return fKey;
    }

    /**
     * @param fKey the fKey to set
     */
    public void setFKey(boolean fKey) {
        this.fKey = fKey;
    }

    /**
     * @return the tabKey
     */
    public boolean isTabKey() {
        return tabKey;
    }

    /**
     * @param tabKey the tabKey to set
     */
    public void setTabKey(boolean tabKey) {
        this.tabKey = tabKey;
    }

    /**
     * @return the upKey
     */
    public boolean isUpKey() {
        return upKey;
    }

    /**
     * @param upKey the upKey to set
     */
    public void setUpKey(boolean upKey) {
        this.upKey = upKey;
    }

    /**
     * @return the downKey
     */
    public boolean isDownKey() {
        return downKey;
    }

    /**
     * @param downKey the downKey to set
     */
    public void setDownKey(boolean downKey) {
        this.downKey = downKey;
    }

    /**
     * @return the leftKey
     */
    public boolean isLeftKey() {
        return leftKey;
    }

    /**
     * @param leftKey the leftKey to set
     */
    public void setLeftKey(boolean leftKey) {
        this.leftKey = leftKey;
    }

    /**
     * @return the rightKey
     */
    public boolean isRightKey() {
        return rightKey;
    }

    /**
     * @param rightKey the rightKey to set
     */
    public void setRightKey(boolean rightKey) {
        this.rightKey = rightKey;
    }

    /**
     * @return the enterKey
     */
    public boolean isEnterKey() {
        return enterKey;
    }

    /**
     * @param enterKey the enterKey to set
     */
    public void setEnterKey(boolean enterKey) {
        this.enterKey = enterKey;
    }

}
