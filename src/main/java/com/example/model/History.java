package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.enterprise.context.SessionScoped;

@SessionScoped
public class History extends ArrayList<Message> implements Serializable {
	// History は ArrayList<Message> を継承しているため、
	// ArrayListクラスと同じメソッドを持つ CDI Bean です。
}
