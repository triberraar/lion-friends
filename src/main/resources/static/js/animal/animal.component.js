'use strict';

angular.module('animal.component', ['animal.controller', 'animal.repository', 'friend.repository'])
    .component('animals', {
        templateUrl: 'js/animal/animal.html',
        controller: 'AnimalController',
        controllerAs: 'animalCtrl'
    });