function contarVogais(){
    const palavra = document.getElementById('palavra').value;
    const vogais = "aeiouAEIOU";
    let contar = 0

    for(var i = 0 ; i = palavra.length ; i++){
        if(vogais.includes(palavra[i])){
            contar++;
                    }
    }
    document.getElementById('mostrar').innerText = `Número de vogais: ${contar}`;
}