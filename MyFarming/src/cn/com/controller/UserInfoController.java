package cn.com.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.groovy.GJson;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;

import pojo.UserInfo;
import service.IUserInfoService;

@Controller
public class UserInfoController {
	@Resource
	private IUserInfoService userInfoService;

	@RequestMapping("/Userinfo.action")
	public String Login(UserInfo userinfo, Model model, HttpSession session) {
		System.out.println("username:" + userinfo.getUsername());
		System.out.println("userpwd:" + userinfo.getUserpwd());
		model.addAttribute("userinfo", userinfo);
		List<UserInfo> ulist = userInfoService.selectUserList();
		session.setAttribute("ulist", ulist);

		return "index";
	}

	@RequestMapping("/Userinfo_ADD.action")
	public String ADD(UserInfo userinfo, Model model, HttpSession session) {
		System.out.println("添加了东西 美滋滋");

		// model.addAttribute("userinfo", userinfo);
		// List<UserInfo> ulist=userInfoService.selectUserList();
		// session.setAttribute("ulist", ulist);

		return "index";
	}
	
	@RequestMapping("/json.action")
	public @ResponseBody
	void myjson(HttpServletResponse response) {
		List<UserInfo> userList = userInfoService.selectUserList();
		System.out.println("用户个数+"+userList.size());
		//springmvc 
		String json = null;
//		Gson gson=new Gson();
//		json=gson.toJson(userList);
		json=JSONArray.toJSON(userList).toString();
		try {

			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//struts
//			PrintWriter pw=response.getWriter();
			// 响应字节流
			ServletOutputStream out = response.getOutputStream();
			byte[] b = json.getBytes("utf-8");//中文
			out.write(b);
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(value="/Download.action")
	public void download(String filename, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("filename=" + filename);
		try {
			String filename1 = new String(filename.getBytes("ISO-8859-1"),
					"UTF-8");
			System.out.println("filename1=" + filename1);
			String filepath = request.getRealPath("download/" + filename1);
			File tempFile = new File(filepath);
			if (tempFile.exists()) {
				request.setCharacterEncoding("utf-8");
				String userAgent = request.getHeader("User-Agent");
				System.out.println("userAgent:" + userAgent);
				// 细节 浏览器 *=utf-8
				response.setHeader(
						"Content-disposition",
						"attachment;filename*="
								+ URLEncoder.encode(filename1, "utf-8"));
				// 设置文件输出类型
				response.setContentType("application/octet-stream; charset=utf-8");
				// //设置输出长度
				response.setHeader("Content-Length",
						String.valueOf(tempFile.length()));
				InputStream in = new BufferedInputStream(new FileInputStream(
						tempFile));
				//
				FileCopyUtils.copy(in, response.getOutputStream());
				in.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	@RequestMapping("/springUpload.action")
	public String upload(HttpServletRequest request, String testid) {
		String res = "error";

		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();
			boolean flag = true;
			try {
				while (iter.hasNext()) {
					System.out.println("okfile");
					// 一次遍历所有文件
					MultipartFile file = multiRequest.getFile(iter.next()
							.toString());
					if (file != null) {
						String path = request.getRealPath("upload") + "\\"
								+ file.getOriginalFilename();
						System.out.println("path:" + path);

						// 上传
						file.transferTo(new File(path));

					}

				}

				// 表单中其它数据
				System.out.println("testid:" + testid);

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("上传文件异常");
				flag = false;

			}
			System.out.println("flag:" + flag);
			if (flag) {

				res = "index";

			}

		}

		return res;
	}
}
