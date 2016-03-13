import javax.jws.WebService;

@WebService(endpointInterface="Itest")
public class MathImpl implements Itest {

	@Override
	public void math(int x, int y, String action) {
		if(action=="+"){
			System.out.println("the anser is: "+x+y);
		}
		if(action=="x"){
			System.out.println("the anser is: "+x*y);
		}

	}

	@Override
	public void reverse(String str) {
		// TODO Auto-generated method stub

	}

}
