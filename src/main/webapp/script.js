function check(e){
    var allInputs = e.getElementsByTagName('input');
    for (var i = 0; i < allInputs.length; i++) {
        var input = allInputs[i];

        if (input.name && !input.value) {
            console.log(input.name);
            input.name = '';
        }
    }
}

function hide(){
    var e = document.getElementById("nom_soc");

    e.innerHTML = '';
}