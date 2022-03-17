package com.scheduler.entity;

import java.util.HashMap;
import java.util.Map;

public class Events {
	private Map<String, Room> rooms;

	public Events() {
		rooms = new HashMap<>();
	}

	public Map<String, Room> getRooms() {
		return rooms;
	}

	public void setRooms(Map<String, Room> rooms) {
		this.rooms = rooms;
	}

	public void addMeeting(Meeting meeting) {
		String roomName = meeting.getRoom().getName();
		rooms.get(roomName).getMeetings().add(meeting);
	}

}