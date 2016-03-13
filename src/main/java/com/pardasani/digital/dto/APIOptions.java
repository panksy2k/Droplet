package com.pardasani.digital.dto;

import org.springframework.http.MediaType;

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

    public APIOptions(APIOptionsBuilder builder) {
        this.documentMetaData = builder.documentMetaData;
        this.fileName = builder.fileName;
        this.documentType = builder.documentType;
        this.documentStream = builder.documentStream;
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

    public static class APIOptionsBuilder <T> {
        private Map<String, T> documentMetaData;
        private String fileName;
        private String documentType;
        private InputStream documentStream;

        public APIOptionsBuilder withDocumentMetaData(Map<String, T> metaDataMap) {
            this.documentMetaData = metaDataMap;
            return this;
        }

        public APIOptionsBuilder withDocumentFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public APIOptionsBuilder withDocumentType(MediaType documentType) {
            this.documentType = documentType.getType();
            return this;
        }

        public APIOptionsBuilder withDocumentStream(InputStream stream) {
            this.documentStream = stream;
            return this;
        }

        public APIOptions build() {
            return new APIOptions(this);
        }
    }
}
