package be.triberraar.lion.friends.friendship.domain.impl;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.animal.domain.api.AnimalRepository;
import be.triberraar.lion.friends.day.domain.api.DayRepository;

@Named
public class DefaultFriendshipService {

	@Inject
	private AnimalRepository animalRepository;

	@Inject
	private FriendsCalculator friendsCalculator;

	@Inject
	private DefaultFriendshipChangeRepository defaultFriendshipChangeRepository;

	@Inject
	private DayRepository dayRepository;

	@Inject
	private DefaultFriendshipChangeFactory defaultFriendshipChangeFactory;

	public void live() {
		dayRepository.advance();
		int currentDay = dayRepository.getCurrentDay();
		for (Animal animal : animalRepository.all()) {
			Optional<Animal> gainedFriend = friendsCalculator.calculateGainedFriend(animal);
			Optional<Animal> lostFriend = friendsCalculator.calculateLostFriend(animal);

			defaultFriendshipChangeRepository.addFriendshipChange(currentDay, defaultFriendshipChangeFactory.create(animal, lostFriend, gainedFriend));
		}
	}
}
