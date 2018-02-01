"use strict";

/******************************************************************************************

Expenses controller

******************************************************************************************/

var app = angular.module("expenses.controller", []);

app.controller("ctrlExpenses", ["$rootScope", "$scope", "config", "restalchemy", function ExpensesCtrl($rootScope, $scope, $config, $restalchemy) {
	// Update the headings
	$rootScope.mainTitle = "Expenses";
	$rootScope.mainHeading = "Expenses";

	// Update the tab sections
	$rootScope.selectTabSection("expenses", 0);

	var restExpenses = $restalchemy.init({ root: $config.apiroot }).at("expenses");

	$scope.dateOptions = {
		changeMonth: true,
		changeYear: true,
		dateFormat: "dd/mm/yy"
	};

	var loadExpenses = function() {
		// Retrieve a list of expenses via REST
		restExpenses.get().then(function(expenses) {
			$scope.expenses = expenses;
		});
	}

	$scope.saveExpense = function() {
		if ($scope.expensesform.$valid) {
			// Post the expense via REST
			restExpenses.post($scope.newExpense).then(function() {
				$scope.clearExpense();
				loadExpenses();
			});
		}
	};

	$scope.clearExpense = function() {
		if($scope.expensesform) {
			$scope.expensesform.$setPristine();
		}
		$scope.newExpense = {
			date: '',
			amount: '',
			vat: '',
			currency: "GBP",
			reason: ''
		};
	};

	$scope.updateVat = function() {
		var amount = $scope.newExpense.amount
		if(!isNaN(parseFloat(amount)) && isFinite(amount)) {
			var netPrice = amount/1.2;
			$scope.newExpense.vat= Math.round((amount - netPrice) * 100) / 100;	
		} else {
			$scope.newExpense.vat = 0;
		}		
	};

	// Initialise scope variables
	loadExpenses();
	$scope.clearExpense();
}]);
