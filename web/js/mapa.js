/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var divMap = document.getElementById('mapa');
navigator.geolocation.getCurrentPosition(fn_ok, fn_mal);
function fn_mal() {}
function fn_ok(rta) {
    var lat = rta.coords.latitude;
    var lon = rta.coords.longitude;

    var gLatLon = new google.maps.LatLng(lat, lon);
    var objConfig = {
        zoom: 17,
        center: gLatLon
    }

    var gMapa = new google.maps.Map(divMap, objConfig);
    var objConfigMarker = {
        position: gLatLon,
        map: gMapa,
        title: "Estacionamiento"
        
    }
    var gMarker = new google.maps.Marker(objConfigMarker);
    gMarker.setIcon('img/map-pin-gray-hi.png');
    
    var gCoder = new google.maps.Geocoder();//variable para codificar la direccion    
    var objInfo = {
        address: 'Luis Matte Larrain 1310,Puente Alto,Region Metropolitana' //direccion que quiero que se muestre
    }
    gCoder.geocode(objInfo, fn_coder);//funcion para transformar la direccion que estoy pasando
    
    
    function fn_coder(datos){
        var coordenadas = datos[0].geometry.location; //esto lo convierte en longitud y latitud
        
        var config = {//configuracion para el marker
            map: gMapa,
            position: coordenadas,
            title: 'Estacionamiento'
        }
        
        var gMarkerEs = new google.maps.Marker(config);//marker con la direccion entregada
        
    }
    
//    function initMapa(){
//        var myLatLong = {lat: -33.598214 , lng: -70.577627};
//        
//        var marker = new google.maps.Marker({
//            position: myLatLong,
//            map: gMapa,
//            title: 'hola'
//        });
//    }

}


