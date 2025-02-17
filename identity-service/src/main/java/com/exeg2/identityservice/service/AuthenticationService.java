package com.exeg2.identityservice.service;

import com.exeg2.identityservice.dto.request.*;
import com.exeg2.identityservice.dto.response.AuthenticateResponse;
import com.exeg2.identityservice.dto.response.IntrospectResponse;
import com.exeg2.identityservice.dto.response.ResetPasswordResponse;
import com.exeg2.identityservice.dto.response.SendEmailResponse;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticateResponse authenticate(AuthenticateRequest request);
    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;
    String logout(LogoutRequest request);
    AuthenticateResponse refresh(RefreshRequest request) throws ParseException, JOSEException;
    SendEmailResponse isSentResetLink(SendEmailRequest request);
    ResetPasswordResponse resetPassword(ResetPasswordRequest request, String token);
}
