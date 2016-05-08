'use strict';

describe('animal.repository', function() {

    var animalRepository, $httpBackend;

    var friendRepositoryMock= {
        queryFriend: function() {}
    };

    beforeEach(module('animal.repository'));

    beforeEach(module(function ($provide) {
        $provide.value('FriendRepository', friendRepositoryMock);
    }));

    beforeEach(inject(function (_$httpBackend_, _AnimalRepository_) {
        animalRepository = _AnimalRepository_;
        $httpBackend = _$httpBackend_;
    }));

    describe('init', function() {
        it('should set default values', function() {
            expect(animalRepository.animals).toEqual([]);
        });
    });

    describe('all', function() {
        it('should query the backend and find the friend for each animal', function() {
            spyOn(friendRepositoryMock, 'queryFriend');
            $httpBackend.expectGET('/animal').respond(200, [{id: 1}, {id:2}]);

            animalRepository.all();
            $httpBackend.flush();

            expect(friendRepositoryMock.queryFriend).toHaveBeenCalledTimes(2);
            expect(friendRepositoryMock.queryFriend).toHaveBeenCalledWith({id: 1});
            expect(friendRepositoryMock.queryFriend).toHaveBeenCalledWith({id: 2});
        });

        afterEach(function () {
            $httpBackend.verifyNoOutstandingExpectation();
            $httpBackend.verifyNoOutstandingRequest();
        });
    });
});