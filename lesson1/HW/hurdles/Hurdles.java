package lesson1.HW.hurdles;

public class Hurdles {


    public Hurdles(int maxSizeHurdles, int lengthOfThreadmill, int heightOfWall) {
        int countTh, countWa;
        int length = 0;
        int height = 0;

        // Количество дорожек при нечетном числе участков на единицу больше
        if (maxSizeHurdles % 2 == 1) {
            countTh = maxSizeHurdles / 2 + 1;
            countWa = maxSizeHurdles / 2;
        } else{
            countTh = maxSizeHurdles / 2;
            countWa = maxSizeHurdles / 2;
        }

        // Создаем препятствия
        Threadmill threadmill = new Threadmill(lengthOfThreadmill, countTh);
        Wall wall = new Wall(heightOfWall, countWa);
        Object[] hurdles = new Object[maxSizeHurdles];

        // Присваиваем через одно каждое препятствие нашей дорожке
        for (int i = 0; i < maxSizeHurdles; i += 2) {
            hurdles[i] = threadmill;
            if (i == maxSizeHurdles - 1)
                break;
            hurdles[i + 1] = wall;
        }

        // Вывод информации о дорожки в консоль
        for (int i = 0; i < hurdles.length; i++) {
            if (hurdles[i].equals(threadmill))
                length+=threadmill.getLength();
            if (hurdles[i].equals(wall))
                height=wall.getHeight();
            System.out.println(hurdles[i]);
        }
        System.out.println("summ of legth: " + length + ". height walls: " + height);

    }
}
