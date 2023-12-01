package com.gestionfondos.Model

data class UserData(
    val Id: String? = null,
    val Username: String? = null,
    val Correo: String? = null,
    var Password: String? = null){
    fun setId(id: String?): UserData {
        return this.copy(Id = id)
    }

    fun setUsername(username: String?): UserData {
        return this.copy(Username = username)
    }

    fun setCorreo(correo: String?): UserData {
        return this.copy(Correo = correo)
    }

    fun setPassword(password: String?): UserData {
        return this.copy(Password = password)
    }
}