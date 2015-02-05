var dashboardControllerModule = angular.module('dashboardControllerModule', []);

// dashboardControllerModule.controller('CountryListCtrl', [ '$scope', '$http',
// function($scope, $http) {
// $http.get('testdata/countries.json').success(function(data) {
// $scope.countries = data;
// });
//
// $scope.orderProp = 'active';
// } ]);

dashboardControllerModule.controller('CountryListCtrl', [ '$scope',
		'countryService', function($scope, countryService) {
			// $scope.countries = countryService.getCountries($scope);
			countryService.getCountries($scope);
			$scope.orderProp = 'active';
		} ]);

dashboardControllerModule.controller('CountryDetailCtrl', [ '$scope',
		'$routeParams', function($scope, $routeParams) {
			$scope.countryId = $routeParams.countryId;
		} ]);
