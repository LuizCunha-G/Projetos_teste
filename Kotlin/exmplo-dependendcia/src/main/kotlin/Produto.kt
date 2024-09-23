package org.example

class Produto {

    var texto: String = ""
        set(value) {
            if (value.length >= 4) {
                field = value
            }
            else {
                field = "N/D"
            }
        }
    var preco : Double = 0.0
        set(value) {
            if (brinde){
                field = 0.01
            }
            else if(value > 0){
                field = value
            }
        }


    var brinde : Boolean = false
        set(value) {
            field = value
            if (brinde == true){
                preco += 0.01
            }
        }




}