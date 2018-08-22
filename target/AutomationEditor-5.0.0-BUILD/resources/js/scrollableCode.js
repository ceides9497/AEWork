/* global angular:false */
'use strict';
var sample_App = angular.module('sample_App',['scrollable-table'])
.service('Data', function() {
    this.get = function() {
    	//AJAX call here
    	//string response
    	return [{
			status: "offline",
    		profilename: "Client Lab test",
    		creatorname: "Janice Lewis",
    		createddate: "5/7/15",
    		datelastmodified: "5/7/15",
    		datelastused: "5/7/15",
    		lastusedinlab: "Ed's test lab 2",
    	}];
    };
})
// when sorting by year, sort by year and then replace %
.service("Comparators", function() { 
  this.year = function(r1, r2) {
    if(r1.planYear === r2.planYear) {
      if (r1.extent === r2.extent) return 0;
      return r1.extent > r2.extent ? 1 : -1;
    } else if(!r1.planYear || !r2.planYear) {
      return !r1.planYear && !r2.planYear ? 0 : (!r1.planYear ? 1 : -1);
    }
    return r1.planYear > r2.planYear ? 1 : -1;
  };
})
.controller('sampleCtrl', function($scope, $timeout, $window, Data, Comparators) {
    $scope.visibleProjects = Data.get();
    $scope.comparator = Comparators.year;
  
    $scope.changeRecord = function(){
        $scope.visibleProjects[3].code = 'aaabbbccc';
        $scope.$broadcast("renderScrollableTable");
    };

    $scope.replaceRecords = function(){
        $scope.visibleProjects = Data.get();
    };
});