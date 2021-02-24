package miniObfuscator;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        double site;
        double price;
        double people;
        double cost=0;
        System.out.print("Введите количество посадочных мест - ");
        site = sc.nextDouble();
        System.out.print("Введите цена билета - ");
        price = sc.nextDouble();
        System.out.print("Введите количество человек - ");
        people = sc.nextDouble();
        if (people < 0 || people > 50){
            System.out.println(" Введите количество человек от 0 до 50 ");
            return;
        }
        if (site < 0 || site > 50){
            System.out.println(" Введите количество мест от 0 до 50 ");
            return;
        }
        if (price < 23 || price > 27){
            System.out.println(" Введите цену в пределах от 23 до 27 ");
            return;
        }
        if (people > site ){
            System.out.println(" Мест не хватает ");
            return;
        }
        for ( int a = 1; a<=site; a++){
            System.out.println( " Человек " + a + " - " + price * a);
        }
    }
}