package com.demo.myticket.util;

import java.util.HashMap;
import java.util.Map;

import com.demo.myticketexception.InsufficientAmountException;

public class PaymentUtils {
	private static Map<String,Double> paymentMap=new HashMap<String, Double>();

	static {
		paymentMap.put("acc1", 17000.0);
		paymentMap.put("acc2", 10000.0);
		paymentMap.put("acc3", 8000.0);
		paymentMap.put("acc4", 13000.0);
	}
	
	public static boolean validateCredentialLimit(String accNo,double paidAmount) {
		if(paidAmount>paymentMap.get(accNo))
		{
			throw new InsufficientAmountException("insufficient amount");
		}else {
			return true;
		}
	}
}
