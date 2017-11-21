package com.cnp.sdk;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cnp.sdk.CnpOnline;
import com.cnp.sdk.generate.ApplepayHeaderType;
import com.cnp.sdk.generate.ApplepayType;
import com.cnp.sdk.generate.CardTokenType;
import com.cnp.sdk.generate.CardType;
import com.cnp.sdk.generate.MethodOfPaymentTypeEnum;
import com.cnp.sdk.generate.OrderSourceType;
import com.cnp.sdk.generate.PayPal;
import com.cnp.sdk.generate.ProcessingTypeEnum;
import com.cnp.sdk.generate.Sale;
import com.cnp.sdk.generate.SaleResponse;
import com.cnp.sdk.generate.SepaDirectDebitType;

public class TestSale {

	private static CnpOnline cnp;

	@BeforeClass
	public static void beforeClass() throws Exception {
		cnp = new CnpOnline();
	}
	
	@Test
	public void simpleSaleWithCard() throws Exception{
		Sale sale = new Sale();
		sale.setAmount(106L);
		sale.setCnpTxnId(123456L);
		sale.setOrderId("12344");
		sale.setOrderSource(OrderSourceType.ECOMMERCE);
		CardType card = new CardType();
		card.setType(MethodOfPaymentTypeEnum.VI);
		card.setNumber("4100000000000000");
		card.setExpDate("1210");
		sale.setCard(card);
		sale.setId("id");
		SaleResponse response = cnp.sale(sale);
		assertEquals("Approved", response.getMessage());
	}
	
	@Test
	public void simpleSaleWithPayPal() throws Exception{
		Sale sale = new Sale();
		sale.setAmount(106L);
		sale.setCnpTxnId(123456L);
		sale.setOrderId("12344");
		sale.setOrderSource(OrderSourceType.ECOMMERCE);
		PayPal paypal = new PayPal();
		paypal.setPayerId("1234");
		paypal.setToken("1234");
		paypal.setTransactionId("123456");
		sale.setPaypal(paypal);
	    sale.setId("id");
		SaleResponse response = cnp.sale(sale);
		assertEquals("Approved", response.getMessage());
	}
	
	@Test
    public void simpleSaleWithApplepayAndSecondaryAmount() throws Exception{
        Sale sale = new Sale();
        sale.setAmount(110L);
        sale.setSecondaryAmount(20L);
        sale.setCnpTxnId(123456L);
        sale.setOrderId("12347");
        sale.setOrderSource(OrderSourceType.ECOMMERCE);

        ApplepayType applepayType = new ApplepayType();
        ApplepayHeaderType applepayHeaderType = new ApplepayHeaderType();
        applepayHeaderType.setApplicationData("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855");
        applepayHeaderType.setEphemeralPublicKey("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855");
        applepayHeaderType.setPublicKeyHash("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855");
        applepayHeaderType.setTransactionId("1234");
        applepayType.setHeader(applepayHeaderType);
        applepayType.setData("user");
        applepayType.setSignature("sign");
        applepayType.setVersion("12345");

        sale.setApplepay(applepayType);
        sale.setId("id");
        SaleResponse response = cnp.sale(sale);
        assertEquals("Insufficient Funds", response.getMessage());
        assertEquals(new Long(110),response.getApplepayResponse().getTransactionAmount());
    }
	
	@Test
	public void simpleSaleWithToken() throws Exception {
		Sale sale = new Sale();
		sale.setAmount(106L);
		sale.setOrderId("12344");
		sale.setOrderSource(OrderSourceType.ECOMMERCE);
		CardTokenType token = new CardTokenType();
		token.setCardValidationNum("349");
		token.setExpDate("1214");
		token.setCnpToken("1111222233334000");
		token.setType(MethodOfPaymentTypeEnum.VI);
		sale.setToken(token);
	    sale.setId("id");
		SaleResponse response = cnp.sale(sale);
		assertEquals("Approved", response.getMessage());
	}
	
	@Test
	public void testSaleWithSEPA() throws Exception{
		Sale sale = new Sale();
		sale.setAmount(106L);
		sale.setCnpTxnId(123456L);
		sale.setOrderId("12344");
		sale.setOrderSource(OrderSourceType.ECOMMERCE);
		SepaDirectDebitType sepa = new SepaDirectDebitType();
		sepa.setIban("ZZ79850503003100180568");
		sepa.setMandateProvider("Vantiv");
		sepa.setSequenceType("OneTime");
		sepa.setMandateUrl("http://mandate.url");
		sale.setSepaDirectDebit(sepa);
		sale.setId("id");
		SaleResponse response = cnp.sale(sale);
		assertEquals("Approved", response.getMessage());
		assertEquals("http://redirect.url.vantiv.com", response.getSepaDirectDebitResponse().getRedirectUrl());
	}
	
	@Test
	public void testSaleWithProcessingTypeAndOrigTxnIdAndAmount() throws Exception{
		Sale sale = new Sale();
		sale.setAmount(106L);
		sale.setCnpTxnId(123456L);
		sale.setOrderId("12344");
		sale.setOrderSource(OrderSourceType.ECOMMERCE);
		CardType card = new CardType();
		card.setType(MethodOfPaymentTypeEnum.VI);
		card.setNumber("4100000000000000");
		card.setExpDate("1210");
		sale.setCard(card);
		sale.setId("id");
		sale.setProcessingType(ProcessingTypeEnum.INITIAL_INSTALLMENT);
		sale.setOriginalNetworkTransactionId("1029384756");
		sale.setOriginalTransactionAmount(4242l);
		SaleResponse response = cnp.sale(sale);
		assertEquals("Approved", response.getMessage());
	}
}