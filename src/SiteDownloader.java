public class SiteDownloader {
    private final KinoClubInterface api;

    public SiteDownloader(KinoClubInterface api) {
        this.api = api;
    }

    public void renderVideoPage(String videoId) {
        api.getFilm(videoId);
    }

    public void renderPopularVideos() {
        api.popularFilms();
    }
}