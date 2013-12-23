package com.vex.videoexam.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.ExampicDao;
import com.vex.videoexam.model.Exampic;
import com.vex.videoexam.service.FileService;

@Component("fileService")
public class FileServiceImpl implements FileService{

	private ExampicDao exampicDao;
	

	public ExampicDao getExampicDao() {
		return exampicDao;
	}

	@Resource(name="exampicDao")
	public void setExampicDao(ExampicDao exampicDao) {
		this.exampicDao = exampicDao;
	}

	@Override
	public int upload(File file ,String uploadPath ,String webPath){
	
       int id = 0;
       file.renameTo(new File(uploadPath));
       Exampic exampic = new Exampic();
       exampic.setAddr(webPath);
       exampic.setTime(new Date().toString());
       id = exampicDao.save(exampic);
       return id;
	}
	
	@Override
	public boolean delete(int fileId) {
		return false;
	}
}
