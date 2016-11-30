package br.com.spring.cassandra;

import br.com.spring.cassandra.model.Quote;
import br.com.spring.cassandra.model.repository.QuoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * http://www.tutorialspoint.com/cassandra/index.htm
 */
@AllArgsConstructor
@SpringBootApplication
public class SpringCassandraSampleApplication implements CommandLineRunner {

	private QuoteRepository repository;

	public static void main(final String[] args) {
		SpringApplication.run(SpringCassandraSampleApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {
		/*try (final Stream<String> lines = Files.lines(new ClassPathResource("Spin_Tabela.csv").getFile().toPath())) {
			final List<Quote> quotes = lines.map(line -> {
				final String[] parts = line.split("\\|");
				final String id = UUIDs.random().toString();
				final Integer serviceId = Integer.valueOf(parts[3]);
				final Integer zipStart = Integer.valueOf(parts[4]);
				final Integer zipEnd = Integer.valueOf(parts[5]);
				final Double weightStart = Double.valueOf(parts[6].replace(",", "."));
				final Double weightEnd = Double.valueOf(parts[7].replace(",", "."));
				final QuotePK pk = new QuotePK(id, serviceId, zipStart, weightStart, zipEnd, weightEnd);
				return new Quote(pk, "Description " + id);
			}).collect(Collectors.toList());

			quotes.forEach(this.repository::save);

			System.out.println("OK");
		}*/

		final Instant start = Instant.now();
		final List<Quote> result = this.repository.findQuotes(1, 35767150, 12);
		final Instant end = Instant.now();
		System.out.println("Total time: " + start.until(end, ChronoUnit.MILLIS)); // ~ 1850 ms
	}
}
