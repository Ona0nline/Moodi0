package moodio.indie.dev.externalAPIs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import moodio.indie.dev.DAOs.AudioFeatures;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class Spotify {
    private RestTemplate restTemplate;
    private static ObjectMapper objectMapper;
    private String accessToken;

//    acousticness, speechiness, instrumentalness, liveness, valence, tempo, danceability, energy
    private static String apiURL(double valence,double tempo,double danceability,double energy){
        return "https://api.spotify.com/v1/recommendations" +
                "?limit=20" +
                "&valence=" + valence +
                "&tempo=" + tempo +
                "&danceability=" + danceability +
                "&energy=" + energy;
    }

    public static HashMap<String, Object> getSongsBasedOffOfAudioFeatures(AudioFeatures audioFeatures) throws JsonProcessingException {
        String apiUrl = apiURL(audioFeatures.getValence(), audioFeatures.getTempo(), audioFeatures.getDanceability(), audioFeatures.getEnergy());
        JsonNode root = objectMapper.readTree(apiUrl);
        System.out.println(root);
        return new HashMap<>();
        // Use restTemplate to make GET request to apiURL with accessToken in header
        // Parse response using objectMapper
        // Return list of songs
    }

//    Getting tracks based off of (properly formatted) ai query


}
