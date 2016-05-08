'use strict';

describe('friendship.controller', function() {

    var ctrl, $controller;

    var friendshipRepositoryMock = {
        live: function() {return {then: function(fn) {fn();}}},
        changes: [{id:1}]
    },animalRepositoryMock={
        animals : [{name: 'animal1'}, {name: 'animal2'}]
    }, friendRepositoryMock = {
        getFriend: function(animal) {
            if(animal.name === 'animal1') {
                return ['animal2'];
            } else {
                return ['animal1'];
            }
        }
    };

    beforeEach(module('friendship.controller'));

    beforeEach(inject(function(_$controller_) {
        $controller = _$controller_;
    }));

    beforeEach(function() {
        ctrl = $controller('FriendshipController', {
            FriendshipRepository: friendshipRepositoryMock,
            AnimalRepository: animalRepositoryMock,
            FriendRepository: friendRepositoryMock
        });
    });

    describe('init', function() {
        it('should build graph data', function() {
            expect(ctrl.graphData.nodes.length).toEqual(2);
            expect(ctrl.graphData.nodes).toEqual([{name: 'animal1'}, {name: 'animal2'}]);
            expect(ctrl.graphData.links.length).toEqual(2);
            expect(ctrl.graphData.links).toEqual([{source: 0, target: 1, group: 10}, { source: 1, target: 0, group: 10 }]);
        });
    });

    describe('live', function() {
        it('should live and calculate graph', function() {
            spyOn(friendshipRepositoryMock, 'live').and.callThrough();
            ctrl.graphData = {};

            ctrl.live();

            expect(friendshipRepositoryMock.live).toHaveBeenCalled();
            expect(ctrl.graphData.nodes.length).toEqual(2);
            expect(ctrl.graphData.nodes).toEqual([{name: 'animal1'}, {name: 'animal2'}]);
            expect(ctrl.graphData.links.length).toEqual(2);
            expect(ctrl.graphData.links).toEqual([{source: 0, target: 1, group: 10}, { source: 1, target: 0, group: 10 }]);
        });
    });
    describe('changes', function() {
        it('should return the changes', function() {
            expect(ctrl.changes()).toEqual([{id:1}]);
        });
    });
});