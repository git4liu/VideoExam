package com.vex.videoexam.action;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.vex.videoexam.service.FileService;

@Component("file")
@Scope("prototype")
public class FileAction extends ActionSupport {
	
	public String delete(){
		return SUCCESS;
	}
	
	public String upload(){
		HttpServletRequest request = ServletActionContext.getRequest();
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/");  
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        String webPath = "";
        if(file != null){
        	webPath = "upload/" + file.getName();
        	uploadPath = uploadPath + "upload\\" + file.getName();
        	picId = fileService.upload(file, uploadPath, webPath);
        	if(picId == 0)
        		return "fail";
        	
        }
        webAddr = webPath;
		return SUCCESS;
	}

	private File file;
	
	private String localAddr;
	
	private String webAddr;
	
	private FileService fileService;
	
	private int picId;

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getLocalAddr() {
		return localAddr;
	}

	public void setLocalAddr(String localAddr) {
		this.localAddr = localAddr;
	}

	public String getWebAddr() {
		return webAddr;
	}

	public void setWebAddr(String webAddr) {
		this.webAddr = webAddr;
	}

	public FileService getFileService() {
		return fileService;
	}

	@Resource(name="fileService")
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public int getPicId() {
		return picId;
	}

	public void setPicId(int picId) {
		this.picId = picId;
	}
	
	
}
