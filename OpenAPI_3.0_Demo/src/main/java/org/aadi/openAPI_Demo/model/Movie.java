package org.aadi.openAPI_Demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	@NotBlank
    @Size(min = 0, max = 20)
	private String title;

	@Column
	@NotBlank
    @Size(min = 0, max = 20)
	private String director;

	@Column
	@NotBlank
	private String price;

}
