package sample;

import java.util.Random;

public class Game {

    private static int WORLDX = 10;
    private static int WORLDY = 10;

    private Cell[][] worldArray = new Cell[WORLDX][WORLDY];


    //Metode til at generere en verden med enten levende eller døde celler
    private Game() {
        for (int x = 0; x < WORLDX; x++) {
            for (int y = 0; y < WORLDY; y++) {
                Random randomGenerator = new Random();
                int random = randomGenerator.nextInt(2); //Randomindex på 0 til 1
                Cell cell = new Cell(); //Ny celle
                cell.setName("X" + x + "Y" + y); //Navn på celle
                //Sætter tilfældigt cellerne til at være i live eller døde
                if (random == 0) {
                    cell.setAlive(false);
                } else {
                    cell.setAlive(true);
                }
                worldArray[x][y] = cell;
            }
        }
    }

public static Game intialize(){
        Game world = new Game();
        return world;
}


}
