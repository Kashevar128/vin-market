angular.module('market', ['ngStorage']).controller('indexController', function ($scope, $http, $localStorage) {
    $scope.tryToAuth = function () {
        $http.post('http://localhost:17003/vin/auth', $scope.user).then(function successCallback(response) {
            if (response.data.token) {
                $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                $localStorage.vinMarketUser = {username: $scope.user.username, token: response.data.token};

                $scope.user.username = null;
                $scope.user.password = null;
            }
        }, function errorCallback(response) {

        });
    }

    $scope.tryToLogout = function () {
        $scope.clearUser();
        $scope.user = null;
    }

    $scope.clearUser = function () {
        delete $localStorage.vinMarketUser;
        $http.defaults.headers.common.Authorization = '';
    }

    $scope.isUserLoggedIn = function () {
        if ($localStorage.vinMarketUser) {
            return true;
        } else {
            return false;
        }
    }

    $scope.authCheck = function () {
        $http.get('http://localhost:17003/vin/auth_check').then(function (response) {
            alert(response.data.value);
        });
    }

    $scope.loadProducts = function () {
        $http.get('http://localhost:17003/vin/api/v1/products').then(function (response) {
            $scope.productsList = response.data;
        });
    }

    $scope.showProductInfo = function (productId) {
        $http.get('http://localhost:17003/vin/api/v1/products/' + productId).then(function (response) {
            alert(response.data.title);
        });
    }

    $scope.removeFromCart = function (productId) {
        $http.get('http://localhost:17003/vin/api/v1/cart/remove/' + productId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.clearCart = function () {
        $http.get('http://localhost:17003/vin/api/v1/cart/clear').then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.addToCart = function (productId) {
        $http.get('http://localhost:17003/vin/api/v1/cart/add/' + productId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.addQuantity = function (productId) {
        $http.get('http://localhost:17003/vin/api/v1/cart/cartItem/add/' + productId).then(function (response) {
            $scope.loadCart();
        })
    }

    $scope.reduceQuantity = function (productId) {
        $http.get('http://localhost:17003/vin/api/v1/cart/cartItem/reduce/' + productId).then(function (response) {
            $scope.loadCart();
        })
    }

    $scope.loadCart = function () {
        $http.get('http://localhost:17003/vin/api/v1/cart').then(function (response) {
            $scope.cart = response.data;
        });
    }

    if ($localStorage.vinMarketUser) {
        try {
            let jwt = $localStorage.vinMarketUser.token;
            let payload = JSON.parse(atob(jwt.split('.')[1]));
            let currentTime = parseInt(new Date().getTime() / 1000);
            if (currentTime > payload.exp) {
                console.log("Token is expired!");
                delete $localStorage.vinMarketUser;
                $http.defaults.headers.common.Authorization = '';
            }
        } catch (e) {

        }

        $http.defaults.headers.common.Authorization = 'Bearer' + $localStorage.vinMarketUser.token;
    }

    $scope.loadProducts();
    $scope.loadCart();
});