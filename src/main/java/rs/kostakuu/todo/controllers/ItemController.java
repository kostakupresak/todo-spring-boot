package rs.kostakuu.todo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.kostakuu.todo.contracts.services.ItemServiceContract;
import rs.kostakuu.todo.payloads.RequestPayload;
import rs.kostakuu.todo.payloads.ResponsePayload;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemServiceContract itemService;

    public ItemController(ItemServiceContract itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<ResponsePayload> allItems = this.itemService.findAll();

        return new ResponseEntity<>(allItems, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody RequestPayload requestPayload) {
        ResponsePayload savedItem = this.itemService.add(requestPayload);

        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> toggle(@PathVariable Integer id) {
        ResponsePayload toggledItem = this.itemService.toggle(id);

        return new ResponseEntity<>(toggledItem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        ResponsePayload deletedItem = this.itemService.delete(id);

        return new ResponseEntity<>(deletedItem, HttpStatus.OK);
    }

}
