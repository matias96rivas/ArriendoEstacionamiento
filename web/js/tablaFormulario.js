/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function mostrarA(){
    document.getElementById('auto').style.display = 'block',
    document.getElementById('estacionamiento').style.display = 'none';
}

function mostrarE(){
    document.getElementById('estacionamiento').style.display = 'block',
    document.getElementById('auto').style.display = 'none';
}

function ocultar(){
document.getElementById('auto').style.display = 'none',
document.getElementById('estacionamiento').style.display = 'none';
}
