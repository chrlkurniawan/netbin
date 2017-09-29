/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageProcessing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Kurniawan
 */
public class Imaging {

    //var obj
    BufferedImage img;
    File f;

    //var image
    String filename;
    int width;
    int height;
    int[] biner;
    String path;

    Imaging() {
    }

    Imaging(String path) {
        try {
            this.path = path;
            f = new File(path);
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        filename = f.getName();
        width = img.getWidth();
        height = img.getHeight();
        System.out.println(f.getName());

    }

    void setFile(String p) {
        try {
            f = new File(p);
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        filename = f.getName();
        width = img.getWidth();
        height = img.getHeight();
        System.out.println(f.getName());

    }

    void gray(BufferedImage img) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                int avg = (r + g + b) / 3;

                p = (a << 24) | (avg << 16) | (avg << 8) | avg;
                img.setRGB(x, y, p);
            }
        }
        try {
            f = new File("C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\imagesOutput.jpg");
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    String grayAverage() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                int avg = (r + g + b) / 3;

                p = (a << 24) | (avg << 16) | (avg << 8) | avg;
                img.setRGB(x, y, p);
            }
        }

        try {

            f = new File("C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\GrayAvg" + filename);
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        return "C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\GrayAvg" + filename;
    }

    String grayLightness() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                int light = (Math.max(Math.max(r, g), b) + Math.min(Math.min(r, g), b)) / 2;

                p = (a << 24) | (light << 16) | (light << 8) | light;
                img.setRGB(x, y, p);
            }
        }
        try {
            f = new File("C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\GrayLightness" + filename);
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        return "C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\GrayLightness" + filename;
    }

    String grayLuminosity() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                int lmn = (int) ((0.21 * r) + (0.71 * g) + (0.07 * b));

                p = (a << 24) | (lmn << 16) | (lmn << 8) | lmn;
                img.setRGB(x, y, p);
            }
        }
        try {
            f = new File("C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\gray\\GrayLmn" + filename);
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        return "C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\gray\\GrayLmn" + filename;
    }

    String ImageNegative() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                p = (a << 24) | ((255 - r) << 16) | ((255 - g) << 8) | (255 - b);
                img.setRGB(x, y, p);
            }
        }
        try {
            f = new File("C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\Negative\\negative " + filename);
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        return "C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\Negative\\negative " + filename;
    }

    String LogTransformation(int cc) {
        int c = cc;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                // (c * Math.log(1 + p)
                p = (a << 24) | ((int) (c * Math.log(1 + r)) << 16) | ((int) (c * Math.log(1 + g)) << 8) | (int) (c * Math.log(1 + b));
                img.setRGB(x, y, p);
            }
        }
        try {
            f = new File("C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\log\\log " + filename);
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        return "C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\log\\log " + filename;
    }

    String PowerLawTransformation(int cc, int yyy) {
        int c = cc;
        int yy = yyy;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                p = (a << 24) | ((int) (c * Math.pow(r, yy)) << 16) | ((int) (c * Math.pow(g, yy)) << 8) | (int) (c * Math.pow(b, yy));
                img.setRGB(x, y, p);
            }
        }
        try {
            f = new File("C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\power\\power " + filename);
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        return "C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\power\\power " + filename;
    }

    String ContrastStretching() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                p = (a << 24) | ((255 - r) << 16) | ((255 - g) << 8) | (255 - b);
                img.setRGB(x, y, p);
            }
        }
        try {
            f = new File("C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\Negative\\negative " + filename);
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        return "C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\Negative\\negative " + filename;
    }

    String BitPlane(int a) {
        int bit = 7 - (a - 1);
        String[][] arrayBinaryImage = new String[height][width];
        int[] binary;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y) & 0xff;

                binary = this.intToBinary(p);

                if (binary[bit] == 1) {
                    int r = 255;
                    int g = 255;
                    int b = 255;
                    p = (255 << 24) | (r << 16) | (g << 8) | b;
                } else {
                    int r = 0;
                    int g = 0;
                    int b = 0;
                    p = (255 << 24) | (r << 16) | (g << 8) | b;
                }

                img.setRGB(x, y, p);
            }
        }
        try {
            f = new File("C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\Bitplane\\" + a + filename);
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        return "C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\Bitplane\\" + a + filename;
    }

    String Back() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                int lmn = (int) ((0.21 / r) + (0.71 / g) + (0.07 / b));

                p = (a << 24) | (lmn << 16) | (lmn << 8) | lmn;
                img.setRGB(x, y, p);
            }
        }

        try {

            f = new File("C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\Back" + filename);
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        return "C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\Back" + filename;
    }

    String RGBtoCMY() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                p = (a << 24) | ((255 - r) << 16) | ((255 - g) << 8) | (255 - b);
                img.setRGB(x, y, p);
            }
        }
        try {
            f = new File(path + "CMY "+filename);
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        return path +"CMY "+ filename;
    }

    void writeMatrix(String filename, String[][] matrix) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename + ".txt"));

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    bw.write(matrix[i][j] + ",");
                }
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
        }
    }

    int[] intToBinary(int number) {
        int[] array = new int[8];

        String bin = Integer.toBinaryString(number);
        int selisih = 8 - bin.length();

        for (int i = 0; i < 8; i++) {
            if (selisih != 0) {
                array[i] = 0;
                selisih--;
            } else {
                int count = 0;
                array[i] = Character.getNumericValue(bin.charAt(count));
                Integer.parseInt(bin);
                count++;
            }
        }
        biner = array;
        //ngecek
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i]);
//
//        }
//        System.out.println("");
        return array;
    }

    void add(String path, String path2) throws IOException {
        File q = new File(path);
        BufferedImage image = ImageIO.read(q);
        File o = new File(path2);
        BufferedImage overlay = ImageIO.read(o);
        // overlay = ImageIO.read(new File(path2, "overlay.png"));

// create the new image, canvas size is the max. of both image sizes
        int w = Math.max(image.getWidth(), overlay.getWidth());
        int h = Math.max(image.getHeight(), overlay.getHeight());
        BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

// paint both images, preserving the alpha channels
        Graphics g = combined.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.drawImage(overlay, 0, 0, null);

// Save as new image
        ImageIO.write(combined, "JPG", new File("C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\tumpuk", "combined.png"));
    }

    public static void main(String[] args) throws IOException {
        Imaging im = new Imaging("C:\\Users\\Kurniawan\\Documents\\NetbeansFilesMen\\1uang.jpg");
        im.RGBtoCMY();

    }
}
