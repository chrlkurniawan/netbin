/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fuzzy;

/**
 *
 * @author Kurniawan
 */
public class testis {

    void intersectionsYaegerW1(double a, double b) {
        double hasil;
        hasil = 1 - (Math.min(1, (2 - a - b)));
        System.out.println(hasil);
    }

    void intersectionsYaegerW2(double a, double b) {
        double hasil;
        hasil = 1 - (Math.min(1, (Math.sqrt(((Math.pow((1 - a), 2)) + (Math.pow((1 - b), 2)))))));
        System.out.println(hasil);
    }

    public static void main(String[] args) {
        testis tes = new testis();
        tes.intersectionsYaegerW2(0.9, 0.1);
    }
}
