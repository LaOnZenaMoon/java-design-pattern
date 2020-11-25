package lozm.command.fan;

public class CeilingFan {

    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;


    String location;
    int speed;


    public CeilingFan(String location) {
        this.location = location;
        this.speed = OFF;
    }


    public void setHigh() {
        speed = HIGH;
    }

    public void setMedium() {
        speed = MEDIUM;
    }

    public void setLow() {
        speed = LOW;
    }

    public void setOff() {
        speed = OFF;
    }

    public int getSpeed() {
        return this.speed;
    }

}
