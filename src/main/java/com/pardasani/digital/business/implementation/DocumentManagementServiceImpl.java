package com.pardasani.digital.business.implementation;

import com.google.common.collect.ImmutableMap;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.pardasani.digital.business.AccountService;
import com.pardasani.digital.business.DocumentManagementService;
import com.pardasani.digital.domain.DropletUser;
import com.pardasani.digital.dto.APIOptions;
import com.pardasani.digital.exception.MediaManagementException;
import com.pardasani.digital.repository.AccountRepository;
import com.pardasani.digital.repository.DocumentStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pankajpardasani on 10/03/2016.
 */
@Service
@Transactional
public class DocumentManagementServiceImpl implements DocumentManagementService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private DocumentStoreRepository dmsRepository;


    @Override
    public URL addNewDocument(APIOptions apiOptions) {
        try {
            DropletUser userAccount = accountRepository.findByUserNameEmail(apiOptions.getUserEmailAddress());
            if(null == userAccount) throw new MediaManagementException("Unknown user and hence cannot save the content from Anonymous user");

            APIOptions moreOptions = new APIOptions.APIOptionsBuilder()
                    .withDocumentStream(apiOptions.getDocumentFile().getInputStream())
                    .withDocumentFileName(apiOptions.getDocumentFile().getOriginalFilename())
                    .withDocumentType(apiOptions.getDocumentFile().getContentType())
                    .withDocumentMetaData(ImmutableMap.of("userId", userAccount.getUserNameEmail()))
                    .build();

            Object fileID = dmsRepository.insertNewDocument(moreOptions);

            //Get the direct URL

            //Add the reference in User collection
            if(CollectionUtils.isEmpty(userAccount.getDropFiles())) {
                userAccount.setDropFiles(Arrays.<Object>asList(fileID));
            }
            else {
                userAccount.getDropFiles().add(fileID);
            }

            accountRepository.updateAccount(userAccount);

            return new URL(""); //TODO: Get the short url from the missing step above and pass it back to the client
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
