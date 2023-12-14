package com.eukolos.userrestapi.client;

import java.util.List;

public class ClientError {
    private Error error;
    private String apiVersion;

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
        private List<ErrorDetail> errors;

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

        public List<ErrorDetail> getErrors() {
            return errors;
        }

        public void setErrors(List<ErrorDetail> errors) {
            this.errors = errors;
        }
    }

    public static class ErrorDetail {
        private String domain;
        private String reason;
        private String message;
        private String sendReport;

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
