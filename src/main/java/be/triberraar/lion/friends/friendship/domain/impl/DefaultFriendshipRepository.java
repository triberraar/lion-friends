package be.triberraar.lion.friends.friendship.domain.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Named;

import be.triberraar.lion.friends.animal.domain.api.Animal;

@Named
public class DefaultFriendshipRepository {

	private Set<DefaultFriendship> friendships = new HashSet<>();

	public Set<DefaultFriendship> getFriendsOf(Animal animal) {
		return friendships.parallelStream().filter(friendship -> friendship.getFriend1().equals(animal) || friendship.getFriend2().equals(animal)).collect(Collectors.toSet());
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

}
