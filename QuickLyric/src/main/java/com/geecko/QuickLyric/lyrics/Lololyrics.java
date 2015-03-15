package com.geecko.QuickLyric.lyrics;

//import android.util.Log;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

import java.io.IOException;
import java.net.URLEncoder;

public class Lololyrics {

    private static final String baseUrl = "http://api.lololyrics.com/0.5/getLyric?artist=%1s&track=%1s";
    //private static final String TAG = "Lololyrics";

    public static Lyrics fromMetaData(String artist, String song) {

        if ((artist == null) || (song == null))
            return new Lyrics(Lyrics.ERROR);

        try {

            String encodedArtist = URLEncoder.encode(artist, "UTF-8");
            String encodedSong = URLEncoder.encode(song, "UTF-8");

            String url = String.format(baseUrl, encodedArtist, encodedSong);
            //Log.v(TAG, url);

            String body = Jsoup.connect(url).execute().body();
            Document lololyrics = Jsoup.parse(body.replaceAll("(\\n)", "<br />"));

            Element loloResult = lololyrics.select("result").first();

            if (!loloResult.select("status").text().equals("OK")) {
                //Log.v(TAG, "Lololyrics error");
                return new Lyrics(Lyrics.NO_RESULT);
            }

            if (loloResult.select("response").hasText()) {

                Lyrics lyrics = new Lyrics(Lyrics.POSITIVE_RESULT);
                lyrics.setArtist(artist);
                lyrics.setTitle(song);
                String text = Parser.unescapeEntities(loloResult.select("response").html(), true);
                lyrics.setText(text);
                lyrics.setSource("Lololyrics");

                if (loloResult.select("cover").hasText()) {
                    //Log.v(TAG, "Cover found");
                    lyrics.setCoverURL(loloResult.select("cover").text());
                }

                //Log.v(TAG, "All good");
                return lyrics;
            } else {
                return new Lyrics(Lyrics.NO_RESULT);
            }

        } catch (IOException e) {
            if (e instanceof HttpStatusException) {
                if (((HttpStatusException) e).getStatusCode() == 404) {
                    //Log.v(TAG, "Lyrics not found");
                    return new Lyrics(Lyrics.NO_RESULT);
                }
            }
            e.printStackTrace();
            return new Lyrics(Lyrics.ERROR);
        }
    }

    // TODO handle lololyrics.com urls
    public static Lyrics fromURL(String url, String artist, String song) {
        /** We can't transform generic lololyrics url to API url.
            Also we can't get artist name and song title from Lololyrics API. **/
        return new Lyrics(Lyrics.NO_RESULT);
    }
}
