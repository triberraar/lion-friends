package be.triberraar.lion.friends.friendship.domain.api;

import java.util.Set;

public interface FriendshipChangeRepository {

	Set<? extends FriendshipChange> getByDay(Integer day);

}
