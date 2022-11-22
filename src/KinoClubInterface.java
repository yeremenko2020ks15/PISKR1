import java.util.HashMap;

public interface KinoClubInterface {
    HashMap<String, Films> popularFilms();

    Films getFilm(String videoId);
}