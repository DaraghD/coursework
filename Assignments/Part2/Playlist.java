//DARAGH DOWNES 22351159
//CAYLUM HURLEY 22356363
//DARRAGH QUINN 22359621
//JOE CONSIDINE 22344977



import java.util.ArrayList;
import java.util.Random;

public class Playlist {

    private String PlaylistName;
    private ArrayList<Track> TrackList= new ArrayList<Track>();

    public Playlist(){
        this.PlaylistName = "My Playlist";
    }

    public Playlist(String Listname){
        this.PlaylistName = Listname;
    }
    public String toString(){
        String temp = " ";
        for(int i=0; i< this.TrackList.size();i++){
            temp = temp + "Title :";
            temp = temp + this.TrackList.get(i).getTitle();
            temp = temp + "\n";
            temp = temp + "Artist: ";
            temp = temp + this.TrackList.get(i).getArtist();
            temp = temp + "\n";
            temp = temp + "Duration :";
            temp = temp + this.TrackList.get(i).getDuration();
            temp = temp + "\n";
            temp = temp + "Year :";
            temp = temp + this.TrackList.get(i).getYear();
            temp = temp + "\n";
            temp = temp + "\n";

        }

        return temp;
    }
    public void setName(String name){
        this.PlaylistName = name;
    }
    public String getName(){
        return this.PlaylistName;
    }
    public void add(String title, String artist){
        Track temp = new Track(title,artist);
        this.TrackList.add(temp);
    }
    public void add(String title, String artist, int year, int duration){
        Track temp = new Track(title,artist,year,duration);
        this.TrackList.add(temp);
    }
    public void add(Track t){
        this.TrackList.add(t);
    }
    public boolean remove(String title){
        String TitleCaps = title.toUpperCase();
        for(int i =0; i<this.TrackList.size();i++){
            String TrackTitleCaps = this.TrackList.get(i).getTitle().toUpperCase();
            if(TitleCaps.equals(TrackTitleCaps)){
                this.TrackList.remove(i);
                return true;
            }

        }
    return false;
    }

    public void showList(){
        if(TrackList.size() == 0){
            System.out.println("The list is empty");
            return ;
        }
        System.out.println(this);

    }
    public void playAll(boolean random){
        Random random2 = new Random();
        boolean exists = false;
        ArrayList<Track> randomList = new ArrayList<Track>();
        ArrayList<Integer> indexList = new ArrayList<Integer>();

        if(random){//printing randomly
            for(int i =0; i<TrackList.size();i++){ //building list of tracks in random order, using indexlist to track indexes already used/ prevent dupes
                int temp = random2.nextInt(TrackList.size());
                if(!indexList.contains(temp)){// e.g if it is a new value
                    randomList.add(TrackList.get(temp));
                    indexList.add(temp);
                }
                else{
                    i = i -1;
                }
        }
            for(int j=0; j<randomList.size();j++){
                System.out.println(randomList.get(j));
                System.out.println();
            }

    }
    else{ //printing in order
        for(int j =0; j<TrackList.size();j++){
            System.out.println(TrackList.get(j));
            System.out.println();

        }
        }
    }
    public void playOnly(String artist){
        artist = artist.toLowerCase();
        for(int i=0; i<TrackList.size();i++){
            Track temp = TrackList.get(i);
            if(temp.getArtist().toLowerCase().contains(artist)){
                System.out.println(temp);
            }
        }
    }
    public void playOnly(int year){
        for(int i=0; i<TrackList.size();i++){
            Track temp = TrackList.get(i);
            if(temp.getYear() == year)
                System.out.println(temp);
            }
        }
    }

