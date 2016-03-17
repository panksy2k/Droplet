package com.pardasani.digital.repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.pardasani.digital.dto.APIOptions;
import com.pardasani.digital.exception.MediaManagementException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.gridfs.GridFsCriteria.*;

import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;


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

    public GridFSDBFile getDocumentById(APIOptions option) {
        List<GridFSDBFile> documents = gridFsTemplate.find(query(whereFilename().is(option.getDocumentId())));
        if(CollectionUtils.isEmpty(documents)) throw new MediaManagementException("Document does not exist -- against the id");
        if(documents.size() > 1) throw new MediaManagementException("More than one document exist against same Id");

        return documents.get(0);
    }
}
