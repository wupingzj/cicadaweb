
dashboardApp = angular.module("dashboardApp", 
		["ngRoute", "ngResource", "dashboardControllers"]);
//var cicada = cicada || {};
//cicada.app = dashboardApp
 
dashboardApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when("/countries", {
        	controller: "CountryListCtrl",
        	templateUrl: "dashboard/country/country-list.html",
        })
        .when("/countries/:countryId", {
        	controller: "CountryDetailCtrl",
        	templateUrl: "dashboard/country/country-detail.html"
        })
        .otherwise({
        	redirectTo: '/countries'
        });
    
    // Route tutorial: 
    // https://docs.angularjs.org/tutorial/step_07
    // https://www.youtube.com/watch?v=ziUelciLL5Q
}]);


//phonecatApp.config(['$routeProvider',
//                    function($routeProvider) {
//                      $routeProvider.
//                        when('/phones', {
//                          templateUrl: 'partials/phone-list.html',
//                          controller: 'PhoneListCtrl'
//                        }).
//                        when('/phones/:phoneId', {
//                          templateUrl: 'partials/phone-detail.html',
//                          controller: 'PhoneDetailCtrl'
//                        }).
//                        otherwise({
//                          redirectTo: '/phones'
//                        });
//                    }]);
