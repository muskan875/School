package com.school;

public class Notice {
   private int id;
	private String notice;
	
	 public String getNotice() {
	        return notice;
	    }

	    public void setNotice(int id) {
	        this.notice = notice;
	    }
	    
	    public int getInt() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }
	    
	    public Notice(int id, String notice) {
	        this.id = id;
	        this.notice = notice;
}
}