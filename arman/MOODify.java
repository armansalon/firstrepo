import javax.sound.sampled.*;
import java.io.File;
import java.util.*;

public class MOODify {
    public static void main(String[] args) {
        new AppController().run();
    }
}

// #Abstraction
abstract class AudioContent {

    // #Encapsulation
    private String id;
    private String title;
    private int duration;

    public AudioContent(String id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    // #Encapsulation
    public String getId() { return id; }
    public String getTitle() { return title; }
    public int getDuration() { return duration; }
    public void setTitle(String title) { this.title = title; }

    // #Abstraction
    public abstract void play();

    public String toString() {
        return id + " | " + title + " (" + duration + "s)";
    }
}

// #Inheritance
class Music extends AudioContent {

    // #Encapsulation
    private String artist;
    private String mood;
    private String filePath;

    public Music(String id, String title, String artist, String mood, String filePath, int duration) {
        super(id, title, duration);
        this.artist = artist;
        this.mood = mood;
        this.filePath = filePath;
    }

    // #Polymorphism
    public void play() {
        System.out.println("\nMood Music Recommendation:");
        System.out.println(getTitle() + " by " + artist);
    }
}

// #Inheritance
class Podcast extends AudioContent {

    // #Encapsulation
    private String link;

    public Podcast(String id, String title, String link, int duration) {
        super(id, title, duration);
        this.link = link;
    }

    // #Polymorphism
    public void play() {
        System.out.println("\nPodcast Recommendation:");
        System.out.println("Title: " + getTitle());
        System.out.println("Watch here: " + link);
    }
}

class AudioUtil {
    public static void play(String path) {
    }
}

class LibraryManager {

    // #Polymorphism
    private Map<String, AudioContent> library = new LinkedHashMap<>();
    private Map<String, List<Music>> moodMap = new HashMap<>();
    private List<Podcast> podcasts = new ArrayList<>();
    private int idCounter = 1;

    public LibraryManager() {
        seedMusic();
        seedPodcasts();
    }

    private String nextId(String p) {
        return p + (idCounter++);
    }

    private void seedMusic() {
        addMusic("sad", "Bawat Piyesa", "Muni-muni", "BawatPiyesa.wav");
        addMusic("sad", "All Too Well", "Taylor Swift", "AllTooWell.wav");
        addMusic("sad", "Cry", "Cigarette After Sex", "Cry.wav");
        addMusic("sad", "Sailor", "Gigi Perez", "Sailor.wav");

        addMusic("happy", "Mananatili", "Cup of Joe", "Mananatili.wav");
        addMusic("happy", "Message in a Bottle", "Taylor Swift", "MessageBottle.wav");
        addMusic("happy", "Who Knows", "Daniel Caesar", "WhoKnows.wav");
        addMusic("happy", "Love Is", "Ridleys", "LoveIs.wav");

        addMusic("angry", "Anti-Hero", "Taylor Swift", "AntiHero.wav");
        addMusic("angry", "10 Things I Hate About You", "Leah Kate", "10Things.wav");
        addMusic("angry", "Kill Bill", "SZA", "KillBill.wav");
        addMusic("angry", "Vampire", "Olivia Rodrigo", "Vampire.wav");
        addMusic("angry", "Traitor", "Olivia Rodrigo", "Traitor.wav");

        addMusic("broken", "Pahina", "Cup of Joe", "Pahina.wav");
        addMusic("broken", "Multo", "Cup of Joe", "Multo.wav");
        addMusic("broken", "You're Losing Me", "Taylor Swift", "YoureLosingMe.wav");
        addMusic("broken", "White Ferrari", "Frank Ocean", "WhiteFerrari.wav");
    }

    private void seedPodcasts() {
        addPodcast("Podcast 1", "https://youtu.be/N90UIXMuMMU?si=rHBI95ogiJLh5wBL");
        addPodcast("Podcast 2", "https://youtu.be/8VVtMnK9nPI?si=EyW3is4z3yRir7pW");
        addPodcast("Podcast 3", "https://youtu.be/w6tQ8ZbjIZU?si=gegbqMXTYyvSSul2");
        addPodcast("Podcast 4", "https://youtu.be/yi6gVC61lv0?si=kYQqvWYODVCcjIX8");
        addPodcast("Podcast 5", "https://youtu.be/ufQEqi4LUZ4?si=J9ibAkuKZKLzcq2t");
        addPodcast("Podcast 6", "https://youtu.be/joNAzJLBO1A?si=24josVJ6cGW2qD2a");
        addPodcast("Podcast 7", "https://youtu.be/BloutcYWbJg?si=cLNysDNPsCK52P82");
        addPodcast("Podcast 8", "https://youtu.be/a_5o8GBiJEE?si=buD_BpTiy8d2Z9lf");
        addPodcast("Podcast 9", "https://youtu.be/x0DTdXEd3mQ?si=NYC0BTsOjHIYk4yu");
        addPodcast("Podcast 10", "https://youtu.be/IDPDEKtd2yM?si=eVA_rH6sg5AInSDf");
    }

    public void addMusic(String mood, String title, String artist, String file) {
        String id = nextId("M");
        Music m = new Music(id, title, artist, mood, file, 180);
        library.put(id, m);
        moodMap.computeIfAbsent(mood, k -> new ArrayList<>()).add(m);
    }

    public void addPodcast(String title, String link) {
        String id = nextId("P");
        Podcast p = new Podcast(id, title, link, 10);
        library.put(id, p);
        podcasts.add(p);
    }

    public Music getRandomMusic(String mood) {
        List<Music> list = moodMap.get(mood);
        if (list == null || list.isEmpty()) return null;
        return list.get(new Random().nextInt(list.size()));
    }

    public List<Podcast> getPodcasts() { return podcasts; }

    public AudioContent find(String id) { return library.get(id); }

    public boolean updateTitle(String id, String t) {
        AudioContent ac = library.get(id);
        if (ac == null) return false;
        ac.setTitle(t);
        return true;
    }

    public boolean delete(String id) {
        return library.remove(id) != null;
    }

    public List<AudioContent> getAll() {
        return new ArrayList<>(library.values());
    }
}

class AppController {
    private Scanner sc = new Scanner(System.in);
    private LibraryManager lib = new LibraryManager();

    public void run() {
        boolean r = true;
        while (r) {
            menu();
            switch (sc.nextLine().trim()) {
                case "1": moodMusic(); break;
                case "2": podcastMenu(); break;
                case "3": crudMenu(); break;
                case "4": showLibrary(); break;
                case "5": r = false; break;
                default: System.out.println("Invalid.");
            }
        }
    }

    private void menu() {
        System.out.println("\n=== MOODify ===");
        System.out.println("[1] Mood Music");
        System.out.println("[2] Podcasts");
        System.out.println("[3] Manage Library (CRUD)");
        System.out.println("[4] Show All");
        System.out.println("[5] Exit");
        System.out.print("Choose: ");
    }

    private void moodMusic() {
        System.out.print("Mood (happy/sad/angry/broken): ");
        Music m = lib.getRandomMusic(sc.nextLine().trim());
        if (m == null) System.out.println("No music found.");
        else m.play(); // #Polymorphism
    }

    private void podcastMenu() {
        List<Podcast> p = lib.getPodcasts();
        System.out.println("\nPodcasts:");
        for (int i = 0; i < p.size(); i++)
            System.out.println("[" + (i + 1) + "] " + p.get(i).getTitle());

        System.out.print("Choose: ");
        try {
            int c = Integer.parseInt(sc.nextLine());
            if (c < 1 || c > p.size()) System.out.println("Invalid.");
            else p.get(c - 1).play(); // #Polymorphism
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }

    private void crudMenu() {
        System.out.println("\n[1] View by ID");
        System.out.println("[2] Update Title");
        System.out.println("[3] Delete");
        System.out.print("Choose: ");
        String c = sc.nextLine();

        switch (c) {
            case "1":
                System.out.print("ID: ");
                AudioContent ac = lib.find(sc.nextLine());
                System.out.println(ac != null ? ac : "Not found.");
                break;

            case "2":
                System.out.print("ID: ");
                String i2 = sc.nextLine();
                System.out.print("New Title: ");
                System.out.println(lib.updateTitle(i2, sc.nextLine()) ? "Updated." : "Failed.");
                break;

            case "3":
                System.out.print("ID: ");
                System.out.println(lib.delete(sc.nextLine()) ? "Deleted." : "Not found.");
                break;

            default:
                System.out.println("Invalid.");
        }
    }

    private void showLibrary() {
        System.out.println("\nLibrary Items:");
        for (AudioContent ac : lib.getAll())
            System.out.println(ac.getId() + " | " + ac.getClass().getSimpleName() + " | " + ac.getTitle());
    }
}
