# Marketing Department Data Analysis

A Spark application. This application will take in a generated CSV file of mock e-commerce data and will answer a series of analytical questions. 
The processing of data uses Spark SQL. Git and GitHub are used for version control management.


# Technologies Used

**Scala**
>All code is written in Scala via VSCode and Spark-SQL

**SparkSQL**
>Connected to Hive, using HQL
>Connected to HDF as the file maintenance program.
>
**R**
>Program where some visualizations were created.

**Excel**
>Program where some visualizations were created.

**Git/GitHub**
>Repository where files and process for this project is saved

# Features

 - Initial CSV to share with the next group was generated in VSCode and written in Scala
 - Scala Random library used
 - CSV handler to deal with rogue data.
 
**To-do list**
>- Learn about various visualization tools
>- Find ways to optimize queries
>- Developing additional marketing data analysis questions.

# Getting Started

linux:
>git clone https://github.com/ksangalaza/Big-Data-P2-G3.git
git pull 
![Clone Repository](https://ucarecdn.com/b567338f-1f60-490c-b282-418dc21d02cf/ScreenShot20220601at112023AM.png)


VS Code: 
>Download Visual Studio Code and install the Scala extension.
>
>Load the individual generators and their corresponding CSV files.


>Install Spark on your machine.

# Usage

VSCode
>Run the main file in the Terminal.
>![Main File](https://ucarecdn.com/0c84cf2a-322d-442e-ad78-2245c50f353d/ScreenShot20220601at115850AM.png)
>generate random data- 10,000 records
>![CSV](https://ucarecdn.com/60bcd7c2-7d3c-4af7-9fc1-e3ff6f43dedb/ScreenShot20220601at115820AM.png)

Start ssh Localhost
Start HDFS Servers
![enter image description here](https://ucarecdn.com/a0ee2163-6137-4f79-81b8-73fef82f9ee4/ScreenShot20220601at125037PM.png)
>
Enter Spark-Shell REPL 
>Run Queries to produce CSV Files
>**Query 1**
>>spark.sql("(SELECT COUNTRY, PRODUCT_CAT, TOP_SELLING_CAT FROM (SELECT COUNTRY, PRODUCT_CAT, MAX(CatCount) as TOP_SELLING_CAT, RANK() over (PARTITION BY COUNTRY order by MAX(CatCount))rank FROM (SELECT COUNTRY, PRODUCT_CAT, COUNT(PRODUCT_CAT) as CatCount FROM sales GROUP BY COUNTRY, PRODUCT_CAT ORDER BY CatCount)t1 GROUP BY COUNTRY, PRODUCT_CAT)t2 WHERE rank = 5)UNION(SELECT COUNTRY, PRODUCT_CAT, TOP_SELLING_CAT FROM (SELECT COUNTRY, PRODUCT_CAT, MAX(CatCount) as TOP_SELLING_CAT, RANK() over (PARTITION BY COUNTRY order by MAX(CatCount))rank FROM (SELECT COUNTRY, PRODUCT_CAT, COUNT(PRODUCT_CAT) as CatCount FROM sales GROUP BY COUNTRY, PRODUCT_CAT ORDER BY CatCount)t1 GROUP BY COUNTRY, PRODUCT_CAT)t2 WHERE rank = 4 AND COUNTRY = 'China');").show
>
>**Query 2**
>>def countProduct(spark: SparkSession, sales: DataFrame): DataFrame = {
        val countProd = spark.sql("SELECT PRODUCT_NAME,pcount,PRODUCT_CAT,COUNTRY, DATETIME FROM(SELECT PRODUCT_NAME ,COUNT(PRODUCT_NAME) as pcount,PRODUCT_CAT ,COUNTRY, DATETIME, RANK() over(PARTITION BY DATETIME,COUNTRY, PRODUCT_NAME order by COUNT(PRODUCT_NAME))rank FROM sales GROUP BY COUNTRY, PRODUCT_NAME, DATETIME, PRODUCT_CAT)t1 WHERE rank = 1;")
>
>**Query 3/4**
>>def successYes(spark: SparkSession, sales: DataFrame): DataFrame = {
        val successY = spark.sql("SELECT COUNTRY, CITY, (QTY * PRICE) AS SALES, DATETIME FROM sales WHERE PAYMENT_SUCCESS= 'Y';")
        return successY

Analyze data of CSV files with any data visualization tool you are comfortable with. 
![Excel](https://ucarecdn.com/6a7348fe-5060-4039-b6f3-4fc677a7ed29/excel.04c2c03d589d445ab619e8955041db36)

![R Studio](https://ucarecdn.com/08129904-899e-484d-99fb-197df7293ea8/R.png)
# Contributors
>Devene Gayle
>Kolby Lingerfelt
>Jodi Mitchell
>Keren Sangalaza
>Jerry Scott


