package io.github.vantiv.sdk;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import io.github.vantiv.sdk.generate.EncryptionKeyRequestEnum;
import io.github.vantiv.sdk.generate.EncryptionKeyResponse;

public class TestEncryptionKeyRequest {
    private static CnpOnline cnp;

    @BeforeClass
    public static void beforeClass() throws Exception {
        cnp = new CnpOnline();
    }

    @Test
    public void testEncryptionKeyRequest() throws Exception {
        EncryptionKeyRequest request = new EncryptionKeyRequest();
        request.setEncryptionKeyRequest(EncryptionKeyRequestEnum.CURRENT);
        EncryptionKeyResponse response = cnp.encryptionKeyRequest(request.getEncryptionKeyRequest());
        assertNotNull(response);
    }
}