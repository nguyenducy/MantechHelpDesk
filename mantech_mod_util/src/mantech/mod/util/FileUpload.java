/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.util;

import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author NGUYEN
 */
public class FileUpload {

    private String uploadDirPath;
    private HttpServletRequest request;
    private String fileName = null;
    private Hashtable hashtable;
    private FileItem item;

    //Khởi tạo FileUpload
    //@uploadDirPath đường dẫn thư mục muốn lưu file
    //@request request của servlet
    public FileUpload(String uploadDirPath, HttpServletRequest request) {
        this.uploadDirPath = uploadDirPath;
        this.request = request;

        this.getIterator();
    }
    //Khởi tạo FileUpload
    //@uploadDirPath đường dẫn thư mục muốn lưu file
    //@request request của servlet
    //@fileRename tên file ban muốn lưu

    public FileUpload(String uploadDirPath, HttpServletRequest request, String fileRename) {
        this.uploadDirPath = uploadDirPath;
        this.request = request;
        this.fileName = fileRename;
        this.getIterator();
    }
    //Lấy tên file.

    public String getFileName() {
//         if (fileName == null) {
//            fileName = item.getName();
//        }
            //else {
//            String[] extendFileName = item.getName().split("[.]");
//            fileName += "." + extendFileName[1];
//        }
        return fileName;
    }

    public String getUploadDirPath() {
        return uploadDirPath;
    }

    public void setUploadDirPath(String uploadDirPath) {
        this.uploadDirPath = uploadDirPath;
    }
    //Lấy các parameter trong request.

    public Hashtable getParameter() {
        return this.hashtable;
    }

    private void getIterator() {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        Iterator iter = null;
        Hashtable hashtable = new Hashtable();
        if (isMultipart) {
            try {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List items = upload.parseRequest(request);
                iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem i = (FileItem) iter.next();
                    if (i.isFormField()) {
                        hashtable.put(i.getFieldName(), i.getString());
                    } else {
                        this.item = i;
                    }
                }

            } catch (FileUploadException ex) {
                ex.printStackTrace();
            }
        }
        this.hashtable = hashtable;
    }
    //Lưu file vào server.

    public boolean save() {
        boolean check = false;
        try {
            String nameFile = this.getFileName();
            File file = new File(uploadDirPath + "\\" + nameFile);
          
            item.write(file);

            check = true;
        } catch (Exception ex) {
            check = false;
            ex.printStackTrace();
        }
        return check;
    }
}
