let app = angular.module('StevensMilee', []);

app.controller('ProfessorCtrl', ($scope, $document, $http, $window) => {

    if(!$window.localStorage.getItem('studentId')){
        $window.location.href = '/views/login.html';
    }
    // This is CourseDetailsCtrl controller
    console.log('Inside ProfessorCtrl controller');

    $scope.professorInfo = JSON.parse($window.localStorage.getItem('professor'));
    console.log($scope.professorInfo);

    let courses = JSON.parse($window.localStorage.getItem('courses'));
    let courseIndex = parseInt($window.localStorage.getItem('courseIndex'));

    $scope.courseTaught = courses[courseIndex].name;
    console.log($scope.courseTaught);

    $scope.logoutUser = function() {
        $window.localStorage.clear();
        $window.location.href = '/views/login.html';
    };
});
