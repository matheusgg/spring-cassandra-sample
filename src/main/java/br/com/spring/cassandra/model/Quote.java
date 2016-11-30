package br.com.spring.cassandra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Quote implements Serializable {

	private static final long serialVersionUID = -393759833111532678L;

	@PrimaryKey
	private QuotePK pk;
	private String description;

}
