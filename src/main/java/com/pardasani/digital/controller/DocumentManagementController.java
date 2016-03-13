package com.pardasani.digital.controller;

import com.pardasani.digital.business.DocumentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by pankajpardasani on 12/03/2016.
 */
@Controller
@RequestMapping("/document")
public class DocumentManagementController {

    @Autowired
    private DocumentManagementService dms;

    @RequestMapping(value = "/registration/form", method = RequestMethod.GET)
    public String initDocumentUploadForm() {
        return "/dropContent";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public Object createNewDocument(@RequestParam("file") MultipartFile uploadedDocument) {
        return dms.addNewDocument(uploadedDocument);
    }
}
