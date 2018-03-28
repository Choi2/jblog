package com.cafe24.jblog.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	private static final String SAVE_PATH = "/jblog";
	private static final String PREFIX_URL = "/jblog/admin/image/";
	private static final String FILE_PATH = "c:/jblog";

	public String restore(MultipartFile multipartFile) {

		String url = "";
		
		try {
			File file = new File(FILE_PATH);  //해당 디렉토리의 존재여부를 확인

			if(!file.exists()){
				file.mkdirs();   //없다면 생성
			}
			
			String originFilename = multipartFile.getOriginalFilename();
			String extName = originFilename.substring(originFilename.length());
			Long size = multipartFile.getSize();
			String saveFilename = genSaveFilename(extName);

			System.out.println("#########" + originFilename);
			System.out.println("#########" + extName);
			System.out.println("#########" + size);
			System.out.println("######### " + saveFilename);

			writeFile(multipartFile, saveFilename);
			
			url = PREFIX_URL + saveFilename;
			
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}

		return url;
	}

	public void writeFile(MultipartFile multipartFile, String saveFilename) throws IOException {
		byte[] fileData = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
		fos.write(fileData);
		fos.close();
	}
	

	private String genSaveFilename(String extName) {

		String filename = "";
		Calendar calendar = Calendar.getInstance();
		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += extName;

		return filename;
	}

}
