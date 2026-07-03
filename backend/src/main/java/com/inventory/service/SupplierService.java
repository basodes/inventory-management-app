package com.inventory.service;

import com.inventory.entity.Supplier;

import java.util.List;

public interface SupplierService {

    Supplier createSupplier(Supplier supplier);

    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(Long supplierId);

    Supplier updateSupplier(Long supplierId, Supplier supplier);

    void deleteSupplier(Long supplierId);

}
