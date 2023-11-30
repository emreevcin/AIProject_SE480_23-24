package com.mey.se420.se420_2023;

public class Node {
    private Room room;
    private int pathCost;
    private int heuristic;
    private Node parent;

    public Node(Room room) {
        this.room = room;
        this.pathCost = 0;
        this.heuristic = 0;
        this.parent = null;
    }

    public Room getRoom() {
        return room;
    }

    public int getPathCost() {
        return pathCost;
    }

    public void setPathCost(int pathCost) {
        this.pathCost = pathCost;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getTotalCost() {
        return pathCost + heuristic;
    }
}
