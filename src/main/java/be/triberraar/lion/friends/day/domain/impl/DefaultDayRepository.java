package be.triberraar.lion.friends.day.domain.impl;

import javax.inject.Named;

@Named
public class DefaultDayRepository {

	private int currentDay = 0;

	public void advance() {
		currentDay++;
	}

	public int getCurrentDay() {
		return currentDay;
	}
}
