package model;

public class BbsCondition {// 페이징 처리를 위한 모델
	private String gameId;
	private Integer startRow;
	private Integer endRow;
	private Integer header;
	private String tableName;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String gameId) {
		this.tableName = "t_bbs_" + gameId;
	}
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getEndRow() {
		return endRow;
	}
	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}
	public Integer getHeader() {
		return header;
	}
	public void setHeader(Integer header) {
		this.header = header;
	}
}
