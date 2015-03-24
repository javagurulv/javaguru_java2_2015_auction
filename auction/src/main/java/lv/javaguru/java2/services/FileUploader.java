package lv.javaguru.java2.services;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created by Vladislav on 3/21/2015.
 */

@Component
public class FileUploader {
    private String UPLOAD_DIRECTORY;

    public void uploadAvatar(HttpServletRequest request){
        UPLOAD_DIRECTORY = "D:\\Programming\\Idea Projects\\WebDev\\javaguru_java2_2015_auction\\auction\\src\\main\\webapp\\uploads\\avatars";
        upload(request);
    }


    private void upload(HttpServletRequest request){

        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                System.out.println(multiparts.size());
                for (FileItem item : multiparts) {
                    System.out.println("ITEM IN FIELDSET");
                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
                        System.out.println("UPLOADING");
                    }
                    else System.out.println("NOT A FORM FIELD");
                }
            }catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("ERROR");
            }
            System.out.println("PROCESSED");
        }
        else{
            System.out.println("IT is NOT A MULTIPART");
        }
    }
}
