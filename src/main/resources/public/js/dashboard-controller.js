var dashboardControllers = angular.module('dashboardControllers', []);

dashboardControllers.controller('CountryListCtrl', ['$scope', '$http',
  function ($scope, $http) {
    $http.get('testdata/countries.json').success(function(data) {
      $scope.phones = data;
    });

    $scope.orderProp = 'age';
  }]);

dashboardControllers.controller('CountryDetailCtrl', ['$scope', '$routeParams',
  function($scope, $routeParams) {
    $scope.countryId = $routeParams.countryId;
  }]);

