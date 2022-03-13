package com.ecommerce.ecommerce.credit.service;

public interface CreditService {
    public double getCustomerCredit(long id);
    public void updateLimit(double limit, long id);
}
