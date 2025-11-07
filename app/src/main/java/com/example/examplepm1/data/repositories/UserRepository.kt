package com.example.examplepm1.data

import com.example.examplepm1.data.models.User


object UserRepository {

    // Lista de usuarios mockeados
    private val mockUsers = listOf(
        User(145L, "admin1", "password1."),
        User(532L, "admin2", "password2.")
    )

    // Inicializa 'users' con los datos de 'mockUsers'
    private val users = mockUsers.toMutableList()

    fun verifyUser(nickname: String, password: String): Boolean {
        val user = login(nickname, password)
        return user != null
    }

    fun login(nickName: String, password: String): User? {
        // Esta validación se puede simplificar.
        if (nickName.isEmpty() || password.isEmpty()) {
            return null
        }
        // Ahora 'users' contiene los datos y la búsqueda funcionará.
        return users.find { it.nickname == nickName && it.password == password }
    }
}