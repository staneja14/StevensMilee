package com.stevensportal.coursesreview.contract.response.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author staneja14
 *
 */
@JsonInclude(Include.NON_NULL)
public class ResponseDTO<T> extends BaseResponse {
	
	private T data;
	private String message;
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ResponseDTO [data=" + data + ", message=" + message + "]";
	}
}
