package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import javax.swing.text.Position;
import java.awt.*;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 45;
    private static final int HEIGHT = 45;
    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);
    private static class Position{
        int x;
        int y;
        Position(int posX, int posY) {
            x = posX;
            y = posY;
        }
    }

    public static void addHexagon(TETile[][] world, Position p, int s, TETile t){
        if(s<2)
            throw new IllegalArgumentException("Hexagon must be atleast size 2");
        int xpos=p.x;
        int ypos=p.y;
        for(int i=0;i<s;i++){
            int count=s+i*2;
            int tempxpos=xpos;
            while(count>0){
                world[tempxpos][ypos]=TETile.colorVariant(t,32,32,32,RANDOM);
                tempxpos=tempxpos+1;
                count=count-1;
            }
            xpos=xpos-1;
            ypos=ypos-1;
        }
        xpos=xpos+1;
        for(int i=s;i>0;i--){
            int count=i*2;
            int tempxpos=xpos;
            while(count>0){
                world[tempxpos][ypos]=TETile.colorVariant(t,32,32,32,RANDOM);
                tempxpos=tempxpos+1;
                count=count-1;
            }
            xpos=xpos+1;
            ypos=ypos-1;
        }
    }
    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.WALL;
            }
        }
        Position testpos=new Position(10,10);
        TETile t=new TETile('❀', Color.magenta, Color.pink, "flower");
        addHexagon(world,testpos,4,t);
        ter.renderFrame(world);
    }

}
