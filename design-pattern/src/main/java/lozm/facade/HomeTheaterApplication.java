package lozm.facade;

public class HomeTheaterApplication {

    public static void main(String[] args) {
        Screen screen = new Screen() {
            @Override
            public void up() {
                System.out.println("screen up");
            }

            @Override
            public void down() {
                System.out.println("screen down");
            }
        };

        Amplifier amplifier = new Amplifier() {
            @Override
            public void on() {
                System.out.println("amplifier on");
            }

            @Override
            public void setDvd(DvdPlayer dvdPlayer) {
                System.out.println("amplifier setDvd: " + dvdPlayer);
            }

            @Override
            public void off() {
                System.out.println("amplifier off");
            }
        };

        DvdPlayer dvdPlayer = new DvdPlayer() {
            @Override
            public void on() {
                System.out.println("dvdPlayer on");
            }

            @Override
            public void play(String movie) {
                System.out.println("dvdPlayer play: " + movie);
            }

            @Override
            public void stop() {
                System.out.println("dvdPlayer stop");
            }

            @Override
            public void off() {
                System.out.println("dvdPlayer off");
            }
        };

        PopcornPopper popcornPopper = new PopcornPopper() {
            @Override
            public void on() {
                System.out.println("popcornPopper on");
            }

            @Override
            public void pop() {
                System.out.println("popcornPopper pop");
            }

            @Override
            public void off() {
                System.out.println("popcornPopper off");
            }
        };


        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(screen, amplifier, dvdPlayer, popcornPopper);
        homeTheaterFacade.watchMovie("Test");
        homeTheaterFacade.endMovie();

    }

}
