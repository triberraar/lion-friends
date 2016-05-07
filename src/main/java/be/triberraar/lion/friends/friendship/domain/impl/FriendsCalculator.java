package be.triberraar.lion.friends.friendship.domain.impl;

import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.animal.domain.api.AnimalRepository;

@Named
public class FriendsCalculator {

	@Inject
	private AnimalRepository animalRepository;
	@Inject
	private DefaultFriendshipRepository defaultFriendshipRepository;

	public Optional<Animal> calculateGainedFriend(Animal animal) {
		Set<? extends Animal> all = animalRepository.all();
		all.remove(animal);
		removeCurrentFriends(animal, all);
		if (!all.isEmpty()) {
			return Optional.of(all.iterator().next());
		}
		return Optional.empty();
	}

	private void removeCurrentFriends(Animal animal, Set<? extends Animal> all) {
		Set<DefaultFriendship> currentFriends = defaultFriendshipRepository.getFriendsOf(animal);
		for (DefaultFriendship friendship : currentFriends) {
			all.remove(friendship.getFriendOf(animal));
		}
	}

	public Optional<Animal> calculateLostFriend(Animal animal) {
		Set<DefaultFriendship> currentFriends = defaultFriendshipRepository.getFriendsOf(animal);
		if (!currentFriends.isEmpty()) {
			return Optional.of(currentFriends.iterator().next().getFriendOf(animal));
		}
		return Optional.empty();
	}
}
