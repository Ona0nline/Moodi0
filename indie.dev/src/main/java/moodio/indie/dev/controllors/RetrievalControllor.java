package moodio.indie.dev.controllors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import moodio.indie.dev.DAOs.AudioFeatures;
import moodio.indie.dev.DAOs.ColorDAO;
import moodio.indie.dev.externalAPIs.Spotify;
import moodio.indie.dev.services.RetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class RetrievalControllor {

    @Autowired
    RetrievalService retrievalService;

//    Temporary mapping, might just be handled by client side
    @GetMapping("/")
    public ResponseEntity<?> home() {
        return ResponseEntity.ok("Hello from Retrieval Controller");
    }

//    Defines what audio features mean to what colour
//    Will make use of spotify api
    @PostMapping("/moodio")
    public ResponseEntity<?> retrieve(@RequestBody ColorDAO colorDAO) throws JsonProcessingException {
        AudioFeatures audioFeatures = retrievalService.audioFeatures(colorDAO.getColorId());
//        Pass into spotify api to get songs with these features
        Spotify spotifyApi = new Spotify();
        System.out.println("Audio Features Retrieved: " + audioFeatures.getValence());
        HashMap<String, Object> songs = spotifyApi.getSongsBasedOffOfAudioFeatures(audioFeatures, colorDAO.getColorId());
        return ResponseEntity.ok(songs);
    }

//    Same but will use OpenAI api to retrieve more advanced mood analysis
    @GetMapping("/moodio/ai")
    public ResponseEntity<?> moodioAI() {
        return ResponseEntity.ok("Hello from Moodio AI Endpoint");
    }



}
