package com.example.Inventoryservice.controller;

import com.example.Inventoryservice.dto.InventoryResponse;
import com.example.Inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    //http://localhost:8082/api/inventory?skuCode=i7-13500K&skuCode=i9-13900K
    public List<InventoryResponse> isInStock(@RequestParam List<String>  skuCode){
        return inventoryService.isInStock(skuCode);
    }

}
