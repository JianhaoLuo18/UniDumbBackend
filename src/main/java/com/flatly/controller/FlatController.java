package com.flatly.controller;

import com.flatly.dto.FlatDTO;
import com.flatly.service.FlatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flats")
public class FlatController {

    private final FlatService flatService;

    public FlatController(FlatService flatService) {
        this.flatService = flatService;
    }

    // Retrieve all flats
    @GetMapping
    public ResponseEntity<List<FlatDTO>> getAllFlats() {
        List<FlatDTO> flats = flatService.getAllFlats();
        return ResponseEntity.ok(flats);
    }

    // Retrieve a single flat by its ID
    @GetMapping("/{id}")
    public ResponseEntity<FlatDTO> getFlatById(@PathVariable Long id) {
        FlatDTO flatDTO = flatService.getFlatById(id);
        return ResponseEntity.ok(flatDTO);
    }

    // Create a new flat
    @PostMapping
    public ResponseEntity<FlatDTO> createFlat(@RequestBody FlatDTO flatDTO) {
        FlatDTO createdFlat = flatService.createFlat(flatDTO);
        return ResponseEntity.ok(createdFlat);
    }

    // Update an existing flat
    @PutMapping("/{id}")
    public ResponseEntity<FlatDTO> updateFlat(@PathVariable Long id, @RequestBody FlatDTO flatDTO) {
        FlatDTO updatedFlat = flatService.updateFlat(id, flatDTO);
        return ResponseEntity.ok(updatedFlat);
    }

    // Delete a flat by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlat(@PathVariable Long id) {
        flatService.deleteFlat(id);
        return ResponseEntity.noContent().build();
    }

    // Unified dynamic filtering endpoint.
    // Any combination of query parameters can be provided.
    @GetMapping("/filter")
    public ResponseEntity<List<FlatDTO>> filterFlats(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Integer roomNumber,
            @RequestParam(required = false) Float minDistance,
            @RequestParam(required = false) Float maxDistance) {
        List<FlatDTO> flats = flatService.filterFlats(location, minPrice, maxPrice, roomNumber, minDistance, maxDistance);
        return ResponseEntity.ok(flats);
    }
}
