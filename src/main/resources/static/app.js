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

function propagate() {
    stompClient.send("/app/propagate", {}, JSON.stringify({}));
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
        'simulation': $("#simulation").val(),
        'height': $("#grid-h-slider").val(),
        'width': $("#grid-w-slider").val()
    }));
}

function showCell(canvas) {
    $("#cells").html(render(canvas))
}

function render(canvas) {
    /* todo make this better */
    var text = "";
    var cells = canvas.cells;
    cells.forEach(function (row, h) {
        text += "<tr>";
        row.forEach(function (cell, w) {
            text += '<td class="col-md-1 cell-content">' + canvas.cells[h][w].value + '</td>';
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
    $("#propagate").click(function () { propagate(); });
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

