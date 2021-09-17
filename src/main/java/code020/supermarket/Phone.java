package code020.supermarket;

import sun.plugin2.gluegen.runtime.CPU;

public class Phone extends MerchandiseV2{

    private double screenSize;
    private CPU cpu;
    private int memoryG;
    private int storageG;
    private String brand;
    private String os;

    public static  class CPU{
        private double speed;
        private String producer;

        public CPU(double speed, String producer){
            this.speed = speed;
            this.producer = producer;
        }

        public double getSpeed(){
            Phone phone = null;
            phone.memoryG = 99;
            return speed;
        }
    }
}
