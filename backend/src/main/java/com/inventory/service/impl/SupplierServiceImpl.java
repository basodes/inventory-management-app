package com.inventory.service.impl;

import com.inventory.entity.Supplier;
import com.inventory.exception.ResourceNotFoundException;
import com.inventory.repository.SupplierRepository;
import com.inventory.service.SupplierService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getSupplierById(Long supplierId) {
        return supplierRepository.findById(supplierId)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
    }

    @Override
    public Supplier updateSupplier(Long supplierId, Supplier supplier) {
        Supplier existing = getSupplierById(supplierId);

        existing.setSupplierName(supplier.getSupplierName());
        existing.setContactPerson(supplier.getContactPerson());
        existing.setEmail(supplier.getEmail());
        existing.setPhone(supplier.getPhone());
        existing.setAddress(supplier.getAddress());

        return supplierRepository.save(existing);
    }

    @Override
    public void deleteSupplier(Long supplierId) {
        supplierRepository.delete(getSupplierById(supplierId));
    }
}
