package com.vex.videoexam.service;

import java.io.File;

public interface FileService {

	int upload(File file ,String uploadPath , String webPath);
	
	boolean delete(int fileId);
	
}