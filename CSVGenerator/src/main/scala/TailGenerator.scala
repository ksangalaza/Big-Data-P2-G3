import java.io.File
import java.io.FileWriter
import java.util.Scanner
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class TailGenerator{

    // This is Site from where order was placed
    def getEcommerceWebsiteName(): String = {
        var websitesArray = new ArrayBuffer[String]()
        val file = new File("websites.txt")
        val sc = new Scanner(file)
        while (sc.hasNext()){
            var website = sc.nextLine()
            if(website == " "){

            }else{
                websitesArray.append(website)
            }
        }
        val rnd = new scala.util.Random
        var rndNum = rnd.nextInt( 200 ) 
        sc.close
        return websitesArray(rndNum)
        
    }

    // This is trasantion confirmation Id 
    def getPaymentTxnId(): Int = {
        val start = 30000
        val end   = 100000
        val rnd = new scala.util.Random
        var rndNum = start + rnd.nextInt( (end - start) + 1 )
        return rndNum
    }

    // This is the payment success or failure Y or N
    def getPaymentTxnSuccess(): String = {
        var txnSuccess = new ArrayBuffer[String]()
        txnSuccess.append("Y")
        txnSuccess.append("N")

        val rnd = new scala.util.Random
        var rndNum = rnd.nextInt(100)
        var makeDecimal: Double = rndNum.toDouble / 100.toDouble

        var yProb = 0.85
        var num = 0

        if (makeDecimal <= yProb){
            num = 0
        }else{
            num = 1
        }

        return txnSuccess(num)
    }

    // This is reason for payment failure
    def getFailureReason(): String = {
        var failureArray = new ArrayBuffer[String]()
        val file = new File("failureMessages.txt")
        val sc = new Scanner(file)
        while (sc.hasNext()){
            var failureMessage = sc.nextLine()
            if(failureMessage == " "){

            }else{
                failureArray.append(failureMessage)
            }
        }
        val rnd = new scala.util.Random
        var rndNum = rnd.nextInt(10) 
        sc.close
        return failureArray(rndNum)
    }

//     def main(args: Array[String]): Unit ={
//         val file = new File("test.csv")
//         val fw = new FileWriter(file)
//         for (i <- 0 to 99){
//             var webName = getEcommerceWebsiteName()
//             var confirmId = getPaymentTxnId()
//             var paymentSuccess = getPaymentTxnSuccess()
//             var failureMessage = getFailureReason()
//             if(paymentSuccess == "N"){
//                 fw.write(webName + ", " + confirmId  + ", " + paymentSuccess + ", " + failureMessage + "\n")
//             }else{
//                 fw.write(webName + ", " + confirmId + ", " + paymentSuccess + "\n")
//             }

//         }
//         fw.close

//     }



}