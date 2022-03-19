package com.company.validator;

import com.company.Order;

public class OrderValidator {

    public enum OrderStatus{
        YES, NO, ERROR;
    }

    public static class OrderError{
        private String code;
        private String text;

        public OrderError(String code, String text) {
            this.code = code;
            this.text = text;
        }

        public String getCode() {
            return code;
        }

        public String getText() {
            return text;
        }
    }

    private OrderStatus customerStatus;
    private OrderStatus itemStatus;
    private OrderError customerError;
    private OrderError itemError;

    public OrderValidator(Order order, OrderStatus customerStatus, OrderStatus itemStatus) {
        this.customerStatus = customerStatus;
        this.itemStatus = itemStatus;
    }

    public OrderValidator(Order order, OrderStatus customerStatus, OrderStatus itemStatus, OrderError customerError, OrderError itemError) {
        this.customerStatus = customerStatus;
        this.itemStatus = itemStatus;
        this.customerError = customerError;
        this.itemError = itemError;
    }

    public OrderStatus getCustomerStatus() {
        return customerStatus;
    }

    public OrderStatus getItemStatus() {
        return itemStatus;
    }

    public OrderError getCustomerError() {
        return customerError;
    }

    public OrderError getItemError() {
        return itemError;
    }
}
