package com.example.config;

import java.util.List;
import java.util.Map;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import com.example.entity.Order;
import com.example.repository.OrderRepository;

import jakarta.annotation.PostConstruct;

@Configuration
public class OrderRagConfig {

    private final OrderRepository orderRepository;
    private final VectorStore vectorStore;

    public OrderRagConfig(
            OrderRepository orderRepository,
            @Qualifier("orderVectorStore")
            VectorStore vectorStore) {

        this.orderRepository = orderRepository;
        this.vectorStore = vectorStore;
    }

    @PostConstruct
    public void loadOrders() {

        System.out.println("Loading orders from PostgreSQL...");

        List<Order> orders = orderRepository.findAll();

        System.out.println(
                "Orders found: " + orders.size()
        );

        List<Document> documents = orders.stream()
                .map(order -> {

                    String content = """
                            Order Number: %s
                            Customer: %s
                            Product: %s
                            Quantity: %d
                            Order Status: %s
                            Order Date: %s
                            Expected Delivery Date: %s
                            Shipping Address: %s
                            """.formatted(
                            order.getOrderNumber(),
                            order.getCustomerName(),
                            order.getProductName(),
                            order.getQuantity(),
                            order.getOrderStatus(),
                            order.getOrderDate(),
                            order.getExpectedDeliveryDate(),
                            order.getShippingAddress()
                    );

                    return new Document(
                            content,
                            Map.of(
                                    "orderNumber",
                                    order.getOrderNumber(),

                                    "customerName",
                                    order.getCustomerName(),

                                    "status",
                                    order.getOrderStatus()
                            )
                    );
                })
                .toList();

        vectorStore.add(documents);

        System.out.println(
                "Orders embedded and stored in PGVector."
        );
    }
}