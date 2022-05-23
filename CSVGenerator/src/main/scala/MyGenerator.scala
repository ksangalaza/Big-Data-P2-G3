import scala.util.Random
import java.io.File
import java.io.FileWriter
import java.util.Scanner
import scala.collection.mutable.ArrayBuffer



object MyGenerator { 
    val cityCountryDatatime = new ArrayBuffer[String]()
    val f = new File("country.csv")
    val sc = new Scanner(f)   
   
val cityListArray = ArrayBuffer("New Orleans", "Brighton", "Gloucester", "Anchorage", "Butler","Ashland","Cook","San Jose","Sioux Falls","Baltimore","Kulpsville","Middle Island"
,"Los Angeles","Chagrin Falls","Laredo","Phoenix","Mc Minnville","Milwaukee","Taylor","Rockford","Aston","San Jose","Irving","Albany","Middlesex","Stevens Point"
,"Shawnee","Easton","New York","Conroe","Columbus","Las Cruces","Ridgefield Park","Dunellen","Metairie","Camarillo","San Antonio","Abilene","Prineville","Overland Park","Fairbanks"
,"Miami","Fairbanks","Hopkins","Boston","Los Angeles","Madison","Philadelphia","Tullahoma","Columbia","Wayne","Flemington","Westbury","Jenkintown","Van Nuys","Providence")

val countryListArray = ArrayBuffer("Albania","Amdorra","Argentina","Amenia","Austria","Bahama","Bahrain","Barbados","Brazil","Bulgaria","Cabo Verde","Cambodia","Canada","Central African Republic",
"Chad","Chile","China","Colombia","Comoros","Congo (Congo-Brazzaville)","Costa Rica","Croatia","Cuba","Cyprus","Czechia (Czech Republic)","Democratic Republic of the Congo",
"Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Fiji","Finland","France","Eswatini (fmr." +
  "Swaziland)","Gabon","Gambia","Georgia", "Germany","Ghana","Greece","Grenada","Guatemaia","Guinea","Guinea-Bissau","Guyana","Haiti","Holy See","Honduras","Hungary","Iceland")

val dateTimeListArray = ArrayBuffer("2013-01-18 19:15:45","2019-12-10 03:35:29","2020-07-15 05:43:54","2012-08-19 16:08:02","2019-11-04 08:20:47","2016-04-13 16:24:11","2016-03-08 15:20:10",
"2020-08-28 13:48:26","2016-12-04 10:14:50","2011-07-30 01:27:12","2013-08-22 13:51:54","2017-01-20 06:35:04","2010-05-25 13:12:05","2010-06-16 23:45:38","2014-11-16 18:53:54",
"2012-09-07 19:38:09","2011-04-29 23:25:43","2011-10-19 08:40:38","2012-06-21 13:27:42","2011-02-22 04:52:18","2014-09-21 15:00:31","2018-11-17 10:43:11","2020-04-23 16:22:38",
"2019-01-12 11:21:19","2015-09-02 07:29:03","2015-06-20 02:54:14","2014-06-25 08:46:32","2021-03-24 06:23:54","2011-07-21 04:18:12","2012-01-03 23:10:24","2019-01-09 19:15:12",
"2013-09-05 03:19:12","2016-08-20 01:13:45","2018-10-06 16:36:53","2020-10-26 23:23:17","2012-01-21 17:27:39","2015-12-06 07:21:04","2017-06-12 08:07:53","2019-07-07 16:29:25",
"2013-02-05 02:51:10","2010-07-19 02:53:54","2011-11-20 12:08:15","2016-07-12 19:43:13","2013-05-14 10:29:55","2020-02-27 18:43:44","2010-02-25 08:56:08","2014-10-21 08:29:42",
"2012-12-30 04:57:09","2021-03-19 07:13:19","2014-08-06 05:41:14")

def  getCityList(): String ={
    val city = new scala.util.Random
    val CityList = city.nextInt(50 - 0)

    // cityCountryDatatime.append(line)
           
   
    return cityListArray(CityList)
}//end city

def  getCountryList(): String ={
    val country = new scala.util.Random
    val CountryList = country.nextInt(50 - 0)
    
     

           // cityCountryDatatime.append(line)
               
    return countryListArray(CountryList)
}//end get country


def  getDateTimeList(): String ={
    val dateTime = new scala.util.Random
    val DateTimeList = dateTime.nextInt(50 - 0)
    

           // cityCountryDatatime.append(line)
           
    return dateTimeListArray(DateTimeList)
            
}// end date time List

 def main(arg:Array[String]): Unit = {
 
    println("Date: " + getDateTimeList())
    println("Country: " + getCountryList())
    println("City: " + getCityList())    
}//end def main

}//end object Generator
