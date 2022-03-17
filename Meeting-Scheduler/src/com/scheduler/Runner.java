package com.scheduler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.scheduler.api.Scheduler;
import com.scheduler.exceptions.NoRoomAvailableException;
import com.scheduler.exceptions.ResourceConflictException;
import com.scheduler.exceptions.ResourceNotFoundException;
import com.scheduler.service.SchedulerImpl;

public class Runner {
	private static BufferedReader reader;

	public static void main(String[] args) throws NumberFormatException, IOException {
		info();
		reader = new BufferedReader(new InputStreamReader(System.in));

		Scheduler scheduler = new SchedulerImpl();

		int choice = Integer.parseInt(reader.readLine());
		while (choice != -1) {
			switch (choice) {
			case 1:
				addRoom(scheduler);
				break;
			case 2:
				scheduleMeeting(scheduler);
				break;
			case 3:
				showHistory(scheduler);
				break;
			default:
				reader.close();
			}
			System.out.println("Enter Choice : ");
			choice = Integer.parseInt(reader.readLine());
		}
	}

	private static void showHistory(Scheduler scheduler) {
		try {
			System.out.println(scheduler.retrieveAllMeetings());
		} catch (ResourceNotFoundException e) {
			System.out.println("Error ::" + e.getMessage());
		}
	}

	private static void scheduleMeeting(Scheduler scheduler) {
		String input[] = null;
		try {
			System.out.println("Enter start time and end time followed by space. Time->(hhmm)");
			input = reader.readLine().split(" ");
			String bookedRoom = scheduler.bookRoom(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			System.out.println("Room " + bookedRoom + " booked  for you on time [" + input[0] + ", " + input[1] + " ]");
		} catch (IOException | NumberFormatException | NoRoomAvailableException e) {
			System.out.println("Error :: " + e.getMessage());
		}
	}

	private static void addRoom(Scheduler scheduler) {
		try {
			System.out.println("Enter room name for adding.");
			scheduler.addRoom(reader.readLine());
		} catch (ResourceConflictException | IOException e) {
			System.out.println("Error :: " + e.getMessage());
		}
	}

	private static void info() {
		System.out.println("Command are :: ");
		System.out.println("1. Add room");
		System.out.println("2. Schedule Meeting.");
		System.out.println("3. History of meetings booked");
		System.out.println("-1. exit");
	}

}
