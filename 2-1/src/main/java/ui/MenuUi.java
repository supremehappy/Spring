package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pro.ProUi;

public class MenuUi extends AbstractUiImpl {

	private TeamUi teamUi;
	private ProUi proUi;
	
	public void setTeamUi(TeamUi teamUi) {
		this.teamUi = teamUi;
	}

	public void setProUi(ProUi proUi) {
		this.proUi = proUi;
	}

	@Override
	protected void showMenu() {
	
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println("1. 종료 / 2. 팀 목록 보기 / 3. 상품 목록 보기");
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println("번호를 입력 후 엔터");

	}

	@Override
	protected int getMaxMenuNumber() {
		
		return 3;
	}

	@Override
	protected int getMinMenuNumber() {
		
		return 1;
	}

	@Override
	protected void execute(int str) {
		
		try{
			switch (str){
			case 1 :
				System.out.println("exit");
				System.exit(0);
				break;
				
			case 2 :
				teamUi.show();
				break;
				
			case 3 :
				proUi.show();
				break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		MenuUi menuUi = ctx.getBean(MenuUi.class);
		
		while(true){
			menuUi.show();
		}
		
	}
}
