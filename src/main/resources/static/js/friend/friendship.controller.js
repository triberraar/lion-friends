'use strict';

angular.module('friendship.controller', ['friendship.repository'])
    .controller('FriendshipController', function (FriendshipRepository) {
        var vm = this;

        vm.live = function() {
            FriendshipRepository.live();
        };

        vm.changes = function() {
            return FriendshipRepository.changes;
        };

    });