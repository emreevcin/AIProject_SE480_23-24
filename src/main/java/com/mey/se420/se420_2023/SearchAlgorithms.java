package com.mey.se420.se420_2023;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SearchAlgorithms {
    public static void uniformCostSearch(GameState gameState) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getPathCost));
        Set<Room> visited = new HashSet<>();

        Node initialNode = new Node(gameState.getSourceRoom());
        initialNode.setPathCost(0);
        priorityQueue.add(initialNode);

        int expandedNodes = 0;

        while (!priorityQueue.isEmpty() && expandedNodes < 10) {
            Node currentNode = priorityQueue.poll();
            expandedNodes++;

            if (currentNode.getRoom().equals(gameState.getGoalRoom())) {
                System.out.println("Goal reached!");
                return;
            }

            visited.add(currentNode.getRoom());

            for (Room room : getAdjacentRooms(gameState, currentNode)) {
                Node neighborNode = new Node(room);
                int cost = calculateMoveCost(currentNode, neighborNode);
                int newPathCost = currentNode.getPathCost() + cost;

                if (!visited.contains(room) && newPathCost < neighborNode.getPathCost()) {
                    neighborNode.setPathCost(newPathCost);
                    neighborNode.setParent(currentNode);
                    priorityQueue.add(neighborNode);
                }
            }
        }

        System.out.println("Goal not found within 10 expanded nodes.");
    }

    public static void aStarSearch(GameState gameState) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getTotalCost));
        Set<Room> visited = new HashSet<>();

        Node initialNode = new Node(gameState.getSourceRoom());
        initialNode.setPathCost(0);
        initialNode.setHeuristic(calculateHammingDistance(initialNode, gameState.getGoalRoom()));
        priorityQueue.add(initialNode);

        int expandedNodes = 0;

        while (!priorityQueue.isEmpty() && expandedNodes < 10) {
            Node currentNode = priorityQueue.poll();
            expandedNodes++;

            if (currentNode.getRoom().equals(gameState.getGoalRoom())) {
                System.out.println("Goal reached!");
                return;
            }

            visited.add(currentNode.getRoom());

            for (Room room : getAdjacentRooms(gameState, currentNode)) {
                Node neighborNode = new Node(room);
                int cost = calculateMoveCost(currentNode, neighborNode);
                int newPathCost = currentNode.getPathCost() + cost;

                if (!visited.contains(room)) {
                    int heuristic = calculateHammingDistance(neighborNode, gameState.getGoalRoom());
                    int totalCost = newPathCost + heuristic;

                    if (totalCost < neighborNode.getTotalCost()) {
                        neighborNode.setPathCost(newPathCost);
                        neighborNode.setHeuristic(heuristic);
                        neighborNode.setParent(currentNode);
                        priorityQueue.add(neighborNode);
                    }
                }
            }
        }

        System.out.println("Goal not found within 10 expanded nodes.");
    }


    private static int calculateMoveCost(Node currentNode, Node neighborNode) {
        int currentRow = currentNode.getRoom().getRow();
        int currentCol = currentNode.getRoom().getColumn();
        int nghRow = neighborNode.getRoom().getRow();
        int nghCol = neighborNode.getRoom().getColumn();

        int rowDiff = Math.abs(currentRow - nghRow);
        int colDiff = Math.abs(currentCol - nghCol);
        return rowDiff + colDiff == 1 ? (rowDiff == 1 ? 1 : 2) : 0; // Cost = 1 for up/down, 2 for left/right
    }

    private static int calculateHammingDistance(Node node, Room goalRoom) {
        char nodeLabel = node.getRoom().getLabel();
        char goalLabel = goalRoom.getLabel();

        return nodeLabel != goalLabel ? 1 : 0; // Return 1 if labels are different, 0 if the same (Hamming distance)
    }

    private static Set<Room> getAdjacentRooms(GameState gameState, Node currentNode) {
        Set<Room> adjacentRooms = new HashSet<>();
        Room currentRoom = currentNode.getRoom();
        int currentRow = currentRoom.getRow();
        int currentCol = currentRoom.getColumn();

        int[][] positions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

        for (int[] position : positions) {
            int newRow = currentRow + position[0];
            int newCol = currentCol + position[1];

            if (newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3) {
                Room adjacentRoom = gameState.getRoomAt(newRow, newCol);

                // Check if there's a wall between current and adjacent room
                if (!gameState.isWallBetween(currentRoom, adjacentRoom)) {
                    adjacentRooms.add(adjacentRoom);
                }
            }
        }
        return adjacentRooms;
    }

}
