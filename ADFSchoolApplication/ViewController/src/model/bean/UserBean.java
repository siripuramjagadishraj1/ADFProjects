package model.bean;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import java.sql.*;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

public class UserBean {
    private RichInputText userNameInputText;
    private RichInputText passwordInputText;

    public UserBean() {
    }

    public void setUserNameInputText(RichInputText userNameInputText) {
        this.userNameInputText = userNameInputText;
    }

    public RichInputText getUserNameInputText() {
        return userNameInputText;
    }

    public void setPasswordInputText(RichInputText passwordInputText) {
        this.passwordInputText = passwordInputText;
    }

    public RichInputText getPasswordInputText() {
        return passwordInputText;
    }

    public String loginAction() {
        String userName = userNameInputText.getValue().toString();
        String password = passwordInputText.getValue().toString();
        System.out.println("UserName :"+userName+ " --> Password :"+password);
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
           String sql = "select school_principal_name from school_information where school_principal_username='" + 
                        userName + "' and SCHOOL_PRINCIPAL_PASWORD='" + password + "'";
           conn = MyADFUtil.getConnection();
           stmt = conn.prepareStatement(sql);
           rs = stmt.executeQuery();
            while(rs.next()){
                MyADFUtil.putInSessionScope("userName", userName);
                MyADFUtil.putInSessionScope("principalName", rs.getString(1));
                return "dashboard";  //  dashboar or faces/dashboard both are same.
            }
       } catch (Exception e) {
            e.printStackTrace();
        }
        MyADFUtil.showErrorMessage("Invalid UserName or Password..!");
        return null;
    }

    public String logOutUser() {
        try
            {
             System.out.println("Invalidating Session..!");
              FacesContext context = FacesContext.getCurrentInstance();
              HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
              if (session != null)
              {
                session.invalidate();
              }
            }
            catch (Exception e)
            {
              System.err.println("error in logout -- " + e);
            }
            return "index";
    }
}
