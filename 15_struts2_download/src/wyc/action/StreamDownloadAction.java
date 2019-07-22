package wyc.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

/**
 * 流式下载，使用Struts2结果集进行文件下载的Action
 * @author Yicheng Wang
 */
public class StreamDownloadAction {
	
	private String fileName;

	public String execute() {
		return Action.SUCCESS;
	}

	/**
	 * 获取文件输入流
	 * @return
	 * @throws FileNotFoundException
	 */
	public InputStream getInputStream() throws FileNotFoundException {
		HttpServletRequest req = ServletActionContext.getRequest();
		// 获取路径
		String path = req.getRealPath("/download");
		return new FileInputStream(new File(path, fileName));
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
