function formatMoney(money){

    return new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(money)
    // var x = 0;
    // x = money.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
    // return x;
}

function formatTenSanPham(name){
    if (name.length > 35){
        return name.substr(0,35)+"...";
    }else{
        return name;
    }

}