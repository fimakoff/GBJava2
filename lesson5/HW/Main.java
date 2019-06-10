package lesson5.HW;

public class Main {

    private static final int SIZE = 10000000;
    private static final int NUMS_OF_THREADS = 2;
    private static final int HALF = SIZE / NUMS_OF_THREADS;

    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        singleThreadingMethod(arr);
//        multyThreadingMethod(arr, HALF);
    }
    private static void singleThreadingMethod(float[] arr) {
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время выполения операции (однопоточно) составляет: " + (System.currentTimeMillis() - a));
    }

    /*
     * System.arraycopy(arr,0,array[0],9,10); // копирование 10 элементов из массива arr, начиная с позиции 0, в массив array[0], начиная с позиции 9
     * */

    private static void multyThreadingMethod(float[] arr, int h) {
//        long a = System.currentTimeMillis();
//        float[][] array = new float[NUMS_OF_THREADS][h];
//        System.arraycopy(arr, 0, array[0], 0, h);
//        System.arraycopy(arr, h, array[1], 0, h);
//        Thread t = new Thread();
//        for (int i = 0; i < 6; i++) {
//            t.start();
//            System.out.println(i);
//        }
//        System.out.println("Время выполения операции () составляет: " + (System.currentTimeMillis() - a));
        GuruThread threadguru1 = new GuruThread(arr,0,SIZE);
        threadguru1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }


    private static class GuruThread extends Thread{
        float[] innerArr;
        GuruThread(float[] array, int begin, int end) {
            innerArr = new float[HALF];
            System.arraycopy(array, begin, innerArr, begin, end-begin+1);
        }

        @Override
        public void run() {

            for (int i = 0; i < innerArr.length; i++) {
                innerArr[i] = (float) (innerArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(innerArr[i+100]);
            }
        }
    }
}
