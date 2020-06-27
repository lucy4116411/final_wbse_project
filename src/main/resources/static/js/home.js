function initMap() {
    var locate_latlng = {lat: 25.0168028, lng: 121.545724}; // 協會的經緯度
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 14, //放大的倍率
        center: locate_latlng //初始化的地圖中心位置
    });
    var marker = new google.maps.Marker({
        position: locate_latlng,
        map: map,
        title: "知青協會"
    });
    var infoWindow = new google.maps.InfoWindow({
        content: "協會辦公室，我只是不知道要標甚麼嘿嘿嘿"
    })
    marker.addListener('click', function () {
        infoWindow.open(map, marker);
    });
}