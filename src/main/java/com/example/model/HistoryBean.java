package com.example.model;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Named;

@SessionScoped
@Alternative
@Named("history")
public class HistoryBean extends AbstractHistory implements Serializable {
}
