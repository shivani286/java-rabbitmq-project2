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
@Table(name = "policy")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Policy implements Serializable {

	
	public Policy(Integer policyId , String quotenumber, String policytype, String status) {
		this.policyId =  policyId;
		this.quotenumber =  quotenumber;
		this.policytype =  policytype;
		this.status = status;
	}

	private static final long serialVersionUID = 4107787201307739451L;
	@Id
	@Column(name = "policy_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer policyId;
	
	@Column(name = "quote_number")
	private String quotenumber;
	
	@Column(name = "policy_type")
	private String policytype;
	
	@Column(name = "status")
    private String status;
}
