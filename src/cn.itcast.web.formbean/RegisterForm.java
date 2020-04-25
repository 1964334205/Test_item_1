package cn.itcast.web.formbean;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterForm {
    private String username;
    private String password;
    private String password2;
    private String email;
    private String birthday;
    private String nickname;
    private String verification_code;

    private Map erros = new HashMap();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getVerification_code() {
        return verification_code;
    }

    public void setVerification_code(String verification_code) {
        this.verification_code = verification_code;
    }

    public void setErros(Map erros) {
        this.erros = erros;
    }
    public void setErros(String name,String value) {
        this.erros.put(name,value);
    }
    public Map getErros() {
        return erros;
    }
    //校验规则
    //用户名不能为空
    //密码不能为空，且3-8位数字
    //确认密码不能为空，且要和密码一致
    //电子邮箱不能为空，但是要格式合法
    //生日可以为空，不为空时必须要是一个日期
    //昵称不可以为空，且要是汉字
    public boolean validate(String verification_code){
        boolean isOK = true;
        //用户名
        if (this.username == null || this.username.trim().equals("")){
            isOK = false;
            getErros().put("username","用户名不能为空");
        }else {
            if (!this.username.matches("[A-Za-z]{3,8}")){
                isOK = false;
                getErros().put("username","用户名必须是3-8位字母");
            }
        }
        //密码
        if (this.password == null || this.password.trim().equals("")){
            isOK = false;
            getErros().put("password","密码不能为空");
        }else {
            if (!this.password.matches("\\d{3,8}")){
                isOK = false;
                getErros().put("password","密码必须是3-8位数字");
            }
        }
        //密码二次验证
        if (this.password2 == null || this.password2.trim().equals("")){
            isOK = false;
            getErros().put("password2","密码不能为空");
        }else {
            if (!this.password.equals(password2)){
                isOK = false;
                getErros().put("password2","两次密码要一致");
            }
        }
        //邮箱
        if (this.email == null || this.email.trim().equals("")){
            isOK = false;
            getErros().put("email","邮箱不能为空");
        }else {
            if (!this.email.matches("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")){
                isOK = false;
                getErros().put("email","邮箱格式不合法");
            }
        }
        //生日验证
        if (this.birthday!= null && !this.birthday.trim().equals("")){

            String format = "([0-9]{4})(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])";
            Pattern pattern = Pattern.compile(format);
            Matcher matcher = pattern.matcher(this.birthday);
            if (matcher.matches()) {
                pattern = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})");
                matcher = pattern.matcher(this.birthday);
                if (matcher.matches()) {
                    int y = Integer.valueOf(matcher.group(1));
                    int m = Integer.valueOf(matcher.group(2));
                    int d = Integer.valueOf(matcher.group(3));
                    if (d > 28) {
                        Calendar c = Calendar.getInstance();
                        c.set(y, m-1, 1);//每个月的最大天数
                        int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                        if (!(lastDay >= d)){
                            isOK = false;
                            getErros().put("email","邮箱格式不合法");
                        }
                    }
                }
            }
        }
        //昵称验证
        if (this.nickname == null || this.nickname.trim().equals("")){
            isOK = false;
            getErros().put("nickname","昵称不能为空");
        }else {
            if (!this.nickname.matches("[\\u4e00-\\u9fa5]+")){
                isOK = false;
                getErros().put("nickname","昵称必须是汉字");
            }
        }
        //验证码验证
        if (this.verification_code == null || this.verification_code.trim().equals("")){
            isOK = false;
            getErros().put("verification_code","验证码不能为空");
        }else {
            System.out.println("验证码:"+verification_code);
            System.out.println("用户提交的验证码-:"+this.verification_code);
            System.out.println(!this.verification_code.equals(verification_code));
            if (!this.verification_code.equals(verification_code)){
                isOK = false;
                getErros().put("verification_code","验证码错误-+.");
                System.out.println("执行");
            }
        }
        return isOK;
    }

}
