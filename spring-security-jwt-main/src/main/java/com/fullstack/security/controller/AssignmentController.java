package com.fullstack.security.controller;

import com.fullstack.security.entity.Assignment;
import com.fullstack.security.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assignments")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class AssignmentController {
    private final AssignmentService assignmentService;

    @GetMapping("/")
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long id) {
        Assignment assignment = assignmentService.getAssignmentById(id);
        if (assignment != null) {
            return ResponseEntity.ok(assignment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
        Assignment createdAssignment = assignmentService.saveAssignment(assignment);
        return ResponseEntity.ok(createdAssignment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable Long id, @RequestBody Assignment updatedAssignmentData) {
        Assignment existingAssignment = assignmentService.getAssignmentById(id);
        if (existingAssignment == null) {
            return ResponseEntity.notFound().build();
        }

        existingAssignment.setAssign_title(updatedAssignmentData.getAssign_title());
        existingAssignment.setAssign_description(updatedAssignmentData.getAssign_description());

        Assignment updatedAssignment = assignmentService.saveAssignment(existingAssignment);
        return ResponseEntity.ok(updatedAssignment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
        return ResponseEntity.noContent().build();
    }
}
