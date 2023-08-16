//DARAGH DOWNES 22351159
//CAYLUM HURLEY 22356363
//DARRAGH QUINN 22359621
//JOE CONSIDINE 22344977


public class PlayListDriver {
    public static void main(String[] args) {
        Playlist favourites = new Playlist();

        Track track1 = new Track("Bohemian Rhapsody", "Queen", 1975, 355);
        Track track2 = new Track("Billie Jean", "Michael Jackson", 1982, 294);
        Track track3 = new Track("Hey Jude", "The Beatles", 1968, 431);
        Track track4 = new Track("Ballade No. 1", "Frédéric Chopin", 1835, 540);
        Track track5 = new Track("Wallace And Gromit Main Theme", "Julian Franklin Keith Nott", 1989, 69);

        favourites.add(track1);
        favourites.add(track2);
        favourites.add(track3);
        favourites.add(track4);
        favourites.add(track5);

        System.out.println("1st playlist:");
        System.out.println("");
        favourites.showList();
        favourites.remove("Hey Jude");

        System.out.println("2nd playlist:");
        System.out.println("");
        favourites.showList();
        favourites.add("Sweet Child O'Mine", "Guns N'Roses", 1988, 355);

        System.out.println("3rd playlist:");
        System.out.println("");
        favourites.showList();

        favourites.setName("liked songs");
        System.out.println("New Playlist Name:" + " " + favourites.getName());
        System.out.println("");
        favourites.showList();

        System.out.println("liked songs In Order:");
        System.out.println("");
        favourites.playAll(false);

        System.out.println("liked songs Shuffled:");
        System.out.println("");
        favourites.playAll(true);

        System.out.println("Play One");
        System.out.println("");
        favourites.playOnly("Queen");
        favourites.playOnly("1975");
    }

}