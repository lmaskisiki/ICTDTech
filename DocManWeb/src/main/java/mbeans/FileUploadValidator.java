package mbeans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

@FacesValidator("fileuploadvalidator")
public class FileUploadValidator implements Validator {

	@Override
	public void validate(FacesContext faceCtx, UIComponent uicomp, Object object)
			throws ValidatorException {
		Part file = (Part) object;
		FacesMessage msg = null;
		if (file == null || file.getSize() <= 0) {
			msg = new FacesMessage("Please select a valid file");
		} else if (file.getSize() < 200000) {
			msg = new FacesMessage("Your file is to big");
		}
		if (msg != null && !msg.getDetail().isEmpty()) {
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

	}

}
