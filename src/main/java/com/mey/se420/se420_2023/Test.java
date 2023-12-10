package com.mey.se420.se420_2023;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
        System.out.println("9 rooms are created");

        System.out.println("Enter the source room label: ");
        char sourceRoomLabel = scanner.next().charAt(0);
        if (sourceRoomLabel == 'A') {
            gameState.setSourceRoom(gameState.getRoomAt(0, 0));
        } else if (sourceRoomLabel == 'B') {
            gameState.setSourceRoom(gameState.getRoomAt(0, 1));
        } else if (sourceRoomLabel == 'C') {
            gameState.setSourceRoom(gameState.getRoomAt(0, 2));
        } else if (sourceRoomLabel == 'D') {
            gameState.setSourceRoom(gameState.getRoomAt(1, 0));
        } else if (sourceRoomLabel == 'E') {
            gameState.setSourceRoom(gameState.getRoomAt(1, 1));
        } else if (sourceRoomLabel == 'F') {
            gameState.setSourceRoom(gameState.getRoomAt(1, 2));
        } else if (sourceRoomLabel == 'G') {
            gameState.setSourceRoom(gameState.getRoomAt(2, 0));
        } else if (sourceRoomLabel == 'H') {
            gameState.setSourceRoom(gameState.getRoomAt(2, 1));
        } else if (sourceRoomLabel == 'I') {
            gameState.setSourceRoom(gameState.getRoomAt(2, 2));
        } else {
            System.out.println("Invalid source room label");
        }
        System.out.println("Source room is " + gameState.getSourceRoom().getLabel());

        Robot robot = new Robot(gameState.getSourceRoom());

        System.out.println("Enter the goal room label: ");
        char goalRoomLabel = scanner.next().charAt(0);
        if (goalRoomLabel == 'A') {
            gameState.setGoalRoom(gameState.getRoomAt(0, 0));
        } else if (goalRoomLabel == 'B') {
            gameState.setGoalRoom(gameState.getRoomAt(0, 1));
        } else if (goalRoomLabel == 'C') {
            gameState.setGoalRoom(gameState.getRoomAt(0, 2));
        } else if (goalRoomLabel == 'D') {
            gameState.setGoalRoom(gameState.getRoomAt(1, 0));
        } else if (goalRoomLabel == 'E') {
            gameState.setGoalRoom(gameState.getRoomAt(1, 1));
        } else if (goalRoomLabel == 'F') {
            gameState.setGoalRoom(gameState.getRoomAt(1, 2));
        } else if (goalRoomLabel == 'G') {
            gameState.setGoalRoom(gameState.getRoomAt(2, 0));
        } else if (goalRoomLabel == 'H') {
            gameState.setGoalRoom(gameState.getRoomAt(2, 1));
        } else if (goalRoomLabel == 'I') {
            gameState.setGoalRoom(gameState.getRoomAt(2, 2));
        } else {
            System.out.println("Invalid goal room label");
        }
        System.out.println("Goal room is " + gameState.getGoalRoom().getLabel());


        System.out.println("Enter the number of walls:");
        int numberOfWalls = scanner.nextInt();
        for (int i = 0; i < numberOfWalls; i++) {
            System.out.println("Enter the wall " + (i + 1) + " label: ");
            char wallLabel = scanner.next().charAt(0);
            System.out.println("Enter the wall " + (i + 1) + " label build a wall between: ");
            String wallDirection = scanner.next();
            if (wallLabel == 'A') {
                if (wallDirection.equals("B")) {
                    gameState.addWall(gameState.getRoomAt(0, 0), gameState.getRoomAt(0, 1));
                } else if (wallDirection.equals("D")) {
                    gameState.addWall(gameState.getRoomAt(0, 0), gameState.getRoomAt(1, 0));
                } else {
                    System.out.println("The two rooms are not adjacent to each other");
                }
            } else if (wallLabel == 'B') {
                if (wallDirection.equals("A")) {
                    gameState.addWall(gameState.getRoomAt(0, 0), gameState.getRoomAt(0, 1));
                } else if (wallDirection.equals("C")) {
                    gameState.addWall(gameState.getRoomAt(0, 1), gameState.getRoomAt(0, 2));
                } else if (wallDirection.equals("E")) {
                    gameState.addWall(gameState.getRoomAt(0, 1), gameState.getRoomAt(1, 1));
                } else {
                    System.out.println("The two rooms are not adjacent to each other");
                }
            } else if (wallLabel == 'C') {
                if (wallDirection.equals("B")) {
                    gameState.addWall(gameState.getRoomAt(0, 1), gameState.getRoomAt(0, 2));
                } else if (wallDirection.equals("F")) {
                    gameState.addWall(gameState.getRoomAt(0, 2), gameState.getRoomAt(1, 2));
                } else {
                    System.out.println("The two rooms are not adjacent to each other");
                }
            } else if (wallLabel == 'D') {
                if (wallDirection.equals("A")) {
                    gameState.addWall(gameState.getRoomAt(0, 0), gameState.getRoomAt(1, 0));
                } else if (wallDirection.equals("E")) {
                    gameState.addWall(gameState.getRoomAt(1, 0), gameState.getRoomAt(1, 1));
                } else if (wallDirection.equals("G")) {
                    gameState.addWall(gameState.getRoomAt(1, 0), gameState.getRoomAt(2, 0));
                } else {
                    System.out.println("The two rooms are not adjacent to each other");
                }
            } else if (wallLabel == 'E') {
                if (wallDirection.equals("B")) {
                    gameState.addWall(gameState.getRoomAt(0, 1), gameState.getRoomAt(1, 1));
                } else if (wallDirection.equals("D")) {
                    gameState.addWall(gameState.getRoomAt(1, 0), gameState.getRoomAt(1, 1));
                } else if (wallDirection.equals("F")) {
                    gameState.addWall(gameState.getRoomAt(1, 1), gameState.getRoomAt(1, 2));
                } else if (wallDirection.equals("H")) {
                    gameState.addWall(gameState.getRoomAt(1, 1), gameState.getRoomAt(2, 1));
                } else {
                    System.out.println("The two rooms are not adjacent to each other");
                }
            } else if (wallLabel == 'F') {
                if (wallDirection.equals("C")) {
                    gameState.addWall(gameState.getRoomAt(0, 2), gameState.getRoomAt(1, 2));
                } else if (wallDirection.equals("E")) {
                    gameState.addWall(gameState.getRoomAt(1, 1), gameState.getRoomAt(1, 2));
                } else if (wallDirection.equals("I")) {
                    gameState.addWall(gameState.getRoomAt(1, 2), gameState.getRoomAt(2, 2));
                } else {
                    System.out.println("The two rooms are not adjacent to each other");
                }
            } else if (wallLabel == 'G') {
                if (wallDirection.equals("D")) {
                    gameState.addWall(gameState.getRoomAt(1, 0), gameState.getRoomAt(2, 0));
                } else if (wallDirection.equals("H")) {
                    gameState.addWall(gameState.getRoomAt(2, 0), gameState.getRoomAt(2, 1));
                } else {
                    System.out.println("The two rooms are not adjacent to each other");
                }
            } else if (wallLabel == 'H') {
                if (wallDirection.equals("E")) {
                    gameState.addWall(gameState.getRoomAt(1, 1), gameState.getRoomAt(2, 1));
                } else if (wallDirection.equals("G")) {
                    gameState.addWall(gameState.getRoomAt(2, 0), gameState.getRoomAt(2, 1));
                } else if (wallDirection.equals("I")) {
                    gameState.addWall(gameState.getRoomAt(2, 1), gameState.getRoomAt(2, 2));
                } else {
                    System.out.println("The two rooms are not adjacent to each other");
                }
            } else if (wallLabel == 'I') {
                if (wallDirection.equals("F")) {
                    gameState.addWall(gameState.getRoomAt(1, 2), gameState.getRoomAt(2, 2));
                } else if (wallDirection.equals("H")) {
                    gameState.addWall(gameState.getRoomAt(2, 1), gameState.getRoomAt(2, 2));
                } else {
                    System.out.println("The two rooms are not adjacent to each other");
                }
            } else {
                System.out.println("Invalid wall label");
            }
        }

        System.out.println("Choose the Search Algorithm: ");
        System.out.println("1. Uniform Cost Search");
        System.out.println("2. A* Search");
        int searchAlgorithm = scanner.nextInt();
        if (searchAlgorithm == 1) {
            System.out.println("Uniform Cost Search");
            List<Node> expansionNodes = SearchAlgorithms.uniformCostSearch(gameState);
            System.out.println("Expanded Nodes: ");
            for (Node node : expansionNodes) {
                System.out.println(node.getRoom().getLabel() + " - " + node.getTotalCost());
            }
        } else if (searchAlgorithm == 2) {
            System.out.println("A* Search");
            List<Node> expansionNodes = SearchAlgorithms.aStarSearch(gameState);
            System.out.println("Expanded Nodes: ");
            for (Node node : expansionNodes) {
                System.out.println(node.getRoom().getLabel() + " - " + node.getTotalCost());
            }
        } else {
            System.out.println("Invalid search algorithm");
        }
    }
}