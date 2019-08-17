package com.pojo;

public class DashBoardPojo {
	
	private String GROUP_CODE=null;
	private String  TOTAL_COUNT=null;
	private String  INPUT_COUNT=null;
	private String DCCODE="test";

	/**
	 * * @author ramya aribandi 
	 * DCCODE
	 * @return
	 */
	public String getDCCODE() {
		return DCCODE;
	}
	/**
	 * @author ramya aribandi 
	 * setting the dccode value in dashboard
	 * @param dCCODE
	 */
	public void setDCCODE(String dCCODE) {
		this.DCCODE = dCCODE;
	}
	public String getINPUT_COUNT() {
		return INPUT_COUNT;
	}
	public void setINPUT_COUNT(String iNPUT_COUNT) {
		INPUT_COUNT = iNPUT_COUNT;
	}
	public String getGROUP_CODE() {
		return GROUP_CODE;
	}
	public void setGROUP_CODE(String gROUP_CODE) {
		GROUP_CODE = gROUP_CODE;
	}
	public String getTOTAL_COUNT() {
		return TOTAL_COUNT;
	}
	public void setTOTAL_COUNT(String tOTAL_COUNT) {
		TOTAL_COUNT = tOTAL_COUNT;
	}

}
