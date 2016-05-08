'use strict';

angular.module('friendship.controller', ['friendship.repository', 'animal.repository'])
    .controller('FriendshipController', function (FriendshipRepository, AnimalRepository, FriendRepository) {
        var vm = this;

        var init = function () {
            vm.graphOptions = {
                chart: {
                    type: 'forceDirectedGraph',
                    height: 250,
                    width: (function(){ return nv.utils.windowSize().width - 450; })(),
                    margin:{top: 20, right: 20, bottom: 20, left: 20},
                    nodeExtras: function(node) {
                        node
                            .append('text')
                            .attr('dx', 8)
                            .attr('dy', '.35em')
                            .text(function(d) { return d.name; })
                            .style('font-size', '10px');
                    }
                }
            };
            vm.graphData = {};
            calculateGraph();
        };

        var calculateGraph = function() {
            vm.graphData.nodes = [];
            vm.graphData.links = [];
            angular.forEach(AnimalRepository.animals, function(animal) {
                vm.graphData.nodes.push({name: animal.name});
            });
            angular.forEach(AnimalRepository.animals, function(animal) {
                angular.forEach(FriendRepository.getFriend(animal), function(friend) {
                    var source = _.findIndex(vm.graphData.nodes, function(node) {return node.name === animal.name;});
                    var target = _.findIndex(vm.graphData.nodes, function(node) {return node.name === friend;});
                    vm.graphData.links.push({source: source, target: target, group: 10});
                });
            });

        };

        vm.live = function () {
            FriendshipRepository.live().then(function() {
                calculateGraph();
            });
        };

        vm.changes = function () {
            return FriendshipRepository.changes;
        };

        init();

    });