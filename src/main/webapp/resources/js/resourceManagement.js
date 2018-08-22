/* global angular:false */
'use strict';

var resourceManagementAudio_txt = [{
    state: "on",
    labname: "Admin test Lab 01",
    connProfile: "Profile Name",
    startdate: "2015-06-14 ",
    duration:"2 Wk",
    admin:"TekVizion",
    backup:"none"
}]

var resourceManagement_App = angular.module('resourceManagement_App',['scrollable-table'])
    .service('Data', function() {
        this.get = function() {

        };
    })
    // when sorting by year, sort by year and then replace %
    .service("Comparators", function() {
        this.year = function(r1, r2) {
            if(r1.date === r2.date) {
                if (r1.extent === r2.extent) return 0;
                return r1.extent > r2.extent ? 1 : -1;
            } else if(!r1.date || !r2.date) {
                return !r1.date && !r2.date ? 0 : (!r1.date ? 1 : -1);
            }
            return r1.date > r2.date ? 1 : -1;
        };
    })

    .controller('resourceManagementCtrl', function($scope, $timeout, $window, Data, Comparators) {

        $scope.visibleProjects = Data.get();
        $scope.comparator = Comparators.year;

        $scope.changeRecord = function(){
            $scope.visibleProjects[3].code = 'aaabbbccc';
            $scope.$broadcast("renderScrollableTable");
        };

        $scope.replaceRecords = function(){
            $scope.visibleProjects = Data.get();
        };

        $scope.visibleProjects = resourceManagementAudio_txt;

    });

