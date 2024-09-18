package io.github.vantiv.sdk;

import io.github.vantiv.sdk.generate.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestTxnForEncryption {
    private static CnpOnline cnp;
    private Properties config;
    @BeforeClass
    public static void beforeClass() throws Exception {
        cnp = new CnpOnline();
    }

    /*@Before
    public void setup() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new Configuration().location()));
        String merchantId = properties.getProperty("merchantId");
        String isEncryptedPayload=properties.getProperty("isEncryptedPayload");
        String encyptionKeySeq=properties.getProperty("keySequence");
        config = new Properties();
        config.setProperty("isEncryptedPayload", isEncryptedPayload);
        config.setProperty("keySequence", encyptionKeySeq);
        config.setProperty("merchantId", merchantId);

    }*/
    @Test
    public void simpleAuthForEncryption() throws Exception {
        Authorization authorization = new Authorization();
        authorization.setReportGroup("abc");
        authorization.setOrderId("12344");
        authorization.setAmount(106L);
        authorization.setOrderSource(OrderSourceType.ECOMMERCE);
        authorization.setId("id");
        CardType card = new CardType();
        card.setType(MethodOfPaymentTypeEnum.VI);
        card.setNumber("4100000000000001");
        card.setExpDate("1210");
        authorization.setCard(card);
        AuthorizationResponse response = cnp.authorize(authorization);
        assertEquals("abc",response.getReportGroup());
        assertEquals("sandbox", response.getLocation());
    }

    @Test
    public void testEncryptionKeyRequest() throws Exception {
        EncryptionKeyRequest request = new EncryptionKeyRequest();
        request.setEncryptionKeyRequest(EncryptionKeyRequestEnum.CURRENT);
        EncryptionKeyResponse response = cnp.encryptionKeyRequest(request.getEncryptionKeyRequest());
        assertNotNull(response);
    }
}