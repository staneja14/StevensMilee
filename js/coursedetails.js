var professorURL = 'http://ec2-3-138-139-116.us-east-2.compute.amazonaws.com:1426/stevens/api/v1/{courseId}/professor';
var reviewsURL = 'http://ec2-3-138-139-116.us-east-2.compute.amazonaws.com:1426/stevens/api/v1/{courseId}/reviews';

var postCommentURL = 'http://ec2-3-138-139-116.us-east-2.compute.amazonaws.com:1426/stevens/api/v1/review';

let app = angular.module('StevensMilee', []);

app.controller('CourseDetailsCtrl', ($scope, $document, $http, $window) => {

    if(!$window.localStorage.getItem('studentId')){
        $window.location.href = '/views/login.html';
    }
    // This is CourseDetailsCtrl controller
    console.log('Inside CourseDetailsCtrl controller');

    $scope.saved = true;

    let courses = JSON.parse($window.localStorage.getItem('courses'));
    let courseIndex = parseInt($window.localStorage.getItem('courseIndex'));

    console.log(courses);
    console.log(courseIndex);

    $scope.courseDetails = courses[courseIndex];

    professorURL = professorURL.replace('{courseId}', courses[courseIndex].courseId);
    reviewsURL = reviewsURL.replace('{courseId}', courses[courseIndex].courseId);

    // Have to hit the API to bring professor's info based on the courseId
    $http.get(professorURL).then((response) => {
        // case of success
        response = response.data;
        console.log('Inside get professor info success response');

        $scope.saved = false;        

        if (response.error) {
            // some validation failed
            console.log(response.error[0].errorCode);
            alert(response.error[0].message);
        } else {
            console.log(response.data);

            $window.localStorage.setItem('professor', JSON.stringify(response.data));

            // making a variable to bind to the scope
            $scope.professorInfo = response.data;
        }
    }, (error) => {
        // case of failure
        alert(error.message);
        console.log(error);
    });

    getReview = function () {
        // Have to hit the comment's API to fetch the comments on the course
        $http.get(reviewsURL).then((response) => {
            // case of success
            response = response.data;
            console.log('Inside get reviews success response');

            $scope.saved = false;

            if (response.error) {
                // some validation failed
                console.log(response.error[0].errorCode);
                alert(response.error[0].message);
            } else {
                console.log(response.data);

                // making a variable to bind to the scope
                $scope.reviews = response.data.reviews;
            }
        }, (error) => {
            // case of failure
            alert(error.message);
            console.log(error);
        });
    }

    getReview();

    $scope.postReview = function () {
        console.log("Review Description: " + $scope.reviewDesc);

        // Calling the post review API
        $http.post(postCommentURL, {
            studentId: $window.localStorage.getItem('studentId'),
            courseId: courses[courseIndex].courseId,
            description: $scope.reviewDesc
        }).then((response) => {
            // case of success
            response = response.data;

            console.log('Inside success response' + response);

            if (response.error) {
                // some validation failed
                console.log('error object found' + response.error);
                console.log(response.error[0].errorCode);
                $window.alert(response.error[0].message);
            } else {
                console.log(response);

                // Nothing needs to be done here. Post comment is successful.
                $scope.saved = true;
                $scope.reviewDesc = "";
                getReview();
            }

        }, (error) => {
            // case of failure
            alert(error.message);
            console.log(error);
        });
    };

    $scope.logoutUser = function() {
        $window.localStorage.clear();
        $window.location.href = '/views/login.html';
    };
});