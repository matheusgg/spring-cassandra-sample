package br.com.spring.cassandra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.io.Serializable;

import static org.springframework.cassandra.core.PrimaryKeyType.PARTITIONED;

@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyClass
public class QuotePK implements Serializable {

	private static final long serialVersionUID = 7578789327848481836L;

	@PrimaryKeyColumn(ordinal = 6)
	private String id;

	@PrimaryKeyColumn(ordinal = 1, type = PARTITIONED)
	private Integer serviceId;

	@PrimaryKeyColumn(ordinal = 2, type = PARTITIONED)
	private Integer zipStart;

	@PrimaryKeyColumn(ordinal = 3, type = PARTITIONED)
	private Double weightStart;

	@PrimaryKeyColumn(ordinal = 4)
	private Integer zipEnd;

	@PrimaryKeyColumn(ordinal = 5)
	private Double weightEnd;

}
