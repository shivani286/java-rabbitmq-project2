package com.rabbitmq.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "policy_table")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MyBatisObject implements Serializable {

	private static final long serialVersionUID = 7403815385432155605L;

		@Id
		@Column(name = "id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		
		@Column(name = "quote_number")
		private String quotenumber;
		
		@Column(name = "status")
	    private String status;
}
