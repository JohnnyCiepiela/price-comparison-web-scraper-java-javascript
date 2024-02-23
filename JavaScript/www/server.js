//Import the express and url modules
var express = require('express');
var url = require("url");

//Status codes defined in external file
require('./http_status.js');

//The express module is a function. When it is executed it returns an app object
var app = express();

//Import the mysql module
var mysql = require('mysql');

//Create a connection object with the user details
var connectionPool = mysql.createPool({
    connectionLimit: 1,
    host: "localhost",
    user: "root",
    password: "",
    database: "mywebsite",
    debug: false
});

module.exports = { connectionPool };

//Set up the application to handle GET requests sent to the user path
app.get('/cameras/*', handleGetRequest);//Subfolders
app.get('/cameras', handleGetRequest);

//Serve up static pages from public folder
app.use(express.static('public'));

//Start the app listening on port 8080
app.listen(8080);
console.log("App listening on port 8080")


/* Handles GET requests sent to web service.
   Processes path and query string and calls appropriate functions to
   return the data. */
function handleGetRequest(request, response) {
    //Parse the URL
    var urlObj = url.parse(request.url, true);

    //Extract object containing queries from URL object.
    var queries = urlObj.query;

    //Get the pagination properties if they have been set. Will be  undefined if not set.
    var numItems = queries['num_items'];
    var offset = queries['offset'];

    //Split the path of the request into its components
    var pathArray = urlObj.pathname.split("/");

    //Get the last part of the path
    var pathEnd = pathArray[pathArray.length - 1];


    if (pathEnd === 'cameras') {
        getTotalCamerasCount(response, numItems, offset);
        return;
    }
    if (pathEnd === '' && pathArray[pathArray.length - 2] === 'cameras') {
        getTotalCamerasCount(response, numItems, offset);
        return;
    }

    //If the last part of the path is a valid user id, return data about that user
    var regEx = new RegExp('^[0-9]+$');//RegEx returns true if string is all digits.
    if (regEx.test(pathEnd)) {
        getCameras(response, pathEnd);
        return;
    }

    //The path is not recognized. Return an error message
    response.status(HTTP_STATUS.NOT_FOUND);
    response.send("{error: 'Path not recognized', url: " + request.url + "}");
}


/** Returns all of the cereals, possibly with a limit on the total number of items returned and the offset (to
 *  enable pagination). This function should be called in the callback of getTotalCerealsCount  */
function getAllCameras(response, totNumItems, numItems, offset) {

    var sql = "SELECT * FROM cameras";

    //Limit the number of results returned, if this has been specified in the query string
    if (numItems !== undefined && offset !== undefined) {
        sql += "LIMIT " + numItems + " OFFSET " + offset;
    }

    //Execute the query
    connectionPool.query(sql, function (err, result) {

        //Check for errors
        if (err) {
            //Not an ideal error code, but we don't know what has gone wrong.
            response.status(HTTP_STATUS.INTERNAL_SERVER_ERROR);
            response.json({ 'error': true, 'message': + err });
            return;
        }

        //Create JavaScript object that combines total number of items with data
        var returnObj = { totNumItems: totNumItems };
        returnObj.cameras = result; //Array of data from database

        //Return results in JSON format
        response.json(returnObj);
    });
}


/** When retrieving all cereals we start by retrieving the total number of cereals
    The database callback function will then call the function to get the cereal data
    with pagination */
function getTotalCamerasCount(response, numItems, offset) {
    var sql = "SELECT COUNT(*) FROM cameras";

    //Execute the query and call the anonymous callback function.
    connectionPool.query(sql, function (err, result) {

        //Check for errors
        if (err) {
            //Not an ideal error code, but we don't know what has gone wrong.
            response.status(HTTP_STATUS.INTERNAL_SERVER_ERROR);
            response.json({ 'error': true, 'message': + err });
            return;
        }

        //Get the total number of items from the result
        var totNumItems = result[0]['COUNT(*)'];

        getAllCameras(response, totNumItems, numItems, offset);
    });
}
function getCameras(response, id) {


    var sql = "SELECT * " +
        "FROM cameras " + "WHERE cameras.id=" + id;

    //Execute the query
    connectionPool.query(sql, function (err, result) {

        //Check for errors
        if (err) {

            response.status(HTTP_STATUS.INTERNAL_SERVER_ERROR);
            response.json({ 'error': true, 'message': + err });
            return;
        }

        //Output results in JSON format
        response.json(result);
    });
}
