'use strict';

describe('friendship.controller', function() {

    var ctrl, $controller;

    var friendshipRepositoryMock = {
        live: function() {},
        changes: [{id:1}]
    };

    beforeEach(module('friendship.controller'));

    beforeEach(inject(function(_$controller_) {
        $controller = _$controller_;
    }));

    beforeEach(function() {
        ctrl = $controller('FriendshipController', {
            FriendshipRepository: friendshipRepositoryMock
        });
    });

    describe('live', function() {
        it('should live', function() {
            spyOn(friendshipRepositoryMock, 'live');

            ctrl.live();

            expect(friendshipRepositoryMock.live).toHaveBeenCalled();
        });
    });
    describe('changes', function() {
        it('should return the changes', function() {
            expect(ctrl.changes()).toEqual([{id:1}]);
        });
    });
});