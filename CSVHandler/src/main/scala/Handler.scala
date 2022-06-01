import java.io.File
import java.io.FileWriter
import java.util.Scanner

object Handler{

    def csvFixer(): Unit = {

        val file1 = new File("team1.csv")
        val sc = new Scanner(file1)

        val file3 = new File("updatedFinal.csv")
        val fw2 = new FileWriter(file3)

        while (sc.hasNext()){
            var line = sc.nextLine()
            if(line == " "){

            }else{
                val arrLine = line.split(",").map(_.trim)
                
                if(arrLine(5) == ""){
                    fw2.write(arrLine(0) + "," + arrLine(1) + "," + arrLine(2) + "," + arrLine(3) + "," + arrLine(4) + "," + "Undefined" + "," + arrLine(6) + "," + arrLine(7) + "," + arrLine(8) + "," + arrLine(9) + "," + arrLine(10) + "," + arrLine(11) + "," 
                    + arrLine(12) + "," + arrLine(13) + "," + arrLine(14) + "," + arrLine(15) + "\n")
                }
                else if(arrLine(11) == ""){
                    fw2.write(arrLine(0) + "," + arrLine(1) + "," + arrLine(2) + "," + arrLine(3) + "," + arrLine(4) + "," + arrLine(5) + "," + arrLine(6) + "," + arrLine(7) + "," + arrLine(8) + "," + arrLine(9) + "," + arrLine(10) + "," + "Undefined" + "," 
                    + arrLine(12) + "," + arrLine(13) + "," + arrLine(14) + "," + arrLine(15) + "\n")
                }
                else{
                    fw2.write(arrLine(0) + "," + arrLine(1) + "," + arrLine(2) + "," + arrLine(3) + "," + arrLine(4) + "," + arrLine(5) + "," + arrLine(6) + "," + arrLine(7) + "," + arrLine(8) + "," + arrLine(9) + "," + arrLine(10) + "," + arrLine(11) + "," 
                    + arrLine(12) + "," + arrLine(13) + "," + arrLine(14) + "," + arrLine(15) + "\n")
                }
            }
        }
        sc.close()
        file3.close()

    }

    def main(args: Array[String]): Unit ={
        csvFixer()
    }
}