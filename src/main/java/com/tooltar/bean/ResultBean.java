package com.tooltar.bean;

import java.io.Serializable;

public class ResultBean implements Serializable{
	
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = -3654935094513717654L;
	//状态0为失败error
	//状态1为成功success
	private Integer state;
	//返回处理详情
	private String message;
	//如需跳转页面返回url
	private String url;
	
	public ResultBean() {
		super();
	}
	public ResultBean(Integer state, String message, String url) {
		super();
		this.state = state;
		this.message = message;
		this.url = url;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultBean other = (ResultBean) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ResultBean [state=" + state + ", message=" + message + ", url=" + url + "]";
	}
	
}
