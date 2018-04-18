package com.springboot.jackson.selfenum;

public enum SexEnum {
	MAN("M", "m"), WOMAN("F", "f");

	private String merChantCode;
	private String nativeCode;

	SexEnum(String merChantCode, String nativeCode) {
		this.merChantCode = merChantCode;
		this.nativeCode = nativeCode;
	}

	public String getMerChantCode() {
		return merChantCode;
	}

	public void setMerChantCode(String merChantCode) {
		this.merChantCode = merChantCode;
	}

	public String getNativeCode() {
		return nativeCode;
	}

	public void setNativeCode(String nativeCode) {
		this.nativeCode = nativeCode;
	}
	/**
	 * 用于序列化进JSON字符串中的值
	 */
	@Override
	public String toString() {
		return this.getMerChantCode();
	}
}
