package com.pardasani.digital.business;

import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.pardasani.digital.dto.APIOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by pankajpardasani on 10/03/2016.
 */

@Service("dms")
public interface DocumentManagementService {
    Object addNewDocument(MultipartFile file);
    GridFSDBFile getDocumentFile(Object documentId);
    List<GridFSFile> getDocumentList(APIOptions fileOptions);
    Long updateDocument(APIOptions fileOptions);
    boolean removeDocument(Long documentId);
}
