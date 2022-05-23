import java.io.File
import java.io.FileWriter
import java.io.File.separator
import java.util.Scanner
import scala.util.Random
import scala.io.Source
import scala.collection.mutable.ArrayBuffer


object KerenGenerator{
     def main(args:Array[String]): Unit = {
     var in = new File("ProductIdNameCategory.csv") 
     var sc = new Scanner(in)
    //  var out = new File("output.csv")
    //  var fw = new FileWriter(out, true)

     var line = sc.nextLine()
     println("Product Name: " + getProductName(sc)) 
     println("Product ID: " + getProductId(sc))
     println("Product Category: " + getProductCategory(sc))

     

        }
    def getProductId(sc: Scanner): Int = {
        val ProductIDArray = new ArrayBuffer[Int]()
        val randID = new Random() 
        var getProductId = randID.nextInt(100)
            val file = io.Source.fromFile("ProductIdNameCategory.csv")
            for (line <- file.getLines) {
            
                    val cols = line.split(",").map(_.trim)
                    ProductIDArray.append(cols(0).toInt)
                    
                
            }
            
        
        return ProductIDArray(getProductId)

    }
    def getProductName(sc: Scanner): String = {
        val ProductNameArray = new ArrayBuffer[String]()
        val randName = new Random()
        var getProductName = randName.nextInt(100)

            val file = io.Source.fromFile("ProductIdNameCategory.csv")
            for (line <- file.getLines) {
                val cols = line.split(",").map(_.trim)
                ProductNameArray.append(cols(1))
               
            
            }
        return ProductNameArray(getProductName)
    }
        
    
    def getProductCategory(sc: Scanner): String = {
        val ProductCategoryArray = new ArrayBuffer[String]()
        val randCat = new Random()
        var getProductCategory = randCat.nextInt(100)

            val file = io.Source.fromFile("ProductIdNameCategory.csv")
            for (line <- file.getLines) {
                val cols = line.split(",").map(_.trim)
                ProductCategoryArray.append(cols(2))
                

            }
        
        return ProductCategoryArray(getProductCategory)
    }


}