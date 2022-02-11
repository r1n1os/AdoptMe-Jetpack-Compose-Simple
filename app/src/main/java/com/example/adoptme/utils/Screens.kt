package com.example.adoptme.utils

sealed class Screens(val route: String) {
    object HomeScreen: Screens("home_screen")
    object DetailsScreen: Screens("details_screen")

    fun withArgs(vararg args: String) : String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
