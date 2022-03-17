package com.scheduler.entity;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private String name;
	private List<Meeting> meetings;

	public Room(String name, List<Meeting> meetings) {
		super();
		this.name = name;
		this.meetings = meetings;
	}

	public Room(String name) {
		super();
		this.name = name;
		this.meetings = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}

	@Override
	public String toString() {
		return "\n Room [name=" + name + ", meetings=" + meetings + "]";
	}

}
