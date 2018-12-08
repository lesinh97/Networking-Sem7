package model.bo;
import java.util.ArrayList;
import model.bean.Wife;
import model.dao.CheckLoginDAO;
public class CheckLoginBO {
	
	CheckLoginDAO checkLoginDAO = new CheckLoginDAO();
	public boolean isValidUser(String userName, String password) {		
		return checkLoginDAO.isExistUser(userName, password);
	}
	public ArrayList<Wife> getWifeList(String userName) {
		return checkLoginDAO.getWifeList(userName);
	}
}
