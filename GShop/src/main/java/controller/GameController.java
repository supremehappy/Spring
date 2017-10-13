package controller;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import logic.GameCatalog;
import model.Bbs;
import model.BbsHeader;
import model.Game;
import model.Genre;
import model.Grade;
import model.Os;

@Controller
public class GameController {
	
	@Autowired
	private GameCatalog gameCatalog;
	
	// 게임 등록 Action 호출
	@RequestMapping(value = "/game/putGame.html", method = RequestMethod.POST)
	public ModelAndView putGame(@Valid Game game, BindingResult result, HttpSession session) {
		if (result.getErrorCount() > 0) {
			ModelAndView mav = new ModelAndView("gshop/game/gameInputForm");
			mav.getModel().putAll(result.getModel());
			List<Os> osList = this.gameCatalog.getOsList();
			List<Genre> genreList = this.gameCatalog.getGenreList();
			List<Grade> gradeList = this.gameCatalog.getGradeList();
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("OS_LIST", osList);
			model.put("GENRE_LIST", genreList);
			model.put("GRADE_LIST", gradeList);
			mav.addObject(new Game());
			mav.addAllObjects(model);
			return mav;
		}
		String[] fileName = null;
		MultipartFile[] multiFile = null;
		for(int index = 0; index < 5; index++) {
			multiFile = game.getImage();
			fileName = new String[5];
			String path = null;
			OutputStream out = null;
			ServletContext context = session.getServletContext();
			if(multiFile != null) {
				fileName[index] = multiFile[index].getOriginalFilename();
				path = context.getRealPath("/upload/"+fileName[index]);
				System.out.println(path);
				try{
					out = new FileOutputStream(path);
					BufferedInputStream bis = new BufferedInputStream(multiFile[index].getInputStream());
					byte[] buffer = new byte[8106];
					int read = 0;
					while( (read = bis.read(buffer))>0 ) {
						out.write(buffer, 0, read);
					}
					if(out != null) {
						out.close();
					}
				}
				catch(Exception e) {}
				if(index < 1) {					
					game.setImage1(fileName[index]);
				}
				else if(index > 0 && index < 2) {					
					game.setImage2(fileName[index]);
				}
				else if(index > 1 && index < 3) {
					game.setImage3(fileName[index]);
				}
				else if(index > 2 && index < 4) {
					game.setImage4(fileName[index]);
				}
				else if(index > 3 && index < 5) {
					game.setImage5(fileName[index]);
				}
			}
		}
		String adminId = (String) session.getAttribute("admin_key");
		ModelAndView mav = new ModelAndView();
		if(adminId == null) {
			mav.addObject("/login/loginForm.html");
			return mav;
		}
		else {
			
			Object obj = gameCatalog.getMaxGameId();
			
			int gameId = 0;
			
			if(obj != null) {
				gameId = Integer.parseInt(String.valueOf(obj));
			}
			gameId++;
			System.out.println("gameId : " + gameId);
			game.setGame_id(gameId);
			game.setRelease_date(getToday());
			Map<String, String> map = new HashMap<String, String>();
			map.put("gameId", String.valueOf(game.getGame_id()));
			gameCatalog.createBbsTable(map);
			gameCatalog.createBbsReplyTable(map);
			gameCatalog.insertGame(game);
			gameCatalog.insertImages(game);
			return new ModelAndView("redirect:/game/gameList.html");
		}
	}
	
	// 게임 등록 폼 호출
	@RequestMapping(value = "/game/gameInputForm.html", method = RequestMethod.GET)
	public ModelAndView gameInputForm(HttpSession session) {
		Game game = new Game();
		List<Os> osList = this.gameCatalog.getOsList();
		List<Genre> genreList = this.gameCatalog.getGenreList();
		List<Grade> gradeList = this.gameCatalog.getGradeList();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("OS_LIST", osList);
		model.put("GENRE_LIST", genreList);
		model.put("GRADE_LIST", gradeList);
		ModelAndView mav = new ModelAndView("gshop/game/gameInputForm");
		mav.addObject(game);
		mav.addAllObjects(model);
		return mav;
	}
	
	// 게임 리스트 호출
	@RequestMapping(value = "/game/gameList.html", method = RequestMethod.GET)
	public ModelAndView gameList(HttpSession session) {
		ModelAndView mav = new ModelAndView("gshop/game/gameList");
		/*로그인 확인*/
		String loginAdmin = null;
		/*테스트용 세션*/
		session.setAttribute("admin_key", "admin");
		if(session.getAttribute("admin_key") != null || !session.getAttribute("admin_key").equals("")) {
			loginAdmin = (String) session.getAttribute("admin_key");
		}
		mav.addObject("loginAdmin", loginAdmin);
		return mav;
	}
	
	private String getToday() {// 오늘 날짜를 계산하는 메서드
		Calendar today = Calendar.getInstance();
		String year = String.valueOf(today.get(Calendar.YEAR));
		String month = String.valueOf(today.get(Calendar.MONTH) + 1);
		if(month.length() == 1) month = "0" + month;
		String gDate = String.valueOf(today.get(Calendar.DATE));
		if(gDate.length() == 1) gDate = "0" + gDate;
		String date = String.valueOf(year + month + gDate);
		return date;
	}
	
}
