package com.scheduler.entity;

public class Meeting {
	private int startTime;
	private int endTime;
	Room room;

	public Meeting(int startTime, int endTime, Room room) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.room = room;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public Room getRoom() {
		return room;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Meeting [startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}