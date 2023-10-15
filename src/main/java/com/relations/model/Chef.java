package com.relations.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Chef extends Employee {
	private String departement;

}
