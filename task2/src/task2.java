
import java.io.*;
import java.util.Scanner;

public class task2 {


    public static void main(String[] args) throws Exception {
        String filePath1 = args[0];
        String filePath2 = args[1];
        Circle o1 = new Circle(filePath1);

        Scanner scan2 = new Scanner(task2.readUsingFileReaderTest(filePath2));
        while (scan2.hasNextDouble()) {
            double a2 = scan2.nextDouble();
            Double b2 = scan2.nextDouble();
            if ((a2 - o1.x) * (a2 - o1.x) + (b2 - o1.y) * (b2 - o1.y) == o1.r * o1.r) {
                System.out.println("0");
            } else if ((a2 - o1.x) * (a2 - o1.x) + (b2 - o1.y) * (b2 - o1.y) < o1.r * o1.r) {
                System.out.println("1");
            } else {
                System.out.println("2");
            }
        }
        scan2.close();
    }

    public static String readUsingFileReaderTest(String path) {
        String filestr = "";
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                //обрабатываем считанную строку - пишем ее в консоль
                //curDir = curDir + line + "\n";
                filestr = filestr + line + "\n";
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filestr;
    }

    static class Circle {
        String filePath;

        Scanner scan;

        double x;
        double y;
        double r;


        Circle(String path) throws IOException {
            filePath = path;
            scan = new Scanner(task2.readUsingFileReaderTest(filePath));
            x = scan.nextDouble();
            y = scan.nextDouble();
            r = scan.nextDouble();
        }
    }
}


