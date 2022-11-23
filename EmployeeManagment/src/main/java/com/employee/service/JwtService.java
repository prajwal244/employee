package com.employee.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
import com.employee.entity.JwtRequest;
import com.employee.entity.JwtResponse;
import com.employee.util.JwtUtil;


@Service
public class JwtService implements UserDetailsService {


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private EmployeeDao empdao;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String emailId = jwtRequest.getEmailId();
        String password = jwtRequest.getPassword();
        authenticate(emailId, password);
        
        UserDetails userDetails = loadUserByUsername(emailId);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);
        
        Employee emp = empdao.findById(emailId).get();
        return new JwtResponse(emp, newGeneratedToken);
    }
   
       
        @SuppressWarnings("rawtypes")
		private Set getAuthority(Employee emp) {
            Set<SimpleGrantedAuthority> authorities = new HashSet<>();
            emp.getRole().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            });
            return authorities;
        }

        private void authenticate(String emailId, String password) throws Exception {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(emailId, password));
            } catch (DisabledException e) {
                throw new Exception("USER_DISABLED", e);
            } catch (BadCredentialsException e) {
                throw new Exception("INVALID_CREDENTIALS", e);
            }
        }

		@SuppressWarnings("unchecked")
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			  Employee emp = empdao.findById(username).get();

		        if (emp != null) {
		            return new org.springframework.security.core.userdetails.User(
		                    emp.getEmailId(),
		                    emp.getPassword(),
		                    getAuthority(emp)
		            );
		        } else {
		            throw new UsernameNotFoundException("User not found with username: " + username);
		        }
		}
}
