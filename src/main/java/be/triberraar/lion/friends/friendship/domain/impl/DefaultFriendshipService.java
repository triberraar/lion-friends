package be.triberraar.lion.friends.friendship.domain.impl;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.animal.domain.api.AnimalRepository;
import be.triberraar.lion.friends.day.domain.api.DayRepository;
import be.triberraar.lion.friends.friendship.domain.api.FriendshipService;

@Named
public class DefaultFriendshipService implements FriendshipService {

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

	@Inject
	private DefaultFriendshipRepository defaultFriendshipRepository;

	@Override
	public synchronized void live() {
		dayRepository.advance();
		int currentDay = dayRepository.getCurrentDay();
		for (Animal animal : animalRepository.all()) {
			Optional<Animal> gainedFriend = friendsCalculator.calculateGainedFriend(animal);
			Optional<Animal> lostFriend = friendsCalculator.calculateLostFriend(animal);

			defaultFriendshipChangeRepository.addFriendshipChange(currentDay, defaultFriendshipChangeFactory.create(animal, lostFriend, gainedFriend));
			if (gainedFriend.isPresent()) {
				defaultFriendshipRepository.addFriendship(new DefaultFriendship(animal, gainedFriend.get(), currentDay));
			}
			if (lostFriend.isPresent()) {
				defaultFriendshipRepository.deleteFriendship(new DefaultFriendship(animal, lostFriend.get(), currentDay));
			}
		}
	}
}
