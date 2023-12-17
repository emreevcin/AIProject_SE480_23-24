package com.mey.se420.se420_2023;

import java.util.HashMap;
import java.util.Map;

public class GameState {
    private Room[][] rooms;
    private Room sourceRoom;
    private Room goalRoom;
    private Map<String, Boolean> walls;

    public GameState() {
        rooms = new Room[3][3];
        walls = new HashMap<>();
    }

    public Room getSourceRoom() {
        return sourceRoom;
    }

    public void setSourceRoom(Room room) {
        this.sourceRoom = room;
    }

    public Room getGoalRoom() {
        return goalRoom;
    }

    public void setGoalRoom(Room room) {
        this.goalRoom = room;
    }

    public Room getRoomAt(int row, int column) {
        if (row < 0 || row >= 3 || column < 0 || column >= 3) {
            return null;
        }
        return rooms[row][column];
    }

    public void setRoomAt(int row, int column, Room room) {
        if (row >= 0 && row < 3 && column >= 0 && column < 3) {
            rooms[row][column] = room;
        }
    }

    public boolean isWallBetween(Room room1, Room room2) {
        String wall = constructWallIdentifier(room1, room2);
        return walls.containsKey(wall);
    }

    public void addWall(Room room1, Room room2) {
        String wall = constructWallIdentifier(room1, room2);
        walls.put(wall, true);
    }

    private String constructWallIdentifier(Room room1, Room room2) {
        char label1 = room1.getLabel();
        char label2 = room2.getLabel();
        String wall = label1 < label2 ? label1 + "-" + label2 : label2 + "-" + label1;
        return wall;
    }
}
