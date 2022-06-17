package Lesson2;

public class Main {
    public static void main(String[] args) {

        String[][] arr = new String[][]{{"20", "19", "18", "17"}, {"16", "15", "14", "13"}, {"12", "11", "10", "9"}, {"8", "7", "6", "5"}};
        try {
            try {
                int result = method(arr);
                System.out.println(result);
            } catch (MyArraySizeException y) {
                System.out.println("Размер массива превышен!");
            }
        }
        catch (MyArrayDataException y) {
            System.out.println("Неправильное значение массива!");
            System.out.println("Ошибка в ячейке: " + y.a + "x" + y.b);
        }

    }

    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int a = 0; a < arr.length; a++) {
            if (arr[a].length != 4) {
                throw new MyArraySizeException();
            }
            for (int b = 0; b < arr[a].length; b++) {
                try {
                    count = count + Integer.parseInt(arr[a][b]);
                }
                catch (NumberFormatException y) {
                    throw new MyArrayDataException(a, b);
                }
            }

        }
        return count;
    }
}
