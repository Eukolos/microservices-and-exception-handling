package com.eukolos.userrestapi.client;

import java.util.List;

public class ClientError {
    private Error error;
    private String apiVersion;

    public ClientError(Error error, String apiVersion) {
        this.error = error;
        this.apiVersion = apiVersion;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public static class Error {
        private String code;
        private String message;
        private List<Errors> errors;

        public Error(String code, String message, List<Errors> errors) {
            this.code = code;
            this.message = message;
            this.errors = errors;
        }

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

        public List<Errors> getErrors() {
            return errors;
        }

        public void setErrors(List<Errors> errors) {
            this.errors = errors;
        }
    }

    public static class Errors {
        private String domain;
        private String reason;
        private String message;
        private String sendReport;

        public Errors(String domain, String reason, String message, String sendReport) {
            this.domain = domain;
            this.reason = reason;
            this.message = message;
            this.sendReport = sendReport;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getSendReport() {
            return sendReport;
        }

        public void setSendReport(String sendReport) {
            this.sendReport = sendReport;
        }
    }
}
