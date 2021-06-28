 package com.example.order.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.DatabaseException;
import com.example.Exceptions.OrderNotFoundException;
import com.example.order.dto.OrderDTO;
import com.example.order.entity.Orders;
import com.example.order.repository.OrderRepository;


@Service
public class OrderServiceImpl implements IOrderService {
	

	
	@Autowired
	OrderRepository ordersRepository;
	
	
	@Override
	public List<OrderDTO> getAllOrders() throws DatabaseException {
		
		List<Orders> orders =  ordersRepository.findAll();
		if(orders.size()<1) {
			
			throw new DatabaseException();
		}
		
		List<OrderDTO> ordersReturn = new ArrayList<>();
		for (Orders o : orders ) {
			ordersReturn.add(entityToDTO(o));
		}
		
		return ordersReturn;
	}

	
	@Override
	public OrderDTO findOrder(Integer orderId) throws OrderNotFoundException {
		if(orderId == null) {
			return null;
		}
		
		Optional<Orders> order = ordersRepository.findById(orderId);
		
		if(!order.isPresent() || order == null) {
			throw new OrderNotFoundException();
		}
		
		return entityToDTO(order.get());
	}
	
	
	@Override
	public List<OrderDTO> findOrdersByDate (LocalDate date) throws OrderNotFoundException, DatabaseException{
		if(date == null) {
			return null;
		}
		
		List<Orders> orders;
		try {
			
		    orders = ordersRepository.findByDate(date);
		}
		catch(Exception e) {
			throw new OrderNotFoundException();
		}
	
		List<OrderDTO> ordersReturn = new ArrayList<>();
		for (Orders o : orders ) {
			ordersReturn.add(entityToDTO(o));
		}
		
		return ordersReturn;	
		
	}


	@Override
	public String deleteOrder(Integer orderId) throws OrderNotFoundException {
		if(orderId == null) {
			return null;
		}
		
		try {
			
		    ordersRepository.deleteById(orderId);
		}
		
		catch(Exception e) {
			throw new OrderNotFoundException();
		}
		
		return "Order deleted!";	
	}

	
	@Override
	public OrderDTO createOrder(OrderDTO orderDTO) throws OrderNotFoundException, DatabaseException{
		if(orderDTO == null) {
			return null;
		}
		System.out.println("add dto"+orderDTO);
		
		Orders order = DTOToEntity(orderDTO);
		System.out.println("add entity"+order);
		
		Orders returned = ordersRepository.save(order);
		
	    return entityToDTO(returned);	
	}

	@Override
	public List<OrderDTO> updateOrder(OrderDTO orderDTO) throws OrderNotFoundException, DatabaseException{
		if(orderDTO == null) {
			return null;
		}
		
		Optional<Orders> order = ordersRepository.findById(orderDTO.getOrderId());
		
		if(!order.isPresent() || order == null) {
			throw new OrderNotFoundException();
		}
		
        ordersRepository.save(DTOToEntity(orderDTO));
		
		List<OrderDTO> ordersReturn = new ArrayList<>();
		List<Orders> orders = ordersRepository.findAll();
		
		if(orders.size()<1) {
			throw new OrderNotFoundException();
	    }
	
		for (Orders o : orders ) {
			ordersReturn.add(entityToDTO(o));
		}
		
		return ordersReturn;
	}
			

	@Override
	public List<OrderDTO> findOrdersByUser(String emailId) throws DatabaseException{
		if(emailId == null) {
			return null;
		}
		
		List<Orders> orders = new ArrayList<>();
		ordersRepository.findByUserEmailId(emailId).forEach(orders::add);
		
		if(orders.size()<1 || orders == null) {
			
			throw new DatabaseException();
		}
		
		List<OrderDTO> ordersReturn = new ArrayList<>();
		for (Orders o : orders ) {
			ordersReturn.add(entityToDTO(o));
		}
		
		return ordersReturn;
	}

	public static OrderDTO entityToDTO(Orders order) {
		
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderId(order.getOrderId());
		orderDTO.setDate(order.getDate());
		orderDTO.setAmount(order.getAmount());
		orderDTO.setUser(order.getUser());
		orderDTO.setProducts(order.getProducts());
	
		return orderDTO;
	}
	
	public static Orders DTOToEntity(OrderDTO orderDTO) {
		Orders orders = new Orders();
		orders.setOrderId(orderDTO.getOrderId());
		orders.setDate(orderDTO.getDate());
		orders.setAmount(orderDTO.getAmount());	
		orders.setUser(orderDTO.getUser());		
		orders.setProducts(orderDTO.getProducts());
		
		return orders;
	}
	

	@Override
	public String deleteOrder(int orderId) {
		
		return null;
	
	}

	@Override
	public OrderDTO findOrder(String orderId) throws OrderNotFoundException {
		return null;
	}



}
