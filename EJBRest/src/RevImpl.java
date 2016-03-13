import javax.jws.WebService;


@WebService(endpointInterface="Itest")
public class RevImpl implements Itest {

	@Override
	public void math(int x, int y, String action) {
		
	}

	@Override
	public void reverse(String str) {

	}

}
