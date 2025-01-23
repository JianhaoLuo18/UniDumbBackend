package com.flatly.controller;

import com.flatly.model.Flat;
import com.flatly.service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flats") // Ensure this matches the URL you're calling
public class FlatController {

    @Autowired
    private FlatService flatService;

    @GetMapping
    public List<Flat> getAllFlats() {
        return flatService.getAllFlats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flat> getFlatById(@PathVariable Long id) {
        return flatService.getFlatById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Flat createFlat(@RequestBody Flat flat) {
        return flatService.createFlat(flat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flat> updateFlat(@PathVariable Long id, @RequestBody Flat flatDetails) {
        return ResponseEntity.ok(flatService.updateFlat(id, flatDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlat(@PathVariable Long id) {
        flatService.deleteFlat(id);
        return ResponseEntity.noContent().build();
    }
}
