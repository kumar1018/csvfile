package com.example.csv.model;

public class ReponseMessage {
	
	
	private String message;
	private String fileDownloadUri;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFileDownloadUri() {
		return fileDownloadUri;
	}
	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}
	@Override
	public String toString() {
		return "ReponseMessage [message=" + message + ", fileDownloadUri=" + fileDownloadUri + "]";
	}

	
	

}
