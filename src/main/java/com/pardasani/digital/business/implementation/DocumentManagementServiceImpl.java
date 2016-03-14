package com.pardasani.digital.business.implementation;

import com.google.common.collect.ImmutableMap;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.pardasani.digital.business.DocumentManagementService;
import com.pardasani.digital.dto.APIOptions;
import com.pardasani.digital.exception.MediaManagementException;
import com.pardasani.digital.repository.DocumentStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by pankajpardasani on 10/03/2016.
 */
@Service
public class DocumentManagementServiceImpl implements DocumentManagementService {

    @Autowired
    private DocumentStoreRepository dmsRepository;

    @Override
    public Object addNewDocument(MultipartFile file) {
        try {
            APIOptions options = new APIOptions.APIOptionsBuilder().withDocumentStream(file.getInputStream())
                    .withDocumentFileName(file.getOriginalFilename()).withDocumentType(file.getContentType())
                    .withDocumentMetaData(ImmutableMap.<String, Long>of("length", file.getSize()))
                    .build();

            return dmsRepository.insertNewDocument(options);
        } catch (IOException e) {
            throw new MediaManagementException(e);
        }
    }

    @Override
    public GridFSDBFile getDocumentFile(Object documentId) {
        APIOptions options = new APIOptions.APIOptionsBuilder().withDocumentId(documentId).build();
        return dmsRepository.getDocumentById(options);
    }

    @Override
    public List<GridFSFile> getDocumentList(APIOptions fileOptions) {
        return null;
    }

    @Override
    public Long updateDocument(APIOptions fileOptions) {
        return null;
    }

    @Override
    public boolean removeDocument(Long documentId) {
        return false;
    }
}
