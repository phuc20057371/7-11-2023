package com.example.orderservice.service;

import com.example.orderservice.dto.InventoryResponse;
import com.example.orderservice.dto.OderLineItemsdDto;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItems;
import com.example.orderservice.reponsitory.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> list = orderRequest.getOderLineItemsdDtosList().stream()
                .map(this::mapToDto).toList();
        order.setOrderLineItemsList(list);

        List<String> skuCodes = order.getOrderLineItemsList().stream().map(OrderLineItems::getSkuCode).toList();
        // Call Inventory Service, and place order if product is in stock
        InventoryResponse[] inventoryResponsesArray = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class).block();
        boolean allProductInStock = Arrays.stream(inventoryResponsesArray).allMatch(InventoryResponse::isInStock);
        if(allProductInStock){
            orderRepository.save(order);
        }else {
            throw new IllegalArgumentException("Product is not in stock, please try again !");
        }


    }

    private OrderLineItems mapToDto(OderLineItemsdDto oderLineItemsdDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(oderLineItemsdDto.getPrice());
        orderLineItems.setQuantity(oderLineItemsdDto.getQuantity());
        orderLineItems.setSkuCode(oderLineItemsdDto.getSkuCode());
        return orderLineItems;
    }
}
