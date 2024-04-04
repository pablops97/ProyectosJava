/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// Obtener el enlace
var linkDesconectar = document.getElementById("desconectarLink");

linkDesconectar.addEventListener("click", function (event) {
    // Prevenir el comportamiento predeterminado del enlace (navegación)
    event.preventDefault();

    // Mostrar un mensaje de confirmación
    var confirmacion = confirm("¿Estás seguro de que deseas desconectar?");

    // Si el usuario confirma
    if (confirmacion) {
        // Redireccionar al index
        window.location.href = "ServletDesconexion";
    } else {
        // Si el usuario cancela, no hacer nada
    }
});