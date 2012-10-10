/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author NGUYEN
 */
public final class FileUpload {

    private File file;
    private String uploadDirPath;
    private HttpServletRequest request;

    public FileUpload(String uploadDirPath, HttpServletRequest request) {
        this.uploadDirPath = uploadDirPath;
        this.request = request;
    }

    public String getUploadDirPath() {
        return uploadDirPath;
    }

    public void setUploadDirPath(String uploadDirPath) {
        this.uploadDirPath = uploadDirPath;
    }

    public boolean save() {
        try {
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart) {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List items = upload.parseRequest(request);
                Iterator iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    if (!item.isFormField()) {
                        String fileName = item.getName();
                        file = new File(uploadDirPath + "\\" + fileName);
                        item.write(file);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
