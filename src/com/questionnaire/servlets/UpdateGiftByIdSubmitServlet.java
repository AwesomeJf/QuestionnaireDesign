package com.questionnaire.servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.questionnaire.bean.Gift;
import com.questionnaire.dao.GiftDao;


@WebServlet("/UpdateGiftByIdSubmitServlet")
public class UpdateGiftByIdSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateGiftByIdSubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
/*		Integer id =Integer.parseInt(request.getParameter("id"));
		Integer score =Integer.parseInt(request.getParameter("score"));
		String giftName = request.getParameter("giftName");
		String giftDescription = request.getParameter("giftDescription");
		String giftSrc = request.getParameter("giftSrc");*/
		int id = -1 ;
		int score = -1;
		String giftName = null;
		String giftDescription = null;
		String giftSrc = null;//新图片名
		//String oldPictureSrc = null;//旧图片名
		String basePath ="F:\\代码\\JAVA7\\QuestionnaireDesign\\WebContent\\picture" ;
		
		Gift gif=new Gift();
		GiftDao gDao=new GiftDao();
		try {
			boolean isMultipart =ServletFileUpload.isMultipartContent(request);
			//System.out.println(ServletFileUpload.isMultipartContent(request));
			if(isMultipart)
			{
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				//前端数据存在items中
				List <FileItem> items= upload.parseRequest(request);
				Iterator <FileItem> iter= items.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next();
					// 信息为普通的格式
					String itemName = item.getFieldName();
					if (item.isFormField()) {
						if("id".equals(itemName))
						{id=Integer.parseInt(item.getString("utf-8"));}
						else if("score".equals(itemName))
						{score=Integer.parseInt(item.getString("utf-8"));}
						else if("giftName".equals(itemName))
						{giftName=item.getString("utf-8");}
						else if("giftDescription".equals(itemName))
						{giftDescription=item.getString("utf-8");}
						/*else if("oldPictureSrc".equals(itemName))
						{oldPictureSrc=item.getString("utf-8");}*/
						else {
							System.out.println("其他字段");
						}
					}
					// 信息为文件格式
					else {
						String fileName = item.getName();
						if(fileName=="") {
							//System.out.println("未选择图片");
							giftSrc="404.jpg";
						}
						else{
							giftSrc=fileName;
							//System.out.println(fileName);
							//System.out.println("File.separator:"+File.separator);
							//当前部署的tomcat路径
							//String TomcatPath=request.getSession().getServletContext().getRealPath(File.separator);
							
							String TomcatPath=request.getSession().getServletContext().getRealPath("picture");
							//System.out.println("TomcatPath:"+TomcatPath);
							
							//写入项目路径
							File eclipseFile = new File(basePath, fileName);
							item.write(eclipseFile);
							File tomcatFile = new File(TomcatPath, fileName);
							//复制到Tomcat路径,若有重复文件则删除
							if (tomcatFile.isFile() && tomcatFile.exists()) {  
								tomcatFile.delete();
								//System.out.println("删除重复文件");
							}  
							Files.copy(eclipseFile.toPath(), tomcatFile.toPath());
							
							//写入Tomcat路径
							//File tomcatFile = new File(TomcatPath, fileName);
							//item.write(tomcatFile);
							
							//deleteFile(basePath, oldPictureSrc);//删除旧图片
							//逻辑有点复杂，不删了
						}
					}
				}
			}
			gif.setId(id);
			gif.setScore(score);
			gif.setGiftName(giftName);
			gif.setGiftDescription(giftDescription);
			gif.setGiftSrc(giftSrc);
			gDao.UpdateGiftByIdSubmit(gif);
			response.sendRedirect("GiftManageServlet");
		}
		catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//删除旧图片，但此程序没有使用
	public boolean deleteFile(String basePath,String oldPictureSrc) {
		
        File file = new File(basePath+"\\"+oldPictureSrc);
        System.out.println("**********");
        System.out.println(basePath+"\\"+oldPictureSrc);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
        	if(oldPictureSrc!="404.jpg"){
	            if (file.delete()) {
	                System.out.println("删除单个文件" + oldPictureSrc + "成功！");
	                return true;
	            } else {
	                System.out.println("删除单个文件" + oldPictureSrc + "失败！");
	                return false;
	            }
        	}
        	return true;
        } else {
            System.out.println("删除单个文件失败：" + oldPictureSrc + "不存在！");
            return false;
        }
    }
}
