public class task1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        System.out.print("Круговой массив ");
        for (int i = 1; i < n + 1; i++) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("При длине обхода " + m);
        CircularArray circArr = new CircularArray(n);
        circArr.FindPath(m);
    }

    static class CircularArray {
        private int SizeOfArray;

        public CircularArray(int SizeArray) {
            this.SizeOfArray = SizeArray;
        }

        public void FindPath(int lengthPath) {
            int firstElement = 1;
            System.out.print("Полученный путь: ");
            do {
                System.out.print(firstElement);
                firstElement = firstElement + (lengthPath - 1);
                while (firstElement > SizeOfArray)  // в случае, если размер массива много меньше длины обхода
                    firstElement = firstElement - SizeOfArray;
            } while (firstElement != 1);
            System.out.println();
        }
    }
}