package be.triberraar.lion.friends.day.domain.impl;

import javax.inject.Named;

import be.triberraar.lion.friends.day.domain.api.DayRepository;

@Named
public class DefaultDayRepository implements DayRepository {

	private int currentDay = 0;

	@Override
	public void advance() {
		currentDay++;
	}

	@Override
	public int getCurrentDay() {
		return currentDay;
	}
}
