package logIn;

import java.io.Serializable;

public class TaiKhoan implements Serializable {
    private String tk;
    private String mk;
    private String role;

    public TaiKhoan() {
    }

    public TaiKhoan(String tk, String mk, String role) {
        this.tk = tk;
        this.mk = mk;
        this.role = role;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String ghiTk(){
        return tk + "," + mk + "," + role;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "tk='" + tk + '\'' +
                ", mk='" + mk + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
