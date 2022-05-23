import java.io.File
import java.io.FileWriter
import java.util.Scanner
// import scala.collection.mutable.ArrayBuffer
// import scala.util.Random
object MainFile{
    def main(args: Array[String]): Unit = {
        var sc = new Scanner(System.in)
        val jer = new JerGenerator
        val keren = new KerenGenerator
        val kolby = new KolbyGenerator
        val devene = new MyGenerator
        val jodi = new TailGenerator
       
        val file = new File("test.csv")
        val fw = new FileWriter(file)

        for (i <- 0 to 10000){
            var qty = jer.getQty()
            var price = jer.getPrice()
            var orderId = kolby.getOrderId()
            var custId = kolby.getCustomerId()
            var custName = kolby.getCustomerName()
            var productId = keren.getProductId(sc: Scanner)
            var productName = keren.getProductName(sc: Scanner)
            var productCat = keren.getProductCategory(sc: Scanner)
            var paymentType = jer.getPaymentType()
            var date = devene.getDateTimeList()
            var country = devene.getCountryList()
            var city = devene.getCityList()
            var webName = jodi.getEcommerceWebsiteName()
            var confirmId = jodi.getPaymentTxnId()
            var paymentSuccess = jodi.getPaymentTxnSuccess()
            var failureMessage = jodi.getFailureReason()
            
            if(paymentSuccess == "N"){
                fw.write(orderId + "," + custId + "," + custName + "," + productId + "," + productName + "," + productCat + "," + qty.toString + "," + price + "," + paymentType + "," + date + "," + country + "," + city + "," + webName + ", " + confirmId  + ", " + paymentSuccess + ", " + failureMessage + "\n")
            }else{
                fw.write(orderId + "," + custId + "," + custName + "," + productId + "," + productName + "," + productCat + "," + qty.toString + "," + price + "," + paymentType + "," + date + "," + country + "," + city + "," + webName + ", " + confirmId  + ", " + paymentSuccess + ", " + "\n")
            }

        }
        fw.close


       
    }
}