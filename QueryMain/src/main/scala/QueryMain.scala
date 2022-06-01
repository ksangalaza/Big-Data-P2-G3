import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame

object QueryMain{
    def main(args: Array[String]): Unit ={

        println("Hello")

        val spark = SparkSession
        .builder.appName("QueryMain")
        .config("spark.master", "local")
        .config("spark.eventLog.enabled", "false")
        .getOrCreate()
            
        spark.sparkContext.setLogLevel("WARN")

        val sales = spark.read.format("csv")
        .option("inferSchema","true")
        .option("header", "true")
        .load("./inputs/updatedFinal.csv")

        sales.createOrReplaceTempView("sales")

        val popularProducts = spark.read.format("csv")
        .option("inferSchema","true")
        .option("header", "true")
        .load("./inputs/popProduct.csv")

        popularProducts.createOrReplaceTempView("popularProducts")

        import spark.implicits._


        val topSellCat = topSellingCat(spark, sales)
        topSellCat.write.mode("overwrite").csv("outputs/topCategory")
        val countProd = countProduct(spark,sales)
        countProd.write.mode("overwrite").csv("outputs/popProduct")
        val successY = successYes(spark,sales)
        successY.write.mode("overwrite").csv("outputs/priceSales")
    }


    // topCategory csv
    def topSellingCat(spark: SparkSession, sales: DataFrame): DataFrame = {
       val topSelling = spark.sql("(SELECT COUNTRY, PRODUCT_CAT, TOP_SELLING_CAT FROM (SELECT COUNTRY, PRODUCT_CAT, MAX(CatCount) as TOP_SELLING_CAT, RANK() over (PARTITION BY COUNTRY order by MAX(CatCount))rank FROM (SELECT COUNTRY, PRODUCT_CAT, COUNT(PRODUCT_CAT) as CatCount FROM sales GROUP BY COUNTRY, PRODUCT_CAT ORDER BY CatCount)t1 GROUP BY COUNTRY, PRODUCT_CAT)t2 WHERE rank = 5)UNION(SELECT COUNTRY, PRODUCT_CAT, TOP_SELLING_CAT FROM (SELECT COUNTRY, PRODUCT_CAT, MAX(CatCount) as TOP_SELLING_CAT, RANK() over (PARTITION BY COUNTRY order by MAX(CatCount))rank FROM (SELECT COUNTRY, PRODUCT_CAT, COUNT(PRODUCT_CAT) as CatCount FROM sales GROUP BY COUNTRY, PRODUCT_CAT ORDER BY CatCount)t1 GROUP BY COUNTRY, PRODUCT_CAT)t2 WHERE rank = 4 AND COUNTRY = 'China');")
       return topSelling
    }

    // popProduct csv
    def countProduct(spark: SparkSession, sales: DataFrame): DataFrame = {
        val countProd = spark.sql("SELECT PRODUCT_NAME,pcount,PRODUCT_CAT,COUNTRY, DATETIME FROM(SELECT PRODUCT_NAME ,COUNT(PRODUCT_NAME) as pcount,PRODUCT_CAT ,COUNTRY, DATETIME, RANK() over(PARTITION BY DATETIME,COUNTRY, PRODUCT_NAME order by COUNT(PRODUCT_NAME))rank FROM sales GROUP BY COUNTRY, PRODUCT_NAME, DATETIME, PRODUCT_CAT)t1 WHERE rank = 1;")
        return countProd
    }

    // priceSales csv
    def successYes(spark: SparkSession, sales: DataFrame): DataFrame = {
        val successY = spark.sql("SELECT COUNTRY, CITY, (QTY * PRICE) AS SALES, DATETIME FROM sales WHERE PAYMENT_SUCCESS= 'Y';")
        return successY
    }

}