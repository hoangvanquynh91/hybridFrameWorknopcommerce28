package com.jquery.datatable;

import commons.GlobalConstants;

public class testFIlePath {

	public static void main(String[] args) {
		String[] fileName = {"cat.png"};
		String filePath = GlobalConstants.UPLOAD_FILE_FOLDER;
		String fullFileName = "";
		for (String file: fileName) {
			fullFileName = fullFileName +filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		System.out.println(fullFileName);
	}

}
