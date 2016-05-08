package be.triberraar.lion.friends.friendship.domain.api;

import java.util.Set;

import be.triberraar.lion.friends.animal.domain.api.Animal;

public interface FriendshipRepository {

	Set<? extends Friendship> getFriendsOf(Animal animal);

}
