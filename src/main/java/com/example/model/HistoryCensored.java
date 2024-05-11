package com.example.model;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Named;

@SessionScoped
@Alternative
@Named("history")
public class HistoryCensored extends AbstractHistory implements Serializable {
	@Override
	public boolean add(Message msg) {
		msg.setBody(msg.getBody().replaceAll("xyz", "(censored)"));
		return super.add(msg);
	}
}
