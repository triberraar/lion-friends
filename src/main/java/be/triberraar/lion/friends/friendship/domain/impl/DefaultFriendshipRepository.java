package be.triberraar.lion.friends.friendship.domain.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Named;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.friendship.domain.api.FriendshipRepository;

@Named
public class DefaultFriendshipRepository implements FriendshipRepository {

	private Set<DefaultFriendship> friendships = new HashSet<>();

	@Override
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
