package com.example.adoptme.data

data class Dog(val name: String, val breed: String, val age: Int)
object DogSampleData {
    val dogs = listOf(
        Dog("Ronald", "Golden Retriever", 4),
        Dog("Elsa", "Golden Retriever", 7),
        Dog("Vitalia", "Bergamasco Shepherd", 2),
        Dog("Constantijn", "Dutch Sheepdog", 6),
        Dog("Giusy", "Bolognese", 3),
        Dog("Glanville", "Dalmatian", 8),
        Dog("Jessa", "Corgi", 7),
        Dog("Azzurra", "Hound", 2),
        Dog("Amarante", "French Poodle", 6),
        Dog("Pier", "Frisian Pointer", 3),
        Dog("Ora", "Corgi", 8),
        Dog("Ginger", "Corgi", 2),
        Dog("Rufus", "Saint Bernard", 5),
        Dog("Lila", "Bolognese", 6),
        Dog("Spencer", "Beagle", 3),
    )
}