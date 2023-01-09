import {Injectable} from "@angular/core";

var SockJs = require("sockjs-client");
var Stomp = require("stompjs");


@Injectable()
export class WebSocketService {

    constructor() { }

    connect() {
        let socket = new SockJs(`http://172.17.12.115:8080/socket`);

        let stompClient = Stomp.over(socket);

        return stompClient;
    }
}
