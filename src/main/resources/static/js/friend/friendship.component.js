'use strict';

angular.module('friendship.component', ['friendship.controller', 'animal.repository', 'friend.repository', 'friendship.repository'])
    .component('friendship', {
        templateUrl: 'js/friend/friendship.html',
        controller: 'FriendshipController',
        controllerAs: 'friendshipCtrl'
    });