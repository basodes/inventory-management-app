package com.inventory.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.inventory.entity.Inventory;
import com.inventory.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
    name = "Inventory APIs",
    description = "Operations related to inventory management"
)
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Operation(summary = "Create a new inventory item")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory createInventory(@Valid @RequestBody Inventory inventory) {
        return inventoryService.createInventory(inventory);
    }

    @Operation(summary = "Get all inventory items") 
    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @Operation(summary = "Get inventory item by ID")
    @GetMapping("/{id}")
    public Inventory getInventoryById(@PathVariable Long id) {
        return inventoryService.getInventoryById(id);
    }

    @Operation(summary = "Update inventory item")   
    @PutMapping("/{id}")
    public Inventory updateInventory(@PathVariable Long id,
                                     @RequestBody Inventory inventory) {
        return inventoryService.updateInventory(id, inventory);
    }

    @Operation(summary = "Delete inventory item")   
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
    }
}
