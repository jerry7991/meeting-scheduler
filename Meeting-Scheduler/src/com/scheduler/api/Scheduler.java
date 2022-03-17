package com.scheduler.api;

import java.util.List;

import com.scheduler.entity.Meeting;
import com.scheduler.exceptions.NoRoomAvailableException;
import com.scheduler.exceptions.ResourceConflictException;
import com.scheduler.exceptions.ResourceNotFoundException;

public interface Scheduler {
	String bookRoom(int startTime, int endTime) throws NoRoomAvailableException;

	String retrieveAllMeetings() throws ResourceNotFoundException;

	void addRoom(String roomName) throws ResourceConflictException;

	List<Meeting> retrieveMeetingsByRoomName(String room) throws ResourceNotFoundException;
}