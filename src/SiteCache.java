import java.util.HashMap;

public class SiteCache implements KinoClubInterface {
    private final KinoClubInterface SiteService;
    private HashMap<String, Films> cache = new HashMap<>();
    private final HashMap<String, Films> cacheAll = new HashMap<>();

    public SiteCache() {
        this.SiteService = new KinoClub();
    }

    @Override
    public HashMap<String, Films> popularFilms() {
        if (cache.isEmpty()) {
            cache = SiteService.popularFilms();
        } else {
            System.out.println("Отримано список кешу");
        }
        return cache;
    }

    @Override
    public Films getFilm(String FilmId) {
        Films films = cacheAll.get(FilmId);
        if (films == null) {
            films = SiteService.getFilm(FilmId);
            cacheAll.put(FilmId, films);
        } else {
            System.out.println("Отримано відео " + FilmId + " з кешу.");
        }
        return films;
    }
}