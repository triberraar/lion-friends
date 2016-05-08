'use strict';


angular.module('friend.repository', [])
    .factory('FriendRepository', function($http, $log) {
        var FriendRepository = {};
        var friends = {};
        FriendRepository.queryFriend = function(animal) {
            var name = animal.name;
            $http.get('/friend', {params: {name: name}}).then(function(response) {
                friends[name] = [];
                angular.forEach(response.data, function(friend) {
                    friends[name].push(friend.name);
                });

            }, function(){
                $log.error('Could not get friends');
            });
        };
        FriendRepository.getFriend = function(animal) {
            var name = animal.name;
            return friends[name];
        };

        return FriendRepository;
    });