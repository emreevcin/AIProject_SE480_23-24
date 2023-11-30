package com.mey.se420.se420_2023;

public class Robot {
    private Room currentRoom;

    public Robot(Room startingRoom) {
        this.currentRoom = startingRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public void move(Room newRoom) {
        if (newRoom != null) {
            currentRoom = newRoom;
            System.out.println("Robot moved to room " + newRoom.getLabel());
        } else {
            System.out.println("Invalid movement");
        }
    }
}

