package br.com.luizgustavo.models

class User {

    var name: String = ""
        set(value){
            field = value.uppercase()
        }
        get(){
            println("Buscando no get")
            return field
        }
    var age: Int = 20

    //fun setName(name: String){
      //  this.name = name
   // }

    //fun getName() = name

}