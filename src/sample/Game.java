package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    // Størelsen på x siden og y siden af arrayet
    private final int WORLDX = 20, WORLDY = 20;

    // 2 dimensionelt array på 20*20
    private Cell[][] cellsArray = new Cell[WORLDX][WORLDY];

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

                cellsArray[x][y] = cell;
            }
        }
    }

    // metode som retunerer game
    public static Game createGame() {
        Game game = new Game();
        return game;
    }

    private Rectangle rectangleGreen, rectangleWhite;
    private ArrayList<Rectangle> rectangles = new ArrayList<>();

    // Metode der løber arrayet igennem og tegner cellerne
    public void drawCells() {
        for (int y = 0, yPosition = 25; y < WORLDY; y++, yPosition = yPosition + 22) {
            for (int x = 0, xPosition = 25; x < WORLDX; x++, xPosition = xPosition + 22) {

                if (cellsArray[x][y].isAlive()) {
                    rectangleGreen = new Rectangle(20, 20, Color.LIMEGREEN);
                    rectangleGreen.setX(xPosition);
                    rectangleGreen.setY(yPosition);
                    rectangleGreen.setStrokeType(StrokeType.INSIDE);
                    rectangleGreen.setStroke(Color.BLACK);
                    rectangleGreen.setStrokeWidth(2);
                    Main.getPane().getChildren().add(rectangleGreen);
                    rectangles.add(rectangleGreen);
                }

                if (!cellsArray[x][y].isAlive()) {
                    rectangleWhite = new Rectangle(20, 20, Color.WHITE);
                    rectangleWhite.setX(xPosition);
                    rectangleWhite.setY(yPosition);
                    rectangleWhite.setStrokeType(StrokeType.INSIDE);
                    rectangleWhite.setStroke(Color.BLACK);
                    rectangleWhite.setStrokeWidth(2);
                    Main.getPane().getChildren().add(rectangleWhite);
                    rectangles.add(rectangleWhite);
                }

            }
        }

    }

    // En update metode der først løber hele arrayet igennem og sætter hver celles livingNeighbours,
    // dernæst løber arrayet igennem og kalder update() på hver celle.
    public void update() {

        for (int y = 0; y < WORLDY; y++) {
            for (int x = 0; x < WORLDX; x++) {

                cellsArray[x][y].setLivingNeighbours(0);

                if (x > 0 && y > 0) {
                    if (cellsArray[x - 1][y - 1].isAlive()) {
                        cellsArray[x][y].setLivingNeighbours(cellsArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (x > 0) {
                    if (cellsArray[x - 1][y].isAlive()) {
                        cellsArray[x][y].setLivingNeighbours(cellsArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (y < WORLDY - 1 && x > 0) {
                    if (cellsArray[x - 1][y + 1].isAlive()) {
                        cellsArray[x][y].setLivingNeighbours(cellsArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (y < WORLDY - 1) {
                    if (cellsArray[x][y + 1].isAlive()) {
                        cellsArray[x][y].setLivingNeighbours(cellsArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (x < WORLDX - 1 && y < WORLDY - 1) {
                    if (cellsArray[x + 1][y + 1].isAlive()) {
                        cellsArray[x][y].setLivingNeighbours(cellsArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (x < WORLDX - 1) {
                    if (cellsArray[x + 1][y].isAlive()) {
                        cellsArray[x][y].setLivingNeighbours(cellsArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (y > 0) {
                    if (cellsArray[x][y - 1].isAlive()) {
                        cellsArray[x][y].setLivingNeighbours(cellsArray[x][y].getLivingNeighbours() + 1);
                    }
                }

                if (x < WORLDX - 1 && y > 0) {
                    if (cellsArray[x + 1][y - 1].isAlive()) {
                        cellsArray[x][y].setLivingNeighbours(cellsArray[x][y].getLivingNeighbours() + 1);
                    }
                }
            }
        }

        for (int y = 0; y < WORLDY; y++) {
            for (int x = 0; x < WORLDX; x++) {
                cellsArray[x][y].update();
            }
        }
    }

    private int counter = 0;

    // Metode til hvad der sker når man trykker på knappen
    public void buttonAction() {
        Main.getPane().getChildren().removeAll(rectangles);

        rectangles.clear();

        update();

        drawCells();

        counter++;

        String counterToString = String.valueOf(counter);

        Main.getLabel().setText(counterToString);
    }
}