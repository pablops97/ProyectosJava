/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validarIdentificador() {
const campoNombre = document.querySelector("input");

campoNombre.addEventListener("input", () => {
  campoNombre.setCustomValidity("");
  campoNombre.checkValidity();
  console.log(campoNombre.checkValidity());
});

campoNombre.addEventListener("invalid", () => {
  campoNombre.setCustomValidity("Por favor, ingrese su nombre.");
});

        
}

