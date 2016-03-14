$(document).ready(function() {
    $("#refreshBtn").click(function(){
        $('#example').DataTable().ajax.reload();
    }); 
});