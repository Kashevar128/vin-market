
angular.module('market', []).controller('indexController', function ($scope, $http) {
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

    $scope.deleteProductById = function (productId) {
        $http.delete('http://localhost:17003/vin/api/v1/products/' + productId).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.loadProducts();
    // $scope.fillTable = function () {
    //     $http.get('http://localhost:8189/market/api/v1/products')
    //         .then(function (response) {
    //             $scope.products = response.data;
    //             // console.log(response);
    //         });
    // };
    //
    // $scope.deleteProduct = function (id) {
    //     $http.delete('http://localhost:8189/market/api/v1/products/' + id)
    //         .then(function (response) {
    //             $scope.fillTable();
    //         });
    // }
    //
    // $scope.createNewProduct = function () {
    //     // console.log($scope.newProduct);
    //     $http.post('http://localhost:8189/market/api/v1/products', $scope.newProduct)
    //         .then(function (response) {
    //             $scope.newProduct = null;
    //             $scope.fillTable();
    //         });
    // }
    //
    // $scope.fillTable();
});