package com.cafe24.todaymemo.dto;

public class LanguageDTO {

	
	private int langIdx; 
	private String  langWord;
	private String  langMeaning; 
	private String  langEtc; 
	private int  categoryIdx; 
	private String  langRegId;
	private String  langRegDate;
	public int getLangIdx() {
		return langIdx;
	}
	public void setLangIdx(int langIdx) {
		this.langIdx = langIdx;
	}
	public String getLangWord() {
		return langWord;
	}
	public void setLangWord(String langWord) {
		this.langWord = langWord;
	}
	public String getLangMeaning() {
		return langMeaning;
	}
	public void setLangMeaning(String langMeaning) {
		this.langMeaning = langMeaning;
	}
	public String getLangEtc() {
		return langEtc;
	}
	public void setLangEtc(String langEtc) {
		this.langEtc = langEtc;
	}
	public int getCategoryIdx() {
		return categoryIdx;
	}
	public void setCategoryIdx(int categoryIdx) {
		this.categoryIdx = categoryIdx;
	}
	public String getLangRegId() {
		return langRegId;
	}
	public void setLangRegId(String langRegId) {
		this.langRegId = langRegId;
	}
	public String getLangRegDate() {
		return langRegDate;
	}
	public void setLangRegDate(String langRegDate) {
		this.langRegDate = langRegDate;
	}
	@Override
	public String toString() {
		return "LanguageDTO [langIdx=" + langIdx + ", langWord=" + langWord + ", langMeaning=" + langMeaning
				+ ", langEtc=" + langEtc + ", categoryIdx=" + categoryIdx + ", langRegId=" + langRegId
				+ ", langRegDate=" + langRegDate + "]";
	}
	
	
	
}
