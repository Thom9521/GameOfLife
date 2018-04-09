package sample;

public class Cell {

    // Deklaration af datatyper
    private int livingNeighbours;
    private boolean alive;
    private byte info;


    public void update() {

        // Hvis cellen er død og har 3 levende naboer, bliver den til en levende celle (birth)
        if (!isAlive() && livingNeighbours == 3) {
            alive = true;
            info = 1; //birth
        }
        // Hvis cellen er levende og har 2 eller 3 levende naboer så er den stadig levende (survival)
        else if (isAlive() && (livingNeighbours == 2 || livingNeighbours == 3)) {
            alive = true;
            info = 2; //survival
        }
        // Ellers dør den eller er stadig død (overcrowding or loneliness)
        else {
            alive = false;
            info = 3; //lonelyness / overcrowdning
        }

    }

    public int getLivingNeighbours() {
        return livingNeighbours;
    }

    public void setLivingNeighbours(int livingNeighbours) {
        this.livingNeighbours = livingNeighbours;
    }


    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }


    public byte getInfo() {
        return info;
    }


    public void setInfo(byte info) {
        this.info = info;
    }
}