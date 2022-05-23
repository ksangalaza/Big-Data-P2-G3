import scala.util.Random

object jerGenerator{ 

     def getPaymentType(): String ={
        val paymentArray = Array("Wallet", "Internet Banking", "UPI", "Card")
        var getPaymentType = Random.shuffle(paymentArray.toList).head
        return getPaymentType
    }

    def getQty(): Int = {
        val Qty = new scala.util.Random
        var getQty = Random.nextInt(500)
        return getQty
    } 

    def getPrice(): Int ={
        val Price = new scala.util.Random
        var getPrice = Price.nextInt(50000)
        return getPrice
    }

   


       


   
    

    def main(args: Array[String]): Unit = {
        println(getPaymentType)
        println(getPrice())
        println(getQty)

       
    }




   

  }
  
