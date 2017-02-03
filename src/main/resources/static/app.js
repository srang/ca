var stompClient = null;

function setConnected(connected) {
    if (connected) {
        $("#board").show();
    }
    else {
        $("#board").hide();
    }
    $("#cells").html("");
}

function connect() {
    var socket = new SockJS('/cell-auto-socket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/cells', function (canvas) {
            showCell(JSON.parse(canvas.body));
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

// function reset() {
//     disconnect();
//     connect();
// }

function startSimulation() {
    stompClient.send("/app/simulate", {}, JSON.stringify({
        'simulation': $("#name").val(),
        'width': $("#grid-w-slider").val(),
        'height': $("#grid-h-slider").val()
    }));
}

function showCell(canvas) {
    $("#cells").html(render(canvas))
}

function render(canvas) {
    /* todo make this better */
    var text = "";
    var cells = canvas.cells;
    cells.forEach(function (row) {
        text += "<tr>";
        row.forEach(function (cell) {
            text += '<td class="col-md-1 cell-content">' + canvas.cells[0][0].value + '</td>';
        });
        text += "</tr>";

    });
    return text;
}

$(function () {
    connect();
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#reset" ).click(function() { reset(); });
    $( "#start" ).click(function() { startSimulation(); });
    $('#grid-h-slider').slider({
        formatter: function(value) {
            return value + " cells";
        }
    });
    $('#grid-w-slider').slider({
        formatter: function(value) {
            return value + " cells";
        }
    });
});

