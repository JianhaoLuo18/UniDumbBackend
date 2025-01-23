package com.flatly.service;

import com.flatly.model.Flat;
import com.flatly.repository.FlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlatService {

    @Autowired
    private FlatRepository flatRepository;

    public List<Flat> getAllFlats() {
        return flatRepository.findAll();
    }

    public Optional<Flat> getFlatById(Long id) {
        return flatRepository.findById(id);
    }

    public Flat createFlat(Flat flat) {
        return flatRepository.save(flat);
    }

    public Flat updateFlat(Long id, Flat flatDetails) {
        Flat flat = flatRepository.findById(id).orElseThrow(() -> new RuntimeException("Flat not found"));
        flat.setName(flatDetails.getName());
        flat.setLocation(flatDetails.getLocation());
        flat.setPrice(flatDetails.getPrice());
        flat.setDescription(flatDetails.getDescription());
        flat.setDistance(flatDetails.getDistance());
        flat.setAmenities(flatDetails.getAmenities());
        flat.setAvailability(flatDetails.getAvailability());
        flat.setImages(flatDetails.getImages());
        return flatRepository.save(flat);
    }

    public void deleteFlat(Long id) {
        flatRepository.deleteById(id);
    }
}
