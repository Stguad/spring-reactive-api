package com.springboot.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.reactive.model.Invoice;
import com.springboot.reactive.service.IInvoiceService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/invoice")
public class InvoiceRestController {

	
	@Autowired
	private IInvoiceService service;
	
	
	@PostMapping("/save")
	public Mono<Invoice> saveInvoice(@RequestBody Invoice invoice){
		return service.saveInvoice(invoice);
	}
	
	@GetMapping("/allInvoices")
	public Flux<Invoice> getAll(){
		return service.findAllInvoices();
	}
	
	@GetMapping("/get/{id}")
	public Mono<Invoice> getOne(@PathVariable Integer id){
		return service.getOneInvoice(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public Mono<String> deleteInvoice(@PathVariable Integer id){
		service.deleteInvoice(id);
		return Mono.just("Invoice with id: " + id + "deleted!" );
	}
	
}
