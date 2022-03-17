package com.scheduler.service;

import java.util.List;

import com.scheduler.api.Scheduler;
import com.scheduler.entity.Meeting;
import com.scheduler.exceptions.NoRoomAvailableException;
import com.scheduler.exceptions.ResourceConflictException;
import com.scheduler.exceptions.ResourceNotFoundException;
import com.scheduler.repositories.EventRepository;

public class SchedulerImpl extends CommonService implements Scheduler {
	EventRepository eventRepository;

	public SchedulerImpl() {
		eventRepository = new EventRepository();
	}

	@Override
	public String bookRoom(int startTime, int endTime) throws NoRoomAvailableException {
		String availableRoom = getAvailableRoom(eventRepository.getAllRooms(), startTime, endTime);
		eventRepository.scheduleMeeting(availableRoom, startTime, endTime);
		return availableRoom;
	}

	@Override
	public List<Meeting> retrieveMeetingsByRoomName(String room) throws ResourceNotFoundException {
		if (!eventRepository.roomExistByName(room)) {
			throw new ResourceNotFoundException("No such room = " + room + " exist.");
		}
		return eventRepository.findMeetingsByRoomName(room);
	}

	@Override
	public void addRoom(String roomName) throws ResourceConflictException {
		if (eventRepository.roomExistByName(roomName)) {
			throw new ResourceConflictException("Given room name = " + roomName + " already added.");
		}
		eventRepository.addRoom(roomName);
	}

	@Override
	public String retrieveAllMeetings() throws ResourceNotFoundException {
		StringBuilder data = new StringBuilder();
		eventRepository.getAllRooms().forEach((key, value) -> {
			data.append("Room = " + key + " : has Meetings => " + value);
		});
		return data.toString();
	}

}