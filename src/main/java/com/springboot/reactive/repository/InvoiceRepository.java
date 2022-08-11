package com.springboot.reactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.springboot.reactive.model.Invoice;

public interface InvoiceRepository extends ReactiveMongoRepository<Invoice, Integer>{

	
}
