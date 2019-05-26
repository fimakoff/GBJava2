package lesson2;

public class Main {
    public static void main(String[] args) {
        String[][] array1 = new String[][]{
                {"0", "1", "2", "3"},
                {"4", "5", "6", "7"},
                {"8", "9", "10", "11"},
                {"12", "13", "14", "15"},
                {}
        };

        String[][] array2 = new String[][]{
                {"0", "1.", "2", "3"},
                {"4", "5", "6", "7"},
                {"8", "9", "10", "11"},
                {"12", "13", "14", "15"}
        };
        try {
            parseAndSumm(array1);
        } catch (MyArraySizeException e) {
            System.out.println("Размер массива не соответствует необходимому");
        } catch (MyArrayDataException e) {
            e.getMessage();
        }
        try {
            parseAndSumm(array2);
        } catch (MyArraySizeException e) {
            System.out.println("Размер массива не соответствует необходимому");
        } catch (MyArrayDataException e) {
            e.getMessage();
        }
    }

    private static void parseAndSumm(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int summ = 0;
        if (arr.length != 4) throw new MyArraySizeException("Размер массива не соответствует необходимому");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (!isNumeric(arr[i][j])) throw new MyArrayDataException("Неверный тип данных в ячейке ", i, j);
                int a = Integer.parseInt(arr[i][j]);
                summ += a;
            }
        }
        System.out.println("Сумма элементов массива составляет: " + summ);
    }

    private static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }

}
