package com.springboot.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.reactive.model.Invoice;
import com.springboot.reactive.repository.InvoiceRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service 
public class InvoiceServiceImpl implements IInvoiceService{


	@Autowired
	private InvoiceRepository repository;
	
	@Override
	public Mono<Invoice> saveInvoice(Invoice invoice) {
		return repository.save(invoice);
		//for Mono<String> return type
		 //return Mono.just("saved successfully");
	}

	@Override
	public Flux<Invoice> findAllInvoices() {
		return repository.findAll().switchIfEmpty(Flux.empty());
	}

	@Override
	public Mono<Invoice> getOneInvoice(Integer id) {
		return repository.findById(id).switchIfEmpty(Mono.empty());
	}

	@Override
	public Mono<Void> deleteInvoice(Integer id) {
		return repository.deleteById(id);
	}



}
