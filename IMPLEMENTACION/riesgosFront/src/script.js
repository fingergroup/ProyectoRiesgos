$("#myModal").draggable({
    handle: ".modal-header",
    cursor: 'move'
    });
    $("#myModal2").draggable({
    handle: ".modal-header",
    cursor: 'move'
    });
    $('.modal.draggable>.modal-dialog>.modal-content>.modal-header').css('cursor', 'move');
    
function myFunction() {
    alert( "Hola" );
}
