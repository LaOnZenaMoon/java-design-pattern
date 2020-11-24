package lozm.command;

public class Stereo {

    public void on() {
        System.out.println("Stereo is on.");
    }

    public void off() {
        System.out.println("Stereo is off.");
    }

    public void setCd() {
        System.out.println("CD is set.");
    }

    public void setDvd() {
        System.out.println("DVD is set.");
    }

    public void setRadio() {
        System.out.println("Radio is set.");
    }

    public void setVolume(int size) {
        System.out.println("Volume is " + String.valueOf(size));
    }

}
