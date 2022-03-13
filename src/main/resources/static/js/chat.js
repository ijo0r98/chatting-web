const websocket = new WebSocket("ws://localhost:8080/ws/chat");
websocket.onmessage = onMessage;
// websocket.onopen = onOpen;
// websocket.onclose = onClose;

// 메시지 전송
function send() {
    let msg = document.getElementById("msgInput");
    console.log('msg: ' + msg.value);
    websocket.send(msg.value);
    msg.value = '';
}

// 메시지 수신
function onMessage(data) {
    let msg = data.data;
    console.log('data: ', msg);
    if(msg != null) {
        $('#chatTable').append($('<tr />').append($('<td />', {
            text: '아이디'
        })).append($('<td />', {
            text: msg
        })).append($('<td />', {
            text: '시간'
        })));
    }
}
//채팅창에서 나갔을 때
function onClose(evt) {
    let str = username + ": 님이 방을 나가셨습니다.";
    websocket.send(str);
}

//채팅창에 들어왔을 때
function onOpen(evt) {
    let str = username + ": 님이 입장하셨습니다.";
    websocket.send(str);
}