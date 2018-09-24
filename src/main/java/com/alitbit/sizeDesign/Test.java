package com.alitbit.sizeDesign;

import java.util.Scanner;

public class Test {

    // n段落 p页 w宽 h高

    /*
        2
        1 10 4 3
        10
        2 10 4 3
        10 10

        3
        2
     */

    static class Data{
        private int n;
        private int p;
        private int w;
        private int h;
        private Integer[] charCount;

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public int getP() {
            return p;
        }

        public void setP(int p) {
            this.p = p;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public Integer[] getCharCount() {
            return charCount;
        }

        public void setCharCount(Integer[] charCount) {
            this.charCount = charCount;
        }
    }


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int testCount;

        testCount = Integer.parseInt(scanner.next());

        Data[] data = new Data[testCount];

        for (int i=0; i<testCount; i++){
            data[i] = new Data();
            data[i].setN(Integer.parseInt(scanner.next()));
            data[i].setP(Integer.parseInt(scanner.next()));
            data[i].setW(Integer.parseInt(scanner.next()));
            data[i].setH(Integer.parseInt(scanner.next()));

            data[i].setCharCount(new Integer[data[i].getN()]);
            for (int j=0; j<data[i].getN(); j++){
                data[i].getCharCount()[j] = Integer.parseInt(scanner.next());
            }
        }

        for (int i=0; i<testCount; i++){
            for (int s=1; ; s++){
                int r = data[i].getH() / s; // 每页最多显示行数
                int c = data[i].getW() / s; // 每页最多显示列数

                if (r==0 || c==0){
                    System.out.println(s-1);
                    break;
                }

                int rowCount = 0;
                for (int j=0; j<data[i].getN(); j++){
                    if (data[i].getCharCount()[j] % c == 0){
                        rowCount += data[i].getCharCount()[j] / c;
                    }else {
                        rowCount += (data[i].getCharCount()[j] / c + 1);
                    }
                }

                if (data[i].getP()*r < rowCount){
                    System.out.println(s-1);
                    break;
                }
            }
        }

    }

}
