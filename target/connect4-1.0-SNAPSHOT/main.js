//var matrix = [
//            [0,1,1,2,2,1,0],
//            [0,0,0,0,0,0,0],
//            [0,1,0,2,1,1,0],
//            [1,2,1,1,1,0,1],
//            [0,0,0,0,2,0,0],
//            [0,2,0,2,0,1,0],
//            [0,0,1,0,1,0,0],
//            [0,0,1,0,1,0,0],
//        ];

var globalData;
function addToken(column){
    $.ajax({
    url: 'http://localhost:8080/game/',
    type: 'PUT',
    data: 'column='+column, // or $('#myform').serializeArray()
    success: function(data) {  console.log('PUT completed');update(JSON.parse(data)); }
});
}

function forceInit(){
    $.ajax({
        url: 'http://localhost:8080/game/',
        type: 'GET',
        data: 'force=1',
        success: function(data) { console.log('GET completed'); update(JSON.parse(data)); }
    });
}

function init() {
    $.ajax({
        url: 'http://localhost:8080/game/',
        type: 'GET',
        success: function(data) { console.log('GET completed'); update(JSON.parse(data)); }
    });
}

function update(data) {
        var matrix = JSON.parse(data.matrix);
        globalData = data;
        document.getElementById("tbar").innerHTML = data.status;
        //body reference 
        var space = document.getElementById("space");
        if(space.childNodes.length > 2)
            space.removeChild(space.childNodes[2]);
        // create elements <table> and a <tbody>
        var tbl     = document.createElement("table");
        var tblBody = document.createElement("tbody");

        // cells creation
        for (var j = 0; j < 7; j++) {
            // table row creation
            var row = document.createElement("tr");

            for (var i = 0; i < 7; i++) {
                // create element <td> and text node 
                //Make text node the contents of <td> element
                // put <td> at end of the table row
             var cell = document.createElement("td");    
                var cellText = document.createTextNode("");
                cell.setAttribute("class", "cell");
//                console.log(j + " " + i);
                if(matrix[j][i] == 0){
                    cell.style.background = "blue";
                } else if (matrix[j][i] == 1){
                    cell.style.background = "red";
                } else {
                    cell.style.background = "yellow";
                }
                
                cell.appendChild(cellText);
                row.appendChild(cell);
            }

            //row added to end of table body
            tblBody.appendChild(row);
        }

        // append the <tbody> inside the <table>
        tbl.appendChild(tblBody);
        tbl.setAttribute("class", "table");
        // put <table> in the <body>
        space.appendChild(tbl);
        // tbl border attribute to 
        tbl.setAttribute("border", "2");
    }