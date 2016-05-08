package be.triberraar.lion.friends.friendship.exception;

import be.triberraar.lion.friends.exception.NotFoundException;

public class DayNotFoundException extends NotFoundException {

	private Integer day;

	public DayNotFoundException(Integer day) {
		this.day = day;
	}

	@Override
	public String getMessage() {
		return "Day '" + this.day + "' not found";
	}
}
