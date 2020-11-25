package lozm.facade;

public class HomeTheaterFacade {

    Screen screen;
    Amplifier amplifier;
    DvdPlayer dvdPlayer;
    PopcornPopper popcornPopper;


    public HomeTheaterFacade(
            Screen screen,
            Amplifier amplifier,
            DvdPlayer dvdPlayer,
            PopcornPopper popcornPopper
    ) {
        this.screen = screen;
        this.amplifier = amplifier;
        this.dvdPlayer = dvdPlayer;
        this.popcornPopper = popcornPopper;
    }


    public void watchMovie(String movie) {
        System.out.println("Get ready to watch the movie: " + movie);
        popcornPopper.on();
        popcornPopper.pop();

        screen.down();

        amplifier.on();
        amplifier.setDvd(dvdPlayer);

        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down");
        popcornPopper.off();

        screen.up();

        amplifier.off();

        dvdPlayer.stop();
        dvdPlayer.off();
    }

}
