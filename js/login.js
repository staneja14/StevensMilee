const loginURL = 'http://ec2-3-138-139-116.us-east-2.compute.amazonaws.com:1426/stevens/api/v1/login';
let app = angular.module('StevensMilee', [])

app.controller('LoginCtrl', ($scope, $http, $window) => {

    // This is MyLogin controller
    console.log('Inside the login controller');
    //angular.element(document.querySelector('mydiv')).hide();

    // This is a processLogin function to hit login API
    $scope.processLogin = function () {

        console.log('Inside the processLogin function');
        console.log($scope.emailId);
        $scope.saved = true;

        // Calling the login API
        $http.post(loginURL, { emailId: $scope.emailId }).then((response) => {
            // case of success
            $scope.saved = false;
            response = response.data;

            console.log('Inside success response' + response);

            if (response.error) {
                // some validation failed
                console.log('error object found' + response.error);
                console.log(response.error[0].errorCode);
                $window.alert(response.error[0].message);
            } else {
                console.log(response);

                // saving the studentId in the localStorage
                $window.localStorage.setItem('studentId', response.data.studentId);
                $window.location.href = '/views/courses.html';
            }

        }, (error) => {
            // case of failure
            alert(error.message);
            console.log(error);
        });
    };
});