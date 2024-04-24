package com.example.ecomerce.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import io.jsonwebtoken.Jwts;

import com.example.ecomerce.model.User;
import com.example.ecomerce.repository.UserRepository;

public class AuthorizationFilter extends BasicAuthenticationFilter {
    @Value("${jwt.secret}")
    public String SECRET;

    UserRepository userRepository;
    public AuthorizationFilter(AuthenticationManager authManager,
                               UserRepository userRepository) {
        super(authManager);
        this.userRepository = userRepository;
    }

    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            token = token.replace("Bearer ", "");
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            if (user != null) {
                User userEntity = userRepository.findByEmail(user);
                return new UsernamePasswordAuthenticationToken(user, null, new UserPrincipal(userEntity).getAuthorities());
            }
            return null;
        }
        return null;
    }
}
