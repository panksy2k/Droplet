package com.pardasani.digital.repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSFile;
import com.pardasani.digital.dto.APIOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;



/**
 * Created by pankajpardasani on 10/03/2016.
 */
@Repository("dmsRepository")
public class DocumentStoreRepository {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    public Object insertNewDocument(APIOptions options) {
        DBObject metaData = new BasicDBObject(options.getDocumentMetaData());
        GridFSFile persistedFile = gridFsTemplate.store(options.getDocumentStream(), options.getFileName(),
              options.getDocumentType(), metaData);

        return persistedFile.getId();
    }
}
