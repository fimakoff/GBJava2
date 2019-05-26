package lesson1.HW;

//import lesson1.HW.Sportsmans.Cat;
//import lesson1.HW.Sportsmans.Human;
//import lesson1.HW.Sportsmans.Moveable;
//import lesson1.HW.Sportsmans.Robot;
//import lesson1.HW.hurdles.Threadmill;

import lesson1.HW.hurdles.Hurdles;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner scInt = new Scanner(System.in);
        Scanner scCh = new Scanner(System.in);

        Hurdles hd = new Hurdles(3);
//        int thLength = 5;
//        Threadmill th1 = new Threadmill();
//        th1.setLength(thLength);
//        System.out.println(th1.toString());
//
//
//        LinkedList<Moveable> command = new LinkedList<>();
//        int choice;
//        String ch;
//        do {
//            int jumpHeight = rand.nextInt(10) + 1;
//            int runLength = rand.nextInt(10) + 1;
//            System.out.println("Who will be in your command?\n" +
//                    "1 - Cat, 2 - Robot, 3 - Human");
//            choice = scInt.nextInt();
//
//            switch (choice) {
//                case 1:
//                    command.add(new Cat(runLength, jumpHeight));
//                    break;
//                case 2:
//                    command.add(new Robot(runLength, jumpHeight));
//                    break;
//                case 3:
////                    command.add(new Human(runLength, jumpHeight));
//                    break;
//
//            }
//            System.out.println("Your command is:");
//            System.out.println(command.toString());
//            System.out.println("Add also player (y/n)? ");
//            ch = scCh.nextLine();
//        } while (ch.equalsIgnoreCase("Y"));
//
//        System.out.println("Ok! We are finished to complied your command!\nAre you ready?");
//
//        command.get(0);











        //        int choose = 0;
//        int i = 0;
//        String str;
//        do {
//
//            switch (choose){
//                case 1:
//                    str = "Cat" + i;
//                    str = new Cat(runLength, jumpHeight);
//            }
//        }

//        if (cat1.getMaxRunLength() >= th1.getLength()) {
//            System.out.println("Кот успешно пробежал");
//        }
    }
}
