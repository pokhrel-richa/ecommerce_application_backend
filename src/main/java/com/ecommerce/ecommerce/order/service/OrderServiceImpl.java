package com.ecommerce.ecommerce.order.service;

import com.ecommerce.ecommerce.credit.service.CreditService;
import com.ecommerce.ecommerce.order.dto.OrderRequest;
import com.ecommerce.ecommerce.order.dto.OrderResponse;
import com.ecommerce.ecommerce.order.entity.OrderItem;
import com.ecommerce.ecommerce.order.orderrepository.OrderRepository;
import com.ecommerce.ecommerce.product.dto.ProductResponse;
import com.ecommerce.ecommerce.product.entity.Product;
import com.ecommerce.ecommerce.product.productrepository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CreditService customerService;

    @Override
    public String checkProduct(OrderRequest orderRequest, long id) {
        Product product = productRepository.getById(id);
        if(product == null){
            return "Sorry the product either doesn't exist or is out of the stock";
        }
        int quantity = product.getQuantity();
        int quantity1 = orderRequest.getQuantity();
        double limit = customerService.getCustomerCredit(orderRequest.getCustomer_id());
        if(quantity == 0){
            return "product is out of stock";
        }
        if((quantity1 - quantity) > 0){
            return "Only " + quantity + " products are available";
        }
        if(quantity1*product.getPrice() > limit){
            return "Insufficient Credit Balance";
        }

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setCustomerId(orderRequest.getCustomer_id());
        orderItem.setPrice(product.getPrice()*quantity1);
        orderItem.setQuantity(quantity1);
        orderItem.setBill_amount(product.getPrice()*quantity1);
        orderRepository.save(orderItem);
        product.setQuantity(quantity-quantity1);
        productRepository.save(product);
        //updates customer available credit after subtracting from the purchased amount
        customerService.updateLimit(orderItem.getBill_amount(),orderItem.getCustomerId());

        ProductResponse productResponse = new ProductResponse();
        productResponse.setPrice(product.getPrice());
        productResponse.setDescription(product.getDescription());
        productResponse.setName(product.getName());
        productResponse.setTitle(product.getTitle());
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setPrice(orderItem.getPrice());
        orderResponse.setBill_amount(orderItem.getBill_amount());
        orderResponse.setCustomer_id(orderItem.getCustomerId());
        orderResponse.setQuantity(orderItem.getQuantity());
        orderResponse.setProductResponse(productResponse);
        return  "Order verified" + orderResponse.toString();
    }
}
