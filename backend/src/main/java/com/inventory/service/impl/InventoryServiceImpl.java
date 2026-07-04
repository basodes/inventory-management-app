package com.inventory.service.impl;

import com.inventory.entity.Inventory;
import com.inventory.exception.ResourceNotFoundException;
import com.inventory.repository.InventoryRepository;
import com.inventory.service.InventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory getInventoryById(Long inventoryId) {
        return inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found"));
    }

    @Override
    public Inventory updateInventory(Long inventoryId, Inventory inventory) {

        Inventory existing = getInventoryById(inventoryId);

        existing.setProductId(inventory.getProductId());
        existing.setQuantity(inventory.getQuantity());
        existing.setMinimumQuantity(inventory.getMinimumQuantity());
        existing.setWarehouseLocation(inventory.getWarehouseLocation());

        return inventoryRepository.save(existing);
    }

    @Override
    public void deleteInventory(Long inventoryId) {
        inventoryRepository.delete(getInventoryById(inventoryId));
    }
}
