'use strict';

angular.module('crudApp').controller('BookController',
    ['BookService', '$scope',  function( BookService) {

        var self = this;
        self.book = {};
        self.books=[];

        self.getAllBooks = getAllBooks;
        self.updateBook = updateBook;
        self.rentBook = rentBook;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.showAll = true;
        self.showAvailable = false;
        self.showRented = false;

        self.all = all;
        self.available = available;
        self.rented = rented;

        function all(){
            self.showAll = true;
            self.showAvailable = false;
            self.showRented = false;
        }

        function available(){
            self.showAll = false;
            self.showAvailable = true;
            self.showRented = false;
        }

        function rented(){
            self.showAll = false;
            self.showAvailable = false;
            self.showRented = true;
        }

        function updateBook(book, id){
            console.log('About to update book');
            BookService.updateBook(book, id)
                .then(
                    function (response){
                        console.log('Book updated successfully');
                        self.successMessage='Book updated successfully';
                        self.errorMessage='';
                        self.done = true;
                    },
                    function(errResponse){
                        console.error('Error while updating Book');
                        self.errorMessage='Error while updating Book '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }

        function getAllBooks(){
            return BookService.getAllBooks();
        }

        function rentBook(book) {
            self.successMessage='';
            self.errorMessage='';
            var comment = book.comment;
            BookService.getBook(book.id).then(
                function (book) {
                    book.rentedout = !book.rentedout;
                    if (book.rentedout) {
                        book.comment = comment;
                    } else {
                        book.comment = "";
                    }
                    updateBook(book, book.id);
                },
                function (errResponse) {
                    console.error('Error while renting book ' + book.id + ', Error :' + errResponse.data);
                }
            );
        }

    }


    ]);