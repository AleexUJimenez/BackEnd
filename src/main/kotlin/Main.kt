import factorymethod.IDBAdapter
import factorymethod.MySqlDBAdapter
import factorymethod.OracleDBAdapter
import properties.PropertiesUtil
import java.util.*

fun main() {
    /*
        val property: Properties? = PropertiesUtil
            .loadProperty("properties/DBMySQL")
        println(property)
        val mySql: IDBAdapter = MySqlDBAdapter()
        println(mySql.getConnection().toString())

        val oracle: IDBAdapter = OracleDBAdapter()
        println(oracle.getConnection().toString())

    */
    val projects = listOf(
        "Command",
        "Chain of Responsability")

    println(projects[Random().nextInt(0,projects.size-1)])
}


