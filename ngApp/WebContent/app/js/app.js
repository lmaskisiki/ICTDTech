 angular.module("myapp", [])
         
         .controller("myCtrl", function($scope) {
         	$scope.welcome="welcome to angular";
            $scope.user={};
            $scope.test =function(){
            	console.log("what"+$scope.user.name	);
            };
            $scope.people=[{name: "Lizo", surname: "Masikisiki"},
                           {name: "Lele", surname: "Masikisiki"},
                           {name: "Toto", surname: "Masikisiki"},
                           {name: "Onie", surname: "Masikisiki"}];
            
         });