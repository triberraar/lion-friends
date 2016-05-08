'use strict';

describe('animal.controller', function() {
    var $rootScope, $controller;

    var animalRepositoryMock= {
        all: function() {},
        animals: {id: 1}
    }, friendRepositoryMock = {
        getFriend: function() {}
    };

    beforeEach(module('animal.controller'));

    beforeEach(inject(function(_$controller_, _$rootScope_) {
        $rootScope = _$rootScope_;
        $controller = _$controller_;
    }));


    var createController = function() {
        return $controller('AnimalController', {
            $scope: $rootScope.$new(),
            AnimalRepository: animalRepositoryMock,
            FriendRepository: friendRepositoryMock
        });
    };

    describe('init', function() {
        it('should query animals', function() {
            spyOn(animalRepositoryMock, 'all');

            createController();

            expect(animalRepositoryMock.all).toHaveBeenCalled();
        });
    });
    describe('animals', function() {
        it('should return animals', function() {
            var ctrl = createController();

            expect(ctrl.animals()).toEqual({id: 1});
        });
    });
    describe('getMetadata', function() {
        it('shouldn\'t return if animal has no metadata', function() {
            var ctrl = createController();

            expect(ctrl.getMetadata({})).toBeUndefined();
        });
        it('should concatenate metadata if animal has metadata', function() {
            var ctrl = createController();

            expect(ctrl.getMetadata({metaData: ['one', 'two']})).toEqual('one, two');
        });
    });
    describe('getFriends', function() {
        it('shouldn\'t return if animal has no friends', function() {
            spyOn(friendRepositoryMock, 'getFriend').and.returnValue(undefined);

            var ctrl = createController();

            expect(ctrl.getFriends({})).toBeUndefined();
        });
        it('should concatenate friends if animal has friends', function() {
            spyOn(friendRepositoryMock, 'getFriend').and.returnValue(['friend1', 'friend2']);

            var ctrl = createController();

            expect(ctrl.getFriends({})).toEqual('friend1, friend2');
        });
    });
});