package moodio.indie.dev.externalAPIs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import moodio.indie.dev.DAOs.AudioFeatures;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import static moodio.indie.dev.services.RetrievalService.getRandomGenre;

public class Spotify {
    private static RestTemplate restTemplate = new RestTemplate();
    private static ObjectMapper objectMapper = new ObjectMapper();
    private String accessToken;

//    acousticness, speechiness, instrumentalness, liveness, valence, tempo, danceability, energy
    private static String apiURL(int colorId, double valence,double tempo,double danceability,double energy){
        String genre = getRandomGenre(colorId);
        return "https://api.spotify.com/v1/recommendations" +
                "?limit=20" +
                "&seed_genres=" + genre +
                "&valence=" + valence +
                "&tempo=" + tempo +
                "&danceability=" + danceability +
                "&energy=" + energy;
    }

    public static HashMap<String, Object> getSongsBasedOffOfAudioFeatures(AudioFeatures audioFeatures, int colorId) throws JsonProcessingException {
        String accessToken = "BQBHYNwTpVXGOe5DvPtnYZjo8c6bPeWwyTaUhOWt-9x_L8dfQqfAYOSaH6NkK-8w6KYYMitvnfYn9MEKPztlCQd3bFZ6Bm2iq-c3b5BVH_qrHM6H6rVRCsFvzmEsixZ2y9JSH0bZiKg";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                apiURL(colorId,audioFeatures.getValence(), audioFeatures.getTempo(), audioFeatures.getDanceability(), audioFeatures.getEnergy()),
                HttpMethod.GET,
                entity,
                String.class
        );

        JsonNode root = objectMapper.readTree(response.getBody());
        System.out.println(root);
        return new HashMap<>();
        // Use restTemplate to make GET request to apiURL with accessToken in header
        // Parse response using objectMapper
        // Return list of songs
    }

//    Getting tracks based off of (properly formatted) ai query


}
