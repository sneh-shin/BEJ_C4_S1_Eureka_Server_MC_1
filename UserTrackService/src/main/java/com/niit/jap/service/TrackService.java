package com.niit.jap.service;

import com.niit.jap.domain.Track;
import com.niit.jap.exception.ArtistNotFound;
import com.niit.jap.exception.TrackAlreadyExist;
import com.niit.jap.exception.TrackNotFound;

import java.util.List;

public interface TrackService {
    Track saveTrack(Track track) throws TrackAlreadyExist;

    boolean deleteTrack(int trackId) throws TrackNotFound;

    List<Track> getTracks();

    List<Track> getAllTrackFromTrackRating(double trackRating);

    List<Track> getAllTrackFromArtistName(String artistName) throws ArtistNotFound;

}
