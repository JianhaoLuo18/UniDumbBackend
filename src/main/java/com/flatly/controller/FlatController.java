package com.flatly.controller;

import com.flatly.dto.FlatDTO;
import com.flatly.service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flats")
public class FlatController {

    @Autowired
    private FlatService flatService;

    @GetMapping
    public ResponseEntity<List<FlatDTO>> getAllFlats() {
        List<FlatDTO> flats = flatService.getAllFlats();
        return ResponseEntity.ok(flats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlatDTO> getFlatById(@PathVariable Long id) {
        FlatDTO flatDTO = flatService.getFlatById(id);
        return ResponseEntity.ok(flatDTO);
    }

    @PostMapping
    public ResponseEntity<FlatDTO> createFlat(@RequestBody FlatDTO flatDTO) {
        FlatDTO createdFlat = flatService.createFlat(flatDTO);
        return ResponseEntity.ok(createdFlat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlatDTO> updateFlat(@PathVariable Long id, @RequestBody FlatDTO flatDTO) {
        FlatDTO updatedFlat = flatService.updateFlat(id, flatDTO);
        return ResponseEntity.ok(updatedFlat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlat(@PathVariable Long id) {
        flatService.deleteFlat(id);
        return ResponseEntity.noContent().build();
    }
}
