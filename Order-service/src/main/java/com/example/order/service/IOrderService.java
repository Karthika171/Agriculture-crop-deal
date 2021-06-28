package com.example.order.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Exceptions.OrderNotFoundException;
import com.example.order.dto.OrderDTO;


@Service
public interface IOrderService {

	OrderDTO createOrder(OrderDTO order);

	List<OrderDTO> getAllOrders();

	List<OrderDTO> findOrdersByUser(String emailId);

	String deleteOrder(int orderId);

	OrderDTO findOrder(Integer orderId);

	List<OrderDTO> updateOrder(OrderDTO order);

	List<OrderDTO> findOrdersByDate(LocalDate date);

	OrderDTO findOrder(String orderId) throws OrderNotFoundException;

	String deleteOrder(Integer orderId) throws OrderNotFoundException;




	


	
}
