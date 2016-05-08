'use strict';

describe('friend.repository', function() {

    var friendRepository, $httpBackend;

    beforeEach(module('friend.repository'));

    beforeEach(inject(function (_$httpBackend_, _FriendRepository_) {
        friendRepository = _FriendRepository_;
        $httpBackend = _$httpBackend_;
    }));

    describe('queryFriend + getFriend', function() {
        it('should query backend for friends', function() {
            $httpBackend.expectGET('/friend?name=name').respond(200, [{name: 1}, {name:2}]);

            friendRepository.queryFriend({name: 'name'});
            $httpBackend.flush();

            expect(friendRepository.getFriend({name: 'name'})).toEqual([1, 2]);
        });

        afterEach(function () {
            $httpBackend.verifyNoOutstandingExpectation();
            $httpBackend.verifyNoOutstandingRequest();
        });
    });
});
