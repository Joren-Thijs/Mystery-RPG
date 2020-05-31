/*
 * Game Cluedo
 * 
 * @Author Joren Thijs and Sam Vanhove
 */
package game.view.sprites;

import java.io.File;
import java.nio.file.Files;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.nio.file.Paths;
import javafx.scene.image.Image;

/**
 * Class containing Arraylists of images for rendering
 * 
 * @author Joren and Sam
 */
public class SpriteImages {

    // DEFAULT VALUES:
    // Standard width and height of individual sprites on our spritesheet (in
    // pixels)
    private final int WIDTH = 32, HEIGHT = 32;

    // Standard width and height these sprites have to be drawn at (in pixels)
    private final int DEFAULT_TILEWIDTH = 64;
    private final int DEFAULT_TILEHEIGHT = 64;

    private final int DEFAULT_GAMEOBJECTWIDTH = 64;
    private final int DEFAULT_GAMEOBJECTHEIGHT = 64;

    private final int DEFAULT_GAMECHARACTERWIDTH = 64;
    private final int DEFAULT_GAMECHARACTERHEIGHT = 64;

    // Variables
    // SpriteSheets:
    // <editor-fold defaultstate="collapsed" desc="SpriteSheets">
    // Tiles:
    private SpriteSheet tiles1;
    private SpriteSheet tiles2;
    private SpriteSheet tiles3;

    // GameObjects:
    private SpriteSheet invisibleWallTexture;
    private SpriteSheet furniture1;
    private SpriteSheet furniture2;
    private SpriteSheet furniture3;
    private SpriteSheet furniture4;
    private SpriteSheet threes;

    // GameCharacters:
    private SpriteSheet characters1;
    private SpriteSheet characters2;
    private SpriteSheet characters3;
    // </editor-fold>

    // Sprites:
    // <editor-fold defaultstate="collapsed" desc="Sprites">
    // Tiles:
    // Floors
    private Sprite woodenFloor1, woodenFloor2, woodenFloorVertical, lifhtFloor1, lifhtFloor2, niceFloor1, niceFloor2,
            stoneSquares;

    private Sprite stairsTopLeft, stairsTop, stairsTopRight, stairsBottomLeft, stairsBottom, stairsBottomRight;

    // Walls
    private Sprite fancyWhite1, fancyWhite2, fancyBrown1, fancyBrown2, fancyBooks1, fancyBooks2, fancyWood1, fancyWood2,
            emptyTop, emptyBottom, emptyLeft, emptyRight, emptyTopLeft, emptyTopRight, emptyBottomLeft,
            emptyBottomRight, emptyWallsVertical, emptyWallsHorizontal, emptyWallsTop, emptyWallsBottom, emptyWallsLeft,
            emptyWallsRight, emptyCornerTopLeft, emptyCornerTopRight, emptyCornerBottomLeft, emptyCornerBottomRight;

    // Outside
    // Ground
    private Sprite grass;

    // Walls
    private Sprite grassFence;

    // GameObjects:
    // Story GameObjects
    private Sprite door1, door2, door3, door4, cabinet1, cabinet2, cabinet3, cabinet4, nightStand, BookCase;

    // GameObjects
    private Sprite invisableWall, window, windowDraped, bookShelves, singleBed, doubleBed, chairUp, chairDown,
            chairLeft, chairRight, couchUp, couchDown, couchLeft, couchRight, tableVertical, tableHorizontal,
            paintingMoon, paintingForest, paintingFlowers, paintingMan, paintingWoman, cabinetPots1, cabinetPots2,
            cabinetCutlery1, cabinetCutlery2, cabinetFood1, cabinetFood2, smallTable1, smallTable2, plant1, plant2,
            plant3, plant4, bigTable, redChairUp, redChairDown, redChairLeft, redChairRight;

    private Sprite three1;

    // Game Characters:
    // Animation frames:
    private Sprite[] playerDown, playerUp, playerLeft, playerRight;
    private Sprite[] butlerDown, butlerUp, butlerLeft, butlerRight;
    private Sprite[] sofieDown, sofieUp, sofieLeft, sofieRight;
    private Sprite[] suzieDown, suzieUp, suzieLeft, suzieRight;
    private Sprite[] jonnyDown, jonnyUp, jonnyLeft, jonnyRight;
    private Sprite[] violetDown, violetUp, violetLeft, violetRight;
    private Sprite[] ladyFisherDown, ladyFisherUp, ladyFisherLeft, ladyFisherRight;
    private Sprite[] lordFisherDown, lordFisherUp, lordFisherLeft, lordFisherRight;
    private Sprite[] jeffreyDown, jeffreyUp, jeffreyLeft, jeffreyRight;

    // Static Images:
    private Sprite playerStandingDown, playerStandingUp, playerStandingLeft, playerStandingRight;
    private Sprite butlerStandingDown, butlerStandingUp, butlerStandingLeft, butlerStandingRight;
    private Sprite sofieStandingDown, sofieStandingUp, sofieStandingLeft, sofieStandingRight;
    private Sprite suzieStandingDown, suzieStandingUp, suzieStandingLeft, suzieStandingRight;
    private Sprite jonnyStandingDown, jonnyStandingUp, jonnyStandingLeft, jonnyStandingRight;
    private Sprite violetStandingDown, violetStandingUp, violetStandingLeft, violetStandingRight;
    private Sprite ladyFisherStandingDown, ladyFisherStandingUp, ladyFisherStandingLeft, ladyFisherStandingRight;
    private Sprite lordFisherStandingDown, lordFisherStandingUp, lordFisherStandingLeft, lordFisherStandingRight;
    private Sprite jeffreyStandingDown, jeffreyStandingUp, jeffreyStandingLeft, jeffreyStandingRight;

    // </editor-fold>

    // Final ArrayLists:
    // <editor-fold defaultstate="collapsed" desc="Final ArrayLists">
    // Tiles:
    private Sprite[] tileTextures = new Sprite[100];

    // GameObjects:
    private Sprite[] gameObjectTextures = new Sprite[100];

    // GameCharacters:
    private Sprite[][] gameCharacterTextures = new Sprite[10][4];
    private Sprite[][][] gameCharacterAnimationFrames = new Sprite[10][4][];
    // </editor-fold>

    /**
     * Create a new collection of SpriteImages
     */
    public SpriteImages() {
        initialize();
    }

    // Methods
    /**
     * Load and initialize the SpriteImages
     */
    private void initialize() {

        // Load Spritesheets
        // <editor-fold defaultstate="collapsed" desc="Load SpriteSheets">
        // Tiles
        tiles1 = new SpriteSheet(loadImage("artwork/textures/tiles/tiles1.png"));
        tiles2 = new SpriteSheet(loadImage("artwork/textures/tiles/tiles2.png"));
        tiles3 = new SpriteSheet(loadImage("artwork/textures/tiles/tiles3.png"));

        // GameObjects
        invisibleWallTexture = new SpriteSheet(loadImage("artwork/textures/gameobjects/InvisibleWallTexture.png"));
        furniture1 = new SpriteSheet(loadImage("artwork/textures/gameobjects/furniture.png"));
        furniture2 = new SpriteSheet(loadImage("artwork/textures/gameobjects/furniture2.png"));
        furniture3 = new SpriteSheet(loadImage("artwork/textures/gameobjects/furniture3.png"));
        furniture4 = new SpriteSheet(loadImage("artwork/textures/gameobjects/furniture4.png"));
        threes = new SpriteSheet(loadImage("artwork/textures/gameobjects/trees.png"));

        // GameCharacters
        characters1 = new SpriteSheet(loadImage("artwork/textures/gamecharacters/characters1.png"));
        characters2 = new SpriteSheet(loadImage("artwork/textures/gamecharacters/characters2.png"));
        characters3 = new SpriteSheet(loadImage("artwork/textures/gamecharacters/characters3.png"));

        // </editor-fold>

        // Crop SpriteImages from Spritesheet:

        // Explenation:
        // new Sprite(spriteSheet, x, y, width, height, Xrel, Yrel, targetWidth,
        // targetHeight)

        // Spritesheet = the sheet the sprite is located on
        // x = x position of the top left corner of the Sprite on the spriteSheet
        // y = y position of the top left corner of the Sprite on the spriteSheet
        // width = width of the sprite on the spriteSheet
        // height = height of the sprite on the spriteSheet
        // Xrel = X relationship between the top left corner of the Sprite and the top
        // left corner of the collisionBox
        // Yrel = Y relationship between the top left corner of the Sprite and the top
        // left corner of the collisionBox
        // targetWidth = the width the sprite has to be drawn at
        // targetHeight = the height the sprite has to be drawn at

        // Tiles
        // Indoor
        // Floors
        woodenFloor1 = new Sprite(tiles1, 0 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        woodenFloor2 = new Sprite(tiles1, 1 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        woodenFloorVertical = new Sprite(tiles1, 2 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        lifhtFloor1 = new Sprite(tiles1, 5 * WIDTH, 9 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        lifhtFloor2 = new Sprite(tiles1, 6 * WIDTH, 9 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        niceFloor1 = new Sprite(tiles1, 6 * WIDTH, 10 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        niceFloor2 = new Sprite(tiles1, 6 * WIDTH, 11 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        stoneSquares = new Sprite(tiles1, 7 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);

        stairsTopLeft = new Sprite(tiles1, 5 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        stairsTop = new Sprite(tiles1, 6 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        stairsTopRight = new Sprite(tiles1, 7 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        stairsBottomLeft = new Sprite(tiles1, 5 * WIDTH, 8 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        stairsBottom = new Sprite(tiles1, 6 * WIDTH, 8 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        stairsBottomRight = new Sprite(tiles1, 7 * WIDTH, 8 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);

        // Walls
        fancyWhite1 = new Sprite(tiles2, 0 * WIDTH, 8 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        fancyWhite2 = new Sprite(tiles2, 0 * WIDTH, 9 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        fancyBrown1 = new Sprite(tiles2, 2 * WIDTH, 8 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        fancyBrown2 = new Sprite(tiles2, 2 * WIDTH, 9 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        fancyBooks1 = new Sprite(tiles2, 4 * WIDTH, 8 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        fancyBooks2 = new Sprite(tiles2, 4 * WIDTH, 9 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        fancyWood1 = new Sprite(tiles2, 6 * WIDTH, 8 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        fancyWood2 = new Sprite(tiles2, 6 * WIDTH, 9 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);

        // Special cut outs
        emptyTop = new Sprite(tiles2, 6 * WIDTH + 10, 7 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        emptyBottom = new Sprite(tiles2, 6 * WIDTH + 10, 6 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        emptyLeft = new Sprite(tiles2, 7 * WIDTH, 6 * HEIGHT + 10, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        emptyRight = new Sprite(tiles2, 6 * WIDTH, 6 * HEIGHT + 10, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);

        emptyTopLeft = new Sprite(tiles2, 10 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        emptyTopRight = new Sprite(tiles2, 9 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        emptyBottomLeft = new Sprite(tiles2, 8 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        emptyBottomRight = new Sprite(tiles2, 7 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        emptyWallsVertical = new Sprite(tiles2, 14 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        emptyWallsHorizontal = new Sprite(tiles2, 14 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        emptyWallsTop = new Sprite(tiles2, 15 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        emptyWallsBottom = new Sprite(tiles2, 15 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        emptyWallsLeft = new Sprite(tiles2, 12 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        emptyWallsRight = new Sprite(tiles2, 11 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        emptyCornerTopLeft = new Sprite(tiles2, 12 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        emptyCornerTopRight = new Sprite(tiles2, 13 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        emptyCornerBottomLeft = new Sprite(tiles2, 12 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);
        emptyCornerBottomRight = new Sprite(tiles2, 13 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);

        // Outdoor
        // Ground
        grass = new Sprite(tiles3, 0 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH, DEFAULT_TILEHEIGHT);

        // Walls
        grassFence = new Sprite(tiles3, 0 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 0, 0, DEFAULT_TILEWIDTH,
                DEFAULT_TILEHEIGHT);

        // Walls

        // GameObjects
        // Story GameObjects
        door1 = new Sprite(furniture1, 8.1 * WIDTH, 7 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 2, 5,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        door2 = new Sprite(furniture1, 8.1 * WIDTH, 7 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 2, 5,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        door3 = new Sprite(furniture1, 8.1 * WIDTH, 7 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 2, 5,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        door4 = new Sprite(furniture1, 8.1 * WIDTH, 7 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 2, 5,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        cabinet1 = new Sprite(furniture3, 1 * WIDTH, 8 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 0, 0,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        cabinet2 = new Sprite(furniture3, 1 * WIDTH, 10 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 5, 0,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        cabinet3 = new Sprite(furniture3, 1 * WIDTH, 12 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 0, 0,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        cabinet4 = new Sprite(furniture3, 1 * WIDTH, 14 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 0, 0,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        nightStand = new Sprite(furniture3, 8 * WIDTH, 7 * HEIGHT, 1 * WIDTH, 1.5 * HEIGHT, 0, 0,
                0.8 * DEFAULT_GAMEOBJECTWIDTH, 1.2 * DEFAULT_GAMEOBJECTHEIGHT);
        BookCase = new Sprite(furniture3, 0 * WIDTH, 8 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 0, 0,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);

        // GameObjects
        invisableWall = new Sprite(invisibleWallTexture, 0 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 0, 0,
                1 * DEFAULT_GAMEOBJECTWIDTH, 1 * DEFAULT_GAMEOBJECTHEIGHT);

        window = new Sprite(furniture4, 0 * WIDTH, 4.4 * HEIGHT, 1 * WIDTH, 1.1 * HEIGHT, 5, 0,
                1 * DEFAULT_GAMEOBJECTWIDTH, 1 * DEFAULT_GAMEOBJECTHEIGHT);
        windowDraped = new Sprite(furniture4, 1 * WIDTH, 4.4 * HEIGHT, 1 * WIDTH, 1.1 * HEIGHT, 5, 0,
                1 * DEFAULT_GAMEOBJECTWIDTH, 1 * DEFAULT_GAMEOBJECTHEIGHT);
        bookShelves = new Sprite(furniture4, 0 * WIDTH, 8 * HEIGHT, 5 * WIDTH, 2 * HEIGHT, 0, 0,
                5 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        singleBed = new Sprite(furniture4, 0 * WIDTH, 10 * HEIGHT, 2 * WIDTH, 2 * HEIGHT, 25, 20,
                2 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        doubleBed = new Sprite(furniture4, 4 * WIDTH, 10 * HEIGHT, 2 * WIDTH, 2 * HEIGHT, 15, 15,
                2 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        chairUp = new Sprite(furniture3, 1 * WIDTH, 0.5 * HEIGHT, 1 * WIDTH, 1.3 * HEIGHT, 15, 30,
                1 * DEFAULT_GAMEOBJECTWIDTH, 1.3 * DEFAULT_GAMEOBJECTHEIGHT);
        chairDown = new Sprite(furniture3, 0 * WIDTH, 0.5 * HEIGHT, 1 * WIDTH, 1.3 * HEIGHT, 15, 30,
                1 * DEFAULT_GAMEOBJECTWIDTH, 1.3 * DEFAULT_GAMEOBJECTHEIGHT);
        chairLeft = new Sprite(furniture3, 3 * WIDTH, 0.5 * HEIGHT, 1 * WIDTH, 1.3 * HEIGHT, 15, 30,
                1 * DEFAULT_GAMEOBJECTWIDTH, 1.3 * DEFAULT_GAMEOBJECTHEIGHT);
        chairRight = new Sprite(furniture3, 2 * WIDTH, 0.5 * HEIGHT, 1 * WIDTH, 1.3 * HEIGHT, 15, 30,
                1 * DEFAULT_GAMEOBJECTWIDTH, 1.3 * DEFAULT_GAMEOBJECTHEIGHT);
        couchUp = new Sprite(furniture3, 3 * WIDTH, 2 * HEIGHT, 2 * WIDTH, 1 * HEIGHT, 10, 10,
                2 * DEFAULT_GAMEOBJECTWIDTH, 1 * DEFAULT_GAMEOBJECTHEIGHT);
        couchDown = new Sprite(furniture3, 1 * WIDTH, 2 * HEIGHT, 2 * WIDTH, 2 * HEIGHT, 10, 50,
                2 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        couchLeft = new Sprite(furniture3, 5 * WIDTH, 2 * HEIGHT, 1 * WIDTH, 2.8 * HEIGHT, 5, 30,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        couchRight = new Sprite(furniture3, 6 * WIDTH, 2 * HEIGHT, 1 * WIDTH, 2.8 * HEIGHT, -5, 30,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        tableVertical = new Sprite(furniture3, 0 * WIDTH, 6 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 0, 0,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        tableHorizontal = new Sprite(furniture3, 4 * WIDTH, 5 * HEIGHT, 2 * WIDTH, 1 * HEIGHT, 0, 0,
                2 * DEFAULT_GAMEOBJECTWIDTH, 1 * DEFAULT_GAMEOBJECTHEIGHT);
        paintingMoon = new Sprite(furniture3, 8 * WIDTH, 4 * HEIGHT, 2 * WIDTH, 1 * HEIGHT, 5, 10,
                2 * DEFAULT_GAMEOBJECTWIDTH, 1 * DEFAULT_GAMEOBJECTHEIGHT);
        paintingForest = new Sprite(furniture3, 8 * WIDTH, 5 * HEIGHT, 2 * WIDTH, 1 * HEIGHT, 5, 10,
                2 * DEFAULT_GAMEOBJECTWIDTH, 1 * DEFAULT_GAMEOBJECTHEIGHT);
        paintingFlowers = new Sprite(furniture3, 10 * WIDTH, 4 * HEIGHT, 1 * WIDTH, 1 * HEIGHT, 10, 5,
                1 * DEFAULT_GAMEOBJECTWIDTH, 1 * DEFAULT_GAMEOBJECTHEIGHT);
        paintingMan = new Sprite(furniture3, 10 * WIDTH, 5 * HEIGHT, 1 * WIDTH, 1 * HEIGHT, 10, 10,
                1 * DEFAULT_GAMEOBJECTWIDTH, 1 * DEFAULT_GAMEOBJECTHEIGHT);
        paintingWoman = new Sprite(furniture3, 11 * WIDTH, 5 * HEIGHT, 1 * WIDTH, 1 * HEIGHT, 10, 10,
                1 * DEFAULT_GAMEOBJECTWIDTH, 1 * DEFAULT_GAMEOBJECTHEIGHT);
        cabinetPots1 = new Sprite(furniture3, 2 * WIDTH, 8 * HEIGHT, 2 * WIDTH, 2 * HEIGHT, 0, 0,
                2 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        cabinetPots2 = new Sprite(furniture3, 4 * WIDTH, 8 * HEIGHT, 2 * WIDTH, 2 * HEIGHT, 0, 0,
                2 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        cabinetCutlery1 = new Sprite(furniture3, 2 * WIDTH, 12 * HEIGHT, 2 * WIDTH, 2 * HEIGHT, 0, 0,
                2 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        cabinetCutlery2 = new Sprite(furniture3, 4 * WIDTH, 12 * HEIGHT, 2 * WIDTH, 2 * HEIGHT, 0, 0,
                2 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        cabinetFood1 = new Sprite(furniture3, 2 * WIDTH, 14 * HEIGHT, 2 * WIDTH, 2 * HEIGHT, 0, 0,
                2 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        cabinetFood2 = new Sprite(furniture3, 4 * WIDTH, 14 * HEIGHT, 2 * WIDTH, 2 * HEIGHT, 0, 0,
                2 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        smallTable1 = new Sprite(furniture3, 7 * WIDTH, 15 * HEIGHT, 1 * WIDTH, 1 * HEIGHT, 0, 10,
                1 * DEFAULT_GAMEOBJECTWIDTH, 1 * DEFAULT_GAMEOBJECTHEIGHT);
        smallTable2 = new Sprite(furniture3, 7 * WIDTH, 14 * HEIGHT, 1 * WIDTH, 1 * HEIGHT, 0, 10,
                1 * DEFAULT_GAMEOBJECTWIDTH, 1 * DEFAULT_GAMEOBJECTHEIGHT);
        plant1 = new Sprite(furniture3, 14 * WIDTH, 0 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 16, 80,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        plant2 = new Sprite(furniture3, 15 * WIDTH, 0 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 16, 80,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        plant3 = new Sprite(furniture3, 14 * WIDTH, 2 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 16, 80,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        plant4 = new Sprite(furniture3, 15 * WIDTH, 2 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 16, 80,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        bigTable = new Sprite(furniture2, 0 * WIDTH, 2 * HEIGHT, 3 * WIDTH, 3 * HEIGHT, 10, 48,
                3 * DEFAULT_GAMEOBJECTWIDTH, 3 * DEFAULT_GAMEOBJECTHEIGHT);
        redChairUp = new Sprite(furniture2, 1 * WIDTH, 5 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 12, 64,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        redChairDown = new Sprite(furniture2, 0 * WIDTH, 5 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 12, 64,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        redChairLeft = new Sprite(furniture2, 3 * WIDTH, 5 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 12, 64,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);
        redChairRight = new Sprite(furniture2, 2 * WIDTH, 5 * HEIGHT, 1 * WIDTH, 2 * HEIGHT, 12, 64,
                1 * DEFAULT_GAMEOBJECTWIDTH, 2 * DEFAULT_GAMEOBJECTHEIGHT);

        three1 = new Sprite(threes, 0 * WIDTH, 6 * HEIGHT, 4 * WIDTH, 6 * HEIGHT, 110, 310, 4 * DEFAULT_GAMEOBJECTWIDTH,
                6 * DEFAULT_GAMEOBJECTHEIGHT);

        // Game Characters

        // Static Images:
        // Player
        playerStandingUp = new Sprite(characters1, 4 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        playerStandingDown = new Sprite(characters1, 4 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        playerStandingLeft = new Sprite(characters1, 4 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        playerStandingRight = new Sprite(characters1, 4 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);

        // Butler
        butlerStandingUp = new Sprite(characters3, 1 * WIDTH, 3 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerStandingDown = new Sprite(characters3, 1 * WIDTH, 0 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerStandingLeft = new Sprite(characters3, 1 * WIDTH, 1 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerStandingRight = new Sprite(characters3, 1 * WIDTH, 2 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));

        // Sofie
        sofieStandingUp = new Sprite(characters1, 4 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        sofieStandingDown = new Sprite(characters1, 4 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        sofieStandingLeft = new Sprite(characters1, 4 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        sofieStandingRight = new Sprite(characters1, 4 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);

        // Suzie
        suzieStandingUp = new Sprite(characters1, 10 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        suzieStandingDown = new Sprite(characters1, 10 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        suzieStandingLeft = new Sprite(characters1, 10 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        suzieStandingRight = new Sprite(characters1, 10 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);

        // Jonny
        jonnyStandingUp = new Sprite(characters1, 1 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jonnyStandingDown = new Sprite(characters1, 1 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jonnyStandingLeft = new Sprite(characters1, 1 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jonnyStandingRight = new Sprite(characters1, 1 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);

        // Violet
        violetStandingUp = new Sprite(characters2, 10 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        violetStandingDown = new Sprite(characters2, 10 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        violetStandingLeft = new Sprite(characters2, 10 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        violetStandingRight = new Sprite(characters2, 10 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);

        // Lady Fisher
        ladyFisherStandingUp = new Sprite(characters3, 10 * WIDTH, 3 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherStandingDown = new Sprite(characters3, 10 * WIDTH, 0 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherStandingLeft = new Sprite(characters3, 10 * WIDTH, 1 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherStandingRight = new Sprite(characters3, 10 * WIDTH, 2 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));

        // Lord Fisher
        lordFisherStandingUp = new Sprite(characters3, 7 * WIDTH, 3 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherStandingDown = new Sprite(characters3, 7 * WIDTH, 0 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherStandingLeft = new Sprite(characters3, 7 * WIDTH, 1 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherStandingRight = new Sprite(characters3, 7 * WIDTH, 2 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));

        // Jeffrey
        jeffreyStandingUp = new Sprite(characters2, 4 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyStandingDown = new Sprite(characters2, 4 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyStandingLeft = new Sprite(characters2, 4 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyStandingRight = new Sprite(characters2, 4 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);

        // Animations:

        // Initialize Animations (has to happen before cropping)
        // PLayer
        playerDown = new Sprite[4];
        playerUp = new Sprite[4];
        playerLeft = new Sprite[4];
        playerRight = new Sprite[4];

        // Butler
        butlerDown = new Sprite[4];
        butlerUp = new Sprite[4];
        butlerLeft = new Sprite[4];
        butlerRight = new Sprite[4];

        // Sofie
        sofieDown = new Sprite[4];
        sofieUp = new Sprite[4];
        sofieLeft = new Sprite[4];
        sofieRight = new Sprite[4];

        // Suzie
        suzieDown = new Sprite[4];
        suzieUp = new Sprite[4];
        suzieLeft = new Sprite[4];
        suzieRight = new Sprite[4];

        // Brad
        jonnyDown = new Sprite[4];
        jonnyUp = new Sprite[4];
        jonnyLeft = new Sprite[4];
        jonnyRight = new Sprite[4];

        // Violet
        violetDown = new Sprite[4];
        violetUp = new Sprite[4];
        violetLeft = new Sprite[4];
        violetRight = new Sprite[4];

        // Lady Fisher
        ladyFisherDown = new Sprite[4];
        ladyFisherUp = new Sprite[4];
        ladyFisherLeft = new Sprite[4];
        ladyFisherRight = new Sprite[4];

        // Lord Fisher
        lordFisherDown = new Sprite[4];
        lordFisherUp = new Sprite[4];
        lordFisherLeft = new Sprite[4];
        lordFisherRight = new Sprite[4];

        // Jeffrey
        jeffreyDown = new Sprite[4];
        jeffreyUp = new Sprite[4];
        jeffreyLeft = new Sprite[4];
        jeffreyRight = new Sprite[4];

        // Crop Animations from Spritesheet
        // Player
        playerUp[0] = new Sprite(characters1, 3 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        playerUp[1] = new Sprite(characters1, 4 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        playerUp[2] = new Sprite(characters1, 5 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        playerUp[3] = new Sprite(characters1, 4 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        playerDown[0] = new Sprite(characters1, 3 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        playerDown[1] = new Sprite(characters1, 4 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        playerDown[2] = new Sprite(characters1, 5 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        playerDown[3] = new Sprite(characters1, 4 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        playerLeft[0] = new Sprite(characters1, 3 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        playerLeft[1] = new Sprite(characters1, 4 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        playerLeft[2] = new Sprite(characters1, 5 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        playerLeft[3] = new Sprite(characters1, 4 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        playerRight[0] = new Sprite(characters1, 3 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        playerRight[1] = new Sprite(characters1, 4 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        playerRight[2] = new Sprite(characters1, 5 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        playerRight[3] = new Sprite(characters1, 4 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);

        // Butler
        butlerUp[0] = new Sprite(characters3, 0 * WIDTH, 3 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerUp[1] = new Sprite(characters3, 1 * WIDTH, 3 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerUp[2] = new Sprite(characters3, 2 * WIDTH, 3 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerUp[3] = new Sprite(characters3, 1 * WIDTH, 3 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerDown[0] = new Sprite(characters3, 0 * WIDTH, 0 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerDown[1] = new Sprite(characters3, 1 * WIDTH, 0 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerDown[2] = new Sprite(characters3, 2 * WIDTH, 0 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerDown[3] = new Sprite(characters3, 1 * WIDTH, 0 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerLeft[0] = new Sprite(characters3, 0 * WIDTH, 1 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerLeft[1] = new Sprite(characters3, 1 * WIDTH, 1 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerLeft[2] = new Sprite(characters3, 2 * WIDTH, 1 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerLeft[3] = new Sprite(characters3, 1 * WIDTH, 1 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerRight[0] = new Sprite(characters3, 0 * WIDTH, 2 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerRight[1] = new Sprite(characters3, 1 * WIDTH, 2 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerRight[2] = new Sprite(characters3, 2 * WIDTH, 2 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        butlerRight[3] = new Sprite(characters3, 1 * WIDTH, 2 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));

        // Sofie
        sofieUp[0] = new Sprite(characters1, 3 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        sofieUp[1] = new Sprite(characters1, 4 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        sofieUp[2] = new Sprite(characters1, 5 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        sofieUp[3] = new Sprite(characters1, 4 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        sofieDown[0] = new Sprite(characters1, 3 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        sofieDown[1] = new Sprite(characters1, 4 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        sofieDown[2] = new Sprite(characters1, 5 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        sofieDown[3] = new Sprite(characters1, 4 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        sofieLeft[0] = new Sprite(characters1, 3 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        sofieLeft[1] = new Sprite(characters1, 4 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        sofieLeft[2] = new Sprite(characters1, 5 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        sofieLeft[3] = new Sprite(characters1, 4 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        sofieRight[0] = new Sprite(characters1, 3 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        sofieRight[1] = new Sprite(characters1, 4 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        sofieRight[2] = new Sprite(characters1, 5 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        sofieRight[3] = new Sprite(characters1, 4 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);

        // Suzie
        suzieUp[0] = new Sprite(characters1, 9 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        suzieUp[1] = new Sprite(characters1, 10 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        suzieUp[2] = new Sprite(characters1, 11 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        suzieUp[3] = new Sprite(characters1, 10 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        suzieDown[0] = new Sprite(characters1, 9 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        suzieDown[1] = new Sprite(characters1, 10 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        suzieDown[2] = new Sprite(characters1, 11 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        suzieDown[3] = new Sprite(characters1, 10 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        suzieLeft[0] = new Sprite(characters1, 9 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        suzieLeft[1] = new Sprite(characters1, 10 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        suzieLeft[2] = new Sprite(characters1, 11 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        suzieLeft[3] = new Sprite(characters1, 10 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        suzieRight[0] = new Sprite(characters1, 9 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        suzieRight[1] = new Sprite(characters1, 10 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        suzieRight[2] = new Sprite(characters1, 11 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        suzieRight[3] = new Sprite(characters1, 10 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);

        // Jonny
        jonnyUp[0] = new Sprite(characters1, 0 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        jonnyUp[1] = new Sprite(characters1, 1 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        jonnyUp[2] = new Sprite(characters1, 2 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        jonnyUp[3] = new Sprite(characters1, 1 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        jonnyDown[0] = new Sprite(characters1, 0 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        jonnyDown[1] = new Sprite(characters1, 1 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        jonnyDown[2] = new Sprite(characters1, 2 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        jonnyDown[3] = new Sprite(characters1, 1 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        jonnyLeft[0] = new Sprite(characters1, 0 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        jonnyLeft[1] = new Sprite(characters1, 1 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        jonnyLeft[2] = new Sprite(characters1, 2 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        jonnyLeft[3] = new Sprite(characters1, 1 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        jonnyRight[0] = new Sprite(characters1, 0 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jonnyRight[1] = new Sprite(characters1, 1 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jonnyRight[2] = new Sprite(characters1, 2 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jonnyRight[3] = new Sprite(characters1, 1 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);

        // Violet
        violetUp[0] = new Sprite(characters2, 9 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        violetUp[1] = new Sprite(characters2, 10 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        violetUp[2] = new Sprite(characters2, 11 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        violetUp[3] = new Sprite(characters2, 10 * WIDTH, 3 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        violetDown[0] = new Sprite(characters2, 9 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        violetDown[1] = new Sprite(characters2, 10 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        violetDown[2] = new Sprite(characters2, 11 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        violetDown[3] = new Sprite(characters2, 10 * WIDTH, 0 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        violetLeft[0] = new Sprite(characters2, 9 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        violetLeft[1] = new Sprite(characters2, 10 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        violetLeft[2] = new Sprite(characters2, 11 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        violetLeft[3] = new Sprite(characters2, 10 * WIDTH, 1 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        violetRight[0] = new Sprite(characters2, 9 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        violetRight[1] = new Sprite(characters2, 10 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        violetRight[2] = new Sprite(characters2, 11 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        violetRight[3] = new Sprite(characters2, 10 * WIDTH, 2 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);

        // Lady Fisher
        ladyFisherUp[0] = new Sprite(characters3, 9 * WIDTH, 3 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherUp[1] = new Sprite(characters3, 10 * WIDTH, 3 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherUp[2] = new Sprite(characters3, 11 * WIDTH, 3 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherUp[3] = new Sprite(characters3, 10 * WIDTH, 3 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherDown[0] = new Sprite(characters3, 9 * WIDTH, 0 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherDown[1] = new Sprite(characters3, 10 * WIDTH, 0 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherDown[2] = new Sprite(characters3, 11 * WIDTH, 0 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherDown[3] = new Sprite(characters3, 10 * WIDTH, 0 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherLeft[0] = new Sprite(characters3, 9 * WIDTH, 1 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherLeft[1] = new Sprite(characters3, 10 * WIDTH, 1 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherLeft[2] = new Sprite(characters3, 11 * WIDTH, 1 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherLeft[3] = new Sprite(characters3, 10 * WIDTH, 1 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherRight[0] = new Sprite(characters3, 9 * WIDTH, 2 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherRight[1] = new Sprite(characters3, 10 * WIDTH, 2 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherRight[2] = new Sprite(characters3, 11 * WIDTH, 2 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        ladyFisherRight[3] = new Sprite(characters3, 10 * WIDTH, 2 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));

        // Lord Fisher
        lordFisherUp[0] = new Sprite(characters3, 6 * WIDTH, 3 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherUp[1] = new Sprite(characters3, 7 * WIDTH, 3 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherUp[2] = new Sprite(characters3, 8 * WIDTH, 3 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherUp[3] = new Sprite(characters3, 7 * WIDTH, 3 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherDown[0] = new Sprite(characters3, 6 * WIDTH, 0 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherDown[1] = new Sprite(characters3, 7 * WIDTH, 0 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherDown[2] = new Sprite(characters3, 8 * WIDTH, 0 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherDown[3] = new Sprite(characters3, 7 * WIDTH, 0 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherLeft[0] = new Sprite(characters3, 6 * WIDTH, 1 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherLeft[1] = new Sprite(characters3, 7 * WIDTH, 1 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherLeft[2] = new Sprite(characters3, 8 * WIDTH, 1 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherLeft[3] = new Sprite(characters3, 7 * WIDTH, 1 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherRight[0] = new Sprite(characters3, 6 * WIDTH, 2 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherRight[1] = new Sprite(characters3, 7 * WIDTH, 2 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherRight[2] = new Sprite(characters3, 8 * WIDTH, 2 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));
        lordFisherRight[3] = new Sprite(characters3, 7 * WIDTH, 2 * (HEIGHT * 1.5), WIDTH, (HEIGHT * 1.5), 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, (DEFAULT_GAMECHARACTERHEIGHT * 1.2));

        // Jeffrey
        jeffreyUp[0] = new Sprite(characters2, 3 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyUp[1] = new Sprite(characters2, 4 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyUp[2] = new Sprite(characters2, 5 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyUp[3] = new Sprite(characters2, 4 * WIDTH, 7 * HEIGHT, WIDTH, HEIGHT, 15, 38, DEFAULT_GAMECHARACTERWIDTH,
                DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyDown[0] = new Sprite(characters2, 3 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyDown[1] = new Sprite(characters2, 4 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyDown[2] = new Sprite(characters2, 5 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyDown[3] = new Sprite(characters2, 4 * WIDTH, 4 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyLeft[0] = new Sprite(characters2, 3 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyLeft[1] = new Sprite(characters2, 4 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyLeft[2] = new Sprite(characters2, 5 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyLeft[3] = new Sprite(characters2, 4 * WIDTH, 5 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyRight[0] = new Sprite(characters2, 3 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyRight[1] = new Sprite(characters2, 4 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyRight[2] = new Sprite(characters2, 5 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);
        jeffreyRight[3] = new Sprite(characters2, 4 * WIDTH, 6 * HEIGHT, WIDTH, HEIGHT, 15, 38,
                DEFAULT_GAMECHARACTERWIDTH, DEFAULT_GAMECHARACTERHEIGHT);

        // Put Sprites into Texture Arrays
        // Put Tiletextures into array (tileTextures[ID])
        // Floor
        tileTextures[0] = woodenFloor1;
        tileTextures[1] = woodenFloor2;
        tileTextures[2] = woodenFloorVertical;
        tileTextures[3] = lifhtFloor1;
        tileTextures[4] = lifhtFloor2;
        tileTextures[5] = niceFloor1;
        tileTextures[6] = niceFloor2;
        tileTextures[7] = stoneSquares;

        tileTextures[10] = stairsTopLeft;
        tileTextures[11] = stairsTop;
        tileTextures[12] = stairsTopRight;
        tileTextures[13] = stairsBottomLeft;
        tileTextures[14] = stairsBottom;
        tileTextures[15] = stairsBottomRight;

        // Walls
        tileTextures[20] = fancyWhite1;
        tileTextures[21] = fancyWhite2;
        tileTextures[22] = fancyBrown1;
        tileTextures[23] = fancyBrown2;
        tileTextures[24] = fancyBooks1;
        tileTextures[25] = fancyBooks2;
        tileTextures[26] = fancyWood1;
        tileTextures[27] = fancyWood2;
        tileTextures[28] = emptyTop;
        tileTextures[29] = emptyBottom;
        tileTextures[30] = emptyLeft;
        tileTextures[31] = emptyRight;
        tileTextures[32] = emptyTopLeft;
        tileTextures[33] = emptyTopRight;
        tileTextures[34] = emptyBottomLeft;
        tileTextures[35] = emptyBottomRight;
        tileTextures[36] = emptyWallsVertical;
        tileTextures[37] = emptyWallsHorizontal;
        tileTextures[38] = emptyWallsTop;
        tileTextures[39] = emptyWallsBottom;
        tileTextures[40] = emptyWallsLeft;
        tileTextures[41] = emptyWallsRight;
        tileTextures[42] = emptyCornerTopLeft;
        tileTextures[43] = emptyCornerTopRight;
        tileTextures[44] = emptyCornerBottomLeft;
        tileTextures[45] = emptyCornerBottomRight;

        // Outside
        // Ground
        tileTextures[50] = grass;

        // Walls
        tileTextures[70] = grassFence;

        // Put GameObject textures into array (gameObjectTextures[ID])
        // StoryGameObjects
        gameObjectTextures[0] = door1;
        gameObjectTextures[1] = door2;
        gameObjectTextures[2] = door3;
        gameObjectTextures[3] = door4;
        gameObjectTextures[4] = cabinet1;
        gameObjectTextures[5] = cabinet2;
        gameObjectTextures[6] = cabinet3;
        gameObjectTextures[7] = cabinet4;
        gameObjectTextures[8] = nightStand;
        gameObjectTextures[9] = BookCase;

        // GameObjects
        gameObjectTextures[20] = invisableWall;
        gameObjectTextures[21] = window;
        gameObjectTextures[22] = windowDraped;
        gameObjectTextures[23] = bookShelves;
        gameObjectTextures[24] = singleBed;
        gameObjectTextures[25] = doubleBed;
        gameObjectTextures[26] = chairUp;
        gameObjectTextures[27] = chairDown;
        gameObjectTextures[28] = chairLeft;
        gameObjectTextures[29] = chairRight;
        gameObjectTextures[30] = couchUp;
        gameObjectTextures[31] = couchDown;
        gameObjectTextures[32] = couchLeft;
        gameObjectTextures[33] = couchRight;
        gameObjectTextures[34] = tableVertical;
        gameObjectTextures[35] = tableHorizontal;
        gameObjectTextures[36] = paintingMoon;
        gameObjectTextures[37] = paintingForest;
        gameObjectTextures[38] = paintingFlowers;
        gameObjectTextures[39] = paintingMan;
        gameObjectTextures[40] = paintingWoman;
        gameObjectTextures[41] = cabinetPots1;
        gameObjectTextures[42] = cabinetPots2;
        gameObjectTextures[43] = cabinetCutlery1;
        gameObjectTextures[44] = cabinetCutlery2;
        gameObjectTextures[45] = cabinetFood1;
        gameObjectTextures[46] = cabinetFood2;
        gameObjectTextures[47] = smallTable1;
        gameObjectTextures[48] = smallTable2;
        gameObjectTextures[49] = plant1;
        gameObjectTextures[50] = plant2;
        gameObjectTextures[51] = plant3;
        gameObjectTextures[52] = plant4;
        gameObjectTextures[53] = bigTable;
        gameObjectTextures[54] = redChairUp;
        gameObjectTextures[55] = redChairDown;
        gameObjectTextures[56] = redChairLeft;
        gameObjectTextures[57] = redChairRight;

        gameObjectTextures[60] = three1;

        // Put game character textures into array (gameCharacterTextures[ID][Direction])
        // Player
        gameCharacterTextures[0][0] = playerStandingUp;
        gameCharacterTextures[0][1] = playerStandingDown;
        gameCharacterTextures[0][2] = playerStandingLeft;
        gameCharacterTextures[0][3] = playerStandingRight;

        // Butler
        gameCharacterTextures[1][0] = butlerStandingUp;
        gameCharacterTextures[1][1] = butlerStandingDown;
        gameCharacterTextures[1][2] = butlerStandingLeft;
        gameCharacterTextures[1][3] = butlerStandingRight;

        // Sofie
        gameCharacterTextures[2][0] = sofieStandingUp;
        gameCharacterTextures[2][1] = sofieStandingDown;
        gameCharacterTextures[2][2] = sofieStandingLeft;
        gameCharacterTextures[2][3] = sofieStandingRight;

        // Suzie
        gameCharacterTextures[3][0] = suzieStandingUp;
        gameCharacterTextures[3][1] = suzieStandingDown;
        gameCharacterTextures[3][2] = suzieStandingLeft;
        gameCharacterTextures[3][3] = suzieStandingRight;

        // Jonny
        gameCharacterTextures[4][0] = jonnyStandingUp;
        gameCharacterTextures[4][1] = jonnyStandingDown;
        gameCharacterTextures[4][2] = jonnyStandingLeft;
        gameCharacterTextures[4][3] = jonnyStandingRight;

        // Violet
        gameCharacterTextures[5][0] = violetStandingUp;
        gameCharacterTextures[5][1] = violetStandingDown;
        gameCharacterTextures[5][2] = violetStandingLeft;
        gameCharacterTextures[5][3] = violetStandingRight;

        // Lady Fisher
        gameCharacterTextures[6][0] = ladyFisherStandingUp;
        gameCharacterTextures[6][1] = ladyFisherStandingDown;
        gameCharacterTextures[6][2] = ladyFisherStandingLeft;
        gameCharacterTextures[6][3] = ladyFisherStandingRight;

        // Lord Fisher
        gameCharacterTextures[7][0] = lordFisherStandingUp;
        gameCharacterTextures[7][1] = lordFisherStandingDown;
        gameCharacterTextures[7][2] = lordFisherStandingLeft;
        gameCharacterTextures[7][3] = lordFisherStandingRight;

        // Jeffrey
        gameCharacterTextures[8][0] = jeffreyStandingUp;
        gameCharacterTextures[8][1] = jeffreyStandingDown;
        gameCharacterTextures[8][2] = jeffreyStandingLeft;
        gameCharacterTextures[8][3] = jeffreyStandingRight;

        // Put game Character animations into array
        // (gameCharacterAnimationFrames[ID][Direction])
        // Player
        gameCharacterAnimationFrames[0][0] = playerUp;
        gameCharacterAnimationFrames[0][1] = playerDown;
        gameCharacterAnimationFrames[0][2] = playerLeft;
        gameCharacterAnimationFrames[0][3] = playerRight;

        // Butler
        gameCharacterAnimationFrames[1][0] = butlerUp;
        gameCharacterAnimationFrames[1][1] = butlerDown;
        gameCharacterAnimationFrames[1][2] = butlerLeft;
        gameCharacterAnimationFrames[1][3] = butlerRight;

        // Sofie
        gameCharacterAnimationFrames[2][0] = sofieUp;
        gameCharacterAnimationFrames[2][1] = sofieDown;
        gameCharacterAnimationFrames[2][2] = sofieLeft;
        gameCharacterAnimationFrames[2][3] = sofieRight;

        // Suzie
        gameCharacterAnimationFrames[3][0] = suzieUp;
        gameCharacterAnimationFrames[3][1] = suzieDown;
        gameCharacterAnimationFrames[3][2] = suzieLeft;
        gameCharacterAnimationFrames[3][3] = suzieRight;

        // Jonny
        gameCharacterAnimationFrames[4][0] = jonnyUp;
        gameCharacterAnimationFrames[4][1] = jonnyDown;
        gameCharacterAnimationFrames[4][2] = jonnyLeft;
        gameCharacterAnimationFrames[4][3] = jonnyRight;

        // Violet
        gameCharacterAnimationFrames[5][0] = violetUp;
        gameCharacterAnimationFrames[5][1] = violetDown;
        gameCharacterAnimationFrames[5][2] = violetLeft;
        gameCharacterAnimationFrames[5][3] = violetRight;

        // Lady Fisher
        gameCharacterAnimationFrames[6][0] = ladyFisherUp;
        gameCharacterAnimationFrames[6][1] = ladyFisherDown;
        gameCharacterAnimationFrames[6][2] = ladyFisherLeft;
        gameCharacterAnimationFrames[6][3] = ladyFisherRight;

        // Lord Fisher
        gameCharacterAnimationFrames[7][0] = lordFisherUp;
        gameCharacterAnimationFrames[7][1] = lordFisherDown;
        gameCharacterAnimationFrames[7][2] = lordFisherLeft;
        gameCharacterAnimationFrames[7][3] = lordFisherRight;

        // Jeffrey
        gameCharacterAnimationFrames[8][0] = jeffreyUp;
        gameCharacterAnimationFrames[8][1] = jeffreyDown;
        gameCharacterAnimationFrames[8][2] = jeffreyLeft;
        gameCharacterAnimationFrames[8][3] = jeffreyRight;
    }

    /**
     * Load an image from a file
     * 
     * @param path
     * @return
     */
    public Image loadImage(String path) {
        // Testcode:
        if (Files.exists(Paths.get(path), NOFOLLOW_LINKS)) {
            System.out.println("File found:" + "   " + path);
        } else {
            System.out.println("File not found:" + "   " + path);
        }

        // Create new file from path
        File file = new File(path);
        // Load iamge from file
        return new Image(file.toURI().toString());
    }

    // Getters and Setters
    /**
     * Returns the array that holds the Tile images
     * 
     * @return
     */
    public Sprite[] getTileTextures() {
        return tileTextures;
    }

    /**
     * Returns the array that holds the GameObject images
     * 
     * @return
     */
    public Sprite[] getGameObjectTextures() {
        return gameObjectTextures;
    }

    /**
     * @return the gameCharacterTextures
     */
    public Sprite[][] getGameCharacterTextures() {
        return gameCharacterTextures;
    }

    /**
     * Returns the array that holds the Creature animation frames
     * 
     * @return
     */
    public Sprite[][][] getGameCharacterAnimationFrames() {
        return gameCharacterAnimationFrames;
    }
}
