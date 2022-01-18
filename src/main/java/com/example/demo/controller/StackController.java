package com.example.demo.controller;

import com.example.demo.service.StackService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.EmptyStackException;

@RestController
@AllArgsConstructor
@Slf4j
public class StackController {

    @Autowired
    private StackService stackService;

    // Error handling & response codes

    // Identify specific stack in controller?

    // Sample body


    // Add a JSON body
    @RequestMapping(value = "/stack/push", method = RequestMethod.POST)
    public ResponseEntity push(@RequestBody Integer val) {
        log.info("Pushing value to stack: " + val);

        // Do operation
        stackService.push(val);

        // Return
        return ResponseEntity.ok().build(); // Use created instead?
    }

    // Handle errors for empty stack
    @RequestMapping(value = "/stack/pop", method = RequestMethod.POST)
    public ResponseEntity<Integer> pop() {
        log.info("Popping value from stack");

        Integer val = null;

        // Do operation
        try {
            val = stackService.pop();
        }
        catch (EmptyStackException e) {
            return ResponseEntity.badRequest().build();
        }

        log.info("Popped value from stack: " + val);

        // Return
        return ResponseEntity.ok(val);
    }

    // 404 for bad index
    @RequestMapping(value = "/stack/get", method = RequestMethod.GET)
    public ResponseEntity<Integer> get(@RequestParam Integer index) {
        log.info("Getting value from stack");

        // Do operation
//        try {
//            Integer val = stackService.get(index);
//        }
//        catch (IndexOutOfBoundsException e) {
//            return ResponseEntity.notFound();
//        }
        Integer val = stackService.get(index);

        log.info("Got value from stack: " + val);

        // Return
        return ResponseEntity.ok(val);
    }
}
