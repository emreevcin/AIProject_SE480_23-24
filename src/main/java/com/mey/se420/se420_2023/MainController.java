package com.mey.se420.se420_2023;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;

import java.util.Arrays;
import java.util.List;

public class MainController {

    @FXML
    private ToggleGroup goal;

    @FXML
    private RadioButton goalA;

    @FXML
    private RadioButton goalB;

    @FXML
    private RadioButton goalC;

    @FXML
    private RadioButton goalD;

    @FXML
    private RadioButton goalE;

    @FXML
    private RadioButton goalF;

    @FXML
    private RadioButton goalG;

    @FXML
    private RadioButton goalH;

    @FXML
    private RadioButton goalI;

    @FXML
    private GridPane gridPane;

    @FXML
    private ToggleGroup initial;

    @FXML
    private RadioButton initialA;

    @FXML
    private RadioButton initialB;

    @FXML
    private RadioButton initialC;

    @FXML
    private RadioButton initialD;

    @FXML
    private RadioButton initialE;

    @FXML
    private RadioButton initialF;

    @FXML
    private RadioButton initialG;

    @FXML
    private RadioButton initialH;

    @FXML
    private RadioButton initialI;

    @FXML
    private Rectangle rectangleA;

    @FXML
    private Rectangle rectangleB;

    @FXML
    private Rectangle rectangleC;

    @FXML
    private Rectangle rectangleD;

    @FXML
    private Rectangle rectangleE;

    @FXML
    private Rectangle rectangleF;

    @FXML
    private Rectangle rectangleG;

    @FXML
    private Rectangle rectangleH;

    @FXML
    private Rectangle rectangleI;

    @FXML
    private ToggleGroup search;

    @FXML
    private RadioButton searchAStar;

    @FXML
    private RadioButton searchUCS;

    @FXML
    private TextField stepCounter;

    @FXML
    private TextField expandedList;

    @FXML
    private CheckBox wallAB;

    @FXML
    private CheckBox wallAD;

    @FXML
    private CheckBox wallBC;

    @FXML
    private CheckBox wallBE;

    @FXML
    private CheckBox wallCF;

    @FXML
    private CheckBox wallDE;

    @FXML
    private CheckBox wallDG;

    @FXML
    private CheckBox wallEF;

    @FXML
    private CheckBox wallEH;

    @FXML
    private CheckBox wallFI;

    @FXML
    private CheckBox wallGH;

    @FXML
    private CheckBox wallHI;

    @FXML
    private Arc robotIcon;


    @FXML
    void start() {
        GameState gameState = new GameState();

        gameState.setRoomAt(0, 0, new Room('A', 0, 0));
        gameState.setRoomAt(0, 1, new Room('B', 0, 1));
        gameState.setRoomAt(0, 2, new Room('C', 0, 2));
        gameState.setRoomAt(1, 0, new Room('D', 1, 0));
        gameState.setRoomAt(1, 1, new Room('E', 1, 1));
        gameState.setRoomAt(1, 2, new Room('F', 1, 2));
        gameState.setRoomAt(2, 0, new Room('G', 2, 0));
        gameState.setRoomAt(2, 1, new Room('H', 2, 1));
        gameState.setRoomAt(2, 2, new Room('I', 2, 2));

        robotIcon.setVisible(true);

        char sourceRoomLabel = getSelectedRoomLabel(initial);

        if (sourceRoomLabel == 'A') {
            gameState.setSourceRoom(gameState.getRoomAt(0, 0));
            rectangleA.setFill(Color.LIGHTBLUE);
        } else if (sourceRoomLabel == 'B') {
            gameState.setSourceRoom(gameState.getRoomAt(0, 1));
            rectangleB.setFill(Color.LIGHTBLUE);
        } else if (sourceRoomLabel == 'C') {
            gameState.setSourceRoom(gameState.getRoomAt(0, 2));
            rectangleC.setFill(Color.LIGHTBLUE);
        } else if (sourceRoomLabel == 'D') {
            gameState.setSourceRoom(gameState.getRoomAt(1, 0));
            rectangleD.setFill(Color.LIGHTBLUE);
        } else if (sourceRoomLabel == 'E') {
            gameState.setSourceRoom(gameState.getRoomAt(1, 1));
            rectangleE.setFill(Color.LIGHTBLUE);
        } else if (sourceRoomLabel == 'F') {
            gameState.setSourceRoom(gameState.getRoomAt(1, 2));
            rectangleF.setFill(Color.LIGHTBLUE);
        } else if (sourceRoomLabel == 'G') {
            gameState.setSourceRoom(gameState.getRoomAt(2, 0));
            rectangleG.setFill(Color.LIGHTBLUE);
        } else if (sourceRoomLabel == 'H') {
            gameState.setSourceRoom(gameState.getRoomAt(2, 1));
            rectangleH.setFill(Color.LIGHTBLUE);
        } else if (sourceRoomLabel == 'I') {
            gameState.setSourceRoom(gameState.getRoomAt(2, 2));
            rectangleI.setFill(Color.LIGHTBLUE);
        } else {
            System.out.println("Invalid source room label");
        }

        char goalRoomLabel = getSelectedRoomLabel(goal);

        if (goalRoomLabel == 'A') {
            gameState.setGoalRoom(gameState.getRoomAt(0, 0));
            rectangleA.setFill(Color.LIGHTSEAGREEN);
        } else if (goalRoomLabel == 'B') {
            gameState.setGoalRoom(gameState.getRoomAt(0, 1));
            rectangleB.setFill(Color.LIGHTSEAGREEN);
        } else if (goalRoomLabel == 'C') {
            gameState.setGoalRoom(gameState.getRoomAt(0, 2));
            rectangleC.setFill(Color.LIGHTSEAGREEN);
        } else if (goalRoomLabel == 'D') {
            gameState.setGoalRoom(gameState.getRoomAt(1, 0));
            rectangleD.setFill(Color.LIGHTSEAGREEN);
        } else if (goalRoomLabel == 'E') {
            gameState.setGoalRoom(gameState.getRoomAt(1, 1));
            rectangleE.setFill(Color.LIGHTSEAGREEN);
        } else if (goalRoomLabel == 'F') {
            gameState.setGoalRoom(gameState.getRoomAt(1, 2));
            rectangleF.setFill(Color.LIGHTSEAGREEN);
        } else if (goalRoomLabel == 'G') {
            gameState.setGoalRoom(gameState.getRoomAt(2, 0));
            rectangleG.setFill(Color.LIGHTSEAGREEN);
        } else if (goalRoomLabel == 'H') {
            gameState.setGoalRoom(gameState.getRoomAt(2, 1));
            rectangleH.setFill(Color.LIGHTSEAGREEN);
        } else if (goalRoomLabel == 'I') {
            gameState.setGoalRoom(gameState.getRoomAt(2, 2));
            rectangleI.setFill(Color.LIGHTSEAGREEN);
        } else {
            System.out.println("Invalid goal room label");
        }

        if (wallAB.isSelected()) {
            gameState.addWall(gameState.getRoomAt(0, 0), gameState.getRoomAt(0, 1));
        }
        if (wallAD.isSelected()) {
            gameState.addWall(gameState.getRoomAt(0, 0), gameState.getRoomAt(1, 0));
        }
        if (wallBC.isSelected()) {
            gameState.addWall(gameState.getRoomAt(0, 1), gameState.getRoomAt(0, 2));
        }
        if (wallBE.isSelected()) {
            gameState.addWall(gameState.getRoomAt(0, 1), gameState.getRoomAt(1, 1));
        }
        if (wallCF.isSelected()) {
            gameState.addWall(gameState.getRoomAt(0, 2), gameState.getRoomAt(1, 2));
        }
        if (wallDE.isSelected()) {
            gameState.addWall(gameState.getRoomAt(1, 0), gameState.getRoomAt(1, 1));
        }
        if (wallDG.isSelected()) {
            gameState.addWall(gameState.getRoomAt(1, 0), gameState.getRoomAt(2, 0));
        }
        if (wallEF.isSelected()) {
            gameState.addWall(gameState.getRoomAt(1, 1), gameState.getRoomAt(1, 2));
        }
        if (wallEH.isSelected()) {
            gameState.addWall(gameState.getRoomAt(1, 1), gameState.getRoomAt(2, 1));
        }
        if (wallFI.isSelected()) {
            gameState.addWall(gameState.getRoomAt(1, 2), gameState.getRoomAt(2, 2));
        }
        if (wallGH.isSelected()) {
            gameState.addWall(gameState.getRoomAt(2, 0), gameState.getRoomAt(2, 1));
        }
        if (wallHI.isSelected()) {
            gameState.addWall(gameState.getRoomAt(2, 1), gameState.getRoomAt(2, 2));
        }

        String searchAlgorithm = getSelectedSearchAlgorithm();
        if (searchAlgorithm.equals("A* Search")) {
            List<Node> expansionNodes = SearchAlgorithms.aStarSearch(gameState);
            expandedList.setVisible(true);
            for (Node node : expansionNodes) {
                String currentText = expandedList.getText();
                expandedList.setText(currentText + "    " + node.getRoom().getLabel() + " - " + node.getTotalCost());
            }
        } else if (searchAlgorithm.equals("Uniform Cost Search")) {
            List<Node> expansionNodes = SearchAlgorithms.uniformCostSearch(gameState);
            expandedList.setVisible(true);
            for (Node node : expansionNodes) {
                String currentText = expandedList.getText();
                expandedList.setText(currentText + "    " + node.getRoom().getLabel() + " - " + node.getTotalCost());
            }
        } else {
            System.out.println("Invalid search algorithm");
        }
    }

    @FXML
    void reset() {
        for (Rectangle rectangle : Arrays.asList(rectangleA, rectangleB, rectangleC, rectangleD, rectangleE, rectangleF, rectangleG, rectangleH, rectangleI)) {
            rectangle.setFill(Color.TRANSPARENT);
        }

        for (RadioButton radioButton : Arrays.asList(initialA, initialB, initialC, initialD, initialE, initialF, initialG, initialH, initialI, goalA, goalB, goalC, goalD, goalE, goalF, goalG, goalH, goalI)) {
            radioButton.setSelected(false);
        }

        for (CheckBox checkBox : Arrays.asList(wallAB, wallAD, wallBC, wallBE, wallCF, wallDE, wallDG, wallEF, wallEH, wallFI, wallGH, wallHI)) {
            checkBox.setSelected(false);
        }

        for (RadioButton radioButton : Arrays.asList(searchAStar, searchUCS)) {
            radioButton.setSelected(false);
        }

        robotIcon.setVisible(false);

        stepCounter.setText("Number of Steps: 0");

        expandedList.setVisible(false);
        expandedList.setText("Expanded List: ");

    }

    private char getSelectedRoomLabel(ToggleGroup toggleGroup) {
        RadioButton radioButton = (RadioButton) toggleGroup.getSelectedToggle();
        return radioButton.getText().charAt(0);
    }

    private String getSelectedSearchAlgorithm() {
        RadioButton radioButton = (RadioButton) search.getSelectedToggle();
        return radioButton.getText();
    }
}