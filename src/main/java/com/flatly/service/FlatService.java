package com.flatly.service;

import com.flatly.dto.FlatDTO;
import com.flatly.model.Flat;
import com.flatly.repository.FlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlatService {

    @Autowired
    private FlatRepository flatRepository;

    // Get all flats as DTOs
    public List<FlatDTO> getAllFlats() {
        return flatRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get a flat by ID as a DTO
    public FlatDTO getFlatById(Long id) {
        Flat flat = flatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flat not found with id: " + id));
        return convertToDTO(flat);
    }

    // Create a flat and return the DTO
    public FlatDTO createFlat(FlatDTO flatDTO) {
        Flat flat = convertToEntity(flatDTO);
        Flat savedFlat = flatRepository.save(flat);
        return convertToDTO(savedFlat);
    }

    // Update a flat and return the DTO
    public FlatDTO updateFlat(Long id, FlatDTO flatDTO) {
        Flat flat = flatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flat not found with id: " + id));

        flat.setName(flatDTO.getName());
        flat.setLocation(flatDTO.getLocation());
        flat.setPrice(flatDTO.getPrice());
        flat.setDescription(flatDTO.getDescription());
        flat.setDistance(flatDTO.getDistance());
        flat.setAmenities(flatDTO.getAmenities());
        flat.setAvailability(flatDTO.getAvailability());
        flat.setImages(flatDTO.getImages());
        flat.setRoomNumber(flatDTO.getRoomNumber());

        Flat updatedFlat = flatRepository.save(flat);
        return convertToDTO(updatedFlat);
    }

    // Delete a flat
    public void deleteFlat(Long id) {
        flatRepository.deleteById(id);
    }

    // Convert Flat entity to FlatDTO
    private FlatDTO convertToDTO(Flat flat) {
        FlatDTO dto = new FlatDTO();
        dto.setId(flat.getId());
        dto.setName(flat.getName());
        dto.setLocation(flat.getLocation());
        dto.setPrice(flat.getPrice());
        dto.setDescription(flat.getDescription());
        dto.setDistance(flat.getDistance());
        dto.setAmenities(flat.getAmenities());
        dto.setAvailability(flat.getAvailability());
        dto.setImages(flat.getImages());
        dto.setRoomNumber(flat.getRoomNumber());
        return dto;
    }

    // Convert FlatDTO to Flat entity
    private Flat convertToEntity(FlatDTO flatDTO) {
        Flat flat = new Flat();
        flat.setId(flatDTO.getId());
        flat.setName(flatDTO.getName());
        flat.setLocation(flatDTO.getLocation());
        flat.setPrice(flatDTO.getPrice());
        flat.setDescription(flatDTO.getDescription());
        flat.setDistance(flatDTO.getDistance());
        flat.setAmenities(flatDTO.getAmenities());
        flat.setAvailability(flatDTO.getAvailability());
        flat.setImages(flatDTO.getImages());
        flat.setRoomNumber(flatDTO.getRoomNumber());
        return flat;
    }
}
