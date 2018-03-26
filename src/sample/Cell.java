package sample;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private int livingNeighbours;
    private boolean alive;
    private int cellsAlive = 0; //Antallet af celler i live
    private List neighborList;
    private String about;
    private String name;


    public Cell(){
        livingNeighbours = 0;
        cellsAlive++;
        List neighborList = new ArrayList();

    }

    public String update(){

        String cellAlive = "død";
        if (alive){
            cellAlive = "i live";
        }

        //Hvis en død celle har 3 naboer, så bliver den født
        if (!alive && (livingNeighbours == 3)){
            alive = true;
            about = "Celle er født!";
        }

        //Hvis en levende celler har 2 eller 3 naboer, så forbliver den i live
        if (alive && livingNeighbours == 2){
            alive = true;
            about = "Cellen forbliver i live, da den har 2 naboer.";
        }

        if (alive && livingNeighbours == 3){
            alive = true;
            about = "Cellen forbliver i live, da den har 3 naboer.";
        }

        //Hvis den levende eller døde celle har mindre end 2 levende naboer eller mere end 3 levende naboer, så dør den,
        //eller forbliver død
        if (livingNeighbours < 2){
            if (!alive){
                about = "Cellen forbliver død.";
            } else {
               about = "Cellen begik selvmord fordi den kun havde 2 eller færre venner. FeelsBadMan.";
            }
        }
        if (livingNeighbours > 3){
            if (!alive){
               about = "Cellen forbliver død.";
            } else {
                about = "Cellen døde da den blev overfaldet af 3 eller flere celler.";
            }
        }
        return about + " Celle " + name + " er " + cellAlive + " med " + livingNeighbours + " naboer.";
    }



    public int getLivingNightbours() {
        return livingNeighbours;
    }

    public void setLivingNightbours(int livingNightbours) {
        this.livingNeighbours = livingNightbours;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public List getNeighborList() {
        return neighborList;
    }

    public void setNeighborList(List neighborList) {
        this.neighborList = neighborList;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
