package net.xin.web.service.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import net.xin.web.application.settings.PrivilegeTypeApp;
import net.xin.web.application.settings.ModuleApp;
import net.xin.web.form.settings.ModuleForm;
import net.xin.web.form.settings.PrivilegeTypeForm;
import net.xin.web.packages.framework.FormValidation;
import net.xin.web.packages.framework.UserBean;
import net.xin.web.packages.framework.ValidationForm;
import net.xin.web.packages.framework.Exception.BusinessViolatonException; 
import net.xin.web.packages.framework.Exception.BussinessException;
import net.xin.web.packages.framework.Exception.PrevilegeException;

@Component
public class PrivilegeTypeServiceImpl implements PrivlegeTypeService {

	@Autowired
	private PrivilegeTypeApp app;
	 
	 
  
	 



	@Override
	public ValidationForm SavePrivilegeType(PrivilegeTypeForm form)
			throws PrevilegeException, BussinessException, BusinessViolatonException {
		// TODO Auto-generated method stub
		try
		{
			ValidationForm obj=new FormValidation().validate(form);
			if(obj.isResult())
			{
				return app.savePrivilegeType(form);
			}
			else
			{
				return obj; 
			}

		}
		catch (BusinessViolatonException e)
		{
			throw new BusinessViolatonException(e.getMessage()); 
		}
		catch(PrevilegeException e)
		{
			throw new PrevilegeException(e.getMessage()); 
		}
		 catch (Exception e)
		{
			throw new BussinessException(e.getMessage());  
		}
	}
	 
}
