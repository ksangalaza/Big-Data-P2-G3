import scala.util.Random
import java.io.File
import java.util.Scanner
import scala.collection.mutable.ArrayBuffer

class KolbyGenerator {
    
    def getOrderId(): Int = {
        val OrderId = new scala.util.Random
        var getOrderId = OrderId.nextInt((1000 - 0) + 1)
        return getOrderId
    }

    def getCustomerId(): Int ={
        val CustomerId = new scala.util.Random
        var getCustomerId = CustomerId.nextInt((20000 - 10001) + 1)
        return getCustomerId
    }

    def getCustomerName(): String = {
        var customersArray = new ArrayBuffer[String]()
        val file = new File("CustomerNames.txt")
        var sc = new Scanner(file)
        var CustomerName = new scala.util.Random
        var getCustomerName = CustomerName.nextInt((9999 - 0) +1)
        while(sc.hasNext()){
            var line = sc.nextLine()
            if(line == " "){

            }else{
                customersArray.append(line)
            }
        }
        return customersArray(getCustomerName)
        
    }

   
    //  def main(args: Array[String]): Unit = {
    //      println("Order ID: " + getOrderId())
    //      println("Customer ID: " + getCustomerId())
    //      println("Customer Name: " + getCustomerName())
    // }
}
