package com.ecommerce.ecommerce.credit.service;

import com.ecommerce.ecommerce.credit.entity.Credit;
import com.ecommerce.ecommerce.credit.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditServiceImpl implements CreditService {
    @Autowired
    private CreditRepository customerRepository;

    @Override
    public double getCustomerCredit(long id) {
        Credit customer = customerRepository.getByCustomerId(id);
        return customer.getLimit();
    }

    @Override
    public void updateLimit(double limit, long id) {
        Credit customer = customerRepository.getByCustomerId(id);
        customer.setLimit(customer.getLimit() - limit);
        customer.setCustomerId(id);
        customerRepository.save(customer);
    }
}
