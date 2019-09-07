package com.day26.web.action;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import utils.CommonUtils;


public class UploadAction extends ActionSupport{
		private File photo;
		private String photoContentType;
		private String photoFileName;
		public String upload() {
			String path=ServletActionContext.getServletContext().getRealPath("/WEB-INF/files/");
			//生成两级名称
			String filename=photoFileName;
			System.out.println(photoFileName+"|"+photoContentType);
			
			int index=filename.lastIndexOf("\\");
			if (index!=-1) {
				filename=filename.substring(index+1);
			}
			
			
			String savename=CommonUtils.UUID()+"_"+filename;
			//得到hashcode
			int hcode=filename.hashCode();
			String hex=Integer.toHexString(hcode);
			//获取前两个字母
			
			File dirFile=new File(path,hex.charAt(0)+"/"+hex.charAt(1));
			//创建目录链
			dirFile.mkdirs();
			//创建目录文件
			File desFile=new File(dirFile,savename);
			photo.renameTo(desFile);
			return NONE;
		}

		@Override
		public String toString() {
			return "UploadAction [photo=" + photo + ", photoContentType=" + photoContentType + ", photoFileName="
					+ photoFileName + "]";
		}

		public String getPhotoContentType() {
			return photoContentType;
		}

		public void setPhotoContentType(String photoContentType) {
			this.photoContentType = photoContentType;
		}

		public String getPhotoFileName() {
			return photoFileName;
		}

		public void setPhotoFileName(String photoFileName) {
			this.photoFileName = photoFileName;
		}

		public File getPhoto() {
			return photo;
		}

		public void setPhoto(File photo) {
			this.photo = photo;
		}
		

}
