package wyc.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

/**
 * 普通方法进行文件下载Action
 * @author Yicheng Wang
 */
public class DownloadAction {
	public String execute() throws IOException {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		// 获取路径
		String path = req.getRealPath("/download");
		File file = new File(path, "Struts2.chm");
		resp.setContentLength((int) file.length());
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment;filename=Struts2.chm");
		byte[] buffer = new byte[400];
		int len = 0;
		InputStream is = new FileInputStream(file);
		OutputStream os = resp.getOutputStream();
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		os.close();
		is.close();
		return null;
	}
}
