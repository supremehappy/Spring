package model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Notice {
	
		private	int seq;
		private String admin_id	;
		private	int header_id;
		@NotEmpty(message="제목 입력")
		private String post_title;
		@Min(0)
		@NotNull(message="비번 입력")
		private	int post_pw;
		private String reg_date;
		@NotEmpty(message="내용 입력")
		private String post_content;
		private String image1;
		private String image2;
		private String image3;
		private String image4	;
		private String image5;
		private	int view_count;
		private MultipartFile image;
		private String header_name;
		
		public int getSeq() {
			return seq;
		}
		public void setSeq(int seq) {
			this.seq = seq;
		}
		public String getAdmin_id() {
			return admin_id;
		}
		public void setAdmin_id(String admin_id) {
			this.admin_id = admin_id;
		}
		public int getHeader_id() {
			return header_id;
		}
		public void setHeader_id(int header_id) {
			this.header_id = header_id;
		}
		public String getPost_title() {
			return post_title;
		}
		public void setPost_title(String post_title) {
			this.post_title = post_title;
		}
		public int getPost_pw() {
			return post_pw;
		}
		public void setPost_pw(int post_pw) {
			this.post_pw = post_pw;
		}
		public String getReg_date() {
			return reg_date;
		}
		public void setReg_date(String reg_date) {
			this.reg_date = reg_date;
		}
		public String getPost_content() {
			return post_content;
		}
		public void setPost_content(String post_content) {
			this.post_content = post_content;
		}
		public String getImage1() {
			return image1;
		}
		public void setImage1(String image1) {
			this.image1 = image1;
		}
		public String getImage2() {
			return image2;
		}
		public void setImage2(String image2) {
			this.image2 = image2;
		}
		public String getImage3() {
			return image3;
		}
		public void setImage3(String image3) {
			this.image3 = image3;
		}
		public String getImage4() {
			return image4;
		}
		public void setImage4(String image4) {
			this.image4 = image4;
		}
		public String getImage5() {
			return image5;
		}
		public void setImage5(String image5) {
			this.image5 = image5;
		}
		public int getView_count() {
			return view_count;
		}
		public void setView_count(int view_count) {
			this.view_count = view_count;
		}
		public MultipartFile getImage() {
			return image;
		}
		public void setImage(MultipartFile image) {
			this.image = image;
		}
		public String getHeader_name() {
			return header_name;
		}
		public void setHeader_name(String header_name) {
			this.header_name = header_name;
		}
		
}
