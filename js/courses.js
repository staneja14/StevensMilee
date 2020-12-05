var coursesURL = 'http://ec2-3-138-139-116.us-east-2.compute.amazonaws.com:1426/stevens/api/v1/{studentId}/courses';
var studentInfoURL = 'http://ec2-3-138-139-116.us-east-2.compute.amazonaws.com:1426/stevens/api/v1/{studentId}/info';
let app = angular.module('StevensMilee', []);

app.controller('CoursesCtrl', ($scope, $http, $window) => {

    if(!$window.localStorage.getItem('studentId')){
        $window.location.href = '/views/login.html';
    }
    // This is CoursesCtrl controller
    console.log('App loaded');

    console.log($window.localStorage.getItem('studentId'));
    coursesURL = coursesURL.replace('{studentId}', $window.localStorage.getItem('studentId'));
    studentInfoURL = studentInfoURL.replace('{studentId}', $window.localStorage.getItem('studentId'));
    console.log(coursesURL);
    console.log(studentInfoURL);

    $scope.saved = true;

    // Calling the student info API
    $http.get(studentInfoURL).then((response) => {
        // case of success
        response = response.data;
        console.log('Inside get student info success response');

        if (response.error) {
            // some validation failed
            console.log(response.error[0].errorCode);
            alert(response.error[0].message);
        } else {
            console.log(response.data);

            // making a variable to bind to the scope
            $scope.studentInfo = response.data;
        }

    }, (error) => {
        // case of failure
        alert(error.message);
        console.log(error);
    });

    // Calling the getCourses API
    $http.get(coursesURL).then((response) => {
        // case of success
        $scope.saved = false;
        response = response.data;
        console.log('Inside getCourses success response');

        if (response.error) {
            // some validation failed
            console.log(response.error[0].errorCode);
            alert(response.error[0].message);
        } else {
            console.log(response.data);

            // saving the courses info in the localStorage
            $window.localStorage.setItem('courses', JSON.stringify(response.data.courses));

            // making a variable to bind to the scope
            $scope.courses = response.data.courses;
        }
    }, (error) => {
        // case of failure
        alert(error.message);
        console.log(error);
    });

    $scope.courseDetails = function (index) {
        console.log("Index: " + index);
        $window.localStorage.setItem('courseIndex', index);
        $window.location.href = '/views/coursedetails.html';
    };

    $scope.logoutUser = function() {
        $window.localStorage.clear();
        $window.location.href = '/views/login.html';
    };
});