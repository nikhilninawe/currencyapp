$(document).ready(function () {
    $('#example').DataTable({
    	"ajax": { 
    		"url" : "/latest",
            "dataSrc": ""
    	},
    	"columns": [
    	            { "data": "name" },
    	            { "data": "code" },
    	            { "data": "rate" },
    	        ]
    });   

});