package com.sampleapp.model;

/**
 * Created by saveen_dhiman on 05-November-16.
 * Pojo class for user data
 */
public class UserData {

    /**
     * code : 200
     * message : Success
     */

    private StatusBean status;
    /**
     * auth : {"id":"2746","handle":"saveendhiman","email":"saveendhiman@gmail.com","firstname":"saveen","middlename":"0","lastname":"dhiman"}
     */

    private ResponseBean response;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public static class StatusBean {
        private String code;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class ResponseBean {
        /**
         * id : 2746
         * handle : saveendhiman
         * email : saveendhiman@gmail.com
         * firstname : saveen
         * middlename : 0
         * lastname : dhiman
         */

        private AuthBean auth;

        public AuthBean getAuth() {
            return auth;
        }

        public void setAuth(AuthBean auth) {
            this.auth = auth;
        }

        public static class AuthBean {
            private String id;
            private String handle;
            private String email;
            private String firstname;
            private String middlename;
            private String lastname;
            private String session_id;

            public String getSession_id() {
                return session_id;
            }

            public void setSession_id(String session_id) {
                this.session_id = session_id;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getHandle() {
                return handle;
            }

            public void setHandle(String handle) {
                this.handle = handle;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getFirstname() {
                return firstname;
            }

            public void setFirstname(String firstname) {
                this.firstname = firstname;
            }

            public String getMiddlename() {
                return middlename;
            }

            public void setMiddlename(String middlename) {
                this.middlename = middlename;
            }

            public String getLastname() {
                return lastname;
            }

            public void setLastname(String lastname) {
                this.lastname = lastname;
            }
        }
    }
}
