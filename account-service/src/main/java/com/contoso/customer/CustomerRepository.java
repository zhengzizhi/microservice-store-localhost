package com.contoso.customer;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * A {@link PagingAndSortingRepository} for the {@link Customer} domain class that provides
 * basic data management capabilities that include paging and sorting results.
 *
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
