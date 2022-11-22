import java.util.HashMap;

public class KinoClub implements KinoClubInterface {

    @Override
    public HashMap<String, Films> popularFilms() {
        connectToServer("http://www.uakino.club");
        return getRandomVideos();
    }

    @Override
    public Films getFilm(String FilmId) {
        connectToServer("http://www.uakino.club/" + FilmId);
        return getSomeVideo(FilmId);
    }

    private void experienceNetworkLatency() {
        int randomLatency = 5 + (int) (Math.random() * ((10 - 5) + 1));
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void connectToServer(String site) {
        System.out.print("Під'єднання до " + site + "\n");
        experienceNetworkLatency();
        System.out.print("Готово" + "\n");
    }

    private HashMap<String, Films> getRandomVideos() {
        System.out.print("Завантаження популярних\n");

        experienceNetworkLatency();
        HashMap<String, Films> hmap = new HashMap<>();
        hmap.put("1", new Films("0001", "Home"));
        hmap.put("2", new Films("0002", "Westworld"));
        hmap.put("3", new Films("0003", "Sandman"));
        hmap.put("4", new Films("0004", "Watcher"));

        return hmap;
    }

    private Films getSomeVideo(String videoId) {
        System.out.print("Завантаження фільму\n");

        experienceNetworkLatency();
        Films films = new Films(videoId, "0");

        System.out.print("Готово" + "\n");
        return films;
    }

}