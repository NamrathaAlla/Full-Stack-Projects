const express = require('express');
const socket = require('socket.io');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();
/*
app.use(cors({ options: process.env.CORS_OPTIONS }));
app.use(bodyParser);
*/

let x = true;

const server = app.listen(3000,() => {
    console.log('Started in 3000');

    var host = server.address().address
    var port = server.address().port
    console.log("Example app listening at http://%s:%s", host, port)
});

const io = socket(server);

app.get('/listUsers', function (req, res) {
    //fs.readFile( __dirname + "/" + "users.json", 'utf8', function (err, data) {
       console.log( "Get Users" );
       res.end( "Get Users" );
   // });
 })
 



io.sockets.on('connection', (socket) => {
    console.log(`new connection id: ${socket.id}`);
    sendData(socket);
})

function sendData(socket){
    
    if(x){
        socket.emit('data1', Array.from({length: 8}, () => Math.floor(Math.random() * 590)+ 10));
        x = !x;
    }else{
        socket.emit('data2', Array.from({length: 8}, () => Math.floor(Math.random() * 590)+ 10));
        x = !x;
    }
    // console.log(`data is ${x}`);
    setTimeout(() => {
        sendData(socket);
    }, 100);
}