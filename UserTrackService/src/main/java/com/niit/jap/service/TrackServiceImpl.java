/*
 *Author Name: Sneha Shinde
 *Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jap.service;

import com.niit.jap.domain.Track;
import com.niit.jap.exception.ArtistNotFound;
import com.niit.jap.exception.TrackAlreadyExist;
import com.niit.jap.exception.TrackNotFound;
import com.niit.jap.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository repository;

    @Autowired
    public TrackServiceImpl(TrackRepository repository) {
        this.repository = repository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExist {

        if (repository.findById(track.getTrackId()).isPresent()) {
            throw new TrackAlreadyExist();
        }
        return repository.save(track);
    }

    @Override
    public boolean deleteTrack(int trackId) throws TrackNotFound {
        boolean result = false;
        if (repository.findById(trackId).isEmpty()) {
            throw new TrackNotFound();
        } else {
            repository.deleteById(trackId);
            result = true;
        }
        return result;
    }

    @Override
    public List<Track> getTracks() {
        return repository.findAll();
    }

    @Override
    public List<Track> getAllTrackFromTrackRating(double trackRating) {
        return repository.findAllTrackFromTrackRating(trackRating);
    }

    @Override
    public List<Track> getAllTrackFromArtistName(String artistName) throws ArtistNotFound {
        if (repository.findAllTrackFromArtistName(artistName).isEmpty()) {
            throw new ArtistNotFound();
        }
        return repository.findAllTrackFromArtistName(artistName);
    }
}
