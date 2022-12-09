package com.niit.jap.repository;

import com.niit.jap.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track, Integer> {
    @Query("{'trackRating':{$gt:4}}")
    List<Track> findAllTrackFromTrackRating(double trackRating);

    @Query("{'trackArtist.artistName':{$in:[?0]}}")
    List<Track> findAllTrackFromArtistName(String artistName);

}

