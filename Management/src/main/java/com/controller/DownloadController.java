package com.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apicaller.APICaller;

@Controller
public class DownloadController {
	@Autowired
	APICaller apiCaller;

	@RequestMapping(path = "/download")
	public void downloadList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String file = apiCaller.fetchAllEmployeesFile();
		InputStream stream = new ByteArrayInputStream(file.getBytes(StandardCharsets.UTF_8));
		PrintWriter out = response.getWriter();
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=employeesInfo.txt");
		int i;
		while ((i = stream.read()) != -1) {
			out.write(i);
		}
		stream.close();
		out.close();
	}
}
