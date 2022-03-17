package com.scheduler.repositories;

import java.util.List;
import java.util.Map;

import com.scheduler.entity.Events;
import com.scheduler.entity.Meeting;
import com.scheduler.entity.Room;

public class EventRepository {
	private Events events;

	public EventRepository() {
		events = new Events();
	}

	public Map<String, Room> getAllRooms() {
		return events.getRooms();
	}

	public void scheduleMeeting(String availableRoom, int startTime, int endTime) {

		Meeting meeting = new Meeting(startTime, endTime, events.getRooms().get(availableRoom));
		events.addMeeting(meeting);
	}

	public boolean roomExistByName(String name) {
		return events.getRooms().containsKey(name);
	}

	public List<Meeting> findMeetingsByRoomName(String room) {
		return events.getRooms().get(room).getMeetings();
	}

	public void addRoom(String roomName) {
		events.getRooms().put(roomName, new Room(roomName));
	}
}
