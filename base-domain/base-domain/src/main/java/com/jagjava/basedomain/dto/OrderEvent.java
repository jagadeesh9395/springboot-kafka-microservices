package com.jagjava.basedomain.dto;

public record OrderEvent(String message, String status, Order order) {
}
