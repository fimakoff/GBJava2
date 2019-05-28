package lesson2;

public class Main {
    private static final int countOfElements = 4;
    public static void main(String[] args) {
//        String[][] array1 = new String[][]{
//                {"0", "1", "2", "3"},
//                {"4", "5", "6", "7"},
//                {"8", "9", "10", "11"},
//                {"10", "12", "13", "14", "15"}
//        };
//
//        String[][] array2 = new String[][]{
//                {"0", "1", "2", "3"},
//                {"4", "5", "6", "7"},
//                {"8", "9", "10", "11"},
//                {"12", "13", "14", "15"},
//                {}
//        };
//
//        String[][] array3 = new String[][]{
//                {"0", "1", "2", "3"},
//                {"4", "5", "6", "7"},
//                {"8", "STRING", "10", "11"},
//                {"12", "13", "14", "15"}
//        };

        String[][] array4 = new String[][]{
                {"0", "1", "2", "3"},
                {"4", "5", "6", "7"},
                {"8", "9", "10", "11"},
                {"12", "13", "14", "15"}
        };
//        try {
//            parseAndSumm(array1);
//        } catch (MyArraySizeException e) {
//            System.out.println(e.getMessage());
//        } catch (MyArrayDataException e) {
//            e.getMessage();
//        }
//
//        try {
//            parseAndSumm(array2);
//        } catch (MyArraySizeException e) {
//            System.out.println(e.getMessage());
//        } catch (MyArrayDataException e) {
//            e.getMessage();
//        }
//
//        try {
//            parseAndSumm(array3);
//        } catch (MyArraySizeException e) {
//            System.out.println(e.getMessage());
//        } catch (MyArrayDataException e) {
//            e.getMessage();
//        }

        try {
            parseAndSumm(array4);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            e.getMessage();
        }
    }

    private static void parseAndSumm(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int summ = 0;
        if (arr.length != countOfElements) throw new MyArraySizeException("Размер внешнего массива не соответствует необходимому");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != countOfElements)
                throw new MyArraySizeException("Размер внутреннего массива не соответствует необходимому");
            for (int j = 0; j < arr[i].length; j++) {
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
