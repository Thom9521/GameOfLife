package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    // Størelsen på x siden og y siden af arrayet
    private final int WORLDX = 20, WORLDY = 20;

    // 2 dimensionelt array på 20*20
    private Cell[][] cellArray = new Cell[WORLDX][WORLDY];

    // Constructor til dannelse af døde og levende celler i arrayet
    private Game() {

        for (int y = 0; y < WORLDY; y++) {
            for (int x = 0; x < WORLDX; x++) {

                Random random = new Random();
                int randomNumber = random.nextInt(2);
                Cell cell = new Cell();

                if (randomNumber == 0) {
                    cell.setAlive(false);
                } else if (randomNumber == 1) {
                    cell.setAlive(true);
                }

                cellArray[x][y] = cell;
            }
        }
    }

    // metode som retunerer game
    public static Game gameStart() {
        Game game = new Game();
        return game;
    }


    private ArrayList<Rectangle> rectangles = new ArrayList<>();
    private Rectangle cellAlive, cellDead;


    public void createCells() {
        for (int y = 0, yPosition = 25; y < WORLDY; y++, yPosition = yPosition + 22) {
            for (int x = 0, xPosition = 25; x < WORLDX; x++, xPosition = xPosition + 22) {

                if (cellArray[x][y].isAlive()) {
                    cellAlive = new Rectangle(20, 20, Color.LIMEGREEN);
                    cellAlive.setX(xPosition);
                    cellAlive.setY(yPosition);
                    Main.getPane().getChildren().add(cellAlive);
                    rectangles.add(cellAlive);
                }

                if (!cellArray[x][y].isAlive()) {
                    cellDead = new Rectangle(20, 20, Color.WHITE);
                    cellDead.setX(xPosition);
                    cellDead.setY(yPosition);
                    Main.getPane().getChildren().add(cellDead);
                    rectangles.add(cellDead);
                }

            }
        }

    }

  //metode som går arrayet igennem som tjekker efter de specifikke regler
    public void update() {

        for (int y = 0; y < WORLDY; y++) {
            for (int x = 0; x < WORLDX; x++) {

                cellArray[x][y].setLivingNeighbours(0);

                if (x > 0 && y > 0) {
                    if (cellArray[x - 1][y - 1].isAlive()) {
                        cellArray[x][y].setLivingNeighbours(cellArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (x > 0) {
                    if (cellArray[x - 1][y].isAlive()) {
                        cellArray[x][y].setLivingNeighbours(cellArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (y < WORLDY - 1 && x > 0) {
                    if (cellArray[x - 1][y + 1].isAlive()) {
                        cellArray[x][y].setLivingNeighbours(cellArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (y < WORLDY - 1) {
                    if (cellArray[x][y + 1].isAlive()) {
                        cellArray[x][y].setLivingNeighbours(cellArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (x < WORLDX - 1 && y < WORLDY - 1) {
                    if (cellArray[x + 1][y + 1].isAlive()) {
                        cellArray[x][y].setLivingNeighbours(cellArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (x < WORLDX - 1) {
                    if (cellArray[x + 1][y].isAlive()) {
                        cellArray[x][y].setLivingNeighbours(cellArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (y > 0) {
                    if (cellArray[x][y - 1].isAlive()) {
                        cellArray[x][y].setLivingNeighbours(cellArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (x < WORLDX - 1 && y > 0) {
                    if (cellArray[x + 1][y - 1].isAlive()) {
                        cellArray[x][y].setLivingNeighbours(cellArray[x][y].getLivingNeighbours() + 1);
                    }
                }
            }
        }

        for (int y = 0; y < WORLDY; y++) {
            for (int x = 0; x < WORLDX; x++) {
                cellArray[x][y].update();
            }
        }
    }

    private int counter = 0;

    // Metode til hvad der sker når man trykker på knappen
    public void buttonAction() {
        Main.getPane().getChildren().removeAll(rectangles);

        rectangles.clear();

        update();

        createCells();

        counter++;

        String counterToString = String.valueOf(counter);

        Main.getLabel().setText(counterToString);
    }
}