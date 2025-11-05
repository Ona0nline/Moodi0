package moodio.indie.dev.services;

import moodio.indie.dev.DAOs.AudioFeatures;
import moodio.indie.dev.DAOs.ColorDAO;
import moodio.indie.dev.externalAPIs.Spotify;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class RetrievalService {
    private Spotify spotifyApi;

    private static final Map<Integer, List<String>> COLOR_GENRES = Map.of(
            1, List.of("rock", "metal", "trap", "punk", "industrial"),
            2, List.of("dance", "pop", "funk", "disco", "electropop"),
            3, List.of("afrobeat", "indie-pop", "ska", "soca", "sunshine-pop"),
            4, List.of("lo-fi", "neo-soul", "jazz", "reggae", "chillhop"),
            5, List.of("rnb", "soul", "blues", "alt-pop", "sad-indie"),
            6, List.of("dream-pop", "synth-pop", "electronic", "shoegaze", "art-pop"),
            7, List.of("bedroom-pop", "k-pop", "hyperpop", "soft-rnb", "bubblegum-pop"),
            8, List.of("trap", "drill", "dark-ambient", "techno", "industrial"),
            9, List.of("ambient", "acoustic", "piano", "folk", "minimal-techno")
    );

    public static String getRandomGenre(int colorId) {
        List<String> genres = COLOR_GENRES.get(colorId);
        if (genres == null || genres.isEmpty()) {
            return "pop"; // fallback if ID is invalid
        }
        return genres.get(new Random().nextInt(genres.size()));
    }



    public static AudioFeatures audioFeatures(int colorID) {
        AudioFeatures audioFeatures = new AudioFeatures();

        switch (colorID) {
            case 1: // Red - high energy, sexy
                audioFeatures.setEnergy(0.9);
                audioFeatures.setValence(0.75);
                audioFeatures.setTempo(120.0);
                audioFeatures.setDanceability(0.85);
                audioFeatures.setGenre("rock");

                return audioFeatures;
            case 2: // Orange - house / kaytranda vibes
                audioFeatures.setEnergy(0.8);
                audioFeatures.setValence(0.65);
                audioFeatures.setTempo(124.0);
                audioFeatures.setDanceability(0.88);
                audioFeatures.setGenre("house");

                return audioFeatures;
            case 3: // Pink - soft dreamy
                audioFeatures.setEnergy(0.30);
                audioFeatures.setValence(0.72);
                audioFeatures.setTempo(75.0);
                audioFeatures.setDanceability(0.42);

                return audioFeatures;
            case 4: // Purple - indie / alternative
                audioFeatures.setEnergy(0.55);
                audioFeatures.setValence(0.50);
                audioFeatures.setTempo(105.0);
                audioFeatures.setDanceability(0.60);

                return audioFeatures;
            case 5: // Blue - calm / ambient / melancholic
                audioFeatures.setEnergy(0.28);
                audioFeatures.setValence(0.35);
                audioFeatures.setTempo(70.0);
                audioFeatures.setDanceability(0.30);

                return audioFeatures;
            case 6: // Green - fresh, upbeat, organic
                audioFeatures.setEnergy(0.68);
                audioFeatures.setValence(0.72);
                audioFeatures.setTempo(110.0);
                audioFeatures.setDanceability(0.68);

                return audioFeatures;
            case 7: // Yellow - bright, happy, poppy
                audioFeatures.setEnergy(0.82);
                audioFeatures.setValence(0.88);
                audioFeatures.setTempo(118.0);
                audioFeatures.setDanceability(0.80);

                return audioFeatures;
            case 8: // Brown - earthy, folk, acoustic
                audioFeatures.setEnergy(0.42);
                audioFeatures.setValence(0.48);
                audioFeatures.setTempo(90.0);
                audioFeatures.setDanceability(0.45);

                return audioFeatures;
            case 9: // Black - dark, heavy, low valence
                audioFeatures.setEnergy(0.88);
                audioFeatures.setValence(0.18);
                audioFeatures.setTempo(140.0);
                audioFeatures.setDanceability(0.30);

                return audioFeatures;
            default:
                return audioFeatures;
        }
    }
}
