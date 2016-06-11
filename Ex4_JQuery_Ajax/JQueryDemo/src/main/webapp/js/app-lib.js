get_types();

$('.type').change(function() {
	show_quote();
})  
.change();

function get_types(){

    $.ajax(
            {
                type: "GET",
                url: "/quotes/types",
                success: function(response){
                   console.log( 'get_types - .ajax response : ' + response );
                   $.each(response, function(i, item) {
                        console.log('get_types - .ajax type : ' + item);
                        $('.type').append($('<option>', { 
                            value: item,
                            text : item 
                        }));
                    });

                    $('.type').val($('.type option:first').val());
                    show_quote();
                },
                error: function(response) {
                    console.log( 'show_quote - .ajax error text : ' + response.responseText);
                    console.log( 'show_quote - .ajax error status : ' + response.status);
                }
            }

    );

}

function show_quote(){
	
	var current_type = $('.type').val();
    console.log( 'show_quote - current type : ' + current_type );
    
    if( current_type == null ){
        return;
    }

    var rest_url = "/quotes/" + current_type;
    console.log( 'show_quote - rest_url : ' + rest_url );
    
    $.ajax(
            {
                type: "GET",
                url: rest_url, 
                contentType: "text/html",
                success: function(response){
            	   console.log( 'show_quote - .ajax response : ' + response );
                    $('.quote').html(response);
                },
                error: function(response) {
                    console.log( 'show_quote - .ajax error text : ' + response.responseText);
                    console.log( 'show_quote - .ajax error status : ' + response.status);
                }
            }
    );
    
}