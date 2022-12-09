package com.niit.jap.controller;

import com.niit.jap.domain.Track;
import com.niit.jap.exception.ArtistNotFound;
import com.niit.jap.exception.TrackAlreadyExist;
import com.niit.jap.exception.TrackNotFound;
import com.niit.jap.service.TrackServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class TrackController {
    private TrackServiceImpl service;

    public TrackController(TrackServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/saveValue")
    public ResponseEntity<?> save(@RequestBody Track track) throws TrackAlreadyExist {
        return new ResponseEntity<>(service.saveTrack(track), HttpStatus.CREATED);
    }

    @GetMapping("/getValue")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(service.getTracks(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteValue/{trackId}")
    public ResponseEntity<?> delete(@PathVariable int trackId) throws TrackNotFound {
        return new ResponseEntity<>(service.deleteTrack(trackId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getRating/{trackRating}")
    public ResponseEntity<?> getByRating(@PathVariable double trackRating) {
        return new ResponseEntity<>(service.getAllTrackFromTrackRating(trackRating), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getArtist/{artistName}")
    public ResponseEntity<?> getByArtist(@PathVariable String artistName) throws ArtistNotFound {
        return new ResponseEntity<>(service.getAllTrackFromArtistName(artistName), HttpStatus.ACCEPTED);
    }
}
