package com.example.dto;

import java.util.ArrayList;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named
public class HistoryDTO extends ArrayList<MessageDTO> {

}
