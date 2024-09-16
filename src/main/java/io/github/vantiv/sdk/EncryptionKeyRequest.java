package io.github.vantiv.sdk;

import io.github.vantiv.sdk.generate.EncryptionKeyRequestEnum;
import io.github.vantiv.sdk.generate.TransactionType;
import io.github.vantiv.sdk.generate.TransactionTypeWithReportGroup;

public class EncryptionKeyRequest extends TransactionType {
    EncryptionKeyRequestEnum encryptionKeyRequest;

        public EncryptionKeyRequestEnum getEncryptionKeyRequest() {
            return encryptionKeyRequest;
        }

        public void setEncryptionKeyRequest(EncryptionKeyRequestEnum encryptionKeyRequest) {
            this.encryptionKeyRequest = encryptionKeyRequest;
        }

}
