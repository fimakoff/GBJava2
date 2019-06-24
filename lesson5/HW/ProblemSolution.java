package lesson5.HW;

class ProblemSolution {

    private static final int size = 10000000;
    private static final int h = size / 2;
    private float[] arr = new float[size];

    void monoSolution() {
        initArray();
        long startTime = System.currentTimeMillis();
        arr = calculations(arr);
        System.out.println("Моно: " + (System.currentTimeMillis() - startTime));
    }

    void multySolution() {
        initArray();
        long startTime = System.currentTimeMillis();
        Runnable firstThread = () -> {
            float[] firstHalf = new float[h];
            System.arraycopy(arr, 0, firstHalf, 0, h);
            firstHalf = calculations(firstHalf);
            System.arraycopy(firstHalf, 0, arr, 0, h);
        };
        firstThread.run();
        Runnable secondThread = () -> {
            float[] secondHalf = new float[h];
            System.arraycopy(arr, h, secondHalf, 0, h);
            secondHalf = calculations(secondHalf);
            System.arraycopy(secondHalf, 0, arr, h, h);
        };
        secondThread.run();
        System.out.println("Мульти: " + (System.currentTimeMillis() - startTime));
    }


    private static int j = 0;

    void multySolution(int i) {
        initArray();
        int a = i;
        int b = size / i;

        float[][] array = new float[a][b];
//        System.out.println("i = " + i + " a = " + a + " size = " + size + " b = " + b);
        long startTime = System.currentTimeMillis();
        for (j = 0; j < a; j++) {
//            System.out.println("Начало : " + b * j + " конец: " + (b * j + b - 1));
            new Thread(() -> {
                System.arraycopy(arr, b * j, array[j], 0, array[j].length);
                array[j] = calculations(array[j]);
                System.arraycopy(array[j], 0, arr, b * j, array[j].length);
            }).start();
        }
        System.out.println("Мульти: " + (System.currentTimeMillis() - startTime));
    }

    private void initArray() {
        for (int i = 0; i < arr.length; i++) arr[i] = 1;
    }

    private float[] calculations(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
        return arr;
    }
}