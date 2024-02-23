const { connectionPool } = require('./server.js')
process.env.NODE_ENV = 'test';
const chai = require('chai');
const expect = chai.expect;
const should = chai.should();

const chaiHttp = require('chai-http');
const server = require('server');
const mysql = require('mysql');

chai.use(chaiHttp);

describe('First Test Collection', () => {

    it('should test default API route', async function () {

        chai.request(server)
            .get('/cameras')
            .end((err, res) => {
                res.should.have.status(200);
            });

    });

    it("Should connect to database without an error", function (done) {
        connectionPool.getConnection(function (err, connection) {
            if (err) {
                done(err);
                return;
            }


            done();
        });
    });

});

