package com.example.task7;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
public class NameController {
    @GetMapping("/name")
    public Name getName(
            @Validated @NotNull @NotBlank @RequestParam("id") Integer id, @RequestParam("name") String name) {
        return new Name("tomoyasu", 1);
    }


    @PostMapping("/name")

    public ResponseEntity<Map<String, String>> create(@RequestBody CreateForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/name")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "name successfully created"));

    }

    @PatchMapping("/name/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody UpdateForm form) {
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    @DeleteMapping("/name/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int deleteId) {
        return ResponseEntity.noContent().build();
    }
}
