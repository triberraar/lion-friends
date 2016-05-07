package be.triberraar.lion.friends.day.domain.api;

public interface DayRepository {

	void advance();

	int getCurrentDay();

}
