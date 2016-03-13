import javax.jws.WebService;


@WebService
public interface Itest {
	
	public void math(int x,int y,String action);
	public void reverse(String str);

}
