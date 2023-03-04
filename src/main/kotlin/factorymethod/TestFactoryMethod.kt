package factorymethod

fun main() {

    val productDAO= ProductDAO()
    val products = productDAO.findAllProducts()

    println("before save")

    products!!.forEach {  println(it.toString()) }

    //--- insert new product
    print("Introduzca el producto: ")

    val description = readln()
    print ("Introduzca el precio: ")
    val price =  readln().toDouble()

    val product= Product(id=0, description = description,price)
    productDAO.saveProduct(product)
    println("-------------------------------------")
    println(" ${product.description},  ${product.price}" )
}

