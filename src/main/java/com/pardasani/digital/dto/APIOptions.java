package com.pardasani.digital.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by pankajpardasani on 10/03/2016.
 */
public class APIOptions<T> {
    private Map<String, T> documentMetaData;
    private String fileName;
    private String documentType;
    private InputStream documentStream;
    private MultipartFile documentFile;
    private Object documentId;
    private String userEmailAddress;

    public APIOptions(APIOptionsBuilder builder) {
        this.documentMetaData = builder.documentMetaData;
        this.fileName = builder.fileName;
        this.documentType = builder.documentType;
        this.documentStream = builder.documentStream;
        this.documentId = builder.fileObjectId;
        this.documentFile = builder.documentFile;
        this.userEmailAddress = builder.userEmailId;
    }

    public Map<String, T> getDocumentMetaData() {
        return documentMetaData;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public InputStream getDocumentStream() {
        return documentStream;
    }

    public Object getDocumentId() {
        return documentId;
    }

    public MultipartFile getDocumentFile() {
        return documentFile;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public static class APIOptionsBuilder <T> {
        private Map<String, T> documentMetaData;
        private String fileName;
        private String documentType;
        private InputStream documentStream;
        private Object fileObjectId;
        private MultipartFile documentFile;
        private String userEmailId;

        public APIOptionsBuilder withDocumentId(Object id) {
            this.fileObjectId = id;
            return this;
        }

        public APIOptionsBuilder withDocumentMetaData(Map<String, T> metaDataMap) {
            this.documentMetaData = metaDataMap;
            return this;
        }

        public APIOptionsBuilder withDocumentFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public APIOptionsBuilder withDocumentType(String documentType) {
            this.documentType = documentType;
            return this;
        }

        public APIOptionsBuilder withDocumentStream(InputStream stream) {
            this.documentStream = stream;
            return this;
        }

        public APIOptionsBuilder withMultipartFile(MultipartFile document) {
            this.documentFile = document;
            return this;
        }

        public APIOptionsBuilder withUserEmail(String userEmail) {
            this.userEmailId = userEmail;
            return this;
        }

        public APIOptions build() {
            return new APIOptions(this);
        }
    }
}
