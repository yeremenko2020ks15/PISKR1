public class Main {

    public static void main(String[] args) {
        SiteDownloader naiveDownloader = new SiteDownloader(new KinoClub());
        SiteDownloader smartDownloader = new SiteDownloader(new SiteCache());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Збережений час від кешування проксі: " + (naive - smart) + "мс");

    }

    private static long test(SiteDownloader downloader) {
        long startTime = System.currentTimeMillis();

        downloader.renderPopularVideos();
        downloader.renderVideoPage("1");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("2");
        downloader.renderVideoPage("3");
        downloader.renderVideoPage("4");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Пройшло часу: " + estimatedTime + "мс\n");
        return estimatedTime;
    }
}