package com.scheduler.service;

import java.util.List;
import java.util.Map;

import com.scheduler.entity.Meeting;
import com.scheduler.entity.Room;
import com.scheduler.exceptions.NoRoomAvailableException;

public class CommonService {
	protected String getAvailableRoom(Map<String, Room> rooms, int startTime, int endTime)
			throws NoRoomAvailableException {
		String bookedRoom = "";
		for (Room room : rooms.values()) {
			if (isConflict(room.getMeetings(), startTime, endTime)) {
				bookedRoom = room.getName();
			}
		}
		if (bookedRoom.isEmpty())
			throw new NoRoomAvailableException("No room is available for given start Time and end Time");
		return bookedRoom;
	}

	private boolean isConflict(List<Meeting> meeting, int start, int end) {
		return meeting.stream().filter(meet -> (meet.getStartTime() > start && meet.getStartTime() < end)
				|| (meet.getEndTime() > start && meet.getEndTime() < end)).findAny().isEmpty();
	}
}
