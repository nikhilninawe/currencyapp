$(document).ready(function() {
    $("#refreshBtn").click(function(){
        $('#example').DataTable().ajax.reload();
    }); 
    
    $("#converter").click(function(){
    	$("#converter").addClass("active");
    	$("#list").removeClass("active");

    }); 
    
    $("#list").click(function(){
    	$("#list").addClass("active");
    	$("#converter").removeClass("active");

    }); 
    
    $("#submitBtn").click(function(){
    	var fromCode = $("#fromCode").val().toUpperCase();
    	var toCode = $("#toCode").val().toUpperCase();
    	var fromAmount = $("#fromAmount").val();
    	$.ajax({url: "convert?fromCode=" + fromCode + "&toCode=" + toCode + "&fromAmount=" + fromAmount, success: function(result){
            $("#result").html(result);
        }});
    	
    }); 
    
});