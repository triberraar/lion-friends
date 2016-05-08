'use strict';

describe('friend.repository', function() {

    var friendshipRepository, $httpBackend;

    var friendRepositoryMock = {
        queryFriend:function() {}
    }, animalRepositoryMock = {
        animals : [{animal: '1'}, {animal: '2'}]
    };

    beforeEach(module('friendship.repository'));

    beforeEach(module(function ($provide) {
        $provide.value('AnimalRepository', animalRepositoryMock);
        $provide.value('FriendRepository', friendRepositoryMock);
    }));

    beforeEach(inject(function (_$httpBackend_, _FriendshipRepository_) {
        friendshipRepository = _FriendshipRepository_;
        $httpBackend = _$httpBackend_;
    }));

    describe('init', function() {
        it('should set default values', function() {
            expect(friendshipRepository.changes).toEqual([]);
        });
    });
    describe('live', function() {
        it('should live to the backend, record changes and refresh animal friends', function() {
            $httpBackend.expectPUT('/friendship/live').respond(200, [{id: 1}, {id:2}]);
            spyOn(friendRepositoryMock, 'queryFriend');

            friendshipRepository.live();
            $httpBackend.flush();

            expect(friendshipRepository.changes).toEqual([{id: 1}, {id:2}]);
            expect(friendRepositoryMock.queryFriend).toHaveBeenCalledTimes(2);
            expect(friendRepositoryMock.queryFriend).toHaveBeenCalledWith({animal: '1'});
            expect(friendRepositoryMock.queryFriend).toHaveBeenCalledWith({animal: '2'});
        });

        afterEach(function () {
            $httpBackend.verifyNoOutstandingExpectation();
            $httpBackend.verifyNoOutstandingRequest();
        });
    });
});