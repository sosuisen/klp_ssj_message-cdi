package com.example.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Named;

@SessionScoped
@Alternative
@Named("history")
public class HistoryTest extends AbstractHistory implements Serializable {
	@PostConstruct
	public void init() {
		// list へテスト用データを追加
		this.add(new Message("こんにちは。", LocalDateTime.parse("2024-04-01T10:00:00"))); 
		this.add(new Message("HistoryTestが注入されました。",LocalDateTime.parse("2024-04-02T10:00:00"))); 
		this.add(new Message("これはテスト用データです！", LocalDateTime.parse("2024-04-03T10:00:00"))); 
	}
}
