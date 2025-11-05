package moodio.indie.dev.services;

import moodio.indie.dev.DAOs.AudioFeatures;
import moodio.indie.dev.DAOs.ColorDAO;
import moodio.indie.dev.externalAPIs.Spotify;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RetrievalService {
    private Spotify spotifyApi;

    public static AudioFeatures audioFeatures(int colorID) {
        AudioFeatures audioFeatures = new AudioFeatures();

        switch (colorID) {
            case 1: // Red - high energy, sexy
                audioFeatures.setEnergy(0.9);
                audioFeatures.setValence(0.75);
                audioFeatures.setTempo(120.0);
                audioFeatures.setDanceability(0.85);

                return audioFeatures;
            case 2: // Orange - house / kaytranda vibes
                audioFeatures.setEnergy(0.8);
                audioFeatures.setValence(0.65);
                audioFeatures.setTempo(124.0);
                audioFeatures.setDanceability(0.88);

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
