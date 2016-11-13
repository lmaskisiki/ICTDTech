angular
		.module("InfoWeb.controllers", [])
		.controller("LizoCntrl", function(profileService) {
			alert(profileService("basic", "admin").isValid);
		})
		.controller(
				'loginCntrl',
				function($rootScope, $scope, $location, $http) {
					var self = this;

					var authenticate = function(credentials) {
						$scope.test = function() {
							alert("tested");
						}
						var headers = credentials ? {
							authorization : "Basic "
									+ btoa(credentials.username + ":"
											+ credentials.password)
						} : {};
						$http.post('http://192.168.43.12:8080/userGate/user', {
							headers : headers
						}).then(function(response) {
							alert(JSON.stringify(response));
							if (response.data) {

								$rootScope.authenticated = true;
							} else {

								$rootScope.authenticated = false;
							}

						}, function() {
							$rootScope.authenticated = false;

						});

					}
					self.credentials = {};
					self.credentials.username = "admins";
					self.credentials.password = "lizo@200903375";
					authenticate(self.credentials);
					self.login = function() {
						alert("mxm1");
						authenticate(self.credentials);
					}

				})
		.controller('accessCntrl', function($rootScope, $scope, $location) {

			$scope.user = {};
			$rootScope.authenticated = false;
			$scope.login = function() {
				if ($scope.user.username && $scope.user.password) {
					$rootScope.authenticated = true;
					$location.path("/search");
				}
			};
		})
		.controller(
				'homeAffCntrl',
				function($rootScope, $scope, $http,
						HomeAffairsApplicationService,
						HomeAffairsNoticBoardService) {
					$scope.userId = 4;
					$scope.statusinfo = {};
					$scope.statusCheck = {};
					$scope.statusCheck.hideForm = false;
					$scope.showResults = false;
					$scope.checkstatus = function() {
						$scope.applications = [];
						$scope.rs = HomeAffairsApplicationService.checkstatus(
								$scope.userId, function(applications) {
									var appl = {};
									appl.id = applications["id"];
									appl.message = applications["message"];
									$scope.applications.push(appl);
									$scope.showResults = true;
								});
					}
					$scope.notices = function() {
						$scope.applications = [];
						var result = HomeAffairsNoticBoardService
								.notices(function(applications) {
									for (var i = 0; i < applications.length; i++) {
										var appl = {};
										appl.id = applications[i]["parentId"];
										appl.message = applications[i]["message"];
										$scope.applications.push(appl);
									}
									$scope.showResults = true;
								});
					};

				})
		.controller(
				'martenityCntrl',
				function($rootScope, $scope, $http) {
					$scope.checkups = [];
					$scope.showcheckups = false;
					$scope.userId = ""
					$scope.showCheckList = false;
					$scope.loadCheckups = function() {
						$scope.checkups = [];
						$scope.showcheckups = $scope.userId.length > 5 ? true
								: false;
						$http(
								{
									Method : "GET",
									url : "http://192.168.43.12:8181/cxf/healthservice/checkups/"
											+ $scope.userId,
									headers : {
										'Accept' : 'application/json'
									}
								}).success(function(data) {
							loadWomanData(data);

						});
					};
					loadWomanData = function(data) {
						if (data["list"]) {
							if (data["list"]["birthtech.entities.Checkup"]) {
								var datas = data["list"]["birthtech.entities.Checkup"];
								for (var x = 0; x < datas.length; x++) {
									var checkup = {};
									checkup.id = datas[x]["checkupId"];
									checkup.date = datas[x]["date"];
									checkup.comments = datas[x]["comments"];
									$scope.checkups.push(checkup);

								}

							}
						}
					}
				})
		.controller('profileController', function($scope, $rootScope) {
			$scope.profile = $rootScope.profile;
			$scope.hasdocuments = $rootScope.hasdocuments;
			$scope.profile.documents = [];
			$scope.showprofile = $rootScope.showprofile;
			alert($scope.profile.name);
			alert($scope.profile.documents);

		})
		.controller('homeController', function($scope) {
			$scope.message = "Welcome to Infosource Web";
			$scope.showappform = false;
			$scope.applyform = function() {
				$scope.showappform = $scope.showappform ? false : true;
			};

		})
		.controller(
				"searchCntrl",
				function($scope, $location, $rootScope, profileService) {
					$scope.modeOptions = [ "Select", "Basic", "Docs", "Full" ];
					$scope.pmode = $scope.modeOptions[0];
					$scope.showprofile = false;
					$scope.user = "";
					$scope.profile = {};
					$scope.searchuser = function() {
						$scope.profile = profileService
								.profile(
										$scope.pmode.toLowerCase(),
										$scope.user.toLowerCase(),
										function() {
											if ($scope.profile.isValid) {
												if ($scope.profile["data"]["personalDetails"]) {
													$scope.profile.surname = $scope.profile["data"]["personalDetails"][0]["lastName"];
													$scope.profile.name = $scope.profile["data"]["personalDetails"][0]["firstName"];
													$scope.profile.idnumber = $scope.profile["data"]["personalDetails"][0]["idNumber"];
													$scope.profile.username = $scope.profile["data"]["personalDetails"][0]["username"];
													$scope.profile.mobile = $scope.profile["data"]["personalDetails"][0]["cell"];
													$scope.profile.email = $scope.profile["data"]["personalDetails"][0]["email"];
												}
												if ($scope.profile.hasDocs) {
													$scope.profile.documents = [];
													var docs = $scope.profile["data"]["documents"];
													for (var i = 0; i < docs[0].length; i++) {
														var file = {};
														file.id = docs[0][i]["fileId"];
														file.name = docs[0][i]["fileName"];
														file.uploaded = docs[0][i]["uploadedBy"];
														$scope.profile.documents
																.push(file);
													}
												}
											}
											$scope.showprofile = true;
										});

					}

				})
		.controller(
				"loginController",
				function($rootScope, $http, $location, $scope, AuthService,
						UserDetialsService) {
					$scope.credentials = {};
					$scope.login = function() {
						$http
								.post("http://192.168.43.12:8181/cxf/upservice/createaccount","lizo").success(function(responseData) {
								alert("back");
								});
						// alert($scope.credentials.username+":"+$scope.credentials.password);
						// var
						// user=AuthService.login($scope.credentials.username,$scope.credentials.password,
						// function(){
						// if($rootScope.authenticated){
						// $location.path("/homeaffairs");
						// }else{
						// $scope.loginError=true;
						// $location.path("/login");
						// 
						// }
						// });
					};

				});