package com.study.dvd.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Producer {
	private int producer_id;
	private String producer_name;
	
}
