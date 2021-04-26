package com.cafe24.todaymemo.encryption;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncriptionConfig {

	

		@Bean("jasyptStringEncryptor")
		public StringEncryptor stringEncryptor() {
			
			PooledPBEStringEncryptor pooledPBEStringEncryptor = new PooledPBEStringEncryptor();
			SimpleStringPBEConfig stringPBEConfig = new SimpleStringPBEConfig();

			stringPBEConfig.setPassword("ksmart38");		   //대칭키 (암호화 키) 설정
			stringPBEConfig.setAlgorithm("PBEWithMD5AndDES");  //사용할 암호화  알고리즘
			stringPBEConfig.setKeyObtentionIterations("1000"); //몇번을 반복해서 키를 얻을지에 대한  설정
			stringPBEConfig.setPoolSize("1");
			//평문으로 나올때 어떤식으로 나올지를 결정. randomsaltGenerator는 랜덤으로 평문의 암호화문이 바뀜. 암호문이 랜덤으로 나올 수 있게 해주는 라이브러리
			stringPBEConfig.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");  
			//암호문의 형태 64진법
			stringPBEConfig.setStringOutputType("base64");
			pooledPBEStringEncryptor.setConfig(stringPBEConfig);
			return pooledPBEStringEncryptor;
		}
}
