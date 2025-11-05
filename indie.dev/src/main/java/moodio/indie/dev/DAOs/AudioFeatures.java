package moodio.indie.dev.DAOs;

import lombok.Data;

@Data
public class AudioFeatures {
    private double acousticness;
    private double speechiness;
    private double instrumentalness;
    private double liveness;
    private double valence;
    private double tempo;
    private double danceability;
    private double energy;
}
