package homework2;

public class MemberFindDto {
	private int seq;
	private String email;
	private String code;
	private String sdate;
	private String edate;
	//생성자 만들기
	public MemberFindDto( int seq, String email,String code , String sdate, String edate) {
		this.seq = seq;
		this.email = email;
		this.code = code;
		this.sdate = sdate;
		this.edate = edate;		
	}
	
	
	//seq에 대한 setter 만들기
	public void SetSeq(int seq) {
		this.seq = seq;
	}	
	//seq에 대한 getter 만들기
	public int GetSeq() {
		return seq;
	}
	
	public void SetEmail(String email) {
		this.email = email;
	}
	
	public String GetEmail() {
		return email;
	}
	
	public void SetCode(String code) {
		this.code = code;
	}
	public String GetCode() {
		return code;
	}
	
	public void SetSdate(String sdate) {
		this.SetSdate(sdate);
	}
	
	public String GetSdate() {
		return sdate;
	}
	
	public void SetEdate(String edate) {
		this.SetSdate(edate);
	}
	
	public String GetEdate() {
		return edate;
	}
}
