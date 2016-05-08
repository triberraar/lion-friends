'use strict';

var dependencies = [
    'ui.router',
    'ngMessages',
    'ngResource',
    'ngAnimate',
    'animal.component'];

angular.module('lion-friends', dependencies)
    .config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/friends');
        $stateProvider.state('friends', {
            url: '/friends',
            templateUrl: 'js/animal/animal.html',
            controller: 'AnimalController',
            controllerAs: 'animalCtrl'
        });

    });
