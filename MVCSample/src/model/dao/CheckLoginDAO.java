package model.dao;

import java.util.ArrayList;

import model.bean.Wife;

public class CheckLoginDAO {

	public boolean isExistUser(String userName, String password) {
		// Connect vao Database lam mo so viec
		// Tat ca nhung cau SQL deu phai dat o DAO
		
		return true;
	}

	public ArrayList<Wife> getWifeList(String userName) {
		ArrayList<Wife> result = new ArrayList<Wife>();
		// Connect vao Database lam mo so viec
		Wife wife = new Wife();
		wife.setName("Nguyen Thi No");
		wife.setAddress("Lò vôi");
		wife.setAlive(false);
		result.add(wife);
		
		wife = new Wife();
		wife.setName("Tran Van Tam");
		wife.setAddress("Ho ca");
		wife.setAlive(true);
		result.add(wife);
		
		return result;
	}
	
}
