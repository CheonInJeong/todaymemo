
package com.cafe24.todaymemo.common;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;


@Generated("jsonschema2pojo")
public class KakaoProfile {
		
		private Integer id;
		private String connected_at;
		private Properties properties;
		private KakaoAccount kakao_account;
		private Map<String, Object> additional_properties = new HashMap<String, Object>();
		
	


		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getConnected_at() {
			return connected_at;
		}

		public void setConnected_at(String connected_at) {
			this.connected_at = connected_at;
		}

		public Properties getProperties() {
			return properties;
		}

		public void setProperties(Properties properties) {
			this.properties = properties;
		}

		public KakaoAccount getKakao_account() {
			return kakao_account;
		}

		public void setKakao_account(KakaoAccount kakao_account) {
			this.kakao_account = kakao_account;
		}

		public Map<String, Object> getAdditional_properties() {
			return additional_properties;
		}

		public void setAdditional_properties(Map<String, Object> additional_properties) {
			this.additional_properties = additional_properties;
		}

		@Generated("jsonschema2pojo")
		public class Properties {
				
				private String nickname;
				private String profile_image;
				private String thumbnail_image;
				private Map<String, Object> additional_properties = new HashMap<String, Object>();
				public String getNickname() {
					return nickname;
				}
				public void setNickname(String nickname) {
					this.nickname = nickname;
				}
				public String getProfile_image() {
					return profile_image;
				}
				public void setProfile_image(String profile_image) {
					this.profile_image = profile_image;
				}
				public String getThumbnail_image() {
					return thumbnail_image;
				}
				public void setThumbnail_image(String thumbnail_image) {
					this.thumbnail_image = thumbnail_image;
				}
				public Map<String, Object> getAdditional_properties() {
					return additional_properties;
				}
				public void setAdditional_properties(Map<String, Object> additional_properties) {
					this.additional_properties = additional_properties;
				}
				
				
		}	
	
		@Generated("jsonschema2pojo")
		public class KakaoAccount {
		
				private Boolean profile_needs_agreement;
				private Profile profile;
				private Boolean has_email;
				private Boolean email_needs_agreement;
				private Boolean has_age_range;
				private Boolean age_range_needs_agreement;
				private String age_range;
				private Map<String, Object> additional_properties = new HashMap<String, Object>();
				
				
				
				public Boolean getProfile_needs_agreement() {
					return profile_needs_agreement;
				}



				public void setProfile_needs_agreement(Boolean profile_needs_agreement) {
					this.profile_needs_agreement = profile_needs_agreement;
				}



				public Profile getProfile() {
					return profile;
				}



				public void setProfile(Profile profile) {
					this.profile = profile;
				}



				public Boolean getHas_email() {
					return has_email;
				}



				public void setHas_email(Boolean has_email) {
					this.has_email = has_email;
				}



				public Boolean getEmail_needs_agreement() {
					return email_needs_agreement;
				}



				public void setEmail_needs_agreement(Boolean email_needs_agreement) {
					this.email_needs_agreement = email_needs_agreement;
				}



				public Boolean getHas_age_range() {
					return has_age_range;
				}



				public void setHas_age_range(Boolean has_age_range) {
					this.has_age_range = has_age_range;
				}



				public Boolean getAge_range_needs_agreement() {
					return age_range_needs_agreement;
				}



				public void setAge_range_needs_agreement(Boolean age_range_needs_agreement) {
					this.age_range_needs_agreement = age_range_needs_agreement;
				}



				public String getAge_range() {
					return age_range;
				}



				public void setAge_range(String age_range) {
					this.age_range = age_range;
				}



				public Map<String, Object> getAdditional_properties() {
					return additional_properties;
				}



				public void setAdditional_properties(Map<String, Object> additional_properties) {
					this.additional_properties = additional_properties;
				}



				@Generated("jsonschema2pojo")
				public class Profile {
						
						private String nickname;
						private String thumbnail_image_url;
						private String profile_image_url;
						private Boolean is_default_image;
						private Map<String, Object> additional_properties = new HashMap<String, Object>();
						public String getNickname() {
							return nickname;
						}
						public void setNickname(String nickname) {
							this.nickname = nickname;
						}
						public String getThumbnail_image_url() {
							return thumbnail_image_url;
						}
						public void setThumbnail_image_url(String thumbnail_image_url) {
							this.thumbnail_image_url = thumbnail_image_url;
						}
						public String getProfile_image_url() {
							return profile_image_url;
						}
						public void setProfile_image_url(String profile_image_url) {
							this.profile_image_url = profile_image_url;
						}
						public Boolean getIs_default_image() {
							return is_default_image;
						}
						public void setIs_default_image(Boolean is_default_image) {
							this.is_default_image = is_default_image;
						}
						public Map<String, Object> getAdditional_properties() {
							return additional_properties;
						}
						public void setAdditional_properties(Map<String, Object> additional_properties) {
							this.additional_properties = additional_properties;
						}
						
						
				}
	
	
		}

}

