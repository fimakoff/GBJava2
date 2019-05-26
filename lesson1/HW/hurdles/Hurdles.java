package lesson1.HW.hurdles;

public class Hurdles {
    private Object[] hurdles = new Object[100];

    public Hurdles(int maxSizeHurdles) {
        Threadmill threadmill = new Threadmill(10, 3);
//        Threadmill[] threadmills = new Threadmill[maxSizeHurdles];
        Wall wall = new Wall(3,2);
//        Wall[] walls = new Wall[threadmills.length-1];
//        System.out.println(maxSizeHurdles);
//        System.out.println(threadmills.length-1);

        for (int i = 0, j=0; i < 2*maxSizeHurdles; i+=2,j++) {
            this.hurdles[i] = threadmill;
            if (i==(2*maxSizeHurdles-1))
                break;
            this.hurdles[i+1] = wall;
        }

//        System.out.println(hurdles.length + " " + threadmills.length + " " + walls.length);

    }
}
