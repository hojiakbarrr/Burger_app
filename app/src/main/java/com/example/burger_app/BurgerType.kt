package com.example.burger_app

import java.io.Serializable

class BurgerType (

    var imageId: Int = 0,
    var description: String = "",
    var name: String = "",
    var cena: Int = 0,
    var cateogry: Int = 0,
    var plus: Int = 0,
    var isSelected: Boolean = false


) : Serializable