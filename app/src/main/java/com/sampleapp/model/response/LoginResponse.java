package com.sampleapp.model.response;

/**
 * Created by saveen_dhiman on 05-November-16.
 * response model for login api
 */
public class LoginResponse {
    /**
     * result : 1
     * resultText : Success
     * errorMSG : Success.
     * user_id : 20
     * phone : 1234567890
     * first_name : saveen
     * last_name : null
     * email : saveendhiman@gmail.com
     * role : 1
     * avatar :
     */

    private ResponseBean Response;

    public ResponseBean getResponse() {
        return Response;
    }

    public void setResponse(ResponseBean Response) {
        this.Response = Response;
    }

    public static class ResponseBean {
        private int result;
        private String resultText;
        private String errorMSG;
        private int user_id;
        private String phone;
        private String first_name;
        private Object last_name;
        private String email;
        private int role;
        private String avatar;

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public String getResultText() {
            return resultText;
        }

        public void setResultText(String resultText) {
            this.resultText = resultText;
        }

        public String getErrorMSG() {
            return errorMSG;
        }

        public void setErrorMSG(String errorMSG) {
            this.errorMSG = errorMSG;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public Object getLast_name() {
            return last_name;
        }

        public void setLast_name(Object last_name) {
            this.last_name = last_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getRole() {
            return role;
        }

        public void setRole(int role) {
            this.role = role;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
