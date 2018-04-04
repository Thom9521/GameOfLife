package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;


public class Controller {

    Cell cell1 = new Cell();

    @FXML
    private GridPane gridPane;

    @FXML
    private Circle c33, c34, c35, c36, c37, c43, c44, c45, c46, c47, c53, c54, c55, c56, c57, c63, c64, c65, c66, c67;
    @FXML
    private Circle c73, c74, c75, c76, c77;

    @FXML
    private Button b1, b2;

    @FXML
    private void eButtonAction(ActionEvent e) {
        if (e.getSource() == b1) {
            c33.setVisible(false);
            c34.setVisible(false);
            c35.setVisible(false);
            c36.setVisible(false);
            c37.setVisible(false);
            c43.setVisible(false);
            c44.setVisible(false);
            c45.setVisible(false);
            c46.setVisible(false);
            c47.setVisible(false);
            c53.setVisible(false);
            c54.setVisible(false);
            c55.setVisible(true);
            c56.setVisible(false);
            c57.setVisible(false);
            c63.setVisible(false);
            c64.setVisible(false);
            c65.setVisible(false);
            c66.setVisible(false);
            c67.setVisible(false);
            c73.setVisible(false);
            c74.setVisible(false);
            c75.setVisible(false);
            c76.setVisible(false);
            c77.setVisible(false);

        } else if (e.getSource() == b2) {
            while (c55.isVisible()) {


            }
        }

    }
}
