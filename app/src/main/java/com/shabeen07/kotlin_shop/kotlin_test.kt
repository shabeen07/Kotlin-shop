package com.shabeen07.kotlin_shop


fun main() {

    val integers = arrayOf(1, 2, 3, 4, 5, 6, 1, 2, 5, 6)
    println(integers.toSet())

    val nonDuplicates = mutableListOf<Int>()
    val duplicates = mutableListOf<Int>()

    println(integers.fold(0){a ,b -> a+ b})

    for (number in integers) {
        if (nonDuplicates.contains(number)) {
            nonDuplicates.remove(number)
            duplicates.add(number)
        } else {
            nonDuplicates.add(number)
        }
    }
    println(nonDuplicates.toString())
    println(duplicates.toString())

    val vehicle : Vehicle = Bike("Yamaha")
    vehicle.fuelType()
}

abstract class Vehicle(
    private val name: String
) {

    abstract fun wheels()

    open fun fuelType() {
        println("unknown")
    }
}

class Bike(private val bikeName: String) : Vehicle(bikeName) {
    override fun wheels() {

    }

    override fun fuelType(){
       println("Petrol")
    }

}