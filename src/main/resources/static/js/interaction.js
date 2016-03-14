$(document).ready(function() {
	$("#refreshBtn").click(function(){
		$('#example').DataTable().clear().draw();
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

	$('#form').on('submit', function (e) {
		if (e.isDefaultPrevented()) {
		}
		else {
			if($("#submitBtn").hasClass("disabled")){
				return;
			}
			console.log("Here2");
			var fromCode = $("#fromCode").val().toUpperCase();
			var toCode = $("#toCode").val().toUpperCase();
			var fromAmount = $("#fromAmount").val();
			$("#result").html("");
			$.ajax({url: "convert?fromCode=" + fromCode + "&toCode=" + toCode + "&fromAmount=" + fromAmount, 
				success: function(result){
					$("#result").html(result);
				}});
		}
		e.preventDefault();
	});
});