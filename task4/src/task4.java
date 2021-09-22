import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class task4 {

    public static void main(String[] args) {
        String path = args[0];

        //File file = new File(path);

        ArrayList<Double> list = new ArrayList<>();
        try (Scanner scan = new Scanner(readUsingFileReaderTest(path))) {
            while (scan.hasNextDouble()) {
                list.add(scan.nextDouble());
            }}
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        Double[] nums = list.toArray(new Double[0]);

        int count = 0;
        double m = Math.round(getSum(nums) / nums.length);
        Double[] result_digit = new Double[nums.length];
        System.arraycopy(nums, 0, result_digit, 0, nums.length);

        for (int ip = 0; ip < nums.length; ip++) {
            result_digit[ip] = Math.abs(nums[ip] - m);
            double f = getSum(result_digit);
        }
        System.out.println(getSum(result_digit));
    }

    public static Double getMax(Double[] inputArray) {
        Double maxValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maxValue) {
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

    public static Double getSum(Double[] inputArray) {
        double sum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            sum = sum + inputArray[i];
        }
        //System.out.println(sum);
        return sum;
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
}
