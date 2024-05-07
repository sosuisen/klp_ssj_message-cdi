package com.example;

import java.io.IOException;
import java.time.LocalDateTime;

import com.example.dto.HistoryDTO;
import com.example.dto.MessageDTO;
import com.example.model.History;
import com.example.model.Message;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MessageServlet extends HttpServlet {
	// ModelのインスタンスをCDIから取得します。
	@Inject
	private History history;
	
	// View側と共有したいDTOのインスタンスをCDIから取得します。
	@Inject
	private HistoryDTO historyDTO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// historyからhistoryDTOへ、データを調整しながら詰め替えます。
		for (var message : history) {
			historyDTO.addFirst(new MessageDTO(
					message.getBody(),
					message.getCreatedDate().toString().substring(0, 10)));
		}
		// CDIを用いるため、request.setAttributeメソッドは不要です。
		request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// Webブラウザから送られてきたデータを取得します。
		var body = request.getParameter("body");
		var action = request.getParameter("action");
		switch(action) {
			case "add" -> history.add(new Message(body, LocalDateTime.now()));
			case "clear" -> history.clear();
        }
		
		// この後の処理はdoGetメソッドと同じなので、doGetに任せます。
		doGet(request, response);
	}
}