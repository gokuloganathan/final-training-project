package com.supermarket.billing.ExceptionCentral;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillErrorInfo {
	private int errorCode;
	private String errorMessage;
	private LocalDateTime timestampDateTime;
}
