<%@ include file="../common/commonTagLib.jsp" %>


<div ng-app="myapp" ng-controller="myappcontroller" align="center">
	<h3>User Registration Form</h3>
	<form ng-submit="processUserDetails()">
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 600px">
				<tr>
					<td>Name</td>
					<td><input type="text" id="name" ng-model="userform.name"
						size="30" /></td>
				</tr>
				<tr>
					<td>Department</td>
					<td><input type="text" id="department"
						ng-model="userform.department" size="30" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit"
						class="btn btn-primary btn-sm" ng-click="processUser()"
						value="Create / Update User" /></td>
				</tr>
			</table>
		</div>
	</form>
	<h3>Registered Users</h3>
	<div class="table-responsive">
		<table class="table table-bordered" style="width: 600px">
			<tr>
				<th>Name</th>
				<th>Department</th>
				<th>Actions</th>
			</tr>

			<tr ng-repeat="user in users">
				<td>{{ user.name}}</td>
				<td>{{ user.department }}</td>
				<td><a ng-click="editUser(user)" class="btn btn-primary btn-sm">Edit</a>
					| <a ng-click="deleteUser(user)" class="btn btn-danger btn-sm">Delete</a></td>
			</tr>
		</table>
	</div>
</div>

<script type="text/javascript">
	var app = angular.module('myapp', []);

	app.controller('myappcontroller', function($scope, $http) {
		$scope.users = []
		$scope.userform = {
			name : "",
			department : ""
		};

		getUserDetails();

		function getUserDetails() {
			$http({
				method : 'GET',
				url : 'userdetails'
			}).then(function successCallback(response) {
				$scope.users = response.data;
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
		}

		$scope.processUser = function() {
			$http({
				method : 'POST',
				url : 'user',
				data : angular.toJson($scope.userform),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(getUserDetails(), clearForm())
			  .success(function(data){
				$scope.users= data
		    });
		}
		$scope.editUser = function(user) {
			$scope.userform.name = user.name;
			$scope.userform.department = user.department;
			disableName();
		}
		$scope.deleteUser = function(user) {
			$http({
				method : 'DELETE',
				url : 'deleteuser',
				data : angular.toJson(user),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(getUserDetails());
		}

		function clearForm() {
			$scope.userform.name = "";
			$scope.userform.department = "";
			document.getElementById("name").disabled = false;
		}
		;
		function disableName() {
			document.getElementById("name").disabled = true;
		}
	});
</script>