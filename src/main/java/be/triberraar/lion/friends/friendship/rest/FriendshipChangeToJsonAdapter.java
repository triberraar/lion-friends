package be.triberraar.lion.friends.friendship.rest;

import be.triberraar.lion.friends.friendship.domain.api.FriendshipChange;

public class FriendshipChangeToJsonAdapter {

	private FriendshipChange friendshipChange;

	public FriendshipChangeToJsonAdapter(FriendshipChange friendshipChange) {
		this.friendshipChange = friendshipChange;
	}

	public String getSubject() {
		return friendshipChange.getSubject().getName();
	}

	public String getLostFriend() {
		if (friendshipChange.getLostFriend().isPresent()) {
			return friendshipChange.getLostFriend().get().getName();
		}
		return null;
	}

	public String getGainedFriend() {
		if (friendshipChange.getGainedFriend().isPresent()) {
			return friendshipChange.getGainedFriend().get().getName();
		}
		return null;
	}

}
