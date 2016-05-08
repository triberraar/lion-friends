package be.triberraar.lion.friends.friendship.domain.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.day.domain.api.DayRepository;
import be.triberraar.lion.friends.friendship.domain.api.FriendshipRepository;

@Named
public class DefaultFriendshipRepository implements FriendshipRepository {

	private Set<DefaultFriendship> friendships = new HashSet<>();

	@Inject
	private DayRepository dayRepository;

	@Override
	public Set<DefaultFriendship> getFriendsOf(Animal animal) {
		return friendships.parallelStream().filter(friendship -> isFriendOf(animal, friendship)).collect(Collectors.toSet());
	}

	public void addFriendship(DefaultFriendship friendship) {
		friendships.add(friendship);
	}

	public void deleteFriendship(DefaultFriendship friendship) {
		friendships.remove(friendship);
	}

	Set<DefaultFriendship> getAll() {
		return friendships;
	}

	public Set<DefaultFriendship> getFriendsFromBeforeToday(Animal animal) {
		Integer currentDay = dayRepository.getCurrentDay();
		return friendships.parallelStream().filter(friendship -> isFriendOf(animal, friendship) && !friendship.getEstablished().equals(currentDay)).collect(Collectors.toSet());
	}

	private boolean isFriendOf(Animal animal, DefaultFriendship friendship) {
		return friendship.getFriend1().equals(animal) || friendship.getFriend2().equals(animal);
	}

}
