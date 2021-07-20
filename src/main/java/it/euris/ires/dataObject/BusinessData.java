package it.euris.ires.dataObject;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class BusinessData {

	private String accountId;

	private String paymentConfigId;

	private String consumerId;

}
