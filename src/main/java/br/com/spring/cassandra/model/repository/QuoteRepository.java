package br.com.spring.cassandra.model.repository;

import br.com.spring.cassandra.model.Quote;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface QuoteRepository extends CassandraRepository<Quote> {

	@Query("SELECT * FROM quote WHERE TOKEN(serviceid, zipStart, weightStart) >= TOKEN(?0, ?1, ?2) AND (zipend, weightend) <= (?1, ?2) ALLOW FILTERING;")
	List<Quote> findQuotes(final int serviceId, final int zipCode, final double weight);
}
