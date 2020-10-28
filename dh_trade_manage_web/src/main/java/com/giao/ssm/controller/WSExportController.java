package com.giao.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 在系统中调用cxf提供WebService
 */
@Controller
public class WSExportController {

	@RequestMapping("/ws/export/toedit.action")
	public String toedit(){
		return "ws/export/ajaxExport";
	}
}