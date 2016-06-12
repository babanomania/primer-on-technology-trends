var app = angular.module("quote-app", ["ngResource"]);
app.controller("quotes", function($scope, $http, $resource) {

        var QuoteEntity = $resource("/quotes/:type");

        $scope.get_types = function() {
            $http.get("/quotes/types")
                    .then(function(response) {
                        $scope.type_data = response.data;
                        $scope.type = $scope.type_data[0];
                        $scope.show_quote();
                    });
        };
        $scope.get_types();


        $scope.show_quote = function() {
            $scope.quotes_db = QuoteEntity.get({ type: $scope.type });
        };
    }

);