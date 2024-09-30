package io.github.vantiv.sdk;

import io.github.vantiv.sdk.generate.EncryptionKeyRequestEnum;

public class EncryptionKeyRequest {
    EncryptionKeyRequestEnum encryptionKeyRequest;

    public EncryptionKeyRequestEnum getEncryptionKeyRequest() {
        return encryptionKeyRequest;
    }

    public void setEncryptionKeyRequest(EncryptionKeyRequestEnum encryptionKeyRequest) {
        this.encryptionKeyRequest = encryptionKeyRequest;
    }
}