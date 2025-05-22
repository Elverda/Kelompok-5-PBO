package com.example.angkringan_99.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




    @Component
public class LoginInterceptor implements HandlerInterceptor {

       @Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String uri = request.getRequestURI();
    if (uri.startsWith("/auth")) {
        return true; // Izinkan akses ke halaman auth
    }

    // Cek session
    Object userSession = request.getSession().getAttribute("loggedInUser"); // Perbaiki di sini
    if (userSession == null) {
        response.sendRedirect("/auth/login");
        return false; // Redirect jika tidak ada session
    }

    return true; // Izinkan akses jika session ada
}

   
}

