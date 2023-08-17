package com.example.midterm_project_v1.services;

import com.example.midterm_project_v1.modals.OrderDetail;
import com.example.midterm_project_v1.repository.OrderDetailRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface OrderDetailService extends OrderDetailRepository {
    @Query("SELECT od from OrderDetail od where od.order_id = ?1")
    ArrayList<OrderDetail> findAllByID(Integer id);
}
