package com.inventory.service;

import com.inventory.entity.Inventory;

import java.util.List;

public interface InventoryService {

    Inventory createInventory(Inventory inventory);

    List<Inventory> getAllInventory();

    Inventory getInventoryById(Long inventoryId);

    Inventory updateInventory(Long inventoryId, Inventory inventory);

    void deleteInventory(Long inventoryId);
}
