package com.example.order.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exceptions.DatabaseException;
import com.example.Exceptions.OrderNotFoundException;
import com.example.order.dto.OrderDTO;
import com.example.order.service.IOrderService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;

	
	@PostMapping("/orders")
	@ApiOperation(value="Place orders")
	public ResponseEntity<OrderDTO> insertOrder(@Validated @RequestBody OrderDTO order) throws OrderNotFoundException {
		
		System.out.println("Insert order started");
		OrderDTO orderReturned= orderService.createOrder(order);
		
		return new ResponseEntity<OrderDTO>(orderReturned, HttpStatus.OK);
	
	}
	
	
	@ApiOperation(value="Get all orders")
	@GetMapping("/orders")
	public ResponseEntity<List<OrderDTO>> getAllOrders() throws DatabaseException{
		
		
		List<OrderDTO> orders = orderService.getAllOrders();
		
		return new ResponseEntity<List<OrderDTO>>(orders, HttpStatus.OK);
	}
	
	
	@ApiOperation(value="Find orders by user")
	@GetMapping("/orders/user/{emailId}")
	public ResponseEntity<List<OrderDTO>> getAllOrdersByUser(@PathVariable("emailId") String emailId) throws OrderNotFoundException,DatabaseException{
		
		
		List<OrderDTO> orders = orderService.findOrdersByUser(emailId);
		
		return new ResponseEntity<List<OrderDTO>>(orders, HttpStatus.OK);
	}
	
	
	@ApiOperation(value="Delete orders")
	@DeleteMapping("orders/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable("orderId")int orderId) throws  OrderNotFoundException {
			                      
		
		String status= orderService.deleteOrder(orderId);
			
		return new ResponseEntity<String>(status, HttpStatus.OK);
		
	}
	
	
	@ApiOperation(value="Find orders by id")
	@GetMapping("orders/{orderId}")
	public ResponseEntity<OrderDTO> findOrder (@PathVariable("orderId")Integer orderId) throws OrderNotFoundException {
			                       
		
		OrderDTO order= orderService.findOrder(orderId);
		
		return new ResponseEntity<OrderDTO>(order, HttpStatus.OK);
	}
	
	@ApiOperation(value="Update orders")
	@PutMapping("/orders")
	public ResponseEntity<List<OrderDTO>> updateOrder (@Validated @RequestBody OrderDTO order) throws OrderNotFoundException, DatabaseException {
			                      
		
		List<OrderDTO> orders = orderService.updateOrder(order);
		
		return new ResponseEntity<List<OrderDTO>>(orders,HttpStatus.OK);
	}
	
	
	@ApiOperation(value="Get orders by date")
	@GetMapping("/orders/bydate/{date}")
	public ResponseEntity<List<OrderDTO>> getAllOrdersByDate (@PathVariable("date") String dateInput) throws OrderNotFoundException {
		
		LocalDate date = LocalDate.parse(dateInput);
	                                     
		List<OrderDTO> orders = orderService.findOrdersByDate(date);
		
		return new ResponseEntity<List<OrderDTO>>(orders,HttpStatus.OK);
	}

}