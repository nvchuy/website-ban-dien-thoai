package com.example.midterm_project_v1.services;

import com.example.midterm_project_v1.modals.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImp {
    final OrderDetailService OrderDetailService;

    public OrderDetailServiceImp(OrderDetailService orderDetailService) {
        OrderDetailService = orderDetailService;
    }


    public List<OrderDetail> findAll() {
        return (List<OrderDetail>) OrderDetailService.findAll();
    }
    public List<OrderDetail> findAllByOrderID(Integer id) {
        return OrderDetailService.findAllByID(id);
    }


    public void save(OrderDetail OrderDetail) {
        OrderDetailService.save(OrderDetail);
    }

    public OrderDetail get(Integer id) {
        Optional<OrderDetail> result = OrderDetailService.findById(id);

        return result.orElseGet(OrderDetail::new);
    }
}
